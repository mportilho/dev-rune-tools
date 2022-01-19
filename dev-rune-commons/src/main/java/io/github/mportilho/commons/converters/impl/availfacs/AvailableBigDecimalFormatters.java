package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.bigdecimal.BigDecimalToStringConverter;

import java.math.BigDecimal;
import java.util.Map;

public class AvailableBigDecimalFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(BigDecimal.class, String.class), new BigDecimalToStringConverter());
    }

}
