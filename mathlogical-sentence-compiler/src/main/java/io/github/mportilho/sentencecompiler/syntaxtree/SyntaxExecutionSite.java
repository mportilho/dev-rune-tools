package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;

import java.math.MathContext;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.createFunctionCaller;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class SyntaxExecutionSite {

    private final AbstractOperation operation;
    private final MathContext mathContext;
    private final Integer scale;
    private final Map<String, AbstractVariableValueOperation> userVariables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final ExecutionContext executionContext;
    private final FormattedConversionService conversionService;

    public SyntaxExecutionSite(
            AbstractOperation operation,
            MathContext mathContext,
            Integer scale,
            Map<String, AbstractVariableValueOperation> userVariables,
            Map<String, AssignedVariableOperation> assignedVariables,
            ExecutionContext executionContext,
            FormattedConversionService conversionService) {
        this.operation = operation;
        this.mathContext = mathContext;
        this.scale = scale;
        this.userVariables = Collections.unmodifiableMap(userVariables);
        this.assignedVariables = Collections.unmodifiableMap(assignedVariables);
        this.executionContext = executionContext;
        this.conversionService = conversionService;
    }

    public Object compute() {
        return compute(executionContext);
    }

    public Object compute(ExecutionContext userExecutionContext) {
        Objects.requireNonNull(userExecutionContext, "Parameter [userExecutionContext] must be provided");
        OperationContext operationContext = new OperationContext(mathContext,
                scale, false, ZonedDateTime.now(), conversionService, executionContext, userExecutionContext);
        for (AbstractVariableValueOperation variableValueOperation : userVariables.values()) {
            if (variableValueOperation.shouldResetOperation(operationContext)) {
                variableValueOperation.clearCache();
            }
        }
        return operation.evaluate(operationContext);
    }

    public void warmUp() {
        OperationContext operationContext = new OperationContext(mathContext,
                scale, true, ZonedDateTime.now(), conversionService, executionContext, executionContext);
        visitOperation(new WarmUpOperationVisitor(operationContext));
    }

    public void addDictionary(Map<String, Object> dictionary) {
        Objects.requireNonNull(dictionary, "Cannot add a null dictionary to execution context");
        executionContext.getDictionary().putAll(dictionary);
    }

    public void addFunction(String name, OperationLambdaCaller function) {
        AssertUtils.notNullOrBlank(name, "Function name must be provided");
        Objects.requireNonNull(function, "A function implementation must be provided");
        executionContext.getFunctions().put(keyName(name, -1), function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        try {
            Map<String, OperationLambdaCaller> callerMap = createFunctionCaller(functionProvider);
            executionContext.getFunctions().putAll(callerMap);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while extracting functions from provider object", e);
        }
    }

    public SyntaxExecutionSite copy() {
        CloningContext cloningCtx = new CloningContext();
        AbstractOperation copy = operation.copy(cloningCtx);
        return new SyntaxExecutionSite(
                copy, mathContext, scale, cloningCtx.getUserVariables(), cloningCtx.getAssignedVariables(),
                new ExecutionContext(new HashMap<>(executionContext.getDictionary()), new HashMap<>(executionContext.getFunctions())),
                conversionService);
    }

    public void setUserVariable(String name, Object value) {
        AssertUtils.notNullOrBlank(name, "Parameter [name] must be provided");
        Objects.requireNonNull(value, "Parameter [value] must be provided");

        AbstractVariableValueOperation variableOperation = userVariables.get(name);
        if (variableOperation != null) {
            if (value instanceof VariableProvider
                    || !conversionService.canConvert(value.getClass(), variableOperation.getExpectedType())) {
                variableOperation.setValue(value);
            } else {
                variableOperation.setValue(conversionService.convert(value, variableOperation.getExpectedType(), null));
            }
        }
    }

    public Map<String, Object> listAssignedVariables() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, AssignedVariableOperation> entry : assignedVariables.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getCache());
        }
        return map;
    }

    public Map<String, Object> listUserVariables() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, AbstractVariableValueOperation> entry : userVariables.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getCache());
        }
        return map;
    }

    public void visitOperation(OperationVisitor<?> visitor) {
        operation.accept(visitor);
    }

    public String toOperationStringRepresentation() {
        return operation.toString();
    }

}
