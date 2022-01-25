package io.github.mportilho.sentencecompiler.sentence;

import io.github.mportilho.sentencecompiler.MathSentence;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestZonedDateTimeVariables {

    @Test
    public void testZonedDT_withLocalDate() {
        MathSentence compiler;

        ZonedDateTime zdt = ZonedDateTime.of(LocalDate.of(2020, 4, 30), LocalTime.now(), ZoneId.systemDefault());
        compiler = new MathSentence("a = 2020-04-30").setVariable("a", zdt);
        assertThat(compiler.<Boolean>compute()).isTrue();
    }

}
