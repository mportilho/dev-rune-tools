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

    private Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> formattedConverters;

    public DefaultFormattedConversionService() {
        this.formattedConverters = loadFormattedValueConverters();
    }

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return formattedConverters.containsKey(new ConvertMappingKey(sourceType, targetType));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S, T, F> T convert(S source, Class<T> targetType, F format) {
        Objects.requireNonNull(targetType, "Target Type must be provided");
        if (source == null) {
            return null;
        } else if (source.getClass().equals(targetType)) {
            return (T) source;
        }
        FormattedConverter<S, T, F> converter = (FormattedConverter<S, T, F>) formattedConverters
                .get(new ConvertMappingKey(source.getClass(), targetType));
        if (converter == null) {
            if (targetType.isInstance(source)) {
                return (T) source;
            }
            throw new NoFormattedConverterFoundException(source.getClass(), targetType);
        }
        return converter.convert(source, format);
    }

    /**
     * Adds the default {@link FormattedConverter}s into the new instance of this
     * type
     */
    private Map<ConvertMappingKey, FormattedConverter<?, ?, ?>> loadFormattedValueConverters() {
        formattedConverters = new HashMap<>();
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
