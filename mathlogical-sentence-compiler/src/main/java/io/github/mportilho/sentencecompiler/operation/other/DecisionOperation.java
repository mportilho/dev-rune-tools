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

package io.github.mportilho.sentencecompiler.operation.other;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

public class DecisionOperation extends AbstractOperation {

    private final boolean expressionLike;
    private final AbstractOperation[] operations;

    public DecisionOperation(boolean expressionLike, AbstractOperation[] operations) {
        this.expressionLike = expressionLike;
        if (operations == null || operations.length < 3) {
            throw new IllegalStateException(
                    "Decision operation must have at least two conditionals (if ... then ... [elsif then ...] else ... endif)");
        }
        this.operations = operations;
        for (int i = 0; i < operations.length; i++) {
            this.operations[i].addParent(this);
        }
    }

    @Override
    protected Object resolve(OperationContext context) {
        Boolean condition;
        for (int i = 0; i < operations.length - 1; i += 2) {
            condition = operations[i].evaluate(context);
            if (condition) {
                return operations[i + 1].evaluate(context);
            }
        }
        return operations[operations.length - 1].evaluate(context);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        AbstractOperation[] clonedOperations = new AbstractOperation[operations.length];
        for (int i = 0; i < operations.length; i++) {
            clonedOperations[i] = operations[i].copy(context);
        }
        return new DecisionOperation(expressionLike, clonedOperations);
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        if (expressionLike) {
            expressionRepresentation(builder);
        } else {
            functionRepresentation(builder);
        }
    }

    private void functionRepresentation(StringBuilder builder) {
        int count = operations.length;
        for (int i = 0; i < count - 1; i += 2) {
            if (i == 0) {
                builder.append("if(");
            } else {
                builder.append(", ");
            }
            builder.append(operations[i]).append(", ").append(operations[i + 1]);
        }
        builder.append(", ").append(operations[operations.length - 1]).append(")");
    }

    private void expressionRepresentation(StringBuilder builder) {
        int count = operations.length;
        for (int i = 0; i < count - 1; i += 2) {
            if (i == 0) {
                builder.append("if ");
            } else {
                builder.append(" elsif ");
            }
            builder.append(operations[i]).append(" then ").append(operations[i + 1]);
        }
        builder.append(" else ").append(operations[operations.length - 1]).append(" endif");
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        for (AbstractOperation operation : this.operations) {
            operation.accept(visitor);
        }
        visitor.visit(this);
    }

    public AbstractOperation[] getOperations() {
        return operations;
    }

    @Override
    protected String getOperationToken() {
        return "";
    }

}
