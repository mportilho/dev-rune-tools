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
import io.github.mportilho.commons.converters.impl.string.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.Map;

public class AvailableStringFormatters {

    public static void loadFormattedValueConverters(
            Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters) {
        formattedConverters.put(new ConvertMappingKey(String.class, BigDecimal.class), new StringToBigDecimalConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, BigInteger.class), new StringToBigIntegerConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Boolean.class), new StringToBooleanConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Byte.class), new StringToByteConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Double.class), new StringToDoubleConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Float.class), new StringToFloatConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Instant.class), new StringToInstantConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Integer.class), new StringToIntegerConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, java.sql.Date.class), new StringToJavaSqlDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Date.class), new StringToJavaUtilDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDate.class), new StringToLocalDateConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalDateTime.class), new StringToLocalDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, LocalTime.class), new StringToLocalTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Long.class), new StringToLongConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetDateTime.class), new StringToOffsetDateTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, OffsetTime.class), new StringToOffsetTimeConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Short.class), new StringToShortConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Timestamp.class), new StringToTimestampConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, Year.class), new StringToYearConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, YearMonth.class), new StringToYearMonthConverter());
        formattedConverters.put(new ConvertMappingKey(String.class, ZonedDateTime.class), new StringToZonedDateTimeConverter());
    }

}
