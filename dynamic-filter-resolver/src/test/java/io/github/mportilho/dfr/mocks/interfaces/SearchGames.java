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

import io.github.mportilho.dfr.core.processor.annotation.Conjunction;
import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.github.mportilho.dfr.core.operation.type.Between;
import io.github.mportilho.dfr.core.operation.type.Equals;
import io.github.mportilho.dfr.core.operation.type.IsIn;

import java.math.BigDecimal;
import java.time.LocalDate;

@Conjunction(value = {
        @Filter(path = "genre", parameters = "genre", operation = Equals.class, targetType = String.class, required = true),
        @Filter(path = "onSale", parameters = "onSale", operation = Equals.class, targetType = String.class, defaultValues = "${ON_SALE}"),
        @Filter(path = "specialClient", parameters = "specialClient", operation = Equals.class, targetType = Boolean.class, constantValues = "${SPECIAL_CLIENT}"),
        @Filter(path = "dateSearchInterval", parameters = {"minDate", "maxDate"}, operation = Between.class, targetType = LocalDate.class, defaultValues = {"${MIN_DATE}", "${MAX_DATE}"}),
        @Filter(path = "priceInterval", parameters = {"minPrice", "maxPrice"}, operation = Between.class, targetType = BigDecimal.class),
        @Filter(path = "tags", parameters = "tags", operation = IsIn.class, targetType = String.class, defaultValues = {"on_stock", "reviewed"})
})
public interface SearchGames {
}
