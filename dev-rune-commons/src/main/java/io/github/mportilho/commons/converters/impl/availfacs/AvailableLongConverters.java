package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.longc.LongToBigDecimalConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableLongConverters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(Long.class, BigDecimal.class), new LongToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(long.class, BigDecimal.class), new LongToBigDecimalConverter());
    }

}
