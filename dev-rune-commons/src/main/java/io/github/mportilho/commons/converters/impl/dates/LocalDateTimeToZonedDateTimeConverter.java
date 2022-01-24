package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeToZonedDateTimeConverter implements FormattedConverter<LocalDateTime, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(LocalDateTime source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(source, zone);
    }
}
