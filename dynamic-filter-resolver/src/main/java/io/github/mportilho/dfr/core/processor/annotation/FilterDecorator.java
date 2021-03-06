package io.github.mportilho.dfr.core.processor.annotation;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.dfr.core.operation.FilterData;
import io.github.mportilho.dfr.core.operation.type.Decorated;
import io.github.mportilho.dfr.core.processor.ConditionalStatement;

import java.util.Collections;

public interface FilterDecorator<T> {

    FilterData EMPTY_FILTERDATA = new FilterData("", "", new String[]{""}, Object.class, Decorated.class, false,
            false, Collections.emptyList(), "", Collections.emptyMap(), "");

    T decorate(T filter, ConditionalStatement conditionalStatement, FormattedConversionService formattedConversionService);

}
