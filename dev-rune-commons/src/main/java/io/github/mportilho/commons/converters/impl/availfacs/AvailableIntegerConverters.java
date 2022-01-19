package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.integer.IntegerToBigDecimalConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableIntegerConverters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(Integer.class, BigDecimal.class), new IntegerToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(int.class, BigDecimal.class), new IntegerToBigDecimalConverter());
    }

}
