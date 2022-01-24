package io.github.mportilho.commons.converters.impl.dates;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestDateTimeConverters {

    @Test
    public void testLocalTimeToZonedDateTimeConverter() {
        LocalTimeToZonedDateTimeConverter converter = new LocalTimeToZonedDateTimeConverter();

        assertThat(converter.convert(LocalTime.of(13, 14, 15), null).toLocalTime())
                .isEqualTo(LocalTime.of(13, 14, 15));
    }

    @Test
    public void testLocalTimeToZonedDateTimeConverter_withFormat() {
        LocalTimeToZonedDateTimeConverter converter = new LocalTimeToZonedDateTimeConverter();

        String zoneIdName = ZoneId.getAvailableZoneIds().stream().findAny().orElseThrow();
        ZonedDateTime zonedDateTime = converter.convert(LocalTime.of(13, 14, 15), zoneIdName);
        assertThat(zonedDateTime.getZone()).isEqualTo(ZoneId.of(zoneIdName));
        assertThat(zonedDateTime.toLocalTime()).isEqualTo(LocalTime.of(13, 14, 15));
    }

}
