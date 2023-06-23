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

package io.github.mportilho.sentencecompiler.sentence.cache;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class TestConstantAndVariableOperationCaches {

    private static CacheCheckVisitor cacheVisitor;

    @BeforeAll
    public static void beforeClass() {
        cacheVisitor = new CacheCheckVisitor();
    }

    @Test
    public void testSimpleOperation() {
        MathSentence original = new MathSentence("(c) * (a + b)");
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.setConstant("a", 1);
        original.setVariable("b", 2);
        original.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(1);

        original.setConstant("b", 2);
        original.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(1);
        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

        original.setConstant("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
    }

    @Test
    public void testCacheWithOrBooleanConstantOperations() {
        MathSentence original = new MathSentence("if (d = 0 or a > b or 1 = 1) then 1 else 0 endif");
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.setConstant("a", 1);
        original.setVariable("b", 2);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(7);

        original.setConstant("d", 0);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(9);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(9);

        original.setConstant("b", 2);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(15);
    }

    @Test
    public void testCacheSimpleConditionalOperations_withConstants() {
        MathSentence original = new MathSentence("((<datetime>a < b plusDays 1) or (c or d)) and f");

        original.warmUp();

        Date date = new Date();
        original.setConstant("a", new java.sql.Date(date.getTime()));
        original.setVariable("b", date);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(2);

        original.setConstant("b", date);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(5);

        original.setConstant("c", false);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(6);

        original.setConstant("f", true);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(7);

        original.setConstant("d", true);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(12);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualTo(12);
    }

}
