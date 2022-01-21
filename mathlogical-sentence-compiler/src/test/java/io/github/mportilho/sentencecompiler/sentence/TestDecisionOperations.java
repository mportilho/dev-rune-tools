package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestDecisionOperations {

    @Test
    public void testDecisionOperations() {
        MathSentence mathSentence;

        mathSentence = new MathSentence("if true then 1 else 0 endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("1");
        mathSentence = new MathSentence("if(true, 1, 0)");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("1");

        mathSentence = new MathSentence("if false then 1 else 0 endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("0");
        mathSentence = new MathSentence("if(false, 1, 0)");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("0");

        mathSentence = new MathSentence("if true then 7 elsif false then 1 else if true then 1 else 0 endif endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
        mathSentence = new MathSentence("if(true, 7, false, 1, if(true, 1, 0))");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");

        mathSentence = new MathSentence("if false then 0 elsif false then 1 else if true then 7 else 0 endif endif");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
        mathSentence = new MathSentence("if(false, 0, false, 1, if(true, 7, 0))");
        assertThat(mathSentence.<BigDecimal>compute()).isEqualByComparingTo("7");
    }

}
