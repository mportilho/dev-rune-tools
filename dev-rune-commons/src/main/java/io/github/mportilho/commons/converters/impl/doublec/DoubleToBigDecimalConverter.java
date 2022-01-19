package io.github.mportilho.commons.converters.impl.doublec;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.math.BigDecimal;

public class DoubleToBigDecimalConverter implements FormattedConverter<Double, BigDecimal, String> {

    @Override
    public BigDecimal convert(Double source, String format) {
        return BigDecimal.valueOf(source);
    }
}
