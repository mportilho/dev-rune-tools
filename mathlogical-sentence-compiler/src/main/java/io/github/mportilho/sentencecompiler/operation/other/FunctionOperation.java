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

import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.LambdaCallSite;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

public class FunctionOperation extends AbstractOperation {

    private static final AbstractOperation[] EMPTY = new AbstractOperation[0];

    private final String functionName;
    private final AbstractOperation[] parameters;

    public FunctionOperation(String functionName, AbstractOperation[] parameters, boolean caching) {
        this.functionName = functionName;
        if (parameters != null) {
            this.parameters = parameters;
            for (AbstractOperation parameter : this.parameters) {
                parameter.addParent(this);
            }
        } else {
            this.parameters = EMPTY;
        }
        if (!caching) {
            this.hintDisableCache();
        }
    }

    @Override
    protected Object resolve(OperationContext context) {
        LambdaCallSite caller = context.getFunction(functionName, parameters.length);
        if (caller == null) {
            throw new SyntaxExecutionException(String.format("Function [%s] with [%s] parameter(s) not found", functionName, parameters.length));
        }

        if (caller.isCacheHint()) {
            this.setCachingOptions(true);
        }

        Object[] params = new Object[parameters.length];
        for (int i = 0, paramsLength = params.length; i < paramsLength; i++) {
            params[i] = parameters[i].evaluate(context);
        }
        try {
            return caller.call(new FunctionContext(context.mathContext(), context.scale()), params);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SyntaxExecutionException(String.format("Wrong parameter number on calling function [%s] with [%s] parameters",
                    functionName, parameters.length), e);
        }
    }


    @Override
    protected AbstractOperation createClone(CloningContext context) {
        AbstractOperation[] copyParams = new AbstractOperation[parameters.length];
        for (int i = 0, copyParamsLength = copyParams.length; i < copyParamsLength; i++) {
            copyParams[i] = parameters[i].copy(context);
        }
        return new FunctionOperation(functionName, copyParams, isCaching());
    }

    /**
     * Caching representation token ($.) can dynamically change
     */
    @Override
    protected void formatRepresentation(StringBuilder builder) {
        builder.append(functionName).append("(");
        int index = parameters.length;
        for (AbstractOperation parameter : parameters) {
            parameter.toString(builder);
            if (--index != 0) {
                builder.append(", ");
            }
        }
        builder.append(")");
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        for (AbstractOperation parameter : this.parameters) {
            parameter.accept(visitor);
        }
        visitor.visit(this);
    }

    public AbstractOperation[] getParameters() {
        return parameters;
    }

    public String getFunctionName() {
        return functionName;
    }

    @Override
    protected String getOperationToken() {
        return "";
    }

}
