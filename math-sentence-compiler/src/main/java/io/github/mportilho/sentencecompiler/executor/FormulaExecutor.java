package io.github.mportilho.sentencecompiler.executor;

import io.github.mportilho.sentencecompiler.MathSentence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormulaExecutor {

    private final MathSentenceFactory factory;

    public FormulaExecutor(MathSentenceFactory factory) {
        this.factory = factory;
    }

    public List<FormulaOutcome> execute(FormulaContainer formulaContainer) {
        List<FormulaOutcome> outcomes = new ArrayList<>();
        Map<String, Object> computationVariables = new HashMap<>(formulaContainer.contextVariables());
        for (MathFormula formula : formulaContainer.formulas()) {
            ComputationMemory memory = executeFormula(formula, computationVariables);
            computationVariables.putAll(memory.assignedVariables());
            outcomes.add(new FormulaOutcome(formula, memory));
        }
        return outcomes;
    }

    private ComputationMemory executeFormula(MathFormula mathFormula, Map<String, Object> contextVariables) {
        MathSentence ms = factory.create(mathFormula);
        Object result = ms.setVariables(contextVariables).compute();
        return new ComputationMemory(mathFormula, result, ms.listUserVariables(), ms.listAssignedVariables(), new HashMap<>(contextVariables));
    }

}
