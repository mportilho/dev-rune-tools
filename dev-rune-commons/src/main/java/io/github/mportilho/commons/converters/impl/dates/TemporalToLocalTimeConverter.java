package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

public class TemporalToLocalTimeConverter implements FormattedConverter<Temporal, LocalTime, String> {

    @Override
    public LocalTime convert(Temporal source, String format) {
        if (source instanceof ZonedDateTime src) {
            return zonedDateTimeLocalTime(src, format);
        } else if (source instanceof LocalDateTime src) {
            return localDateTimeLocalTime(src, format);
        } else if (source instanceof OffsetDateTime src) {
            return offsetDateTimeLocalTime(src, format);
        }
        throw new IllegalArgumentException(String.format("Converter from [%s] to [%s] not available",
                source.getClass(), LocalTime.class));
    }

    public LocalTime zonedDateTimeLocalTime(ZonedDateTime source, String format) {
        return source.toLocalTime();
    }

    public LocalTime localDateTimeLocalTime(LocalDateTime source, String format) {
        return source.toLocalTime();
    }

    public LocalTime offsetDateTimeLocalTime(OffsetDateTime source, String format) {
        return source.toLocalTime();
    }
}
