package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.string.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.Map;

public class AvailableStringFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(String.class, BigDecimal.class), new StringToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, BigInteger.class), new StringToBigIntegerConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Boolean.class), new StringToBooleanConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Byte.class), new StringToByteConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Double.class), new StringToDoubleConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Float.class), new StringToFloatConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Instant.class), new StringToInstantConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Integer.class), new StringToIntegerConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, java.sql.Date.class), new StringToJavaSqlDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Date.class), new StringToJavaUtilDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDate.class), new StringToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDateTime.class), new StringToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalTime.class), new StringToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Long.class), new StringToLongConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetDateTime.class), new StringToOffsetDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetTime.class), new StringToOffsetTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Short.class), new StringToShortConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Timestamp.class), new StringToTimestampConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Year.class), new StringToYearConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, YearMonth.class), new StringToYearMonthConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, ZonedDateTime.class), new StringToZonedDateTimeConverter());
    }

}
