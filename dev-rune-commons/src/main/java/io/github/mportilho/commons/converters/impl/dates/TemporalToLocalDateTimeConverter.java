package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.*;
import java.time.temporal.Temporal;

public class TemporalToLocalDateTimeConverter implements FormattedConverter<Temporal, LocalDateTime, String> {

    @Override
    public LocalDateTime convert(Temporal source, String format) {
        if (source instanceof ZonedDateTime src) {
            return zonedDateTimeToLocalDateTime(src, format);
        } else if (source instanceof LocalDate src) {
            return localDateToLocalDateTime(src, format);
        } else if (source instanceof OffsetDateTime src) {
            return offsetDateTimeToLocalDateTime(src, format);
        }
        throw new IllegalArgumentException(String.format("Converter from [%s] to [%s] not available",
                source.getClass(), LocalDateTime.class));
    }

    public LocalDateTime zonedDateTimeToLocalDateTime(ZonedDateTime source, String format) {
        return source.toLocalDateTime();
    }

    public LocalDateTime localDateToLocalDateTime(LocalDate source, String format) {
        return LocalDateTime.of(source, LocalTime.MIDNIGHT);
    }

    public LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime source, String format) {
        return source.toLocalDateTime();
    }
}
