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

/**
 * Encapsules converting capabilities for the FormattedConverter component.
 * <p/>
 * For example, helps to delegate the SpringFramework's ConversionService or similar components.
 *
 * @author Marcelo Portilho
 */
public interface FormattedConversionService {

    /**
     * Indicates if this conversion service can convert a sourceType to a targetType
     *
     * @param sourceType The source's class to be converted from
     * @param targetType The source's target class to be converted to
     * @return an indication if there's a converter for the provided types
     */
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * Converts an object to a target type
     *
     * @param source     The value to be converted
     * @param targetType Target types for conversion
     * @param <T>        Target type
     * @return The converted object
     */
    <S, T> T convert(S source, Class<T> targetType, String format);

    /**
     * Converts an object to a target type
     *
     * @param source     The value to be converted
     * @param targetType Target types for conversion
     * @param <S>        Source Type
     * @param <T>        Target type
     * @return the converted value
     */
    default <S, T> T convert(S source, Class<T> targetType) {
        return convert(source, targetType, null);
    }

}
