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

package io.github.mportilho.sentencecompiler.syntaxtree.visitor;

import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractUnaryOperator;
import io.github.mportilho.sentencecompiler.operation.BaseOperation;
import io.github.mportilho.sentencecompiler.operation.datetime.AbstractDateTimeOperation;
import io.github.mportilho.sentencecompiler.operation.math.AbstractSequencialMathOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.other.FunctionOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.AbstractConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;

/**
 * Prepares the current AST to be used
 */
public class InitialConfigurationOperationVisitor implements OperationVisitor<Object> {

    private Object disableCaching(AbstractOperation operation) {
        if (operation.checkAndRemoveDisableCacheHint()) {
            operation.setCachingOptions(false);
        }
        return operation;
    }

    @Override
    public Object visit(BaseOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractUnaryOperator operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractBinaryOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractDateTimeOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(DecisionOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(FunctionOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractSequencialMathOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(
            AbstractConstantValueOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(
            AbstractVariableValueOperation operation) {
        return disableCaching(operation);
    }
}
