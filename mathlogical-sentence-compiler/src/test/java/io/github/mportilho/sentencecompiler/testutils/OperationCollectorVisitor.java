package io.github.mportilho.sentencecompiler.testutils;

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
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.util.HashSet;
import java.util.Set;

public class OperationCollectorVisitor implements OperationVisitor<Set<AbstractOperation>> {

    private final Set<AbstractOperation> operations = new HashSet<>();

    @Override
    public Set<AbstractOperation> getFinalResult() {
        return operations;
    }

    @Override
    public Set<AbstractOperation> visit(BaseOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractUnaryOperator operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractBinaryOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractDateTimeOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(DecisionOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(FunctionOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractSequencialMathOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractConstantValueOperation operation) {
        operations.add(operation);
        return null;
    }

    @Override
    public Set<AbstractOperation> visit(AbstractVariableValueOperation operation) {
        operations.add(operation);
        return null;
    }
}
