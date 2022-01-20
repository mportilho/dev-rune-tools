package io.github.mportilho.sentencecompiler.operation.value.variable;

import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationContext;

import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

public class InternallyMutableValueOperation extends AbstractVariableValueOperation {

    private final BiFunction<InternallyMutableValueOperation, OperationContext, Object> mutableOperationResolver;

    public InternallyMutableValueOperation(
            String variableName,
            BiFunction<InternallyMutableValueOperation, OperationContext, Object> mutableOperationResolver) {
        super(variableName);
        Objects.requireNonNull(mutableOperationResolver, "Mutable operation resolver must be provided");
        this.mutableOperationResolver = mutableOperationResolver;
        this.setCachingOptions(false);
    }

    @Override
    protected Object resolve(OperationContext context) {
        return mutableOperationResolver.apply(this, context);
    }

    @Override
    public void setValue(Object newValue, Set<Class<? extends AbstractOperation>> limitingOperationTypesMap) {
        throw new SentenceConfigurationException("Cannot set value to an internally mutable variable");
    }

    @Override
    protected AbstractOperation createClone(
            CloningContext context) {
        return new InternallyMutableValueOperation(getVariableName(), this.mutableOperationResolver);
    }

    @Override
    protected void formatRepresentation(StringBuilder builder) {
        builder.append(getVariableName());
    }
}
