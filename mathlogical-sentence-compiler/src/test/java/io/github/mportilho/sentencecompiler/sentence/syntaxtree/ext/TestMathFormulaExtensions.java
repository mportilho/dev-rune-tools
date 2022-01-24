package io.github.mportilho.sentencecompiler.sentence.syntaxtree.ext;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.MathFormulasExtension.mathFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;
import static java.math.BigDecimal.*;

public class TestMathFormulaExtensions {

    private static final FunctionContext functionContext =
            new FunctionContext(MathContext.DECIMAL64, null, new DefaultFormattedConversionService());

    @Test
    public void test_Max_Function() {
        OperationLambdaCaller max = mathFunctionsFactory().get(keyName("max", -1));

        assertThat((BigDecimal) max.call(functionContext, new BigDecimal[]{ONE, TEN, valueOf(-50), valueOf(231)}))
                .isEqualByComparingTo("231");

        assertThat((BigDecimal) max.call(functionContext, new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}))
                .isEqualByComparingTo("99");
    }

    @Test
    public void test_Min_Function() {
        OperationLambdaCaller min = mathFunctionsFactory().get(keyName("min", -1));

        assertThat((BigDecimal) min.call(functionContext, new BigDecimal[]{ONE, TEN, valueOf(-50), valueOf(231)}))
                .isEqualByComparingTo("-50");

        assertThat((BigDecimal) min.call(functionContext, new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}))
                .isEqualByComparingTo("1");
    }

    @Test
    public void test_Avg_Function() {
        OperationLambdaCaller avg = mathFunctionsFactory().get(keyName("avg", -1));

        assertThat((BigDecimal) avg.call(functionContext, new BigDecimal[]{ONE, TEN, valueOf(-50), valueOf(231)}))
                .isEqualByComparingTo("48");

        assertThat((BigDecimal) avg.call(functionContext, new Integer[]{1, 2, 3, 4, 5, 6, 99, 98, 97, 96}))
                .isEqualByComparingTo("41.1");
    }

    @Test
    public void test_Rule3d_Function() {
        OperationLambdaCaller rule3d = mathFunctionsFactory().get(keyName("rule3d", 3));
        assertThat((BigDecimal) rule3d.call(functionContext, new Double[]{1.2, 400.0, 1.5}))
                .isEqualByComparingTo("500");
    }

    @Test
    public void test_Rule3i_Function() {
        OperationLambdaCaller rule3i = mathFunctionsFactory().get(keyName("rule3i", 3));
        assertThat((BigDecimal) rule3i.call(functionContext, new Integer[]{400, 3, 480}))
                .isEqualByComparingTo("2.5");
    }

}
