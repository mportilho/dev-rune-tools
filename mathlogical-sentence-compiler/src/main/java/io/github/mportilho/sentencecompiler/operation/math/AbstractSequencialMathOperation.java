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

package io.github.mportilho.sentencecompiler.operation.math;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

public abstract class AbstractSequencialMathOperation extends AbstractOperation {

    private final AbstractOperation input;
    private final AbstractOperation operation;
    private final SequenceVariableValueOperation sequenceVariable;

    public AbstractSequencialMathOperation(
            AbstractOperation input, AbstractOperation operation, SequenceVariableValueOperation sequenceVariable) {
        this.input = input;
        this.operation = operation;
        this.sequenceVariable = sequenceVariable;
        this.input.addParent(this);
        this.operation.addParent(this);
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        input.accept(visitor);
        operation.accept(visitor);
        visitor.visit(this);
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        builder.append(getOperationToken()).append("[x](");
        operation.toString(builder);
        builder.append(')');
    }

    public AbstractOperation getInput() {
        return input;
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public SequenceVariableValueOperation getSequenceVariable() {
        return sequenceVariable;
    }
}
