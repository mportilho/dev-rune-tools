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

package io.github.mportilho.dfr.mocks.interfaces.queries;


import io.github.mportilho.dfr.core.processor.annotation.Conjunction;
import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.github.mportilho.dfr.core.operation.type.IsIn;
import io.github.mportilho.dfr.core.operation.type.IsNotIn;
import io.github.mportilho.dfr.core.operation.type.IsNotNull;
import io.github.mportilho.dfr.core.operation.type.IsNull;

@Conjunction(value = {
        @Filter(path = "addresses.number", parameters = "houseNumber", operation = IsNull.class, defaultValues = "true"),
        @Filter(path = "name", parameters = "clientName", operation = IsNotNull.class, defaultValues = "true"),
        @Filter(path = "height", parameters = "height", operation = IsIn.class, defaultValues = {"170", "180", "190"}),
        @Filter(path = "addresses.number", parameters = "houseNumber", operation = IsNotIn.class, defaultValues = {"1010", "1020", "1030"}),
        @Filter(path = "weight", parameters = "weight", operation = IsNotNull.class)
})
public interface OtherComparisonOperations {

}
