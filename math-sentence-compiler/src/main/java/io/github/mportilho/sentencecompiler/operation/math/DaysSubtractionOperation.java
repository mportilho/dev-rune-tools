package io.github.mportilho.sentencecompiler.operation.math;

import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.operation.AbstractBinaryOperation;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.support.function.generics.DateTimeFunctionExtension;

public class DaysSubtractionOperation extends AbstractBinaryOperation {

    public DaysSubtractionOperation(AbstractOperation leftOperand, AbstractOperation rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected Object resolve(OperationContext context) {
        return DateTimeFunctionExtension.daysBetween(getRightOperand().evaluate(context), getLeftOperand().evaluate(context));
    }

    @Override
    protected AbstractOperation createClone(CloningContext context) {
        return new DaysSubtractionOperation(getLeftOperand().copy(context), getRightOperand().copy(context));
    }

    @Override
    protected String getOperationToken() {
        return "-";
    }
}
