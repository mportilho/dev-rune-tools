/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
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

package io.github.mportilho.commons.converters;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;

public class TestDefaultFilterValueConverter {

    FormattedConversionService filterValueConverter = new DefaultFormattedConversionService();

    static class NotConfiguredForConversionClass {

    }

    @Test
    public void test_CanConvert_method() {
        assertThat(filterValueConverter.canConvert(String.class, LocalDate.class)).isTrue();
        assertThat(filterValueConverter.canConvert(NotConfiguredForConversionClass.class, LocalDate.class)).isFalse();
        assertThat(filterValueConverter.canConvert(LocalDate.class, NotConfiguredForConversionClass.class)).isFalse();
        assertThat(filterValueConverter.canConvert(null, NotConfiguredForConversionClass.class)).isFalse();
        assertThat(filterValueConverter.canConvert(LocalDate.class, null)).isFalse();
    }

    @Test
    public void test_Instant_converter() {
        Instant instant = filterValueConverter.convert("03-12-2011T10:15:30Z", Instant.class, null);
        assertThat(instant).isEqualTo("2011-12-03T10:15:30Z");
    }

    @Test
    public void test_javaSqlDate_converter() {
        Date javaSqlDate;

        javaSqlDate = filterValueConverter.convert("21/12/2014", Date.class, null);
        assertThat(javaSqlDate).isEqualTo("2014-12-21");

        javaSqlDate = filterValueConverter.convert("21/12/2014 13:14:15", Date.class, null);
        assertThat(javaSqlDate).isEqualTo("2014-12-21T13:14:15");

        javaSqlDate = filterValueConverter.convert("2014-12-21T13:14:15+01:00[Europe/Paris]", Date.class, null);
        assertThat(javaSqlDate).isEqualTo("2014-12-21T10:14:15[Europe/Paris]");
    }

    @Test
    public void test_javaUtilDate_dateOnly_converter() {
        java.util.Date javaUtilDate;

        javaUtilDate = filterValueConverter.convert("21/12/2014", java.util.Date.class, null);
        assertThat(javaUtilDate).isEqualTo("2014-12-21");

        javaUtilDate = filterValueConverter.convert("21/12/2014 13:14:15", java.util.Date.class, null);
        assertThat(javaUtilDate).isEqualTo("2014-12-21T13:14:15");

        // java.util.Date combines local date-time with offset
        javaUtilDate = filterValueConverter.convert("2014-12-21T13:14:15+01:00[Europe/Paris]", java.util.Date.class, null);
        assertThat(javaUtilDate).isEqualTo("2014-12-21T10:14:15[Europe/Paris]");
    }

    @Test
    public void test_localDate_converter() {
        LocalDate localDate = filterValueConverter.convert("21/12/2014", LocalDate.class, null);
        assertThat(localDate).isEqualTo(LocalDate.of(2014, 12, 21));
    }

    @Test
    public void test_LocalDateTime_converter() {
        LocalDateTime localDateTime = filterValueConverter.convert("21/12/2011T10:15:30Z", LocalDateTime.class, null);
        assertThat(localDateTime).isEqualTo("2011-12-21T10:15:30");
    }

    @Test
    public void test_LocalTime_converter() {
        LocalTime localTime = filterValueConverter.convert("10:15:30Z", LocalTime.class, null);
        assertThat(localTime).isEqualTo("10:15:30");
    }

    @Test
    public void test_OffsetDateTime_converter() {
        OffsetDateTime offsetDateTime;

        offsetDateTime = filterValueConverter.convert("03-12-2007T10:15:30+01:00", OffsetDateTime.class, null);
        assertThat(offsetDateTime).isEqualTo("2007-12-03T10:15:30+01:00");

        offsetDateTime = filterValueConverter.convert("03-12-2007T10:15:30+01:00", OffsetDateTime.class, null);
        assertThat(offsetDateTime).isEqualTo("2007-12-03T10:15:30+01:00");


    }

    @Test
    public void test_OffsetTime_converter() {
        OffsetTime offsetTime = filterValueConverter.convert("10:15-01:00", OffsetTime.class, null);
        assertThat(offsetTime).isEqualTo("10:15-01:00");
    }

    @Test
    public void test_Timestamp_converter() {
        Timestamp timestamp = filterValueConverter.convert("03-12-2011T10:15:30Z", Timestamp.class, null);
        assertThat(timestamp).isEqualTo(Timestamp.valueOf(LocalDateTime.of(2011, 12, 3, 10, 15, 30, 0)));
    }

    @Test
    public void test_Year_converter() {
        Year year = filterValueConverter.convert("2014", Year.class, null);
        assertThat(year).isEqualTo(Year.of(2014));
    }

    @Test
    public void test_YearMonth_converter() {
        YearMonth yearMonth = filterValueConverter.convert("12/2012", YearMonth.class, null);
        assertThat(yearMonth).isEqualByComparingTo(YearMonth.of(2012, 12));
    }

    @Test
    public void test_ZonedDateTime_converter() {
        ZonedDateTime zonedDateTime = filterValueConverter.convert("03-12-2011T10:15:30Z", ZonedDateTime.class, null);
        assertThat(zonedDateTime).isEqualTo("2011-12-03T10:15:30Z");
    }

}
