package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComputingSite {

    private final AbstractOperation operation;
    private final Map<String, AbstractVariableValueOperation> userVariables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final FormattedConversionService conversionService;

    public ComputingSite(
            AbstractOperation operation,
            Map<String, AbstractVariableValueOperation> userVariables,
            Map<String, AssignedVariableOperation> assignedVariables,
            FormattedConversionService conversionService) {
        this.operation = operation;
        this.userVariables = Collections.unmodifiableMap(userVariables);
        this.assignedVariables = Collections.unmodifiableMap(assignedVariables);
        this.conversionService = conversionService;
    }

    public Object compute(OperationContext operationContext) {
        return operation.evaluate(operationContext);
    }

    public void warmUp(OperationContext operationContext) {
        visitOperation(new WarmUpOperationVisitor(operationContext));
    }

    public FormattedConversionService getConversionService() {
        return conversionService;
    }

    public ComputingSite copy() {
        CloningContext cloningCtx = new CloningContext();
        AbstractOperation copy = operation.copy(cloningCtx);
        return new ComputingSite(copy, cloningCtx.getUserVariables(), cloningCtx.getAssignedVariables(), conversionService);
    }

    public void setUserVariable(String name, Object value) {
        AssertUtils.notNullOrBlank(name, "Parameter [name] must be provided");
        Objects.requireNonNull(value, "Parameter [value] must be provided");

        AbstractVariableValueOperation variableOperation = userVariables.get(name);
        if (variableOperation == null) {
            throw new IllegalArgumentException(String.format("No variable [%s] present in sentence", name));
        }

        if (value instanceof VariableProvider || Object.class.equals(variableOperation.getVariableType())) {
            variableOperation.setValue(value);
        } else {
            variableOperation.setValue(conversionService.convert(value, variableOperation.getVariableType(), null));
        }
    }

    public Map<String, Object> listAssignedVariables() {
        return assignedVariables.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCache()));
    }

    public Map<String, Object> listUserVariables() {
        return userVariables.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getCache()));
    }

    public <T> T visitOperation(OperationVisitor<T> visitor) {
        return operation.accept(visitor);
    }

    public String toOperationStringRepresentation() {
        return operation.toString();
    }

}
