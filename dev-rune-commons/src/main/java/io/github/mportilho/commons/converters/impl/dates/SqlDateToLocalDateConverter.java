package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.sql.Date;
import java.time.LocalDate;

public class SqlDateToLocalDateConverter implements FormattedConverter<Date, LocalDate, String> {

    @Override
    public LocalDate convert(Date source, String format) {
        return source.toLocalDate();
    }
}
