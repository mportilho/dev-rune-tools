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

package io.github.mportilho.sentencecompiler.sentence.syntaxtree.ext;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.DateTimeFunctionExtension.dateTimeFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.MethodMetadataFactory.keyName;

public class TestDateTimeFunctionExtension {

    private static final FunctionContext functionContext =
            new FunctionContext(MathContext.DECIMAL64, null, new DefaultFormattedConversionService());

    @Test
    public void test_secondsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("secondsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(60 * 60 * 24 * 2L);
    }

    @Test
    public void test_minutesBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("minutesBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(60 * 24 * 2L);
    }

    @Test
    public void test_hoursBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("hoursBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(24 * 2L);
    }

    @Test
    public void test_daysBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("daysBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(2L);
    }

    @Test
    public void test_monthsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("monthsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusYears(2)}))
                .isEqualByComparingTo(12 * 2L);
    }

    @Test
    public void test_yearsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("yearsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusYears(2)}))
                .isEqualByComparingTo(2L);
    }
}
