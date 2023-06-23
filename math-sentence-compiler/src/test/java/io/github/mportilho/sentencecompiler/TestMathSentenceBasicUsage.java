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

package io.github.mportilho.sentencecompiler;

import io.github.mportilho.sentencecompiler.exceptions.MathSentenceLockingException;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaSupplier;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestMathSentenceBasicUsage {

    @Test
    public void testSetVariableMap() {
        MathSentence compiler = new MathSentence("a + b");
        compiler.setVariables(Map.of("a", 1, "b", 2));
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("3");
    }

    @Test
    public void testSetVariable_MultiType() {
        MathSentence compiler = new MathSentence("a + b");
        compiler.setVariable("a", Double.valueOf(1));
        compiler.setVariable("b", "2");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("3");
    }

    @Test
    public void testSetVariable_MultiType_booleanExpression() {
        MathSentence compiler = new MathSentence("!a = true = b");
        compiler.setVariable("a", "false");
        compiler.setVariableProvider("b", c -> "tr" + "ue");
        assertThat(compiler.<Boolean>compute()).isTrue();
    }

    @Test
    public void testListVariables() {
        MathSentence compiler = new MathSentence("a + b");
        assertThat(compiler.listUserVariables())
                .isNotEmpty().hasSize(2)
                .containsKeys("a", "b").containsValue(null);

        compiler.setVariables(Map.of("a", 1, "b", 2));
        assertThat(compiler.listUserVariables())
                .isNotEmpty().hasSize(2)
                .containsKeys("a", "b").containsValue(null);

        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("3");
        assertThat(compiler.listUserVariables())
                .isNotEmpty().hasSize(2)
                .containsKeys("a", "b").containsValues(valueOf(1), valueOf(2));
    }

    @Test
    public void testDefaultVisitorValue() {
        assertThat(new WarmUpOperationVisitor(null).getFinalResult()).isNull();
    }

    @Test
    public void testLockingMathSentence() {
        MathSentence compiler = new MathSentence("1 + 2");
        compiler.lock();

        assertThat(compiler.isLocked()).isTrue();
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(compiler::warmUp)
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.addFunction(new LambdaCallSite("", null, (LambdaSupplier) null)))
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.setVariable("", ""))
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.setVariableProvider("", c -> null))
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.addDictionary(Collections.emptyMap()))
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.addDictionaryEntry("", ""))
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.addFunctionFromObject(Object.class))
                .isInstanceOf(MathSentenceLockingException.class);
    }

    @Test
    public void testFailSettingConstantVariableManyTimes() {
        MathSentence compiler = new MathSentence("b + c");
        compiler.setConstant("b", 2);
        assertThatThrownBy(() -> compiler.setConstant("b", 2)).isInstanceOf(SentenceConfigurationException.class);
    }

}
