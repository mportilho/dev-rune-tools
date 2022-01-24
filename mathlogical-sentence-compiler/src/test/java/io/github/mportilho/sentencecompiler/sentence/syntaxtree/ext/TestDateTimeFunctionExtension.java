package io.github.mportilho.sentencecompiler.sentence.syntaxtree.ext;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.DateTimeFunctionExtension.dateTimeFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;

public class TestDateTimeFunctionExtension {

    private static final FunctionContext functionContext =
            new FunctionContext(MathContext.DECIMAL64, null, new DefaultFormattedConversionService());

    @Test
    public void test_secondsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("secondsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(60 * 60 * 24 * 2L);
    }

    @Test
    public void test_minutesBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("minutesBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(60 * 24 * 2L);
    }

    @Test
    public void test_hoursBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("hoursBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(24 * 2L);
    }

    @Test
    public void test_daysBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("daysBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusDays(2)}))
                .isEqualByComparingTo(2L);
    }

    @Test
    public void test_monthsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("monthsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusYears(2)}))
                .isEqualByComparingTo(12 * 2L);
    }

    @Test
    public void test_yearsBetween_Function() {
        OperationLambdaCaller between = dateTimeFunctionsFactory().get(keyName("yearsBetween", 2));

        LocalDateTime d1 = LocalDateTime.of(2020, 4, 7, 12, 23, 14);
        assertThat((long) between.call(functionContext, new Temporal[]{d1, d1.plusYears(2)}))
                .isEqualByComparingTo(2L);
    }
}
