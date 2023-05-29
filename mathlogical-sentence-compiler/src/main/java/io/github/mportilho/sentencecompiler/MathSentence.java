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
import io.github.mportilho.sentencecompiler.data.DataStore;
import io.github.mportilho.sentencecompiler.exceptions.MathSentenceLockingException;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.OperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeData;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeParser;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.impl.FastOperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.impl.PreciseOperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.lang.invoke.MethodType;
import java.math.MathContext;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathSentence {

    private final String originalSentence;
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
        this.originalSentence = sentence;
        this.mathContext = mathSentenceOptions.getMathContext();
        this.scale = mathSentenceOptions.getScale();
        this.syntaxExecutionSite = initializeComputingSite(sentence, mathSentenceOptions);
        this.locked = false;
    }

    public MathSentence(String sentence, DataStore dataStore) {
        this(sentence, new MathSentenceOptions(dataStore));
    }

    private MathSentence(String originalSentence, MathContext mathContext, Integer scale, SyntaxExecutionSite syntaxExecutionSite) {
        this.originalSentence = originalSentence;
        this.mathContext = mathContext;
        this.scale = scale;
        this.syntaxExecutionSite = syntaxExecutionSite;
    }

    private SyntaxExecutionSite initializeComputingSite(String sentence, MathSentenceOptions mathSentenceOptions) {
        OperationSyntaxTreeGenerator generator = mathSentenceOptions.isPreciseNumbers() ?
                new PreciseOperationSyntaxTreeGenerator() : new FastOperationSyntaxTreeGenerator();

        SyntaxTreeData data = SyntaxTreeParser.parseSentence(sentence, generator);
        return new SyntaxExecutionSite(data.operation(),
                new SyntaxExecutionData(mathSentenceOptions.getMathContext(), mathSentenceOptions.getScale(),
                        mathSentenceOptions.getZoneId(), mathSentenceOptions.isPreciseNumbers(),
                        mathSentenceOptions.isCachingVariableProvider()),
                data.userVariables(), data.assignedVariables(),
                mathSentenceOptions.getDataStore() != null ? mathSentenceOptions.getDataStore() : new DataStore(),
                mathSentenceOptions.getFormattedConversionService());
    }

    @SuppressWarnings("unchecked")
    public <T> T compute() {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute();
    }

    @SuppressWarnings("unchecked")
    public <T> T compute(DataStore userDataStore) {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute(userDataStore);
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
        syntaxExecutionSite.getDataStore().putDictionary(key, value);
        return this;
    }

    public MathSentence addDictionary(Map<String, Object> dictionary) {
        checkUpdateLock();
        syntaxExecutionSite.getDataStore().putAllDictionary(dictionary);
        return this;
    }

    public MathSentence addFunction(LambdaCallSite function) {
        checkUpdateLock();
        syntaxExecutionSite.getDataStore().putFunction(function);
        return this;
    }

    public MathSentence addFunction(String functionName, MethodType methodType, Function<Object[], Object> function) {
        checkUpdateLock();
        syntaxExecutionSite.getDataStore().putFunction(functionName, methodType, function);
        return this;
    }

    public MathSentence addFunctionFromObject(Object functionProvider) {
        checkUpdateLock();
        syntaxExecutionSite.addFunctionFromObject(functionProvider);
        return this;
    }

    public MathSentence setConstant(String variableName, Object value) {
        this.syntaxExecutionSite.setAndLockVariable(variableName, value);
        return this;
    }

    public MathSentence setVariable(String variableName, Object value) {
        checkUpdateLock();
        syntaxExecutionSite.setVariable(variableName, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public MathSentence setVariables(Map<String, Object> variables) {
        checkUpdateLock();
        variables.forEach((name, value) -> {
            if (value instanceof VariableProvider) {
                setVariableProvider(name, (VariableProvider) value);
            } else if (value instanceof Supplier) {
                setVariableProvider(name, (Supplier<Object>) value);
            } else {
                setVariable(name, value);
            }
        });
        return this;
    }

    public MathSentence setVariableProvider(String variableName, VariableProvider provider) {
        checkUpdateLock();
        return setVariable(variableName, provider);
    }

    public MathSentence setVariableProvider(String variableName, Supplier<Object> supplier) {
        checkUpdateLock();
        return setVariable(variableName, (VariableProvider) context -> supplier.get());
    }

    public Map<String, Object> listAssignedVariables() {
        return syntaxExecutionSite.listAssignedVariables();
    }

    public Map<String, Object> listUserVariables() {
        return syntaxExecutionSite.listVariables();
    }

    public final MathSentence copy() {
        return new MathSentence(this.originalSentence, this.mathContext, this.scale, this.syntaxExecutionSite.copy());
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

    public String getOriginalSentence() {
        return originalSentence;
    }

    @Override
    public String toString() {
        return syntaxExecutionSite.toOperationStringRepresentation();
    }

}
