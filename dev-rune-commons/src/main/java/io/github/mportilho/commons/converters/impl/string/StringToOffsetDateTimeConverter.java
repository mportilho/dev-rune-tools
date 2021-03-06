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

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Converts an {@link OffsetDateTime} from a {@link String}
 *
 * @author Marcelo Portilho
 */
public class StringToOffsetDateTimeConverter implements FormattedConverter<String, OffsetDateTime> {

    /**
     * {@inheritDoc}
     */
    @Override
    public OffsetDateTime convert(String source, String format) {
        Objects.requireNonNull(source);
        if (isNullOrBlank(format)) {
            return DateUtils.DATETIME_FORMATTER.parse(source, OffsetDateTime::from);
        }
        return DateTimeFormatter.ofPattern(format).parse(source, OffsetDateTime::from);
    }

}
