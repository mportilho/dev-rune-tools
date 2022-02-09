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

package io.github.mportilho.sentencecompiler.operation.math.precise;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.math.AbstractSequencialMathOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.SequenceVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.math.BigDecimal;

public class PreciseProductOfSequenceOperation extends AbstractSequencialMathOperation {

    public PreciseProductOfSequenceOperation(
            AbstractOperation startIndex, AbstractOperation endIndex, AbstractOperation operation,
            SequenceVariableValueOperation sequenceVariable) {
        super(startIndex, endIndex, operation, sequenceVariable);
    }

    @Override
    protected Object resolve(OperationContext context) {
        int startIndexResult = getStartIndex().<BigDecimal>evaluate(context).intValue();
        int endIndexResult = getEndIndex().<BigDecimal>evaluate(context).intValue();
        BigDecimal result = BigDecimal.ONE;
        for (int i = startIndexResult; i <= endIndexResult; i++) {
            if (this.getSequenceVariable() != null) {
                this.getSequenceVariable().setValue(BigDecimal.valueOf(i));
            }
            result = result.multiply(getOperation().evaluate(context));
        }
        return result;
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new PreciseProductOfSequenceOperation(getStartIndex().copy(context), getEndIndex().copy(context), getOperation().copy(context),
                (SequenceVariableValueOperation) getSequenceVariable().copy(context));
    }

    @Override
    protected String getOperationToken() {
        return "P";
    }

}
