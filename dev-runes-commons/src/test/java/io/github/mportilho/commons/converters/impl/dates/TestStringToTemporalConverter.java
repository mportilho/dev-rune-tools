package io.github.mportilho.commons.converters.impl.dates;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestStringToTemporalConverter {

    @Test
    public void testLocalTime() {
        StringToTemporalConverter converter = new StringToTemporalConverter();
        Assertions.assertThat(converter.convert("14:01:02", null)).isEqualTo(LocalTime.parse("14:01:02"));
        Assertions.assertThat(converter.convert("00:00:00", null)).isEqualTo(LocalTime.parse("00:00:00"));
    }

    @Test
    public void testLocalDate() {
        StringToTemporalConverter converter = new StringToTemporalConverter();
        Assertions.assertThat(converter.convert("2020-01-01", null)).isEqualTo(LocalDate.parse("2020-01-01"));
    }

    @Test
    public void testLocalDateTime() {
        StringToTemporalConverter converter = new StringToTemporalConverter();
        Assertions.assertThat(converter.convert("2020-01-01 14:01:02", null)).isEqualTo(LocalDateTime.parse("2020-01-01T14:01:02"));
        Assertions.assertThat(converter.convert("2020-01-01T14:01:02", null)).isEqualTo(LocalDateTime.parse("2020-01-01T14:01:02"));
        Assertions.assertThat(converter.convert("2020-01-01T14:01:02 +01", null)).isEqualTo(LocalDateTime.parse("2020-01-01T14:01:02"));
    }

}
