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

package io.github.mportilho.commons.converters.impl.availfacs;

import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.impl.ConvertMappingKey;
import io.github.mportilho.commons.converters.impl.dates.*;

import java.time.*;
import java.util.Map;

public class AvailableDatesFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDate.class), new SqlDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalDateTime.class), new SqlDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, LocalTime.class), new SqlDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.sql.Date.class, ZonedDateTime.class), new SqlDateToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDate.class), new UtilDateToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalDateTime.class), new UtilDateToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, LocalTime.class), new UtilDateToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(java.util.Date.class, ZonedDateTime.class), new UtilDateToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(LocalDate.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, ZonedDateTime.class), new TemporalToZonedDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDate.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalDateTime.class), new TemporalToLocalDateTimeConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalDate.class), new TemporalToLocalDateConverter());

        formattedConverters.put(new ConvertMappingKey(ZonedDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(LocalDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(OffsetDateTime.class, LocalTime.class), new TemporalToLocalTimeConverter());

    }

}
