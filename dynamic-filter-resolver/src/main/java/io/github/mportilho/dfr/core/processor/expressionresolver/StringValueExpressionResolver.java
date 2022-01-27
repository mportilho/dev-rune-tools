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

package io.github.mportilho.dfr.core.processor.expressionresolver;

import io.github.mportilho.dfr.core.processor.ValueExpressionResolver;

import java.util.Collections;
import java.util.Map;

public class StringValueExpressionResolver implements ValueExpressionResolver<String> {

    private final Map<String, String> valueMap;
    private final ValueExpressionResolver<String> delegate;

    public StringValueExpressionResolver(Map<String, String> valueMap) {
        this(valueMap, null);
    }

    public StringValueExpressionResolver(Map<String, String> valueMap, ValueExpressionResolver<String> delegate) {
        this.valueMap = valueMap != null ? valueMap : Collections.emptyMap();
        this.delegate = delegate;
    }

    @Override
    public String resolveValue(String value) {
        if (value == null) {
            return null;
        } else if (valueMap.containsKey(value)) {
            return valueMap.get(value);
        }
        return delegate != null ? delegate.resolveValue(value) : null;
    }

}
