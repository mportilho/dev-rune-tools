package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateToZonedDateTimeConverter implements FormattedConverter<LocalDate, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(LocalDate source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(source, LocalTime.MIDNIGHT, zone);
    }
}
