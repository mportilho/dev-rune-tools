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

import io.github.mportilho.commons.converters.DefaultFormattedConversionService;
import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.utils.AssertUtils;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import io.github.mportilho.sentencecompiler.syntaxtree.*;
import io.github.mportilho.sentencecompiler.syntaxtree.function.DynamicFunction;
import io.github.mportilho.sentencecompiler.syntaxtree.parser.DefaultOperationSyntaxTreeGenerator;
import io.github.mportilho.sentencecompiler.syntaxtree.visitor.OperationVisitor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class MathSentence {

    private MathSentenceOptions mathSentenceOptions;
    private FormattedConversionService service;
    private ComputingSite computingSite;
    private ComputingContext computingContext;

    private MathSentence() {
        // internal use
    }

    public MathSentence(String sentence) {
        this(sentence, null, new DefaultFormattedConversionService());
    }

    public MathSentence(String sentence, MathSentenceOptions mathSentenceOptions) {
        this(sentence, mathSentenceOptions, new DefaultFormattedConversionService());
    }

    public MathSentence(
            String sentence, MathSentenceOptions mathSentenceOptions,
            FormattedConversionService formattedConversionService) {
        AssertUtils.notNullOrBlank(sentence, "Parameter [sentence] must be provided");
        Objects.requireNonNull(formattedConversionService, "Parameter [formattedConversionService] must be provided");

        this.mathSentenceOptions = mathSentenceOptions != null ? mathSentenceOptions : new MathSentenceOptions();
        this.computingContext = new ComputingContext();
        initializeComputingSite(sentence, formattedConversionService);
    }

    private void initializeComputingSite(String sentence, FormattedConversionService formattedConversionService) {
        SyntaxTreeData data = SyntaxTreeParser.parseSentence(sentence, new DefaultOperationSyntaxTreeGenerator());
        this.computingSite = new ComputingSite(data.operation(), data.userVariables(), data.assignedVariables(),
                formattedConversionService);
    }

    @SuppressWarnings("unchecked")
    public <T> T compute() {
        OperationContext operationContext = new OperationContext(mathSentenceOptions.getMathContext(),
                mathSentenceOptions.getScale(), false, LocalDateTime.now(), computingSite,
                computingContext, ComputingContext.EMPTY);
        return (T) this.computingSite.compute(operationContext);
    }

    @SuppressWarnings("unchecked")
    public <T> T compute(ComputingContext userComputingContext) {
        OperationContext operationContext = new OperationContext(mathSentenceOptions.getMathContext(),
                mathSentenceOptions.getScale(), false, LocalDateTime.now(), computingSite,
                computingContext, userComputingContext);
        return (T) this.computingSite.compute(operationContext);
    }

    public MathSentence warmUp() {
        OperationContext operationContext = new OperationContext(mathSentenceOptions.getMathContext(),
                mathSentenceOptions.getScale(), true, null, computingSite,
                computingContext, ComputingContext.EMPTY);
        this.computingSite.warmUp(operationContext);
        return this;
    }

    public MathSentence computingContext(ComputingContext computingContext) {
        this.computingContext = computingContext;
        return this;
    }

    public void addFunction(String functionName, DynamicFunction function) {
        throw new IllegalStateException();
    }

    public void addFunctions(Object functionProvider) {
        throw new IllegalStateException();
    }

    public MathSentence setUserVariable(String variableName, Object value) {
        computingSite.setUserVariable(variableName, value);
        return this;
    }

    public MathSentence setUserVariableProvider(String variableName, VariableProvider provider) {
        return setUserVariable(variableName, provider);
    }

    public Map<String, Object> listAssignedVariables() {
        return computingSite.listAssignedVariables();
    }

    public Map<String, Object> listUserVariables() {
        return computingSite.listUserVariables();
    }

    public final MathSentence copy() {
        MathSentence mathSentence = new MathSentence();
        mathSentence.computingSite = this.computingSite.copy();
        mathSentence.mathSentenceOptions = this.mathSentenceOptions;
        mathSentence.service = this.service;
        mathSentence.computingContext = this.computingContext;
        return mathSentence;
    }

    public <T> T visitOperations(OperationVisitor<T> visitor) {
        return computingSite.visitOperation(visitor);
    }

    @Override
    public String toString() {
        return computingSite.toOperationStringRepresentation();
    }

}
