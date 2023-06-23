package io.github.mportilho.sentencecompiler.sentence.variables;

import io.github.mportilho.sentencecompiler.MathSentence;
import io.github.mportilho.sentencecompiler.exceptions.SentenceExecutionException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestUnknownVariables {

    @Test
    void testUnknownVariableTypes_MathOperation_ofNumber() {
        MathSentence sentence = new MathSentence("a + b");
        sentence.setVariable("a", 1);
        sentence.setVariable("b", 2);
        assertThat(sentence.<BigDecimal>compute()).isEqualByComparingTo("3");
    }

    @Test
    void testUnknownVariableTypes_BooleanOperation_ofNumber() {
        MathSentence sentence = new MathSentence("a = b");
        sentence.setVariable("a", 1);
        sentence.setVariable("b", 2);
        assertThat(sentence.<Boolean>compute()).isFalse();
    }

    @Test
    void testUnknownVariableTypes_BooleanOperation_ofBoolean() {
        MathSentence sentence = new MathSentence("a = b");
        sentence.setVariable("a", true);
        sentence.setVariable("b", true);
        assertThatThrownBy(sentence::<Boolean>compute).isInstanceOf(SentenceExecutionException.class);
    }

}
