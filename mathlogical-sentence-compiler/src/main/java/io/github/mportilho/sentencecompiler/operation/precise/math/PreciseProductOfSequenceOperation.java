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

package io.github.mportilho.sentencecompiler.operation.precise.math;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.math.BigDecimal;

public class PreciseProductOfSequenceOperation extends AbstractOperation {

    private final AbstractOperation startIndex;
    private final AbstractOperation endIndex;
    private final AbstractOperation operation;
    private final SequenceVariableValueOperation sequenceVariable;

    public PreciseProductOfSequenceOperation(
            AbstractOperation startIndex, AbstractOperation endIndex, AbstractOperation operation,
            SequenceVariableValueOperation sequenceVariable) {
        super();
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.operation = operation;
        this.sequenceVariable = sequenceVariable;

        this.startIndex.addParent(this);
        this.endIndex.addParent(this);
        this.operation.addParent(this);
        if (this.sequenceVariable != null) {
            this.sequenceVariable.addParent(this);
        }
    }

    @Override
    protected Object resolve(OperationContext context) {
        int startIndexResult = startIndex.<BigDecimal>evaluate(context).intValue();
        int endIndexResult = endIndex.<BigDecimal>evaluate(context).intValue();
        BigDecimal result = BigDecimal.ONE;
        for (int i = startIndexResult; i <= endIndexResult; i++) {
            if (this.sequenceVariable != null) {
                this.sequenceVariable.setValue(BigDecimal.valueOf(i));
            }
            result = result.multiply(operation.evaluate(context));
        }
        return result;
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new PreciseProductOfSequenceOperation(startIndex.copy(context), endIndex.copy(context), operation.copy(context),
                (SequenceVariableValueOperation) sequenceVariable.copy(context));
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        builder.append("P[");
        startIndex.toString(builder);
        builder.append(',');
        endIndex.toString(builder);
        builder.append("](");
        operation.toString(builder);
        builder.append(')');
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        getStartIndex().accept(visitor);
        getEndIndex().accept(visitor);
        getOperation().accept(visitor);
        visitor.visit(this);
    }

    public AbstractOperation getStartIndex() {
        return startIndex;
    }

    public AbstractOperation getEndIndex() {
        return endIndex;
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public SequenceVariableValueOperation getSequenceVariable() {
        return sequenceVariable;
    }

    @Override
    protected String getOperationToken() {
        return "";
    }

}
