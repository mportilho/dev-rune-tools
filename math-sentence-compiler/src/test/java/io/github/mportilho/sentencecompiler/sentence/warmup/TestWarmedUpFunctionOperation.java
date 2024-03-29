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

package io.github.mportilho.sentencecompiler.sentence.warmup;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.sentence.cache.CacheCheckVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestWarmedUpFunctionOperation {

    private static CacheCheckVisitor cacheVisitor;

    @BeforeAll
    public static void beforeClass() {
        cacheVisitor = new CacheCheckVisitor();
    }

    @Test
    public void testFunctionOperationsWithExternalNumberMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedNumber() + 2");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        mathSentence.warmUp();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
    }

    @Test
    public void testFunctionOperationsWithExternalStringMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedString() = 'food'");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        MathSentence copyBefore = mathSentence.copy();
        mathSentence.warmUp();
        MathSentence copyAfter = mathSentence.copy();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
        assertThat(copyBefore.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copyAfter.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
    }

    @Test
    public void testFunctionOperationsWithExternalDateMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedDate() = currDate");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        mathSentence.warmUp();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(1);
    }

    @Test
    public void testFunctionOperationsWithExternalTimeMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedTime() = 02:03:00");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        mathSentence.warmUp();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
    }

    @Test
    public void testFunctionOperationsWithExternalDateTimeMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("extractedDateTime() = (currDateTime setHours 2 setMinutes 3 setSeconds 0)");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        mathSentence.warmUp();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
    }

    @Test
    public void testFunctionOperationsWithExternalBooleanMethods() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("<bool>extractedBoolean()");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        mathSentence.warmUp();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(2);
    }

    @Test
    public void testFunctionOperationsWithNumberExternalMethods_MultipleParameters() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("add(3, 4 + 2 - extractedNumber())");
        mathSentence.addFunctionFromObject(new FunctionProviderClass());
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        MathSentence copyBefore = mathSentence.copy();
        mathSentence.warmUp();
        MathSentence copyAfter = mathSentence.copy();
        assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(8);
        assertThat(copyBefore.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copyAfter.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(8);
    }

    public static class FunctionProviderClass {

        public BigDecimal extractedNumber() {
            return BigDecimal.ONE;
        }

        public LocalDate extractedDate() {
            return LocalDate.now();
        }

        public LocalTime extractedTime() {
            return LocalTime.of(2, 3, 0);
        }

        public LocalDateTime extractedDateTime() {
            return LocalDateTime.of(LocalDate.now(), LocalTime.of(2, 3, 0));
        }

        public String extractedString() {
            return "food";
        }

        public Boolean extractedBoolean() {
            return Boolean.TRUE;
        }

        public BigDecimal add(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    }

}
