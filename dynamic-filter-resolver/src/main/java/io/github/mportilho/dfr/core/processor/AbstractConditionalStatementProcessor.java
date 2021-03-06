/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
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

package io.github.mportilho.dfr.core.processor;

import java.util.*;

public abstract class AbstractConditionalStatementProcessor<T> implements ConditionalStatementProcessor<T> {

    protected final ValueExpressionResolver<?> valueExpressionResolver;

    protected AbstractConditionalStatementProcessor() {
        this.valueExpressionResolver = v -> null;
    }

    protected AbstractConditionalStatementProcessor(ValueExpressionResolver<?> valueExpressionResolver) {
        this.valueExpressionResolver = valueExpressionResolver != null ? valueExpressionResolver : v -> null;
    }

    /**
     *
     */
    protected List<Object[]> computeValues(String[] parameters, Object[] defaultValues, Map<String, Object[]> parametersMap) {
        if (parameters == null || parameters.length == 0) {
            Object[] value = computeValue(null, defaultValues, parametersMap);
            return value != null ? List.<Object[]>of(value) : Collections.emptyList();
        }

        List<Object[]> valueList = new ArrayList<>();
        for (int i = 0; i < parameters.length; i++) {
            Object defaultValue = defaultValues != null && defaultValues.length > 0 ? defaultValues[i] : null;
            Object[] value = computeValue(parameters[i], defaultValue, parametersMap);
            if (value != null) {
                valueList.add(value);
            }
        }
        return valueList;
    }

    /**
     *
     */
    protected Object[] computeValue(String parameter, Object defaultValue, Map<String, Object[]> parametersMap) {
        if (parameter != null && !parameter.isBlank() && parametersMap.containsKey(parameter)) {
            return parametersMap.get(parameter);
        } else {
            if (defaultValue instanceof Object[] arr) {
                return Arrays.stream(arr)
                        .mapMulti((obj, mapper) -> {
                            if (obj instanceof String str) {
                                Object resolvedValue = applyExpressionResolver(str);
                                mapper.accept(resolvedValue != null ? resolvedValue : str);
                            } else {
                                mapper.accept(obj);
                            }
                        }).toArray();
            } else if (defaultValue instanceof String strValue && !strValue.isBlank()) {
                Object resolvedValue = applyExpressionResolver(strValue);
                return resolvedValue != null ? new Object[]{resolvedValue} : new Object[]{strValue};
            }
            return null;
        }
    }

    private Object applyExpressionResolver(String value) {
        try {
            return valueExpressionResolver.resolveValue(value);
        } catch (Exception e) {
            throw new IllegalStateException("Provided expression resolver threw an error", e);
        }
    }

}
