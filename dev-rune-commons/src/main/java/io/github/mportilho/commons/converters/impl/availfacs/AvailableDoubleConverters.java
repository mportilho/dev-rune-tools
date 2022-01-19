package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.doublec.DoubleToBigDecimalConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableDoubleConverters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(Double.class, BigDecimal.class), new DoubleToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(double.class, BigDecimal.class), new DoubleToBigDecimalConverter());
    }

}
