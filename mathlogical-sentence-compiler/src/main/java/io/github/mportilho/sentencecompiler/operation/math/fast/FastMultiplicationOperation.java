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

import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.math.BigDecimal;

public class FastMultiplicationOperation extends AbstractBinaryOperation {

    private boolean implicit = false;

    public FastMultiplicationOperation(AbstractOperation leftOperand, AbstractOperation rightOperand) {
        super(leftOperand, rightOperand);
    }

    public FastMultiplicationOperation(
            AbstractOperation leftOperand, AbstractOperation rightOperand, boolean implicit) {
        super(leftOperand, rightOperand);
        this.implicit = implicit;
    }

    @Override
    protected Object resolve(OperationContext context) {
        return getLeftOperand().<Double>evaluate(context) * getRightOperand().<Double>evaluate(context);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        FastMultiplicationOperation operation = new FastMultiplicationOperation(getLeftOperand().copy(context),
                getRightOperand().copy(context));
        operation.implicit = this.implicit;
        return operation;
    }

    @Override
    protected String getOperationToken() {
        return "*";
    }

    public boolean isImplicit() {
        return implicit;
    }

    @Override
    public void formatRepresentation(StringBuilder builder) {
        if (implicit) {
            boolean isVariableWithCache =
                    AbstractVariableValueOperation.class.isAssignableFrom(getRightOperand().getClass())
                            && getRightOperand().getCache() != null;
            boolean isRightOperationNotApplyingParenthesis =
                    !AbstractVariableValueOperation.class.isAssignableFrom(getRightOperand().getClass())
                            && !getRightOperand().isApplyingParenthesis();
            boolean applyParenthesis = isVariableWithCache || isRightOperationNotApplyingParenthesis;

            getLeftOperand().toString(builder);
            if (applyParenthesis) {
                builder.append('(');
            }
            getRightOperand().toString(builder);
            if (applyParenthesis) {
                builder.append(')');
            }
        } else {
            super.formatRepresentation(builder);
        }
    }

}
