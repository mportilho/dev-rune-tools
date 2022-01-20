/*MIT License

Copyright (c) 2021 Marcelo Portilho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.util.Objects;

public class VariableValueOperation extends AbstractVariableValueOperation {

    public VariableValueOperation(String variableName) {
        super(variableName);
    }

    @Override
    protected Object resolve(OperationContext context) {
        if (getValue() instanceof VariableProvider variableProvider) {
            return resolveVariableProvider(context, variableProvider);
        }
        return resolveVariable(context);
    }

    /**
     * Variable provider disables setCachingOptions, but users can activate it through the 'value provider context' parameter.
     * Note that by doing so, the provider won't be called again unless it gets cleaned by subtree operations.
     */
    private Object resolveVariableProvider(OperationContext context, VariableProvider variableProvider) {
        VariableValueProviderContext valueProviderContext =
                new VariableValueProviderContext(context.mathContext(), context.scale(), false);
        Object result = variableProvider.provideValue(valueProviderContext);
        setCachingOptions(valueProviderContext.isCaching());
        return result;
    }

    private Object resolveVariable(OperationContext context) {
        Object returningValue = context.readDictionary(getVariableName());
        return returningValue == null ? getValue() : returningValue;
    }

    @Override
    public boolean shouldResetOperation(OperationContext context) {
        if (isCaching() && getCache() != null) {
            return context.userExecutionContext().getDictionary().containsKey(getVariableName())
                    && !compareValues(getCache(), context.userExecutionContext().getDictionary().get(getVariableName()));
        }
        return super.shouldResetOperation(context);
    }

    @SuppressWarnings({"unchecked"})
    protected boolean compareValues(Object value1, Object value2) {
        if (value1 instanceof Comparable c1 && value2 instanceof Comparable c2) {
            return c1.compareTo(c2) == 0;
        }
        return Objects.equals(value1, value2);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        VariableValueOperation copiedOperation = new VariableValueOperation(getVariableName());
        copiedOperation.value = this.value;
        context.getUserVariables().put(getVariableName(), copiedOperation);
        return copiedOperation;
    }

}
