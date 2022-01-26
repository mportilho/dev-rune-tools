package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.dates.*;

import java.time.*;
import java.util.Map;

public class AvailableDatesFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDate.class), new SqlDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDateTime.class), new SqlDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalTime.class), new SqlDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, ZonedDateTime.class), new SqlDateToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDate.class), new UtilDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDateTime.class), new UtilDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalTime.class), new UtilDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, ZonedDateTime.class), new UtilDateToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(LocalDate.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDate.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());

    }

}
