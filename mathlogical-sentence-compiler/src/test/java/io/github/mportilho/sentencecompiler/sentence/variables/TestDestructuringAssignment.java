package io.github.mportilho.sentencecompiler.sentence.variables;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDestructuringAssignment {

    @Test
    public void testSimpleDestructuringAssignment() {
        MathSentence compiler = new MathSentence("[pagtoPrincipal, pagtoCorrecao, pagtoJuros] = [1, 2, 3];");
        compiler.compute();
        Map<String, Object> assignedVariables = compiler.listAssignedVariables();
        assertThat(assignedVariables).containsEntry("pagtoPrincipal", BigDecimal.valueOf(1));
        assertThat(assignedVariables).containsEntry("pagtoCorrecao", BigDecimal.valueOf(2));
        assertThat(assignedVariables).containsEntry("pagtoJuros", BigDecimal.valueOf(3));
    }

    @Test
    public void testDestructuringAssignmentFromFunction() {
        MathSentence compiler = new MathSentence("[pagtoPrincipal, pagtoCorrecao, pagtoJuros] = multiplyVector(2, [4, 5, 6]);");

        compiler.addFunction("multiplyVector", MethodType.methodType(BigDecimal[].class, BigDecimal.class, BigDecimal[].class), (args) -> {
            BigDecimal multiplier = (BigDecimal) args[0];
            BigDecimal[] vector = (BigDecimal[]) args[1];
            BigDecimal[] result = new BigDecimal[vector.length];
            for (int i = 0; i < vector.length; i++) {
                result[i] = vector[i].multiply(multiplier);
            }
            return result;
        });

        compiler.compute();
        Map<String, Object> assignedVariables = compiler.listAssignedVariables();
        assertThat(assignedVariables).containsEntry("pagtoPrincipal", BigDecimal.valueOf(8));
        assertThat(assignedVariables).containsEntry("pagtoCorrecao", BigDecimal.valueOf(10));
        assertThat(assignedVariables).containsEntry("pagtoJuros", BigDecimal.valueOf(12));
    }

}
