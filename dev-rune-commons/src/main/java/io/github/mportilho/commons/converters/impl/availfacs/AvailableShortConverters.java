package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.shortc.ShortToBigDecimalConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableShortConverters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(Short.class, BigDecimal.class), new ShortToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(short.class, BigDecimal.class), new ShortToBigDecimalConverter());
    }

}
