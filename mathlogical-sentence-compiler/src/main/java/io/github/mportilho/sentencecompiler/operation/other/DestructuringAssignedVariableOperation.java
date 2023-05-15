package io.github.mportilho.sentencecompiler.operation.other;

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;

import java.util.List;

public class DestructuringAssignedVariableOperation extends AbstractVariableValueOperation {

    private List<String> variables;

    public DestructuringAssignedVariableOperation(String variableName, List<String> variables, AbstractOperation assignedOperation) {
        super(variableName);
        this.variables = variables;
        this.overrideValue(assignedOperation);
        assignedOperation.addParent(this);
    }

    @Override
    protected Object resolve(OperationContext context) {
        return ((AbstractOperation) getValue()).evaluate(context);
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return null;
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {

    }

    @Override
    protected String getOperationToken() {
        return "=";
    }
}
