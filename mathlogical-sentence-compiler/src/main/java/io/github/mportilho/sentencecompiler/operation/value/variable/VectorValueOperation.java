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

package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

public class VectorValueOperation extends AbstractVariableValueOperation {

    private final AbstractOperation[] vector;

    public VectorValueOperation(String variableName, AbstractOperation[] vector) {
        super(variableName);
        this.vector = vector;
    }

    @Override
    protected Object resolve(OperationContext context) {
        FormattedConversionService conversionService = context.formattedConversionService();
        Object[] result = new Object[vector.length];
        for (int i = 0, splitLength = vector.length; i < splitLength; i++) {
            result[i] = conversionService.convert(vector[i].evaluate(context), getExpectedType().getComponentType());
        }
        return setLastResult(result);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new VectorValueOperation(this.getVariableName(), vector);
    }
}
