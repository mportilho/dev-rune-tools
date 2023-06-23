package io.github.mportilho.sentencecompiler.executor;

import java.util.List;
import java.util.Map;

public record FormulaContainer(List<MathFormula> formulas, Map<String, Object> contextVariables) {

}
