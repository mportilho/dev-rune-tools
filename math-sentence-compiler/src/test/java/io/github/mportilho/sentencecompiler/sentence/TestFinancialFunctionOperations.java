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

package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFinancialFunctionOperations {

    @Test
    public void test_FV() {
        MathSentence compiler;

        compiler = new MathSentence("fv(10%, 1, 3, 1, -100, 0)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("129.79");

        compiler = new MathSentence("fv(10%, 1, 3, 1, -100, 0)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("129.79");

        compiler = new MathSentence("fv(10%, 3, 1, -100)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("129.79");
    }

    @Test
    public void test_PV() {
        MathSentence compiler;

        compiler = new MathSentence("pv(10%, 1, 3, 1, -100, 0)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("72.644628099173558");
    }

    @Test
    public void test_NPV() {
        MathSentence compiler;

        compiler = new MathSentence("npv(5%, -1000, [300, 400, 400, 300])");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("240.871858947661");
    }

    @Test
    public void test_XNPV() {
        MathSentence compiler;

        compiler = new MathSentence("xnpv(5%, [-1000, 300, 400, 400, 300], [2011-12-01, 2012-01-01, 2013-02-01, 2014-03-01, 2015-04-01])");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("289.9017226041945");
    }

    @Test
    public void test_PMT() {
        MathSentence compiler;

        compiler = new MathSentence("pmt(10%, 3, 1000)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("-402.1148036253776");
    }

    @Test
    public void test_PPMT() {
        MathSentence compiler;

        compiler = new MathSentence("ppmt(10%, 1, 3, 1000)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("-302.1148036253776");

        compiler = new MathSentence("ppmt(10%, 2, 3, 1000)");
        assertThat((BigDecimal) compiler.compute()).isEqualByComparingTo("-332.3262839879154");
    }

    @Test
    public void test_IRR() {
        MathSentence compiler;

        compiler = new MathSentence("irr([-1000, 300, 400, 400, 300], 10%)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.1489502812737555");
    }

    @Test
    public void test_MIRR() {
        MathSentence compiler = new MathSentence("mirr([-1000, 300, 400, 400, 300], frate%, 10%)");
        compiler.setVariable("frate", 12);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.136997740050973");
    }

    @Test
    public void test_XIRR() {
        MathSentence compiler;

        compiler = new MathSentence("xirr([-1000, 300, 400, 400, 300], [2011-12-01, 2012-01-01, 2013-02-01, 2014-03-01, 2015-04-01], 10%)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.23860325588720818");
    }

}
