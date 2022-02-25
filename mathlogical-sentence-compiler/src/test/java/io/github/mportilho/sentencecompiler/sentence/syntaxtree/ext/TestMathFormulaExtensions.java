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

import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.MathFormulasExtension.mathFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite.keyName;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSiteFactory.VARARGS;
import static java.math.BigDecimal.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestMathFormulaExtensions {

    private static final LambdaContext CONTEXT = new LambdaContext(MathContext.DECIMAL64, null);

    @Test
    public void test_Max_Function() {
        LambdaCallSite max = mathFunctionsFactory().get(keyName("max", VARARGS));

        assertThat((BigDecimal) max.call(CONTEXT, new Object[]{new BigDecimal[]{ONE}}))
                .isEqualByComparingTo("1");

        assertThat((BigDecimal) max.call(CONTEXT, new Object[]{new BigDecimal[]{TEN, valueOf(-50)}}))
                .isEqualByComparingTo("10");

        assertThat((BigDecimal) max.call(CONTEXT, new Object[]{new BigDecimal[]{ONE, TEN, valueOf(-50), valueOf(231)}}))
                .isEqualByComparingTo("231");

        assertThat((BigDecimal) max.call(CONTEXT, new Object[]{new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}}))
                .isEqualByComparingTo("99");
    }

    @Test
    public void test_Min_Function() {
        LambdaCallSite min = mathFunctionsFactory().get(keyName("min", VARARGS));

        assertThat((BigDecimal) min.call(CONTEXT, new Object[]{new BigDecimal[]{ONE}}))
                .isEqualByComparingTo("1");

        assertThat((BigDecimal) min.call(CONTEXT, new Object[]{new BigDecimal[]{valueOf(-50), valueOf(231)}}))
                .isEqualByComparingTo("-50");

        assertThat((BigDecimal) min.call(CONTEXT, new Object[]{new BigDecimal[]{ONE, TEN, valueOf(-50), valueOf(231)}}))
                .isEqualByComparingTo("-50");

        assertThat((BigDecimal) min.call(CONTEXT, new Object[]{new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}}))
                .isEqualByComparingTo("1");
    }

    @Test
    public void test_Avg_Function() {
        LambdaCallSite avg = mathFunctionsFactory().get(keyName("avg", VARARGS));

        assertThat((BigDecimal) avg.call(CONTEXT, new Object[]{new BigDecimal[]{valueOf(231)}}))
                .isEqualByComparingTo("231");

        assertThat((BigDecimal) avg.call(CONTEXT, new Object[]{new BigDecimal[]{ONE, TEN}}))
                .isEqualByComparingTo("5.5");

        assertThat((BigDecimal) avg.call(CONTEXT, new Object[]{new Object[]{ONE, "10", valueOf(-50), valueOf(231)}}))
                .isEqualByComparingTo("48");

        assertThat((BigDecimal) avg.call(CONTEXT, new Object[]{new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}}))
                .isEqualByComparingTo("41.1");
    }

    @Test
    public void test_Rule3d_Function() {
        LambdaCallSite rule3d = mathFunctionsFactory().get(keyName("rule3d", 3));
        assertThat((BigDecimal) rule3d.call(CONTEXT, new Double[]{1.2, 400.0, 1.5}))
                .isEqualByComparingTo("500");
    }

    @Test
    public void test_Rule3i_Function() {
        LambdaCallSite rule3i = mathFunctionsFactory().get(keyName("rule3i", 3));
        assertThat((BigDecimal) rule3i.call(CONTEXT, new Integer[]{400, 3, 480}))
                .isEqualByComparingTo("2.5");
    }

}
