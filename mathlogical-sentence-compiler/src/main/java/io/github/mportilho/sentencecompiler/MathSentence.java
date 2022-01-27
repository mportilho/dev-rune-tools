/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2021-2022. Marcelo Silva Portilho
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

import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.exceptions.MathSentenceLockingException;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationSupportData;
import io.github.mportilho.sentencecompiler.syntaxtree.SyntaxExecutionSite;
import io.github.mportilho.sentencecompiler.syntaxtree.ext.DateTimeFunctionExtension;
import io.github.mportilho.sentencecompiler.syntaxtree.ext.FinancialFormulasExtension;
import io.github.mportilho.sentencecompiler.syntaxtree.ext.MathFormulasExtension;
import io.github.mportilho.sentencecompiler.syntaxtree.ext.StringFunctionExtension;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeData;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeParser;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.impl.DefaultOperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.math.MathContext;
import java.util.Map;
import java.util.Objects;

public class MathSentence {

    private final MathContext mathContext;
    private final Integer scale;
    private final SyntaxExecutionSite syntaxExecutionSite;
    private boolean locked;

    public MathSentence(String sentence) {
        this(sentence, new MathSentenceOptions());
    }

    public MathSentence(String sentence, MathSentenceOptions mathSentenceOptions) {
        AssertUtils.notNullOrBlank(sentence, "Sentence text must be provided");
        Objects.requireNonNull(mathSentenceOptions, "MathSentenceOptions must be provided");
        this.mathContext = mathSentenceOptions.getMathContext();
        this.scale = mathSentenceOptions.getScale();
        this.syntaxExecutionSite = initializeComputingSite(sentence, mathSentenceOptions);
        this.locked = false;
    }

    private MathSentence(
            MathContext mathContext, Integer scale, SyntaxExecutionSite syntaxExecutionSite, boolean locked) {
        this.mathContext = mathContext;
        this.scale = scale;
        this.syntaxExecutionSite = syntaxExecutionSite;
        this.locked = locked;
    }

    private SyntaxExecutionSite initializeComputingSite(String sentence, MathSentenceOptions mathSentenceOptions) {
        SyntaxTreeData data = SyntaxTreeParser.parseSentence(sentence, new DefaultOperationSyntaxTreeGenerator());
        return new SyntaxExecutionSite(data.operation(), mathSentenceOptions.getMathContext(),
                mathSentenceOptions.getScale(), mathSentenceOptions.getZoneId(), data.userVariables(),
                data.assignedVariables(), createDefaultOperationSupportData(mathSentenceOptions),
                mathSentenceOptions.getFormattedConversionService());
    }

    private OperationSupportData createDefaultOperationSupportData(MathSentenceOptions mathSentenceOptions) {
        OperationSupportData operationSupportData = mathSentenceOptions.getOperationSupportData() != null ?
                mathSentenceOptions.getOperationSupportData() : new OperationSupportData();

        operationSupportData.getFunctions().putAll(DateTimeFunctionExtension.dateTimeFunctionsFactory());
        operationSupportData.getFunctions().putAll(FinancialFormulasExtension.financialFunctionsFactory());
        operationSupportData.getFunctions().putAll(MathFormulasExtension.mathFunctionsFactory());
        operationSupportData.getFunctions().putAll(StringFunctionExtension.stringFunctionsFactory());
        return operationSupportData;
    }

    @SuppressWarnings("unchecked")
    public <T> T compute() {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute();
    }

    @SuppressWarnings("unchecked")
    public <T> T compute(OperationSupportData userOperationSupportData) {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute(userOperationSupportData);
    }

    public MathSentence warmUp() {
        checkUpdateLock();
        this.syntaxExecutionSite.warmUp();
        return this;
    }

    public MathSentence lock() {
        locked = true;
        return this;
    }

    public MathSentence addDictionaryEntry(String key, Object value) {
        checkUpdateLock();
        syntaxExecutionSite.addDictionaryEntry(key, value);
        return this;
    }

    public MathSentence addDictionary(Map<String, Object> dictionary) {
        checkUpdateLock();
        syntaxExecutionSite.addDictionary(dictionary);
        return this;
    }

    public void addFunction(String name, OperationLambdaCaller function) {
        checkUpdateLock();
        syntaxExecutionSite.addFunction(name, function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        checkUpdateLock();
        syntaxExecutionSite.addFunctionFromObject(functionProvider);
    }

    public MathSentence setVariable(String variableName, Object value) {
        checkUpdateLock();
        syntaxExecutionSite.setUserVariable(variableName, value);
        return this;
    }

    public MathSentence setVariables(Map<String, Object> variables) {
        checkUpdateLock();
        variables.forEach(this::setVariable);
        return this;
    }

    public MathSentence setVariableProvider(String variableName, VariableProvider provider) {
        checkUpdateLock();
        return setVariable(variableName, provider);
    }

    public Map<String, Object> listAssignedVariables() {
        return syntaxExecutionSite.listAssignedVariables();
    }

    public Map<String, Object> listUserVariables() {
        return syntaxExecutionSite.listUserVariables();
    }

    public final MathSentence copy() {
        return new MathSentence(this.mathContext, this.scale, this.syntaxExecutionSite.copy(), this.locked);
    }

    public <T> T visitOperations(OperationVisitor<T> visitor) {
        checkUpdateLock();
        syntaxExecutionSite.visitOperation(visitor);
        return visitor.getFinalResult();
    }

    private void checkUpdateLock() {
        if (locked) {
            throw new MathSentenceLockingException("Math Sentence object is locked for updating");
        }
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return syntaxExecutionSite.toOperationStringRepresentation();
    }

}
