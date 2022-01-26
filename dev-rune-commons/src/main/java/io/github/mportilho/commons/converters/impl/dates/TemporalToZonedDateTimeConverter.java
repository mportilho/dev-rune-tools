package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.*;
import java.time.temporal.Temporal;

public class TemporalToZonedDateTimeConverter implements FormattedConverter<Temporal, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(Temporal source, String format) {
        if (source instanceof LocalDateTime src) {
            return localDateTimeToZonedDateTime(src, format);
        } else if (source instanceof LocalDate src) {
            return localDateToZonedDateTime(src, format);
        } else if (source instanceof OffsetDateTime src) {
            return offsetDateTimeToZonedDateTime(src, format);
        }
        throw new IllegalArgumentException(String.format("Converter from [%s] to [%s] not available",
                source.getClass(), ZonedDateTime.class));
    }

    public ZonedDateTime localDateTimeToZonedDateTime(LocalDateTime source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(source, zone);
    }

    public ZonedDateTime localDateToZonedDateTime(LocalDate source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(source, LocalTime.MIDNIGHT, zone);
    }

    public ZonedDateTime offsetDateTimeToZonedDateTime(OffsetDateTime source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return source.atZoneSameInstant(zone);
    }

}
