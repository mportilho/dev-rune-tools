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

public class TestWarmedUpLogicOperation {

	private static CacheCheckVisitor cacheVisitor;

	@BeforeAll
	public static void beforeClass() {
		cacheVisitor = new CacheCheckVisitor();
	}

	@Test
	public void testAndOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("true and true and true");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);

		mathSentence = new MathSentence("true and true and false");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
	}

	@Test
	public void testEqualsOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 = 1");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("(1 = 1) = false");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);

		mathSentence = new MathSentence("'teste' = 'teste'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-20 = 2000-03-20");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testGreaterOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("11 > 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("3 > 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("'teste2' > 'teste1'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-21 > 2000-03-20");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testGreaterOrEqualsOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("3 >= 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("-3 >= 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2 >= 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("'teste' >= 'teste'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-20 >= 2000-03-20");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testLessOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 < 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 < 1");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("'teste1' < 'teste2'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-20 < 2000-03-22");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testLessOrEqualsOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 <= 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 <= 1");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 <= 0");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("'teste' <= 'teste'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-20 <= 2000-03-20");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testNandOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("true nand false");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testNegationOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("!(1 <> 1)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(5);

		mathSentence = new MathSentence("!(1 = 1)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(5);

		mathSentence = new MathSentence("!true");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testNorOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("false nor false");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testNotEqualsOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 <> 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 <> 1");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("'teste1' <> 'teste'");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2000-03-20 <> 2000-03-22");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testOrOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("true or true");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("false or true");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testXnorOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("true xnor true");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testXorOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("false xor false");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

}
