package io.github.mportilho.commons.converters.impl.longc;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.math.BigDecimal;

public class LongToBigDecimalConverter implements FormattedConverter<Long, BigDecimal, String> {

    @Override
    public BigDecimal convert(Long source, String format) {
        return BigDecimal.valueOf(source);
    }
}
