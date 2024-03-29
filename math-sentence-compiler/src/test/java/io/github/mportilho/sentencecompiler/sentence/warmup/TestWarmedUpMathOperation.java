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

public class TestWarmedUpMathOperation {

	private static CacheCheckVisitor cacheVisitor;

	@BeforeAll
	public static void beforeClass() {
		cacheVisitor = new CacheCheckVisitor();
	}

	@Test
	public void testAdditionOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 + 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 + 2 + 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
	}

	@Test
	public void testDivisionOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("6 / 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("-6 / 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testExponentialOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("3^3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("2^16");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testFactorialOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("3!");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("3!!");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testModuloOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("3 mod 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("6 mod 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testModulusOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("|7|");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("|-7|");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testMultiplicationOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("4 * 4");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("-7 * 7");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("7 * (7 + 2)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);

		mathSentence = new MathSentence("-7 * (7 + 2)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
	}

	@Test
	public void testNumberRoundingOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("up(3.555, 2)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testPercentualOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("3%");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("100%%");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testRootOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("2 root 4");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("3 root 27");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testSquareRootOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("sqrt(144)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("sqrt(9)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testSubtractionOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1 - 2");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("1 - 2 - 3");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
	}

	@Test
	public void testBinaryLogarithmOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("lb(5)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testCommonLogarithmOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("log10(11)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("log10(5) / log10(2)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);
	}

	@Test
	public void testLogarithmOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("log(3.4322, 50)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);

		mathSentence = new MathSentence("10 * (10 * (log(3.4322, 50)))");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(8);
	}

	@Test
	public void testNaturalLogarithmOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("ln(4)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("ln(5) / ln(2)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(6);

		mathSentence = new MathSentence("ln(4) + log10(4^2 + |-1|)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(11);
	}

	@Test
	public void testDeggreOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("1°");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testSineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("sin(90)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("sin(90 * pi / 180)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(7);
	}

	@Test
	public void testCosineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("cos(90)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testTangentOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("tan(10)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);

		mathSentence = new MathSentence("tan(10 * pi / 180)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(7);
	}

	@Test
	public void testArcsineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("asin(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testArccosineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("acos(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testArctangentOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("atan(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testArctangent2Operation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("atan2(0.7, 3)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(4);
	}

	@Test
	public void testHyperbolicSineOperation_noCache() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("$.sinh(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(1);
	}

	@Test
	public void testHyperbolicCosineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("cosh(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testHyperbolicTangentOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("tanh(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testInverseHyperbolicSineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("asinh(0.7)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testInverseHyperbolicCosineOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("acosh(50)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

	@Test
	public void testInverseHyperbolicTangentOperation() {
		MathSentence mathSentence;

		mathSentence = new MathSentence("atanh(0.5)");
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(0);
		mathSentence.warmUp();
		assertThat(mathSentence.visitOperations(cacheVisitor.reset())).isEqualByComparingTo(3);
	}

}
