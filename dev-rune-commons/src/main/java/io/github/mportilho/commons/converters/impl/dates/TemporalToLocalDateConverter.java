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

import io.github.mportilho.commons.converters.FormattedConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

public class TemporalToLocalDateConverter implements FormattedConverter<Temporal, LocalDate> {

    @Override
    public LocalDate convert(Temporal source, String format) {
        if (source instanceof ZonedDateTime src) {
            return zonedDateTimeToLocalDate(src);
        } else if (source instanceof LocalDateTime src) {
            return localDateTimeToLocalDate(src);
        } else if (source instanceof OffsetDateTime src) {
            return offsetDateTimeToLocalDate(src);
        }
        throw new IllegalArgumentException(String.format("Converter from [%s] to [%s] not available",
                source.getClass(), LocalDate.class));
    }


    public LocalDate zonedDateTimeToLocalDate(ZonedDateTime source) {
        return source.toLocalDate();
    }

    public LocalDate localDateTimeToLocalDate(LocalDateTime source) {
        return source.toLocalDate();
    }

    public LocalDate offsetDateTimeToLocalDate(OffsetDateTime source) {
        return source.toLocalDate();
    }
}
