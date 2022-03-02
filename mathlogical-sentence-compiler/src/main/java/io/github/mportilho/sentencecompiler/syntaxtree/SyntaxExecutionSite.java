/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
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

package io.github.mportilho.sentencecompiler.syntaxtree;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.memoization.MemoizedSupplier;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.InitialConfigurationOperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZonedDateTime;
import java.util.*;

import static io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory.createLambdaCallSites;

public class SyntaxExecutionSite {

    private static final Logger LOGGER = LoggerFactory.getLogger(SyntaxExecutionSite.class);

    private final AbstractOperation operation;
    private final SyntaxExecutionData syntaxExecutionData;
    private final Map<String, AbstractVariableValueOperation> userVariables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final OperationSupportData operationSupportData;
    private final FormattedConversionService conversionService;

    // caching
    private AbstractVariableValueOperation[] varCache;

    public SyntaxExecutionSite(
            AbstractOperation operation,
            SyntaxExecutionData syntaxExecutionData,
            Map<String, AbstractVariableValueOperation> userVariables,
            Map<String, AssignedVariableOperation> assignedVariables,
            OperationSupportData operationSupportData,
            FormattedConversionService conversionService) {
        this.operation = operation;
        this.syntaxExecutionData = syntaxExecutionData;
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
        OperationContext operationContext = new OperationContext(syntaxExecutionData.mathContext(),
                syntaxExecutionData.scale(), false,
                new MemoizedSupplier<>(() -> ZonedDateTime.now(syntaxExecutionData.zoneId())),
                conversionService, operationSupportData,
                userOperationSupportData, false, syntaxExecutionData.zoneId());
        for (AbstractVariableValueOperation variableValueOperation : getUserVariablesCache()) {
            if (variableValueOperation.shouldResetOperation(operationContext)) {
                variableValueOperation.clearCache();
            }
        }
        return operation.evaluate(operationContext);
    }

    private AbstractVariableValueOperation[] getUserVariablesCache() {
        if (this.varCache == null) {
            this.varCache = userVariables.values().toArray(new AbstractVariableValueOperation[0]);
        }
        return this.varCache;
    }

    public void warmUp() {
        OperationContext operationContext = new OperationContext(syntaxExecutionData.mathContext(),
                syntaxExecutionData.scale(), true,
                new MemoizedSupplier<>(() -> ZonedDateTime.now(syntaxExecutionData.zoneId())), conversionService, operationSupportData,
                operationSupportData, syntaxExecutionData.preciseNumbers(), syntaxExecutionData.zoneId());
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

    public void addFunction(LambdaCallSite function) {
        Objects.requireNonNull(function, "Function implementation is required");
        String keyName = function.getKeyName();
        if (operationSupportData.getFunction(keyName) != null) {
            LOGGER.warn("Overriding already present function [{}]", function.getMethodName());
        }
        operationSupportData.putFunction(keyName, function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        try {
            Map<String, LambdaCallSite> callSiteMap = createLambdaCallSites(functionProvider);

            List<String> overridingFunctions = callSiteMap.keySet().stream().filter(key ->
                    operationSupportData.getFunction(key) != null).toList();
            if (!overridingFunctions.isEmpty()) {
                LOGGER.warn("Overriding already present function(s) [{}]", String.join(", ", overridingFunctions));
            }
            callSiteMap.forEach(operationSupportData::putFunction);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while extracting functions from provider object", e);
        }
    }

    public SyntaxExecutionSite copy() {
        CloningContext cloningCtx = new CloningContext();
        AbstractOperation copy = operation.copy(cloningCtx);
        copy.accept(new InitialConfigurationOperationVisitor());
        return new SyntaxExecutionSite(
                copy, syntaxExecutionData, cloningCtx.getUserVariables(), cloningCtx.getAssignedVariables(),
                new OperationSupportData(new HashMap<>(operationSupportData.getDictionary()), operationSupportData.copyFunctions()),
                conversionService);
    }

    public void setUserVariable(String name, Object value) {
        AssertUtils.notNullOrBlank(name, "Parameter [name] must be provided");
        Objects.requireNonNull(value, "Parameter [value] must be provided");
        AbstractVariableValueOperation variableOperation = userVariables.get(name);
        if (variableOperation != null) {
            variableOperation.setValue(value);
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
