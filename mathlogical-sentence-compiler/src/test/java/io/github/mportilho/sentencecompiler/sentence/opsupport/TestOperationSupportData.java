package io.github.mportilho.sentencecompiler.sentence.opsupport;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.exceptions.SyntaxExecutionException;
import io.github.mportilho.sentencecompiler.syntaxtree.OperationSupportData;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

public class TestOperationSupportData {

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_1() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [a] requires a value");

        compiler
                .addDictionaryEntry("a", 3)
                .addDictionaryEntry("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_2() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [b] requires a value");

        compiler.addDictionaryEntry("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

    @Test
    public void test_overrideVariable_with_InternalDictionary_case_3() {
        MathSentence compiler;

        compiler = new MathSentence("a + 5 * b");
        compiler
                .addDictionaryEntry("a", 3)
                .addDictionaryEntry("b", 5);

        compiler.setVariable("a", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("30");

        compiler.setVariable("a", 1);
        compiler.setVariable("b", 1);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("6");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_1() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        assertThatThrownBy(compiler::compute)
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [a] requires a value");

        data.putDictionary("a", BigDecimal.valueOf(3));
        assertThatThrownBy(() -> compiler.compute(data))
                .isInstanceOf(SyntaxExecutionException.class).hasMessage("Variable [b] requires a value");

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_2() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_3() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 1);
        compiler.setVariable("b", 2);

        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("11");

        data.putDictionary("a", 3);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("13");

        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("53");
    }

    @Test
    public void test_overrideVariable_with_UserDictionary_case_4() {
        MathSentence compiler;
        OperationSupportData data = new OperationSupportData();

        compiler = new MathSentence("a + 5 * b");
        compiler.setVariable("a", 3);
        compiler.setVariable("b", 5);
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");

        data.putDictionary("a", 5);
        data.putDictionary("b", 10);
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("55");

        data.putDictionary("a", 5);
        data.getDictionary().remove("b");
        assertThat(compiler.<BigDecimal>compute(data)).isEqualByComparingTo("30");

        // not passing user dictionary
        assertThat(compiler.<BigDecimal>compute()).isEqualByComparingTo("28");
    }

}
