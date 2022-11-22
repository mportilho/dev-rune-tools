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

package io.github.mportilho.commons.converters.impl;


import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.FormattedConverter;
import io.github.mportilho.commons.converters.NoFormattedConverterFoundException;
import io.github.mportilho.commons.converters.impl.availfacs.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DefaultFormattedConversionService implements FormattedConversionService {

    private static final Map<ConvertMappingKey, FormattedConverter<?, ?>> FORMATTED_CONVERTERS = loadFormattedValueConverters();

    public DefaultFormattedConversionService() {
    }

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return FORMATTED_CONVERTERS.containsKey(new ConvertMappingKey(sourceType, targetType));
    }

    @SuppressWarnings("unchecked")
    public <S, T> T convert(S source, Class<T> targetType, String format) {
        Objects.requireNonNull(targetType, "Target Type must be provided");
        if (source == null) {
            return null;
        } else if (source.getClass().equals(targetType)) {
            return (T) source;
        }
        ConvertMappingKey convertMappingKey = new ConvertMappingKey(source.getClass(), targetType);
        FormattedConverter<S, T> converter = (FormattedConverter<S, T>) FORMATTED_CONVERTERS.get(convertMappingKey);
        return converter != null ? converter.convert(source, format) : fallbackConversion(source, targetType);
    }

    @SuppressWarnings("unchecked")
    private <S, T> T fallbackConversion(S source, Class<T> targetType) {
        if (targetType.isInstance(source)) {
            return (T) source;
        }
        T anEnum = convertEnum(source, targetType);
        if (anEnum != null) {
            return anEnum;
        }
        throw new NoFormattedConverterFoundException(source.getClass(), targetType);
    }

    private <S, T> T convertEnum(S source, Class<T> targetType) {
        if (targetType.isEnum()) {
            if (source instanceof String value) {
                for (T enumConstant : targetType.getEnumConstants()) {
                    if (((Enum<?>) enumConstant).name().equalsIgnoreCase(value)) {
                        return enumConstant;
                    }
                }
            } else if (source instanceof Number value) {
                for (T enumConstant : targetType.getEnumConstants()) {
                    if (value.intValue() == ((Enum<?>) enumConstant).ordinal()) {
                        return enumConstant;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Adds the default {@link FormattedConverter}s into the new instance of this
     * type
     */
    private static Map<ConvertMappingKey, FormattedConverter<?, ?>> loadFormattedValueConverters() {
        Map<ConvertMappingKey, FormattedConverter<?, ?>> formattedConverters = new HashMap<>();
        AvailableBigDecimalFormatters.loadFormattedValueConverters(formattedConverters);
        AvailableDatesFormatters.loadFormattedValueConverters(formattedConverters);
        AvailableDoubleConverters.loadFormattedValueConverters(formattedConverters);
        AvailableFloatConverters.loadFormattedValueConverters(formattedConverters);
        AvailableIntegerConverters.loadFormattedValueConverters(formattedConverters);
        AvailableLongConverters.loadFormattedValueConverters(formattedConverters);
        AvailableShortConverters.loadFormattedValueConverters(formattedConverters);
        AvailableStringFormatters.loadFormattedValueConverters(formattedConverters);
        return formattedConverters;
    }

}
