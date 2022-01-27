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

package io.github.mportilho.sentencecompiler.sentence.formulas;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestFormulaCallsOnMathSentence {

    @Test
    public void testMathFormulas() {
        MathSentence compiler;

        compiler = new MathSentence("max(1, 3, 5.5, 100/10)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("10");

        compiler = new MathSentence("min(3/3, 3, 5.5, 100/10)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("1");

    }

    @Test
    public void testExcelFormulas() {
        MathSentence compiler;

        compiler = new MathSentence("fv(18%, 12, 1, 0, 10000, 0)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("-11956.18171461535");

        compiler = new MathSentence("ipmt(5%, 12, 10, 5000)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("32.37614374136415");
    }

}
