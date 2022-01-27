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
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionOperation extends AbstractOperation {

    private final String functionName;
    private final List<AbstractOperation> parameters;

    public FunctionOperation(String functionName, List<AbstractOperation> parameters, boolean caching) {
        this.functionName = functionName;
        this.parameters = parameters != null ? parameters : Collections.emptyList();
        this.parameters.forEach(parameter -> parameter.addParent(this));
        if (!caching) {
            this.hintDisableCache();
        }
    }

    @Override
    protected Object resolve(OperationContext context) {
        OperationLambdaCaller caller = context.getFunction(functionName, parameters.size());
        if (caller == null) {
            throw new SyntaxExecutionException(String.format("Function [%s] with [%s] parameter(s) not found",
                    functionName, parameters.size()));
        }
        FunctionContext functionContext =
                new FunctionContext(context.mathContext(), context.scale(), context.formattedConversionService());
        try {
            return caller.call(functionContext, parameters.stream().map(p -> p.evaluate(context)).toArray());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SyntaxExecutionException(
                    String.format("Wrong parameter number on calling function [%s] with [%s] parameters",
                            functionName, parameters.size()), e);
        }
    }


    @Override
    protected AbstractOperation createClone(CloningContext context) {
        List<AbstractOperation> newOperationList = new ArrayList<>();
        for (AbstractOperation param : parameters) {
            newOperationList.add(param.copy(context));
        }
        return new FunctionOperation(functionName, newOperationList, isCaching());
    }

    /**
     * Caching representation token ($.) can dynamically change
     */
    @Override
    protected void formatRepresentation(StringBuilder builder) {
        if (isCaching()) {
            builder.append("$.");
        }
        builder.append(functionName).append("(");
        int index = parameters.size();
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
        getParameters().forEach(op -> op.accept(visitor));
        visitor.visit(this);
    }

    public List<AbstractOperation> getParameters() {
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
