/*MIT License

Copyright (c) 2021 Marcelo Portilho

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/

package io.github.mportilho.sentencecompiler;

import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.exceptions.MathSentenceLockingException;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.ExecutionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.SyntaxExecutionSite;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeData;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.SyntaxTreeParser;
import io.github.mportilho.sentencecompiler.syntaxtree.function.UserDefinedOperationFunction;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.impl.DefaultOperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.math.MathContext;
import java.util.Map;
import java.util.Objects;

public class MathSentence {

    private MathContext mathContext;
    private Integer scale;
    private SyntaxExecutionSite syntaxExecutionSite;
    private boolean locked = false;

    private MathSentence() {
        // internal use
    }

    public MathSentence(String sentence) {
        this(sentence, new MathSentenceOptions());
    }

    public MathSentence(String sentence, MathSentenceOptions mathSentenceOptions) {
        AssertUtils.notNullOrBlank(sentence, "Parameter [sentence] must be provided");
        Objects.requireNonNull(mathSentenceOptions, "Parameter [mathSentenceOptions] must be provided");
        initializeComputingSite(sentence, mathSentenceOptions);
    }

    private void initializeComputingSite(String sentence, MathSentenceOptions mathSentenceOptions) {
        SyntaxTreeData data = SyntaxTreeParser.parseSentence(sentence, new DefaultOperationSyntaxTreeGenerator());
        this.syntaxExecutionSite = new SyntaxExecutionSite(data.operation(), mathSentenceOptions.getMathContext(),
                mathSentenceOptions.getScale(), data.userVariables(), data.assignedVariables(),
                new ExecutionContext(), mathSentenceOptions.getFormattedConversionService());
    }

    @SuppressWarnings("unchecked")
    public <T> T compute() {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute();
    }

    @SuppressWarnings("unchecked")
    public <T> T compute(ExecutionContext userExecutionContext) {
        checkUpdateLock();
        return (T) this.syntaxExecutionSite.compute(userExecutionContext);
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

    public MathSentence addDictionary(Map<String, Object> dictionary) {
        checkUpdateLock();
        syntaxExecutionSite.addDictionary(dictionary);
        return this;
    }

    public void addFunction(String name, UserDefinedOperationFunction function) {
        checkUpdateLock();
        syntaxExecutionSite.addFunction(name, function);
    }

    public void addFunctionFromObject(Object functionProvider) {
        checkUpdateLock();
        syntaxExecutionSite.addFunctionFromObject(functionProvider);
    }

    public MathSentence setUserVariable(String variableName, Object value) {
        checkUpdateLock();
        syntaxExecutionSite.setUserVariable(variableName, value);
        return this;
    }

    public MathSentence setUserVariableProvider(String variableName, VariableProvider provider) {
        checkUpdateLock();
        return setUserVariable(variableName, provider);
    }

    public Map<String, Object> listAssignedVariables() {
        return syntaxExecutionSite.listAssignedVariables();
    }

    public Map<String, Object> listUserVariables() {
        return syntaxExecutionSite.listUserVariables();
    }

    public final MathSentence copy() {
        MathSentence mathSentence = new MathSentence();
        mathSentence.mathContext = this.mathContext;
        mathSentence.scale = this.scale;
        mathSentence.syntaxExecutionSite = this.syntaxExecutionSite.copy();
        mathSentence.locked = false;
        return mathSentence;
    }

    public <T> T visitOperations(OperationVisitor<T> visitor) {
        checkUpdateLock();
        return syntaxExecutionSite.visitOperation(visitor);
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
