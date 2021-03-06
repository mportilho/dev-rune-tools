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

package io.github.mportilho.dfr.mocks.interfaces;


import io.github.mportilho.dfr.core.processor.annotation.Disjunction;
import io.github.mportilho.dfr.core.processor.annotation.Filter;
import io.github.mportilho.dfr.core.processor.annotation.Statement;
import io.github.mportilho.dfr.core.operation.type.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Disjunction(
        value = {
                @Filter(path = "deleted", parameters = "delete", operation = Equals.class, defaultValues = "false", targetType = Boolean.class),
                @Filter(path = "name", parameters = "name", operation = NotEquals.class, targetType = String.class)
        },
        conjunctions = {
                @Statement({
                        @Filter(path = "status", parameters = "status", operation = Equals.class, targetType = StatusEnum.class)
                }),
                @Statement({
                        @Filter(path = "birthday", parameters = "birthday", operation = GreaterOrEquals.class, defaultValues = "12/12/2012", targetType = LocalDate.class),
                        @Filter(path = "height", parameters = "height", operation = Greater.class, targetType = StatusEnum.class)
                }),
                @Statement({
                        @Filter(path = "student", parameters = "student", operation = Equals.class, constantValues = "true", targetType = Boolean.class),
                        @Filter(path = "weight", parameters = "weight", operation = LessOrEquals.class, targetType = BigDecimal.class)
                })
        }
)
public interface RequiringSomeValuesAndSomeDefaults {

}
