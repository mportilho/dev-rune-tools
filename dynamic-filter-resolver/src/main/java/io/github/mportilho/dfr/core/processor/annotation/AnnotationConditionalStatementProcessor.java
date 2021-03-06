/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.github.mportilho.dfr.core.processor.annotation;

import io.github.mportilho.dfr.core.operation.FilterData;
import io.github.mportilho.dfr.core.operation.type.Decorated;
import io.github.mportilho.dfr.core.operation.type.IsIn;
import io.github.mportilho.dfr.core.operation.type.IsNotIn;
import io.github.mportilho.dfr.core.processor.AbstractConditionalStatementProcessor;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;
import io.github.mportilho.dfr.core.processor.LogicType;
import io.github.mportilho.dfr.core.processor.ValueExpressionResolver;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

import static io.github.mportilho.dfr.core.processor.annotation.ConditionalAnnotationUtils.findStatementAnnotations;

/**
 * @author Marcelo Portilho
 */
public class AnnotationConditionalStatementProcessor extends AbstractConditionalStatementProcessor<AnnotationProcessorParameter> {

    private static final FilterData[] EMPTY_FILTER_DATA = {};
    private static final ConditionalStatement[] EMPTY_CONDITIONAL_STATEMENT = {};

    public AnnotationConditionalStatementProcessor(ValueExpressionResolver<?> valueExpressionResolver) {
        super(valueExpressionResolver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionalStatement createStatements(AnnotationProcessorParameter parameter, Map<String, Object[]> userParameters) {
        Map<String, Object[]> parametersMap = userParameters != null ? userParameters : Collections.emptyMap();
        List<ConditionalStatement> statements = new ArrayList<>();
        Map<Annotation, List<Annotation>> statementAnnotations = findStatementAnnotations(parameter);

        for (Map.Entry<Annotation, List<Annotation>> entry : statementAnnotations.entrySet()) {
            String stmtId = findStatementName(entry.getKey());
            statements.addAll(
                    entry.getValue().stream()
                            .map(ann -> createStatements(stmtId, ann, parametersMap))
                            .filter(Objects::nonNull).toList());
        }

        Map<String, FilterData> decoratedFilterMap = ConditionalAnnotationUtils.retrieveFilterParameterAnnotations(parameter)
                .filter(filter -> Decorated.class.equals(filter.operation()))
                .collect(Collectors.toMap(Filter::path, f -> createFilterData(f, computeFilter(f, parametersMap), parametersMap)));

        if (statements.isEmpty() && decoratedFilterMap.isEmpty()) {
            return null;
        } else if (statements.size() == 1) {
            if (!decoratedFilterMap.isEmpty()) {
                ConditionalStatement c = statements.get(0);
                return new ConditionalStatement(c.id(), c.logicType(), c.negate(), c.clauses(), c.oppositeStatements(), decoratedFilterMap);
            }
            return statements.get(0);
        }
        return new ConditionalStatement("conditional_wrapper", LogicType.DISJUNCTION, false,
                EMPTY_FILTER_DATA, statements.toArray(ConditionalStatement[]::new), decoratedFilterMap);
    }

    /**
     *
     */
    private String findStatementName(Annotation annotation) {
        if (annotation instanceof VirtualAnnotationHolder vAnn) {
            return vAnn.getClazz().getSimpleName();
        }
        return annotation.annotationType().getSimpleName();
    }

    /**
     *
     */
    private ConditionalStatement createStatements(
            String stmtId, Annotation annotation, Map<String, Object[]> userParameters) {
        if (annotation == null) {
            return null;
        }
        ConditionalStatement statement = null;
        Conjunction conjunction = Conjunction.class.equals(annotation.annotationType()) ? (Conjunction) annotation : null;
        Disjunction disjunction = Disjunction.class.equals(annotation.annotationType()) ? (Disjunction) annotation : null;
        if (conjunction != null || disjunction != null) {
            LogicType logicType = conjunction != null ? LogicType.CONJUNCTION : LogicType.DISJUNCTION;
            Filter[] filters = conjunction != null ? conjunction.value() : disjunction.value();
            Statement[] statements = conjunction != null ? conjunction.disjunctions() : disjunction.conjunctions();

            String strNegate = conjunction != null ? conjunction.negate() : disjunction.negate();
            boolean negate = computeNegatingParameter(stmtId, strNegate, userParameters);

            FilterData[] clauses = composeFilterData(filters, userParameters);
            List<ConditionalStatement> oppositeConditionals = new ArrayList<>();
            int i = 0;
            for (Statement stmt : statements) {
                FilterData[] params = composeFilterData(stmt.value(), userParameters);
                if (params.length > 0) {
                    String subStmtName = stmtId + "_subStatements_" + i++;
                    oppositeConditionals.add(new ConditionalStatement(
                            subStmtName, logicType.opposite(),
                            computeNegatingParameter(subStmtName, stmt.negate(), userParameters),
                            params, EMPTY_CONDITIONAL_STATEMENT, Collections.emptyMap()));
                }
            }
            if (clauses.length == 0 && oppositeConditionals.size() == 1) {
                statement = oppositeConditionals.get(0);
            } else if (clauses.length > 0 || !oppositeConditionals.isEmpty()) {
                statement = new ConditionalStatement(stmtId, logicType, negate, clauses, oppositeConditionals.toArray(ConditionalStatement[]::new), Collections.emptyMap());
            }
        }
        return statement;
    }

    /**
     *
     */
    private FilterData[] composeFilterData(Filter[] filters, Map<String, Object[]> userParameters) {
        if (filters == null || filters.length == 0) {
            return EMPTY_FILTER_DATA;
        }
        for (Filter filter : filters) { // fail fast
            validateFilter(filter);
        }

        List<FilterData> filterParameters = new ArrayList<>(filters.length);
        for (Filter filter : filters) {
            if (Decorated.class.equals(filter.operation())) {
                continue;
            }

            List<Object[]> values = computeFilter(filter, userParameters);

            if (values.isEmpty()) {
                if (filter.required()) {
                    String pluralChar = filter.parameters().length > 1 ? "s" : "";
                    String parameters = String.join(", ", filter.parameters());
                    throw new IllegalArgumentException(String.format("Parameter%s '%s' required", pluralChar, parameters));
                }
                continue;
            }

            filterParameters.add(createFilterData(filter, values, userParameters));
        }
        return filterParameters.toArray(FilterData[]::new);
    }

    private FilterData createFilterData(Filter filter, List<Object[]> values, Map<String, Object[]> userParameters) {
        boolean negate = computeNegatingParameter(filter.path(), filter.negate(), userParameters);
        String format = computeFormatParameter(filter, userParameters);
        Map<String, String> modifiers = computeModifiersMap(filter.modifiers());

        return new FilterData(filter.parameterField(), filter.path(), filter.parameters(),
                filter.targetType(), filter.operation(), negate, filter.ignoreCase(), values, format, modifiers,
                filter.description());
    }

    /**
     *
     */
    private void validateFilter(Filter filter) {
        if (filter.parameters().length == 0) {
            throw new IllegalStateException("No parameter configured for filter of path " + filter.path());
        }

        if (IsIn.class.equals(filter.operation()) || IsNotIn.class.equals(filter.operation())) {
            if (filter.parameters().length > 1) {
                throw new IllegalStateException(String.format("The multi-valued operation %s cannot have more than one parameter", filter.operation().getSimpleName()));
            }
        } else {
            if (filter.constantValues().length != 0 && filter.constantValues().length != filter.parameters().length) {
                throw new IllegalStateException(String.format("Arrays of Required Parameters and Constant Values have different sizes. Parameters required: '%s'",
                        String.join(", ", Arrays.asList(filter.parameters()))));
            }
            if (filter.defaultValues().length != 0 && filter.defaultValues().length != filter.parameters().length) {
                throw new IllegalStateException(String.format("Arrays of Required Parameters and Default Values have different sizes. Parameters required: '%s'",
                        String.join(", ", Arrays.asList(filter.parameters()))));
            }
        }
    }

    /**
     *
     */
    private List<Object[]> computeFilter(Filter filter, Map<String, Object[]> userParameters) {
        if (filter.constantValues().length > 0) {
            return computeValues(null, filter.constantValues(), userParameters);
        } else if (IsIn.class.equals(filter.operation()) || IsNotIn.class.equals(filter.operation())) {
            computeValues(filter.parameters(), new Object[]{filter.defaultValues()}, userParameters);
        }
        return computeValues(filter.parameters(), filter.defaultValues(), userParameters);
    }

    /**
     *
     */
    private Boolean computeNegatingParameter(
            String elementName, String strNegate, Map<String, Object[]> userParameters) {
        if ("true".equalsIgnoreCase(strNegate)) {
            return Boolean.TRUE;
        } else if ("false".equalsIgnoreCase(strNegate)) {
            return Boolean.FALSE;
        }

        Object[] negateParamResponse = computeValue(null, strNegate, userParameters);
        if (negateParamResponse != null && negateParamResponse.length > 0) {
            Object responseValue = negateParamResponse[0];
            if (responseValue instanceof Object[] arr && arr.length > 1) {
                throw new IllegalStateException("Attribute 'negate' parsing produced more than one value for element " + elementName);
            } else if (responseValue instanceof Object[] arr && arr.length == 1) {
                return Boolean.parseBoolean(arr[0].toString());
            } else if (responseValue != null) {
                return Boolean.parseBoolean(responseValue.toString());
            }
        }
        return Boolean.FALSE;
    }

    /**
     *
     */
    private Map<String, String> computeModifiersMap(String[] modifiers) {
        if (modifiers.length == 0) {
            return Collections.emptyMap();
        }
        return Arrays.stream(modifiers)
                .map(s -> {
                    String[] arr = s.split("=");
                    if (arr.length != 2) {
                        throw new IllegalStateException("The modifiers field format must be like 'Attribute=Value'");
                    }
                    return arr;
                }).collect(Collectors.toMap(s -> s[0], s -> s[1]));
    }

    /**
     *
     */
    private String computeFormatParameter(Filter filter, Map<String, Object[]> userParameters) {
        Object[] formatParamValueArray = computeValue(null, filter.format(), userParameters);
        if (formatParamValueArray != null && formatParamValueArray.length > 0) {
            Object formatValue = formatParamValueArray[0];
            if (formatValue instanceof Object[] arr && arr.length > 1) {
                throw new IllegalStateException("Attribute 'format' produced more than one value for path " + filter.path());
            } else if (formatValue instanceof Object[] arr && arr.length == 1) {
                return arr[0].toString();
            } else if (formatValue != null) {
                return formatValue.toString();
            }
        }
        return filter.format();
    }

}
