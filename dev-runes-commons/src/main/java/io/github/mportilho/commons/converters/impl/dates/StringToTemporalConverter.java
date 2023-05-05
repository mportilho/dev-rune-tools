package io.github.mportilho.commons.converters.impl.dates;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.utils.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

public class StringToTemporalConverter implements FormattedConverter<String, Temporal> {

    @Override
    public Temporal convert(String source, String format) {
        if (source.length() <= 8) {
            return DateUtils.TIME_FORMATTER.parse(source, LocalTime::from);
        } else if (source.length() <= 10) {
            return DateUtils.DATE_FORMATTER.parse(source, LocalDate::from);
        } else {
            return DateUtils.DATETIME_FORMATTER_PADDING_TIME.parse(source, LocalDateTime::from);
        }
    }

}
