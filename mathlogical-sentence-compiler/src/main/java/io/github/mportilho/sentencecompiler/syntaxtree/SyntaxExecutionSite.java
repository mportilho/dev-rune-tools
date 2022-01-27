package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;

import java.math.MathContext;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.*;

public class SyntaxExecutionSite {

    private final AbstractOperation operation;
    private final MathContext mathContext;
    private final Integer scale;
    private final ZoneId zoneId;
    private final Map<String, AbstractVariableValueOperation> userVariables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final OperationSupportData operationSupportData;
    private final FormattedConversionService conversionService;

    public SyntaxExecutionSite(
            AbstractOperation operation,
            MathContext mathContext,
            Integer scale,
            ZoneId zoneId,
            Map<String, AbstractVariableValueOperation> userVariables,
            Map<String, AssignedVariableOperation> assignedVariables,
            OperationSupportData operationSupportData,
            FormattedConversionService conversionService) {
        this.operation = operation;
        this.mathContext = mathContext;
        this.scale = scale;
        this.zoneId = zoneId;
        this.userVariables = Collections.unmodifiableMap(userVariables);
        this.assignedVariables = Collections.unmodifiableMap(assignedVariables);
        this.operationSupportData = operationSupportData;
        this.conversionService = conversionService;
    }

    public Object compute() {
        return compute(OperationSupportData.EMPTY_DATA);
    }

    public Object compute(OperationSupportData userOperationSupportData) {
        Objects.requireNonNull(userOperationSupportData, "Parameter [userExecutionContext] must be provided");
        OperationContext operationContext = new OperationContext(mathContext,
                scale, false, ZonedDateTime.now(zoneId), conversionService, operationSupportData,
                userOperationSupportData);
        for (AbstractVariableValueOperation variableValueOperation : userVariables.values()) {
            if (variableValueOperation.shouldResetOperation(operationContext)) {
                variableValueOperation.clearCache();
            }
        }
        return operation.evaluate(operationContext);
    }

    public void warmUp() {
        OperationContext operationContext = new OperationContext(mathContext,
                scale, true, ZonedDateTime.now(), conversionService, operationSupportData, operationSupportData);
        visitOperation(new WarmUpOperationVisitor(operationContext));
    }

    public void addDictionaryEntry(String key, Object value) {
        AssertUtils.notNullOrBlank(key, "Dictionary entry name required");
        Objects.requireNonNull(value, "Dictionary entry value required");
        operationSupportData.getDictionary().put(key, value);
    }

    public void addDictionary(Map<String, Object> dictionary) {
        Objects.requireNonNull(dictionary, "Cannot add a null dictionary to execution context");
        operationSupportData.getDictionary().putAll(dictionary);
    }

    public void addFunction(String name, OperationLambdaCaller function) {
        AssertUtils.notNullOrBlank(name, "Function name must be provided");
        Objects.requireNonNull(function, "A function implementation must be provided");
        String keyName = keyName(name, UNKNOWN);
        if (operationSupportData.getFunctions().containsKey(keyName)) {
            throw new SentenceConfigurationException(String.format("Cannot override predefined function [%s]", name));
        }
        operationSupportData.getFunctions().put(keyName, function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        try {
            Map<String, OperationLambdaCaller> callerMap = createFunctionCaller(functionProvider);

            List<String> overridingFunctions = callerMap.keySet().stream().filter(key ->
                    operationSupportData.getFunctions().containsKey(key)).toList();
            if (!overridingFunctions.isEmpty()) {
                throw new SentenceConfigurationException(String.format("Cannot override predefined functions [%s]",
                        String.join(", ", overridingFunctions)));
            }
            operationSupportData.getFunctions().putAll(callerMap);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while extracting functions from provider object", e);
        }
    }

    public SyntaxExecutionSite copy() {
        CloningContext cloningCtx = new CloningContext();
        AbstractOperation copy = operation.copy(cloningCtx);
        return new SyntaxExecutionSite(
                copy, mathContext, scale, zoneId, cloningCtx.getUserVariables(), cloningCtx.getAssignedVariables(),
                new OperationSupportData(new HashMap<>(operationSupportData.getDictionary()), new HashMap<>(operationSupportData.getFunctions())),
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
