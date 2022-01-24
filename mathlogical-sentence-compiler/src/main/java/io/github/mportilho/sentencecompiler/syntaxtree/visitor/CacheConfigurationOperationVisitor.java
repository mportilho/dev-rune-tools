package io.github.mportilho.sentencecompiler.syntaxtree.visitor;

import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractUnaryOperator;
import io.github.mportilho.sentencecompiler.operation.BaseOperation;
import io.github.mportilho.sentencecompiler.operation.datetime.AbstractDateTimeOperation;
import io.github.mportilho.sentencecompiler.operation.other.DecisionOperation;
import io.github.mportilho.sentencecompiler.operation.other.FunctionOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.PreciseProductOfSequenceOperation;
import io.github.mportilho.sentencecompiler.operation.precise.math.PreciseSummationOperation;
import io.github.mportilho.sentencecompiler.operation.value.constant.AbstractConstantValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;

public class CacheConfigurationOperationVisitor implements OperationVisitor<Object> {


    private Object disableCaching(AbstractOperation operation) {
        if (operation.checkAndRemoveDisableCacheHint()) {
            operation.setCachingOptions(false);
        }
        return operation;
    }

    @Override
    public Object visit(BaseOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractUnaryOperator operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractBinaryOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(AbstractDateTimeOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(DecisionOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(FunctionOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(PreciseSummationOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(
            PreciseProductOfSequenceOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(
            AbstractConstantValueOperation operation) {
        return disableCaching(operation);
    }

    @Override
    public Object visit(
            AbstractVariableValueOperation operation) {
        return disableCaching(operation);
    }
}
