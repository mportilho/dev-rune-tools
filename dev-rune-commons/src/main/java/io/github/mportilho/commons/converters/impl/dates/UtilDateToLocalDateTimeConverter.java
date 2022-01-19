package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDateTime;
import java.util.Date;

public class UtilDateToLocalDateTimeConverter implements FormattedConverter<Date, LocalDateTime, String> {

    @Override
    public LocalDateTime convert(Date source, String format) {
        return new java.sql.Timestamp(source.getTime()).toLocalDateTime();
    }
}
