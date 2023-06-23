package io.github.mportilho.sentencecompiler.sentence.variables;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.operation.value.variable.VariableProvider;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVariableProviders {

    @Test
    public void testSupplierVariable() {
        MathSentence sentence = new MathSentence("a + 2");
        sentence.setVariableProvider("a", () -> 1);
        assertThat(sentence.<BigDecimal>compute()).isEqualByComparingTo("3");
    }

    @Test
    public void testVariableMapWithSuppliers() {
        MathSentence sentence = new MathSentence("a + b + c + 4");
        Map<String, Object> variables = new HashMap<>();
        variables.put("a", 1);
        variables.put("b", (Supplier<Object>) () -> 2);
        variables.put("c", (VariableProvider) c -> 3);
        sentence.setVariables(variables);
        assertThat(sentence.<BigDecimal>compute()).isEqualByComparingTo("10");
    }

}
