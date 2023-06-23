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

package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;

import java.util.function.Supplier;

public class VariableValueOperation extends AbstractVariableValueOperation {

    public VariableValueOperation(String variableName) {
        super(variableName);
    }

    @Override
    protected Object resolve(OperationContext context) {
        Object result = getValue();
        if (result != null) {
            return unwrapLambda(result, context);
        } else {
            Object currValue = context.userDataStore().findValue(getVariableName());
            if (currValue == null) {
                currValue = context.dataStore().findValue(getVariableName());
            }
            return unwrapLambda(currValue, context);
        }
    }

    private Object unwrapLambda(Object object, OperationContext context) {
        if (object instanceof VariableProvider variableProvider) {
            VariableValueProviderContext valueProviderContext = new VariableValueProviderContext(
                    context.mathContext(), context.scale(), context.cachingVariableProvider());
            return variableProvider.retrieveValue(valueProviderContext);
        } else if (object instanceof Supplier<?> supplier) {
            return supplier.get();
        } else {
            return object;
        }
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        VariableValueOperation copiedOperation = new VariableValueOperation(this.getVariableName());
        copiedOperation.overrideValue(this.getValue());
        copyVariableStateTo(copiedOperation);
        context.getVariables().put(this.getVariableName(), copiedOperation);
        return copiedOperation;
    }

    @Override
    public boolean getCacheHint() {
        return false;
    }
}
