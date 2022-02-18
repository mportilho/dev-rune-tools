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

package io.github.mportilho.sentencecompiler.lambda;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

import static io.github.mportilho.sentencecompiler.formulas.ExcelFinancialFunction.*;
import static java.math.BigDecimal.*;

public class TestExcelFinancialFormulas {

    private static final BigDecimal r = valueOf(0.05);
    private static final BigDecimal per = valueOf(12);
    private static final BigDecimal nper = valueOf(10);
    private static final BigDecimal pv = valueOf(5000);
    private static final BigDecimal fv = valueOf(22000);
    private static final BigDecimal pmt = valueOf(100);
    private static final MathContext mc = MathContext.DECIMAL64;

    @Test
    public void test_pmt() {
        assertThat(pmt(r, nper, pv, fv, ZERO, mc))
                .isEqualByComparingTo("-2396.623524067332");

        assertThat(pmt(r, nper, pv, fv, mc)).isEqualByComparingTo("-2396.623524067332");
        assertThat(pmt(r, nper, pv, mc)).isEqualByComparingTo("-647.5228748272837");
    }

    @Test
    public void test_ipmt() {
        assertThat(ipmt(r, per, nper, pv, fv, ZERO, mc)).isEqualByComparingTo("1274.831176203366");
        assertThat(ipmt(r, per, nper, pv, fv, mc)).isEqualByComparingTo("1274.831176203366");
        assertThat(ipmt(r, per, nper, pv, mc)).isEqualByComparingTo("32.37614374136415");
    }

    @Test
    public void test_ppmt() {
        assertThat(ppmt(r, per, nper, pv, fv, ZERO, mc)).isEqualByComparingTo("-3671.454700270698");
        assertThat(ppmt(r, per, nper, pv, fv, mc)).isEqualByComparingTo("-3671.454700270698");
        assertThat(ppmt(r, per, nper, pv, mc)).isEqualByComparingTo("-679.8990185686478");
    }

    @Test
    public void test_fv() {
        assertThat(fv(valueOf(0.18), valueOf(12), ONE, ZERO, valueOf(10000), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-11956.18171461535");

        assertThat(fv(r, ONE, nper, ZERO, pv, ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-8144.473133887205");

        assertThat(fv(r, ONE, nper, pmt, pv, ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-9402.262387442087");

        assertThat(fv(r, nper, pmt, pv, MathContext.DECIMAL64))
                .isEqualByComparingTo("-9402.262387442087");

        assertThat(fv(r, per, nper, ZERO, pv, ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-8235.047488451745");

        assertThat(fv(r, per, nper, pmt, pv, ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("-23763.27543302012");

    }

    @Test
    public void test_fvs() {
        assertThat(fvs(r, per, nper, pmt, ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("15528.22794456837");

        assertThat(fvs(valueOf(0.1), valueOf(12), ONE, pmt, valueOf(4), ZERO, MathContext.DECIMAL64))
                .isEqualByComparingTo("418.8522697651720");
    }

    @Test
    public void test_pv() {
        assertThat(pv(valueOf(0.08), valueOf(12), valueOf(5), valueOf(10000), MathContext.DECIMAL64))
                .isEqualByComparingTo("6712.104444291458");
    }

    @Test
    public void teste_r() {
        assertThat(r(valueOf(12), valueOf(5), valueOf(6712.10), valueOf(10000), MathContext.DECIMAL64))
                .isEqualByComparingTo("0.080000133309060");
    }

    @Test
    public void teste_nper() {
        assertThat(nper(valueOf(0.08), valueOf(12), valueOf(6712.10), valueOf(10000), MathContext.DECIMAL64))
                .isEqualByComparingTo("5.000008304196684");
    }

    @Test
    public void teste_eir() {
        // month => biannual
        assertThat(eir(valueOf(0.18), valueOf(12), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.195618171461535");

        // annual => annually compounding
        assertThat(eir(valueOf(0.1), ONE, ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.1");

        // annual => six monthly compounding
        assertThat(eir(valueOf(0.1), valueOf(2), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.1025");

        // annual => quarterly compounding
        assertThat(eir(valueOf(0.1), valueOf(4), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.103812890625");

        // annual => monthly compounding
        assertThat(eir(valueOf(0.1), valueOf(12), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.104713067441293");

        // annual => daily compounding
        assertThat(eir(valueOf(0.1), valueOf(365), ONE, MathContext.DECIMAL64))
                .isEqualByComparingTo("0.105155781616375");

        // monthly = annually
        assertThat(eir(valueOf(0.02), ONE, valueOf(12), MathContext.DECIMAL64))
                .isEqualByComparingTo("0.268241794562545");
    }

    @Test
    public void test_npv() {
        assertThat(npv(valueOf(0.1), valueOf(100), Arrays.asList(valueOf(60), valueOf(60)), MathContext.DECIMAL64))
                .isEqualByComparingTo("4.1322314049587");

        assertThat(npv(valueOf(0.15), valueOf(100), Arrays.asList(valueOf(60), valueOf(60)), MathContext.DECIMAL64))
                .isEqualByComparingTo("-2.45746691871456");

        assertThat(npv(valueOf(0.131), valueOf(100), Arrays.asList(valueOf(60), valueOf(60)), MathContext.DECIMAL64))
                .isEqualByComparingTo("-0.04385687180895");
    }

}
