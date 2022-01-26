package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class UtilDateToZonedDateTimeConverter implements FormattedConverter<Date, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(Date source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(new java.sql.Timestamp(source.getTime()).toLocalDateTime(), zone);
    }
}
