package io.github.mportilho.sentencecompiler.executor;

import java.util.Collections;
import java.util.Map;

public record ComputationMemory(

        MathFormula formula,
        Object result,
        Map<String, Object> variables,
        Map<String, Object> assignedVariables,
        Map<String, Object> contextVariables

) {

    public ComputationMemory {
        variables = Collections.unmodifiableMap(variables);
        assignedVariables = Collections.unmodifiableMap(assignedVariables);
        contextVariables = Collections.unmodifiableMap(contextVariables);
    }
}
