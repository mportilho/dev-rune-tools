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

package io.github.mportilho.sentencecompiler.mathsentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.exceptions.MathSentenceLockingException;
import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

public class TestLockingMathSentence {

    @Test
    public void testLockingMathSentence() {
        MathSentence compiler = new MathSentence("1 + 2");
        compiler.lock();

        assertThat(compiler.isLocked()).isTrue();
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(compiler::warmUp)
                .isInstanceOf(MathSentenceLockingException.class);

        assertThatThrownBy(() -> compiler.addFunction("", new LambdaCallSite("", null, null)))
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

}
