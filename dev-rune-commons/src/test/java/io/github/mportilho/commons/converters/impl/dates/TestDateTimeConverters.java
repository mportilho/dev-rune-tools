package io.github.mportilho.commons.converters.impl.dates;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.*;

public class TestDateTimeConverters {

    @Test
    public void testLocalDateTimeToZonedDateTimeConverter() {
        TemporalToZonedDateTimeConverter converter = new TemporalToZonedDateTimeConverter();

        assertThat(converter.convert(
                LocalDateTime.of(2020, 4, 30, 13, 14, 15), null))
                .isEqualTo(ZonedDateTime.of(2020, 4, 30,
                        13, 14, 15, 0, ZoneId.systemDefault()));
    }

    @Test
    public void testLocalDateToZonedDateTimeConverter_withZoneIdFormat() {
        TemporalToZonedDateTimeConverter converter = new TemporalToZonedDateTimeConverter();

        String zoneIdName = ZoneId.getAvailableZoneIds().stream().findAny().orElseThrow();
        assertThat(converter.convert(LocalDate.of(2020, 4, 30), zoneIdName))
                .isEqualTo(ZonedDateTime.of(2020, 4, 30,
                        0, 0, 0, 0, ZoneId.of(zoneIdName)));
    }

    @Test
    public void test_Fail_LocalTimeToZonedDateTimeConverter() {
        TemporalToZonedDateTimeConverter converter = new TemporalToZonedDateTimeConverter();

        assertThatThrownBy(() -> converter.convert(LocalTime.of(13, 14, 15), null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
