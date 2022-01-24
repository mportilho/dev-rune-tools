package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalTimeToZonedDateTimeConverter implements FormattedConverter<LocalTime, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(LocalTime source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(LocalDate.now(), source, zone);
    }

}
