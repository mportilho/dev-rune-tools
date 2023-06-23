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
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVectorOperations {

    @Test
    public void testVectorVariable() {
        MathSentence compiler = new MathSentence("mirr(pmts, f_rate%, r_rate%)");
        compiler.setVariable("pmts", new float[]{-1000, 300, 400, 400, 300});
        compiler.setVariable("f_rate", 12);
        compiler.setVariable("r_rate", 10);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.136997740050973");
    }

    @Test
    public void testFunctionCall_withTwoVectorVariables() {
        MathSentence compiler = new MathSentence("xirr(pmts, dates, guess)");
        compiler.setVariable("pmts", new int[]{-1000, 300, 400, 400, 300});
        compiler.setVariable("dates", new LocalDate[]{
                LocalDate.of(2011, 12, 1),
                LocalDate.of(2012, 1, 1),
                LocalDate.of(2013, 2, 1),
                LocalDate.of(2014, 3, 1),
                LocalDate.of(2015, 4, 1)
        });
        compiler.setVariable("guess", 0.2);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.23860325587217024");
    }

}
