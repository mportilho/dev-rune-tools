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

package io.github.mportilho.sentencecompiler.support.formula;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.support.functions.ExcelFinancialFunction.*;
import static java.math.BigDecimal.*;

public class TestMoreExcelFinancialFormula {

    @Test
    public void test_fv() {
        assertThat(fv(valueOf(0.1), valueOf(3), valueOf(1), valueOf(-100), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("129.79");
    }

    @Test
    public void test_pv() {
        assertThat(pv(valueOf(0.1), ONE, valueOf(3), ONE, valueOf(-100), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("72.644628099173558");
    }

    @Test
    public void test_complex_pv() {
        assertThat(pv(valueOf(0.1), ONE, valueOf(5), valueOf(1000), valueOf(-1000), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-3169.8654463492928");

        assertThat(pv(valueOf(0.1), ONE, valueOf(5), valueOf(1000), valueOf(0), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-3790.786769408448");

        assertThat(pv(valueOf(0.05), ONE, valueOf(5), valueOf(1000), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-4329.476670630820");

        assertThat(pv(valueOf(0.05), ONE, valueOf(5), valueOf(1000), valueOf(0), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("-4545.950504162361");

        assertThat(pv(valueOf(0.05), valueOf(5), valueOf(1000), MathContext.DECIMAL64))
                .isEqualByComparingTo("-4329.476670630820");
    }

    @Test
    public void test_npv() {
        assertThat(npv(valueOf(0.05), valueOf(-1000), new BigDecimal[]{valueOf(300), valueOf(400), valueOf(400), valueOf(300)}, MathContext.DECIMAL64))
                .isEqualByComparingTo("240.871858947661");
    }

    @Test
    public void test_pmt() {
        assertThat(pmt(valueOf(0.1), valueOf(3), valueOf(1000), valueOf(0), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-402.1148036253776");
    }

    @Test
    public void test_ppmt() {
        assertThat(ppmt(valueOf(0.1), ONE, valueOf(3), valueOf(1000), valueOf(0), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-302.1148036253776");

        assertThat(ppmt(valueOf(0.1), valueOf(3), valueOf(1000), MathContext.DECIMAL64))
                .isEqualByComparingTo("-302.1148036253776");
    }

    @Test
    public void test_irr() {
        assertThat(irr(new BigDecimal[]{valueOf(-1000), valueOf(300), valueOf(400), valueOf(400), valueOf(300)},
                ZERO, MathContext.DECIMAL64)).isEqualByComparingTo("0.1489502812737555");
    }

    @Test
    public void test_mirr() {
        assertThat(mirr(new BigDecimal[]{valueOf(-1000), valueOf(300), valueOf(400), valueOf(400), valueOf(300)},
                valueOf(0.12), valueOf(0.1),
                MathContext.DECIMAL64))
                .isEqualByComparingTo("0.136997740050973");
    }

}
