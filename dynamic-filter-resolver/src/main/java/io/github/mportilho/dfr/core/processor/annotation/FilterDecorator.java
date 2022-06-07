package io.github.mportilho.dfr.core.processor.annotation;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;

public interface FilterDecorator<T> {

    T decorate(T filter, ConditionalStatement conditionalStatement, FormattedConversionService formattedConversionService);
}
