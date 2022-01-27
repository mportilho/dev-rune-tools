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

package io.github.mportilho.sentencecompiler.operation;

import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static java.util.Objects.nonNull;

public class BaseOperation extends AbstractOperation {

    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final AbstractOperation operation;

    public BaseOperation(AbstractOperation operation, Map<String, AssignedVariableOperation> assignedVariables) {
        this.assignedVariables = assignedVariables != null ? assignedVariables : Collections.emptyMap();
        this.operation = operation;
        if (this.operation != null) {
            this.expectedType(this.operation.getExpectedType());
            this.operation.addParent(this);
        } else {
            this.expectedType(Boolean.class);
        }
    }

    @Override
    protected Object resolve(OperationContext context) {
        for (Entry<String, AssignedVariableOperation> entry : assignedVariables.entrySet()) {
            entry.getValue().evaluate(context);
        }
        if (operation != null) {
            Object result = operation.evaluate(context);
            if (result instanceof Number) {
                BigDecimal numberResult = result instanceof BigDecimal ? (BigDecimal) result
                        : new BigDecimal(result.toString(), context.mathContext());
                if (context.scale() != null) {
                    numberResult = numberResult.setScale(context.scale(), context.mathContext().getRoundingMode());
                }
                return numberResult;
            }
            return result;
        }
        if (BigDecimal.class.equals(this.getExpectedType())) {
            return BigDecimal.ZERO;
        } else if (Boolean.class.equals(this.getExpectedType())) {
            return Boolean.FALSE;
        }
        throw new SyntaxExecutionException(String.format("Current expected type [%s] is incorrect for base operation", this.getExpectedType()));
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        Map<String, AssignedVariableOperation> newAssignedVariables = null;
        if (nonNull(assignedVariables)) {
            newAssignedVariables = new HashMap<>();
            for (Entry<String, AssignedVariableOperation> entry : assignedVariables.entrySet()) {
                newAssignedVariables.put(entry.getKey(), (AssignedVariableOperation) entry.getValue().copy(context));
            }
        }
        return new BaseOperation(operation != null ? operation.copy(context) : null, newAssignedVariables);
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        Set<Entry<String, AssignedVariableOperation>> entrySet = assignedVariables.entrySet();
        for (Entry<String, AssignedVariableOperation> entry : entrySet) {
            builder.append(entry.getValue().getVariableName()).append(' ').append(entry.getValue().getOperationToken()).append(' ');
            ((AbstractOperation) entry.getValue().getValue()).toString(builder);
            builder.append(';');
            builder.append("\n");
        }
        if (operation != null) {
            operation.toString(builder);
        } else if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    @Override
    public void accept(OperationVisitor<?> visitor) {
        getAssignedVariables().values().forEach(op -> op.accept(visitor));
        if (getOperation() != null) {
            getOperation().accept(visitor);
        }
        visitor.visit(this);
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public Map<String, AssignedVariableOperation> getAssignedVariables() {
        return assignedVariables;
    }

    @Override
    protected String getOperationToken() {
        return "";
    }

}
