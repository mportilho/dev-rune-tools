package io.github.mportilho.sentencecompiler.executor;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestFormulaExecutor {

    @Test
    public void test() {
        FormulaExecutor executor = new FormulaExecutor(mathFormula -> new MathSentence(mathFormula.formula()));
        List<MathFormula> formulas = new ArrayList<>();
        formulas.add(new MathFormula("1", """
                IAS = ((Qi + Qp / 3) / Qt) * 100;
                80 <= IAS and IAS <= 100
                """));
        formulas.add(new MathFormula("2", "valorOS * if(60 <= IAS and IAS < 80, 5%, 10%)"));
        Map<String, Object> variables = Map.of("Qi", 1, "Qp", 2, "Qt", 3, "valorOS", 1000);

        FormulaContainer formulaContainer = new FormulaContainer(formulas, variables);
        List<FormulaOutcome> outcomes = executor.execute(formulaContainer);
        System.out.println(outcomes);
    }

}
