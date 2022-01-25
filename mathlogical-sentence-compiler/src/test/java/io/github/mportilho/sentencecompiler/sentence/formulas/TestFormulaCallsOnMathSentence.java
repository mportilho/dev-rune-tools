package io.github.mportilho.sentencecompiler.sentence.formulas;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestFormulaCallsOnMathSentence {

    @Test
    public void testMathFormulas() {
        MathSentence compiler;

        compiler = new MathSentence("max(1, 3, 5.5, 100/10)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("10");

        compiler = new MathSentence("min(3/3, 3, 5.5, 100/10)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("1");

    }

    @Test
    public void testExcelFormulas() {
        MathSentence compiler;

        compiler = new MathSentence("fv(18%, 12, 1, 0, 10000, 0)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("-11956.18171461535");

        compiler = new MathSentence("ipmt(5%, 12, 10, 5000)");
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("32.37614374136415");
    }

}
