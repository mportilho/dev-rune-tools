package io.github.mportilho.dfr.core.processor.annotation;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;

import java.util.Map;

public interface FilterDecorator<T> {

    T decorate(T filter, ConditionalStatement conditionalStatement, Map<String, Object[]> parametersMap,
               FormattedConversionService formattedConversionService);

    default Object getOne(String key, Map<String, Object[]> parametersMap) {
        Object[] value = parametersMap.get(key);
        if (value != null) {
            if (value.length > 1) {
                throw new IllegalArgumentException("Needed one value but got many for parameter [%s]".formatted(key));
            } else if (value.length == 1) {
                return value[0];
            }
        }
        return null;
    }

}
