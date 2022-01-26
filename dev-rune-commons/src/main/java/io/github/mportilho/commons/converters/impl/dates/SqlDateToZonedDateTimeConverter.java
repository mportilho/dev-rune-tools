package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SqlDateToZonedDateTimeConverter implements FormattedConverter<Date, ZonedDateTime, String> {

    @Override
    public ZonedDateTime convert(Date source, String format) {
        ZoneId zone = isNullOrBlank(format) ? ZoneId.systemDefault() : ZoneId.of(format);
        return ZonedDateTime.of(new Timestamp(source.getTime()).toLocalDateTime(), zone);
    }
}
