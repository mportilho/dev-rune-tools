/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/

package io.github.mportilho.sentencecompiler.support.lambda;

import io.github.mportilho.commons.converters.FormattedConversionService;
import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import static io.github.mportilho.sentencecompiler.testutils.MathSentenceCompilerMockupFactory.getLambdaContext;

public class TestMethodMetaFactory {

    private static final FormattedConversionService conversionService = new DefaultFormattedConversionService();

    @Test
    public void test_addBigDecimal() throws Throwable {
        Map<String, LambdaCallSite> siteMap = LambdaCallSiteFactory.createLambdaCallSites(PlaceholderMethodUtils.class);
        Object value = siteMap.get("adder_2").call(getLambdaContext(), conversionService, new Object[]{BigDecimal.valueOf(3), BigDecimal.valueOf(5)});
        Assertions.assertThat(value)
                .asInstanceOf(InstanceOfAssertFactories.BIG_DECIMAL)
                .isEqualByComparingTo("8");
    }

    @Test
    public void test_concatString() throws Throwable {
        Map<String, LambdaCallSite> siteMap = LambdaCallSiteFactory.createLambdaCallSites(PlaceholderMethodUtils.class);
        Object value = siteMap.get("concatOne_1").call(getLambdaContext(), conversionService, new Object[]{"number"});
        Assertions.assertThat(value)
                .asInstanceOf(InstanceOfAssertFactories.STRING)
                .isEqualTo("number_1");
    }

    @Test
    public void test_callingMethod_withPrimitives() throws Throwable {
        Map<String, LambdaCallSite> siteMap = LambdaCallSiteFactory.createLambdaCallSites(PlaceholderMethodUtils.class);
        Object value = siteMap.get("adderLong_2").call(getLambdaContext(), conversionService, new Object[]{"3", "4"});
        Assertions.assertThat(value)
                .asInstanceOf(InstanceOfAssertFactories.LONG)
                .isEqualTo(7L);
    }

    @Test
    public void test_callingMethod_withLambdas() throws Throwable {
        Map<String, LambdaCallSite> siteMap = LambdaCallSiteFactory.createLambdaCallSites(ChronoUnit.DAYS, "between");
        Object value = siteMap.get("between_2").call(getLambdaContext(), conversionService, new Object[]{"2020-01-15", "2020-01-30"});
        Assertions.assertThat(value)
                .asInstanceOf(InstanceOfAssertFactories.LONG)
                .isEqualTo(15);
    }

}
