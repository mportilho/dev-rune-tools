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

package io.github.mportilho.commons.converters.impl.string;


import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.utils.DateUtils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * Converts a {@link Date} from a {@link String}
 *
 * @author Marcelo Portilho
 */
public class StringToJavaSqlDateConverter implements FormattedConverter<String, Date> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Date convert(String source, String format) {
        Temporal temporal;
        if (isNullOrBlank(format)) {
            if (source.length() <= 10) {
                temporal = DateUtils.DATETIME_FORMATTER.parse(source, LocalDate::from);
            } else if (source.length() <= 30) {
                temporal = DateUtils.DATETIME_FORMATTER.parse(source, LocalDateTime::from);
            } else {
                temporal = DateUtils.DATETIME_FORMATTER.parse(source, ZonedDateTime::from);
            }
        } else {
            if (source.length() <= 10) {
                temporal = DateTimeFormatter.ofPattern(format).parse(source, LocalDate::from);
            } else if (source.length() <= 30) {
                temporal = DateTimeFormatter.ofPattern(format).parse(source, LocalDateTime::from);
            } else {
                temporal = DateTimeFormatter.ofPattern(format).parse(source, ZonedDateTime::from);
            }
        }
        if (temporal instanceof LocalDate localDate) {
            return Date.valueOf(localDate);
        } else if (temporal instanceof LocalDateTime localDateTime) {
            return Date.valueOf(localDateTime.toLocalDate());
        }
        return Date.valueOf(((ZonedDateTime) temporal).toLocalDate());
    }

}
