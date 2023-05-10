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
        Object result;
        if (getValue() instanceof VariableProvider variableProvider) {
            result = resolveVariableProvider(context, variableProvider);
        } else if (getValue() instanceof Supplier<?> supplier) {
            result = supplier.get();
        } else {
            result = resolveVariable(context);
        }
        return result;
    }

    /**
     * Variable provider disables configureCaching, but users can activate it through the 'value provider context' parameter.
     * Note that by doing so, the provider won't be called again unless it gets cleaned by subtree operations.
     */
    private Object resolveVariableProvider(OperationContext context, VariableProvider variableProvider) {
        VariableValueProviderContext valueProviderContext =
                new VariableValueProviderContext(context.mathContext(), context.scale(), false);
        return variableProvider.retrieveValue(valueProviderContext);
    }

    private Object resolveVariable(OperationContext context) {
        Object currValue = context.userOperationSupportData().getDictionary().get(getVariableName());
        if (currValue != null) {
            return currValue;
        }
        if (getValue() != null) {
            return getValue();
        }
        return context.operationSupportData().getDictionary().get(getVariableName());
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        VariableValueOperation copiedOperation = new VariableValueOperation(this.getVariableName());
        copiedOperation.overrideValue(this.getValue());
        context.getUserVariables().put(this.getVariableName(), copiedOperation);
        return copiedOperation;
    }

    @Override
    public boolean getCacheHint() {
        return false;
    }
}
