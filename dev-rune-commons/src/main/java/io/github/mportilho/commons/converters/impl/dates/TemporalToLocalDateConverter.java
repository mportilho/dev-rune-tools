package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

public class TemporalToLocalDateConverter implements FormattedConverter<Temporal, LocalDate, String> {

    @Override
    public LocalDate convert(Temporal source, String format) {
        if (source instanceof ZonedDateTime src) {
            return zonedDateTimeToLocalDate(src, format);
        } else if (source instanceof LocalDateTime src) {
            return localDateTimeToLocalDate(src, format);
        } else if (source instanceof OffsetDateTime src) {
            return offsetDateTimeToLocalDate(src, format);
        }
        throw new IllegalArgumentException(String.format("Converter from [%s] to [%s] not available",
                source.getClass(), LocalDate.class));
    }


    public LocalDate zonedDateTimeToLocalDate(ZonedDateTime source, String format) {
        return source.toLocalDate();
    }

    public LocalDate localDateTimeToLocalDate(LocalDateTime source, String format) {
        return source.toLocalDate();
    }

    public LocalDate offsetDateTimeToLocalDate(OffsetDateTime source, String format) {
        return source.toLocalDate();
    }
}
