package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDate;
import java.util.Date;

public class UtilDateToLocalDateConverter implements FormattedConverter<Date, LocalDate, String> {

    @Override
    public LocalDate convert(Date source, String format) {
        return new java.sql.Date(source.getTime()).toLocalDate();
    }
}
