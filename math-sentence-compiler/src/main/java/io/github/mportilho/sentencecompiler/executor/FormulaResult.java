package io.github.mportilho.sentencecompiler.executor;

import java.math.BigDecimal;

public record FormulaResult(

        MathFormula mathFormula,
        ComputationMemory computationMemory

) {

    /**
     * Finds a numeric variable in the computation memory by its name. It will first look for assigned variable list and then for variable list.
     * <br/>
     * The variable must be a numeric value or *null* will be returned.
     *
     * @param variableName the name of the variable
     * @return the numeric value of the variable or null if it does not exist
     */
    public BigDecimal findNumericVariable(String variableName) {
        if (computationMemory.assignedVariables().get(variableName) instanceof BigDecimal number) {
            return number;
        } else if (computationMemory.variables().get(variableName) instanceof BigDecimal number) {
            return number;
        } else if (computationMemory.contextVariables().get(variableName) instanceof BigDecimal number) {
            return number;
        }
        return null;
    }

}
