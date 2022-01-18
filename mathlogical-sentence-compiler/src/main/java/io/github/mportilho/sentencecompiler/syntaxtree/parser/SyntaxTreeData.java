package io.github.mportilho.sentencecompiler.syntaxtree.parser;

import io.github.mportilho.sentencecompiler.operation.AbstractOperation;
import io.github.mportilho.sentencecompiler.operation.other.AssignedVariableOperation;
import io.github.mportilho.sentencecompiler.operation.value.variable.AbstractVariableValueOperation;

import java.util.Map;

public record SyntaxTreeData(

        AbstractOperation operation,
        Map<String, AbstractVariableValueOperation> userVariables,
        Map<String, AssignedVariableOperation> assignedVariables

) {
}
