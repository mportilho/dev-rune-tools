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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.sentence.cache.CacheCheckVisitor;

public class TestWarmedUpVariableOperation {

	private static CacheCheckVisitor cacheVisitor;

	@BeforeAll
	public static void beforeClass() {
		cacheVisitor = new CacheCheckVisitor();
	}

	@Test
	public void testVariableOperationCache() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("a");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.setVariable("a", 2);
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);

		mathSentence = new MathSentence("b + 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.setVariable("b", 2);
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(1);
	}

}
