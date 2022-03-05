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
import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.OperationContext;

import java.math.BigDecimal;

public class FastRootOperation extends AbstractBinaryOperation {

    public FastRootOperation(AbstractOperation leftOperand, AbstractOperation rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected Object resolve(OperationContext context) {
        Double leftValue = getLeftOperand().evaluate(context);
        Double rightValue = getRightOperand().evaluate(context);
        return BigDecimalMath.root(BigDecimal.valueOf(leftValue), BigDecimal.valueOf(rightValue), context.mathContext()).doubleValue();
    }

    @Override
    public void formatRepresentation(StringBuilder builder) {
        getRightOperand().toString(builder);
        builder.append(getOperationToken()).append('(');
        getLeftOperand().toString(builder);
        builder.append(')');
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new FastRootOperation(getLeftOperand().copy(context), getRightOperand().copy(context));
    }

    @Override
    protected String getOperationToken() {
        return "\u221A";
    }

}
