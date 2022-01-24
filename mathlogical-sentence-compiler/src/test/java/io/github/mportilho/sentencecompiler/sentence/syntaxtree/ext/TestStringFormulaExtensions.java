package io.github.mportilho.sentencecompiler.sentence.syntaxtree.ext;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionContext;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.syntaxtree.ext.StringFunctionExtension.stringFunctionsFactory;
import static io.github.mportilho.sentencecompiler.syntaxtree.function.FunctionMetadataFactory.keyName;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;

public class TestStringFormulaExtensions {

    private static final FunctionContext functionContext =
            new FunctionContext(MathContext.DECIMAL64, null, new DefaultFormattedConversionService());

    @Test
    public void test_concat_Function() {
        OperationLambdaCaller concat = stringFunctionsFactory().get(keyName("concat", -1));

        assertThat((String) concat.call(functionContext, new Object[]{ONE, TEN, "teste", "123"}))
                .isEqualTo("110teste123");
    }

    @Test
    public void test_trim_Function() {
        OperationLambdaCaller trim = stringFunctionsFactory().get(keyName("trim", 1));

        assertThat((String) trim.call(functionContext, new Object[]{" a 12  3  "}))
                .isEqualTo("a 12  3");
    }

}
