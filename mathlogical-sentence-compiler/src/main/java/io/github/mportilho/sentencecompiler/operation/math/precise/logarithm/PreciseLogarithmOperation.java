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

package io.github.mportilho.sentencecompiler.operation.math.precise.logarithm;

import java.math.BigDecimal;

import ch.obermuhlner.math.big.BigDecimalMath;
import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.OperationContext;

public class PreciseLogarithmOperation extends AbstractBinaryOperation {

	public PreciseLogarithmOperation(AbstractOperation leftOperand, AbstractOperation rightOperand) {
		super(leftOperand, rightOperand);
		expectedType(BigDecimal.class);
	}

	@Override
	protected Object resolve(OperationContext context) {
		BigDecimal leftResult = BigDecimalMath.log(getLeftOperand().evaluate(context), context.mathContext());
		BigDecimal rightResult = BigDecimalMath.log(getRightOperand().evaluate(context), context.mathContext());
		return rightResult.divide(leftResult, context.mathContext());
	}

	@Override
	public void formatRepresentation(StringBuilder builder) {
		builder.append(getOperationToken()).append('(');
		getLeftOperand().toString(builder);
		builder.append(", ");
		getRightOperand().toString(builder);
		builder.append(')');
	}

	@Override
	protected AbstractOperation createClone(CloningContext context) {
		return new PreciseLogarithmOperation(getLeftOperand().copy(context), getRightOperand().copy(context));
	}

	@Override
	protected String getOperationToken() {
		return "log";
	}

}
