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


import io.github.mportilho.dfr.core.operation.type.Between;
import io.github.mportilho.dfr.core.operation.type.Equals;
import io.github.mportilho.dfr.core.operation.type.Like;
import io.github.mportilho.dfr.core.processor.annotation.Disjunction;
import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.github.mportilho.dfr.core.processor.annotation.Statement;

@Disjunction(value = {
        @Filter(path = "isbn", parameters = "isbn", operation = Equals.class)
},
        conjunctions = {
                @Statement({
                        @Filter(path = "author", parameters = "author", operation = Like.class, ignoreCase = true),
                        @Filter(path = "publishingDate", parameters = {"publishedFrom", "publishedTo"}, operation = Between.class, required = true),
                        @Filter(path = "releaseState", parameters = "releaseState", operation = Equals.class, negate = "${VAR_NEG_STATE}", defaultValues = "0")
                })
        }
)
public interface SearchBooks {
}
