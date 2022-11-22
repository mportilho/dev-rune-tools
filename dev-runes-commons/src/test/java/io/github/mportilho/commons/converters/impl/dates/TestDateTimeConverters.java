/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

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
