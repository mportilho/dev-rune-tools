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

package io.github.mportilho.sentencecompiler.sentence.copy;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.sentence.cache.CacheCheckVisitor;
import io.github.mportilho.sentencecompiler.testutils.OperationCollectorVisitor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGeneralMathSentenceCopy {

    private static CacheCheckVisitor cacheVisitor;

    @BeforeAll
    public static void beforeClass() {
        cacheVisitor = new CacheCheckVisitor();
    }

    @Test
    public void testSimpleCopy() {
        MathSentence original = new MathSentence("(c) * (a + b)");

        MathSentence copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.setVariable("a", 1);
        original.setVariable("b", 2);
        original.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        copiedSentence.setVariable("a", 1);
        copiedSentence.setVariable("b", 2);
        copiedSentence.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        copiedSentence.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testSimpleCopy_withConstants() {
        MathSentence original = new MathSentence("(c) * (a + b)");
        MathSentence copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.setConstant("a", 1);
        original.setConstant("b", 2);
        original.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        copiedSentence.setConstant("a", 1);
        copiedSentence.setConstant("b", 2);
        copiedSentence.setVariable("c", 3);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        copiedSentence.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithWarmedUpCompilerSimpleMathOperations() {
        MathSentence original = new MathSentence("((a + b) / (c * d)) - f");
        MathSentence copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        original.setVariable("a", 3);
        original.setVariable("b", 3);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("c", 1);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("f", 2);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", 2);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        copiedSentence.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithOrBooleanOperations() {
        MathSentence original = new MathSentence("if (d = 0 or a > b or 1 = 1) then 1 else 0 endif");
        MathSentence copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("a", 1);
        original.setVariable("b", 2);
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(6);

        original.setVariable("d", 0);
        original.warmUp();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(6);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(6);

        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(6);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithAndBooleanExpression() {
        MathSentence original = new MathSentence("if (0 != 0 and a > b and 1 = 1) then 1 else 0 endif");
        original.setVariable("a", 1);
        original.setVariable("b", 2);

        MathSentence copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.compute();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        copiedSentence = original.copy();
        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(4);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithWarmedUpCompilerSimpleConditionalOperations() {
        MathSentence original = new MathSentence("((<datetime>a < b plusDays 1) or (c or d)) and f");
        MathSentence copiedSentence = original.copy();

        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        Date date = new Date();
        original.setVariable("a", new java.sql.Date(date.getTime()));
        original.setVariable("b", date);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        original.setVariable("c", false);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        original.setVariable("f", true);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        original.setVariable("d", true);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        copiedSentence.compute();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(1);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithWarmedUpCompilerSimpleIfElseOperations() {
        MathSentence original = new MathSentence("if a > b then c + d else f endif");
        MathSentence copiedSentence = original.copy();

        original.warmUp();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("a", 1);
        original.setVariable("c", 4);
        original.setVariable("d", 7);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("b", 3);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", 7);
        original.setVariable("f", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void testCacheWithWarmedUpCompilerCaseWhenOperations() {
        MathSentence original = new MathSentence("if a = b then c elsif d then e + f else g endif");
        MathSentence copiedSentence = original.copy();

        original.warmUp();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("a", 7);
        original.setVariableProvider("c", context -> {
            context.caching(true);
            return 8;
        });
        original.setVariable("g", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("b", 7);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("b", 5);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("e", 7);
        original.setVariable("f", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", true);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", false);
        original.setVariable("e", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test  //FIXME esse aqui
    public void testCacheWithWarmedUpCompiler_WithNonCacheableVariableProvider() {
        MathSentence original = new MathSentence("if a = b then c elsif d then e + f else g endif");
        MathSentence copiedSentence = original.copy();

        original.warmUp();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("a", 7);
        original.setVariableProvider("c", context -> 8); // not cacheable by default
        original.setVariable("g", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("b", 7);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("b", 5);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("e", 7);
        original.setVariable("f", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", true);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        original.setVariable("d", false);
        original.setVariable("e", 8);
        original.warmUp();
        copiedSentence = original.copy();
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void shouldComputeSameResults() {
        MathSentence original = new MathSentence("1 + 2 * 3 - 4 / 5 ^ 6 mod 7");
        MathSentence copiedSentence = original.copy();
        assertThat(original.<BigDecimal>compute()).isEqualByComparingTo(copiedSentence.<BigDecimal>compute());

        original = new MathSentence("S[[1,2,3]](S ^ 2)");
        copiedSentence = original.copy();
        BigDecimal resultCopy = copiedSentence.compute();
        BigDecimal resultOriginal = original.compute();
        assertThat(resultOriginal).isEqualByComparingTo(resultCopy);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void shouldCopyWithAllOperations() {
        MathSentence original;
        MathSentence copiedSentence;

        original = new MathSentence("S[[1,3]](S + 1)");
        copiedSentence = original.copy();
        assertThat(original.<BigDecimal>compute()).isEqualByComparingTo(copiedSentence.<BigDecimal>compute());

        original = new MathSentence(
                "1 + 2 * 3 - 4 / 5 ^ 6 mod 7 + S[[1,3]](S ^ 2) + P[[1,3]](P + 2 ^ 4) + log(3.4322, 50) + lb(5) + log10(11) + ln(4) + 4! + |-1| + sqrt(16)");
        copiedSentence = original.copy();
        assertThat(original.<BigDecimal>compute()).isEqualByComparingTo(copiedSentence.<BigDecimal>compute());

        original = new MathSentence(
                "up(21.223, 2) + down(21.223, 2) + ceiling(21.223, 2) + floor(21.223, 2) + halfUp(21.223, 2) + halfDown(21.223, 2) + halfEven(21.223, 2)");
        copiedSentence = original.copy();
        assertThat(original.<BigDecimal>compute()).isEqualByComparingTo(copiedSentence.<BigDecimal>compute());

        original = new MathSentence("true and true or false xor false = false <> true and ~((1 > 2) and (3 <= 5))");
        copiedSentence = original.copy();
        assertThat(original.<Boolean>compute()).isEqualTo(copiedSentence.<Boolean>compute());

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited);
    }

    @Test
    public void shouldCopyWithVectorAssignment() {
        MathSentence original = new MathSentence("[a, b, c] = multiplyVector(2, [4, 5, 6]);");
        MathSentence copiedSentence = original.copy();
        original.addFunction("multiplyVector", MethodType.methodType(BigDecimal[].class, BigDecimal.class, BigDecimal[].class), (args) -> {
            BigDecimal multiplier = (BigDecimal) args[0];
            BigDecimal[] vector = (BigDecimal[]) args[1];
            BigDecimal[] result = new BigDecimal[vector.length];
            for (int i = 0; i < vector.length; i++) {
                result[i] = vector[i].multiply(multiplier);
            }
            return result;
        });
        original.compute();

        assertThat(original.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(10);
        assertThat(copiedSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

        Set<AbstractOperation> originalVisited = original.visitOperations(new OperationCollectorVisitor());
        Set<AbstractOperation> copiedVisited = copiedSentence.visitOperations(new OperationCollectorVisitor());
        assertThat(originalVisited).doesNotContainAnyElementsOf(copiedVisited).hasSameSizeAs(copiedVisited);
    }

}
