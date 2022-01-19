package io.github.mportilho.commons.converters.impl.shortc;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.math.BigDecimal;

public class ShortToBigDecimalConverter implements FormattedConverter<Short, BigDecimal, String> {

    @Override
    public BigDecimal convert(Short source, String format) {
        return BigDecimal.valueOf(source.intValue());
    }
}
