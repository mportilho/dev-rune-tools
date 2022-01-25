package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestExpressionWithVariable {

    @Test
    public void testMathVariables() {
        MathSentence compiler;

        compiler = new MathSentence("a%");
        compiler.setVariable("a", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("0.05");
    }

}
