package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;

public class SqlDateToLocalTimeConverter implements FormattedConverter<Date, LocalTime, String> {

    @Override
    public LocalTime convert(Date source, String format) {
        return new Timestamp(source.getTime()).toLocalDateTime().toLocalTime();
    }
}
