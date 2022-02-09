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

package io.github.mportilho.dfr.modules.springjpa.webautoconfigure;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.mportilho.dfr.core.operation.type.Dynamic;
import io.github.mportilho.dfr.core.operation.type.IsNotNull;
import io.github.mportilho.dfr.core.operation.type.IsNull;
import io.github.mportilho.dfr.core.processor.annotation.AnnotationProcessorParameter;
import io.github.mportilho.dfr.core.processor.annotation.ConditionalAnnotationUtils;
import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.github.mportilho.dfr.modules.springjpa.webautoconfigure.openapi3utils.SchemaValidationUtils;
import io.swagger.v3.core.util.AnnotationsUtils;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static io.github.mportilho.commons.utils.PredicateUtils.isEmpty;
import static io.github.mportilho.commons.utils.PredicateUtils.isNotEmpty;
import static io.github.mportilho.dfr.core.processor.annotation.ConditionalAnnotationUtils.findStatementAnnotations;
import static java.util.Objects.requireNonNull;

/**
 * An {@link OperationCustomizer} implementation for Springdocs library that
 * adds, to a OpenAPI 3 specification, additional request parameters related to
 * the defined {@link Filter}'s configuration on Spring Framework's controllers
 *
 * @author Marcelo Portilho
 */
public class DynamicFilterOperationCustomizer implements OperationCustomizer {

    @Override
    public Operation customize(Operation operation, HandlerMethod handlerMethod) {
        for (MethodParameter methodParameter : handlerMethod.getMethodParameters()) {
            String parameterName = getParameterName(methodParameter);
            List<Filter> parameterAnnotations = retrieveFilterParameterAnnotations(methodParameter.getParameterType(),
                    methodParameter.getParameterAnnotations());

            if (!parameterAnnotations.isEmpty()) {
                operation.getParameters().removeIf(p -> p.getName().equals(parameterName));
                for (Filter spec : parameterAnnotations) {
                    try {
                        customizeParameter(operation, methodParameter, spec);
                    } catch (Exception e) {
                        throw new IllegalStateException("Cannot build custom OpenAPI parameters from specification-args-resolver", e);
                    }
                }
            }
        }
        return operation;
    }

    /**
     * Applies necessary customization on the OpenAPI 3 {@link Operation}
     * representation
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void customizeParameter(
            Operation operation, MethodParameter methodParameter, Filter filter) throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) methodParameter.getParameter().getParameterizedType();
        Class<?> parameterizedClassType = Class.forName(parameterizedType.getActualTypeArguments()[0].getTypeName());

        Field field;
        try {
            String fieldToSearch = filter.parameterField() != null && !filter.parameterField().isBlank() ?
                    filter.parameterField() : filter.path();
            field = ConditionalAnnotationUtils.findFilterField(parameterizedClassType, fieldToSearch);
        } catch (IllegalStateException e) {
            String location = isNotEmpty(operation.getTags()) ? operation.getTags().get(0) + "." : "";
            location += operation.getOperationId();
            throw new IllegalStateException(String.format("Fail to get Schema data from Operation '%s'", location), e);
        }
        Class<?> fieldClass = field.getType();

        if (Dynamic.class.equals(filter.operation()) && filter.parameters().length > 1) {
            throw new IllegalStateException("Dynamic filter operation cannot have two parameters");
        }

        Schema schemaFromType = AnnotationsUtils.resolveSchemaFromType(fieldClass, null, getJsonViewFromMethod(methodParameter));
        for (String parameterName : filter.parameters()) {
            Optional<io.swagger.v3.oas.models.parameters.Parameter> optParameter = operation.getParameters().stream()
                    .filter(p -> p.getName().equals(parameterName)).findFirst();

            boolean parameterExists = optParameter.isPresent();
            io.swagger.v3.oas.models.parameters.Parameter parameter = optParameter.orElse(new io.swagger.v3.oas.models.parameters.Parameter());
            parameter.setName(parameterName);

            if (Dynamic.class.equals(filter.operation())) {
                Schema schema = new Schema<>();
                schema.type("string");
                ArraySchema arraySchema = new ArraySchema();
                arraySchema.type("array");
                arraySchema.minItems(2);
                arraySchema.maxItems(2);
                arraySchema.items(schema);
                parameter.setSchema(arraySchema);
            } else {
                Optional<Schema> optSchema = Optional.ofNullable(parameter.getSchema());
                boolean schemaExists = optSchema.isPresent();
                Schema schema = optSchema.orElse(new Schema<>());

                if (IsNull.class.equals(filter.operation()) || IsNotNull.class.equals(filter.operation())) {
                    schema = new BooleanSchema();
                } else if (schemaExists) {
                    schema.setType(schemaFromType.getType());
                    schema.setEnum(schemaFromType.getEnum());
                } else {
                    schema = schemaFromType;
                }
                parameter.setSchema(schema);

                if (filter.defaultValues() != null && filter.defaultValues().length == 1) {
                    schema.setDefault(filter.defaultValues()[0]);
                }
                SchemaValidationUtils.applyValidations(schema, field);
            }

            if (filter.required() || SchemaValidationUtils.isFieldRequired(field)) {
                parameter.required(true);
            }
            if (parameterExists) {
                if (parameter.getIn() == null || ParameterIn.DEFAULT.toString().equals(parameter.getIn())) {
                    parameter.setIn(ParameterIn.QUERY.toString());
                } else if (ParameterIn.PATH.toString().equals(parameter.getIn())) {
                    parameter.required(true);
                }
            } else {
                parameter.setIn(ParameterIn.QUERY.toString());
                operation.getParameters().add(parameter);
            }
        }
    }

    /**
     * Extracts a {@link JsonView} configuration from a {@link MethodParameter} for
     * additional customization
     */
    private static JsonView getJsonViewFromMethod(MethodParameter methodParameter) {
        JsonView[] jsonViews = requireNonNull(methodParameter.getMethod()).getAnnotationsByType(JsonView.class);
        JsonView jsonView = null;
        if (jsonViews != null && jsonViews.length > 0) {
            jsonView = jsonViews[0];
        }
        return jsonView;
    }

    /**
     * Defines the request parameter's name
     */
    private static String getParameterName(MethodParameter methodParameter) {
        String name;
        Parameter parameter = methodParameter.getParameter();
        io.swagger.v3.oas.annotations.Parameter parameterAnnotation = parameter.getAnnotation(io.swagger.v3.oas.annotations.Parameter.class);
        if (parameterAnnotation != null) {
            name = parameterAnnotation.name();
        } else {
            name = parameter.getName();
        }
        return name;
    }

    /**
     * Extract {@link Filter} annotation from the {@link MethodParameter}'s instance
     */
    static List<Filter> retrieveFilterParameterAnnotations(
            Class<?> parameterType, Annotation[] parameterAnnotations) {
        Map<Annotation, List<Annotation>> statementAnnotations =
                findStatementAnnotations(new AnnotationProcessorParameter(parameterType, parameterAnnotations));
        return statementAnnotations.values().stream()
                .flatMap(Collection::stream)
                .map(ConditionalAnnotationUtils::flattenFilterAnnotations)
                .flatMap(Collection::stream)
                .filter(filter -> isEmpty(filter.constantValues()))
                .toList();
    }


}
