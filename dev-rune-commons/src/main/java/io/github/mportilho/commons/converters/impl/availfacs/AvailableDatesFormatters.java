package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.dates.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Map;

public class AvailableDatesFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDate.class), new SqlDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDateTime.class), new SqlDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalTime.class), new SqlDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDate.class), new UtilDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDateTime.class), new UtilDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalTime.class), new UtilDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDate.class, ZonedDateTime.class), new LocalDateToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalTime.class, ZonedDateTime.class), new LocalTimeToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, ZonedDateTime.class), new LocalDateTimeToZonedDateTimeConverter());
    }

}
