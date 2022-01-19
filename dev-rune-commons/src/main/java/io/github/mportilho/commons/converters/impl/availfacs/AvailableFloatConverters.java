package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.floatc.FloatToBigDecimalConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableFloatConverters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(Float.class, BigDecimal.class), new FloatToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(float.class, BigDecimal.class), new FloatToBigDecimalConverter());
    }

}
