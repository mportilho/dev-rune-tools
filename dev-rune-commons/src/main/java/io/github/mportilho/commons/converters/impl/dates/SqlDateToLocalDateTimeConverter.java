package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SqlDateToLocalDateTimeConverter implements FormattedConverter<Date, LocalDateTime, String> {

    @Override
    public LocalDateTime convert(Date source, String format) {
        return new Timestamp(source.getTime()).toLocalDateTime();
    }
}
