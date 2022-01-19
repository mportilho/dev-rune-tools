package io.github.mportilho.commons.converters.impl.floatc;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.math.BigDecimal;

public class FloatToBigDecimalConverter implements FormattedConverter<Float, BigDecimal, String> {

    @Override
    public BigDecimal convert(Float source, String format) {
        return BigDecimal.valueOf(source);
    }
}
