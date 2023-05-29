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

package io.github.mportilho.sentencecompiler;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.memoization.MemoizedSupplier;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.data.DataStore;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.CloningContext;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.WarmUpOperationVisitor;

import java.time.ZonedDateTime;
import java.util.*;

import static io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory.createLambdaCallSites;

class SyntaxExecutionSite {

    private final AbstractOperation operation;
    private final SyntaxExecutionData syntaxExecutionData;
    private final Map<String, AbstractVariableValueOperation> variables;
    private final Map<String, AssignedVariableOperation> assignedVariables;
    private final DataStore dataStore;
    private final FormattedConversionService conversionService;

    public SyntaxExecutionSite(
            AbstractOperation operation,
            SyntaxExecutionData syntaxExecutionData,
            Map<String, AbstractVariableValueOperation> variables,
            Map<String, AssignedVariableOperation> assignedVariables,
            DataStore dataStore,
            FormattedConversionService conversionService) {
        this.operation = operation;
        this.syntaxExecutionData = syntaxExecutionData;
        this.variables = Collections.unmodifiableMap(variables);
        this.assignedVariables = Collections.unmodifiableMap(assignedVariables);
        this.dataStore = dataStore;
        this.conversionService = conversionService;
    }

    public Object compute() {
        return compute(DataStore.EMPTY_DATA);
    }

    public Object compute(DataStore userDataStore) {
        Objects.requireNonNull(userDataStore, "Parameter [userExecutionContext] must be provided");
        OperationContext operationContext = new OperationContext(syntaxExecutionData.mathContext(),
                syntaxExecutionData.scale(), false, syntaxExecutionData.cachingVariableProvider(),
                new MemoizedSupplier<>(() -> ZonedDateTime.now(syntaxExecutionData.zoneId())),
                conversionService, dataStore,
                userDataStore, false, syntaxExecutionData.zoneId());
        return operation.evaluate(operationContext);
    }

    public void warmUp() {
        OperationContext operationContext = new OperationContext(syntaxExecutionData.mathContext(),
                syntaxExecutionData.scale(), true, syntaxExecutionData.cachingVariableProvider(),
                new MemoizedSupplier<>(() -> ZonedDateTime.now(syntaxExecutionData.zoneId())), conversionService, dataStore,
                dataStore, syntaxExecutionData.preciseNumbers(), syntaxExecutionData.zoneId());
        visitOperation(new WarmUpOperationVisitor(operationContext));
    }

    public void addDictionaryEntry(String key, Object value) {
        dataStore.putDictionary(key, value);
    }

    public void addDictionary(Map<String, Object> dictionary) {
        dataStore.putAllDictionary(dictionary);
    }

    public void addFunction(LambdaCallSite function) {
        dataStore.putFunction(function.getKeyName(), function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        try {
            Map<String, LambdaCallSite> callSiteMap = createLambdaCallSites(functionProvider);
            List<String> overridingFunctions = callSiteMap.keySet().stream().filter(key -> dataStore.findFunction(key) != null).toList();
            if (!overridingFunctions.isEmpty()) {
                throw new SentenceConfigurationException("Cannot add the following functions because they are already defined: " + overridingFunctions);
            }
            callSiteMap.forEach(dataStore::putFunction);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while extracting functions from provider object", e);
        }
    }

    public SyntaxExecutionSite copy() {
        CloningContext cloningCtx = new CloningContext();
        AbstractOperation copy = operation.copy(cloningCtx);
        return new SyntaxExecutionSite(copy, syntaxExecutionData, cloningCtx.getVariables(),
                cloningCtx.getAssignedVariables(), dataStore, conversionService);
    }

    AbstractVariableValueOperation getVariableOperation(String name) {
        AssertUtils.notNullOrBlank(name, "Parameter [name] must be provided");
        return variables.get(name);
    }

    public void setVariable(String name, Object value) {
        AbstractVariableValueOperation variableOperation = getVariableOperation(name);
        if (variableOperation != null) {
            variableOperation.setValue(value);
        }
    }

    public void setAndLockVariable(String name, Object value) {
        AbstractVariableValueOperation variableOperation = getVariableOperation(name);
        if (variableOperation != null) {
            variableOperation.setValueAndLock(value);
        }
    }

    public Map<String, Object> listAssignedVariables() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, AssignedVariableOperation> entry : assignedVariables.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getLastResult());
        }
        return map;
    }

    public Map<String, Object> listVariables() {
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, AbstractVariableValueOperation> entry : variables.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getLastResult());
        }
        return map;
    }

    public void visitOperation(OperationVisitor<?> visitor) {
        operation.accept(visitor);
    }

    public String toOperationStringRepresentation() {
        return operation.toString();
    }

    public FormattedConversionService getConversionService() {
        return conversionService;
    }
}
