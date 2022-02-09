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

package io.github.mportilho.sentencecompiler.operation.math.fast;

import ch.obermuhlner.math.big.BigDecimalMath;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractUnaryOperator;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

public class FastFactorialOperation extends AbstractUnaryOperator {

	private static final Double[] factorialCache = new Double[100];

	public FastFactorialOperation(AbstractOperation operand) {
		super(operand, OperatorPosition.RIGHT);
	}

	@Override
	protected Object resolve(OperationContext context) {
		return factorial(getOperand().evaluate(context));
	}

	public static Double factorial(int n) {
		if (n < 0) {
			throw new ArithmeticException("Illegal factorial(n) for n < 0: n = " + n);
		}
		if (n < factorialCache.length) {
			return factorialCache[n];
		}

		Double result = factorialCache[factorialCache.length - 1];
		return result * (factorialRecursion(factorialCache.length, n));
	}

	private static long factorialLoop(int n1, final int n2) {
		final long limit = Long.MAX_VALUE / n2;
		long accu = 1;
		long result = 1;
		while (n1 <= n2) {
			if (accu <= limit) {
				accu *= n1;
			} else {
				result = result * accu;
				accu = n1;
			}
			n1++;
		}
		return result * accu;
	}

	private static long factorialRecursion(final int n1, final int n2) {
		int threshold = n1 > 200 ? 80 : 150;
		if (n2 - n1 < threshold) {
			return factorialLoop(n1, n2);
		}
		final int mid = (n1 + n2) >> 1;
		return factorialRecursion(mid + 1, n2) * (factorialRecursion(n1, mid));
	}

	@Override
	protected AbstractOperation createClone(CloningContext context) {
		return new FastFactorialOperation(getOperand().copy(context));
	}

	@Override
	protected String getOperationToken() {
		return "!";
	}

}
