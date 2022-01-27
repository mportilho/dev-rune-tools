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

package io.github.mportilho.dfr.core.operation;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//TODO include doc

public record FilterData(
        String attributePath,
        String path,
        String[] parameters,
        Class<?> targetType,
        @SuppressWarnings("rawtypes") Class<? extends FilterOperationFactory> operation,
        boolean negate,
        boolean ignoreCase,
        List<Object[]> values,
        String format,
        Map<String, String> modifiers
) {

    public FilterData {
        Objects.requireNonNull(parameters, "Parameters cannot be null");
        Objects.requireNonNull(values, "Value list cannot be null");
    }

    /**
     * @return the parameter's value if there's one provided from the first array
     * position. Returns null if none is found.
     */
    public Object findOneValue() {
        if (values == null || values.isEmpty() || (values.size() == 1 && values.get(0) == null)) {
            return null;
        } else if (values.size() > 1 || (values.get(0) != null && values.get(0).length > 1)) {
            throw new IllegalStateException(String.format("Multiple values found while fetching a single one for path [%s]", path));
        }
        return values.get(0)[0];
    }

    public Object findOneValueOnIndex(int i) {
        if (values.isEmpty()) {
            return null;
        } else if (i >= values.size()) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Accessing nonexistent value index [%s] for path [%s]", i, path));
        }
        Object[] objects = values.get(i);
        if (objects != null && objects.length > 0) {
            if (objects.length > 1) {
                throw new IllegalStateException(String.format("Multiple values found while fetching a single one for path [%s]", path));
            }
            return objects[0];
        }
        return null;
    }

    public String findModifier(String name) {
        if (modifiers != null) {
            return modifiers.get(name);
        }
        return null;
    }

}
