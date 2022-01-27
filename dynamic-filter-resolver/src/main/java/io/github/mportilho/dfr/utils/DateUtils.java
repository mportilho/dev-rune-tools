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

package io.github.mportilho.dfr.utils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public final class DateUtils {

    public static final DateTimeFormatter MONTH_YEAR_FORMATTER;
    public static final DateTimeFormatter DATE_FORMATTER;
    public static final DateTimeFormatter TIME_FORMATTER;
    public static final DateTimeFormatter DATETIME_FORMATTER;
    public static final DateTimeFormatter DATETIME_FORMATTER_PADDING_TIME;

    static {
        String DEF_YEAR_MONTH = "yyyyMM";
        String DEF_SLASH_YEAR_MONTH = "MM/yyyy";
        String DEF_DASH_YEAR_MONTH = "MM-yyyy";
        String DEF_SLASH_YEAR_MONTH_INVERTED = "yyyy/MM";
        String DEF_DASH_YEAR_MONTH_INVERTED = "yyyy-MM";

        String DEF_SLASH_DATE = "yyyy/MM[/dd]";
        String DEF_DASH_DATE = "yyyy-MM[-dd]";
        String DEF_SLASH_DATE_PTBR = "dd/MM/yyyy";
        String DEF_DASH_DATE_PTBR = "dd-MM-yyyy";

        String DEF_DATE_TIME_SEPARATOR = "['Z']['T']['z']['t'][ ][-]";

        String DEF_TIME = "HH:mm[:ss[.SSSSSSSSS]]";
        String DEF_TIMEZONE = "[ Z][Z][XXX]['Z']";

        StringBuilder sb;

        sb = new StringBuilder();
        appendOptional(sb, DEF_YEAR_MONTH, DEF_SLASH_YEAR_MONTH, DEF_DASH_YEAR_MONTH, DEF_SLASH_YEAR_MONTH_INVERTED, DEF_DASH_YEAR_MONTH_INVERTED);
        MONTH_YEAR_FORMATTER = new DateTimeFormatterBuilder().appendPattern(sb.toString()).toFormatter();

        sb = new StringBuilder();
        appendOptional(sb, DEF_SLASH_DATE, DEF_DASH_DATE, DEF_SLASH_DATE_PTBR, DEF_DASH_DATE_PTBR);
        DATE_FORMATTER = new DateTimeFormatterBuilder().appendOptional(DateTimeFormatter.BASIC_ISO_DATE).appendPattern(sb.toString())
                .toFormatter();

        sb = new StringBuilder();
        appendOptional(sb, String.format("%s[%s]", DEF_TIME, DEF_TIMEZONE));
        TIME_FORMATTER = new DateTimeFormatterBuilder().appendPattern(sb.toString()).toFormatter();

        sb = new StringBuilder();
        appendOptional(sb, String.format("%s[%s%s][%s]", DEF_SLASH_DATE, DEF_DATE_TIME_SEPARATOR, DEF_TIME, DEF_TIMEZONE));
        appendOptional(sb, String.format("%s[%s%s][%s]", DEF_DASH_DATE, DEF_DATE_TIME_SEPARATOR, DEF_TIME, DEF_TIMEZONE));
        appendOptional(sb, String.format("%s[%s%s][%s]", DEF_SLASH_DATE_PTBR, DEF_DATE_TIME_SEPARATOR, DEF_TIME, DEF_TIMEZONE));
        appendOptional(sb, String.format("%s[%s%s][%s]", DEF_DASH_DATE_PTBR, DEF_DATE_TIME_SEPARATOR, DEF_TIME, DEF_TIMEZONE));
        DATETIME_FORMATTER = new DateTimeFormatterBuilder().appendOptional(DateTimeFormatter.BASIC_ISO_DATE).appendPattern(sb.toString())
                .toFormatter();

        DATETIME_FORMATTER_PADDING_TIME = new DateTimeFormatterBuilder().append(DATETIME_FORMATTER)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).parseDefaulting(ChronoField.NANO_OF_SECOND, 0).toFormatter();
    }

    private DateUtils() {
    }

    private static void appendOptional(StringBuilder sb, String... values) {
        for (String value : values) {
            sb.append("[").append(value).append("]");
        }
    }

}
