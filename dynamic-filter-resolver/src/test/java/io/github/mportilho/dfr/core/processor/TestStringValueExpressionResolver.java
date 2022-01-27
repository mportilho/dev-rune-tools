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

package io.github.mportilho.dfr.core.processor;

import io.github.mportilho.dfr.core.processor.expressionresolver.StringValueExpressionResolver;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

public class TestStringValueExpressionResolver {

    @Test
    public void testEmptyResolver() {
        StringValueExpressionResolver resolver;

        resolver = new StringValueExpressionResolver(null);
        Assertions.assertThat(resolver.resolveValue("nothing")).isNull();

        resolver = new StringValueExpressionResolver(Collections.emptyMap(), null);
        Assertions.assertThat(resolver.resolveValue("nothing")).isNull();
    }

    @Test
    public void testMultipleUsages() {
        StringValueExpressionResolver resolver;
        Map<String, String> map = Map.of("a", "1", "b", "2");

        resolver = new StringValueExpressionResolver(map, null);
        Assertions.assertThat(resolver.resolveValue(null)).isNull();
        Assertions.assertThat(resolver.resolveValue("nothing")).isNull();
        Assertions.assertThat(resolver.resolveValue("a")).isEqualTo("1");
        Assertions.assertThat(resolver.resolveValue("b")).isEqualTo("2");
    }

    @Test
    public void testDelegate() {
        StringValueExpressionResolver resolver;
        Map<String, String> normalMap = Map.of("a", "1");
        Map<String, String> delegateMap = Map.of("a", "99", "b", "2");

        resolver = new StringValueExpressionResolver(normalMap, new StringValueExpressionResolver(delegateMap));
        Assertions.assertThat(resolver.resolveValue(null)).isNull();
        Assertions.assertThat(resolver.resolveValue("nothing")).isNull();
        Assertions.assertThat(resolver.resolveValue("a")).isEqualTo("1");
        Assertions.assertThat(resolver.resolveValue("b")).isEqualTo("2");
    }

}
