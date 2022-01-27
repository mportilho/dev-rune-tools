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

package io.github.mportilho.dfr.mocks.interfaces;

import io.github.mportilho.dfr.core.operation.type.Equals;
import io.github.mportilho.dfr.core.operation.type.GreaterOrEquals;
import io.github.mportilho.dfr.core.operation.type.Like;
import io.github.mportilho.dfr.core.processor.annotation.Conjunction;
import io.github.mportilho.dfr.core.processor.annotation.Filter;

@Conjunction(value = {
        @Filter(path = "author", parameters = "author", operation = Equals.class, modifiers = {"mod1=modValue1"}),
        @Filter(path = "genre", parameters = "genre", operation = Equals.class, modifiers = {"mod2=modValue2", "mod3=modValue3"}),
        @Filter(path = "releaseDate", parameters = "releaseDate", operation = GreaterOrEquals.class, format = "dd-MM/yyyy"),
        @Filter(path = "trackQuery", parameters = "trackQuery", operation = Like.class, format = "${TRACK_REGEX}"),
})
public interface SearchMusics {
}
