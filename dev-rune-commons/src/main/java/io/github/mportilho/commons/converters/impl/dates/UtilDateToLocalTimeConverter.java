package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalTime;
import java.util.Date;

public class UtilDateToLocalTimeConverter implements FormattedConverter<Date, LocalTime, String> {

    @Override
    public LocalTime convert(Date source, String format) {
        return new java.sql.Timestamp(source.getTime()).toLocalDateTime().toLocalTime();
    }
}
