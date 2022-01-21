package io.github.mportilho.commons.converters.impl.bigdecimal;

import io.github.mportilho.commons.converters.impl.AbstractCachedStringFormattedConverter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalToStringConverter extends AbstractCachedStringFormattedConverter<BigDecimal, String> {

    @Override
    public String convert(BigDecimal source, String format) {
        if (isNullOrBlank(format)) {
            return source.toPlainString();
        }
        return new DecimalFormat(format).format(format);
    }

}