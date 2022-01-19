package io.github.mportilho.commons.converters.impl.integer;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.math.BigDecimal;

public class IntegerToBigDecimalConverter implements FormattedConverter<Integer, BigDecimal, String> {

    @Override
    public BigDecimal convert(Integer source, String format) {
        return BigDecimal.valueOf(source);
    }
}
