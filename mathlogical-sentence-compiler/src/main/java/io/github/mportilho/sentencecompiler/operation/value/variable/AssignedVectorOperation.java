package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.exceptions.SentenceExecutionException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;

public class AssignedVectorOperation extends AssignedVariableOperation {

    private final int vectorPosition;

    public AssignedVectorOperation(String variableName, AbstractOperation assignedOperation, int vectorPosition) {
        super(variableName, assignedOperation);
        this.vectorPosition = vectorPosition;
    }

    @Override
    protected Object resolve(OperationContext context) {
        Object[] vector = ((AbstractOperation) getValue()).evaluate(context);
        try {
            return vector[vectorPosition];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SentenceExecutionException("Vector index out of bounds for assigned variable [" + getVariableName() + "]: " + vectorPosition + " (vector size: " + vector.length + ")", e);
        }
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        AssignedVectorOperation copyOperation = new AssignedVectorOperation(getVariableName(),
                ((AbstractOperation) getValue()).copy(context), vectorPosition);
        copyVariableStateTo(copyOperation);
        context.getAssignedVariables().put(getVariableName(), copyOperation);
        return copyOperation;
    }

}
