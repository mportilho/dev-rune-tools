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

package io.github.mportilho.sentencecompiler.sentence.cache;

import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractUnaryOperator;
import io.github.mportilho.sentencecompiler.operation.BaseOperation;
import io.github.mportilho.sentencecompiler.operation.datetime.AbstractDateTimeOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.other.FunctionOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.PreciseProductOfSequenceOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.PreciseSummationOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.AbstractConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.HashSet;
import java.util.Set;

public class CacheCheckVisitor implements OperationVisitor<Integer> {

    private Set<AbstractVariableValueOperation> visitedVariables = new HashSet<>();
    private int counter = 0;

    public CacheCheckVisitor reset() {
        visitedVariables = new HashSet<>();
        counter = 0;
        return this;
    }

    @Override
    public Integer getFinalResult() {
        return counter;
    }

    public int getCounter() {
        return counter;
    }

    private Integer checkCache(AbstractOperation operation) {
        if (operation.getCache() != null) {
            return ++counter;
        }
        return counter;
    }

    @Override
    public Integer visit(BaseOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(AbstractUnaryOperator operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(AbstractBinaryOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(AbstractDateTimeOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(DecisionOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(FunctionOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(PreciseSummationOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(PreciseProductOfSequenceOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(AbstractConstantValueOperation operation) {
        return checkCache(operation);
    }

    @Override
    public Integer visit(AbstractVariableValueOperation operation) {
        // don't revisit same variables
        if (visitedVariables.contains(operation)) {
            return 0;
        } else {
            Integer numberOfCaches = checkCache(operation);
            visitedVariables.add(operation);
            if (operation.getValue() instanceof AbstractOperation op) {
                op.accept(this);
            }
            return numberOfCaches;
        }
    }

}
