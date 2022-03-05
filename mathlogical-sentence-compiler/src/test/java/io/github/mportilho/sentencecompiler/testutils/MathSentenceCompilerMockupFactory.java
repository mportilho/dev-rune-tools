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

package io.github.mportilho.sentencecompiler.testutils;

import io.github.mportilho.commons.converters.impl.DefaultFormattedConversionService;
import io.github.mportilho.commons.memoization.MemoizedSupplier;
import io.github.mportilho.sentencecompiler.MathSentenceOptions;
import io.github.mportilho.sentencecompiler.OperationContext;
import io.github.mportilho.sentencecompiler.OperationSupportData;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaContext;

import java.math.MathContext;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class MathSentenceCompilerMockupFactory {

    public static OperationContext getPreciseOperationContext() {
        return new OperationContext(MathContext.DECIMAL64, 8, false, new MemoizedSupplier<>(ZonedDateTime::now),
                new DefaultFormattedConversionService(), new OperationSupportData(),
                new OperationSupportData(), true, ZoneId.systemDefault());
    }

    public static OperationContext getPreciseOperationContext(boolean allowingNull) {
        return new OperationContext(MathContext.DECIMAL64, 8, allowingNull, new MemoizedSupplier<>(ZonedDateTime::now),
                new DefaultFormattedConversionService(), new OperationSupportData(), new OperationSupportData(),
                true, ZoneId.systemDefault());
    }

    public static OperationContext getFastOperationContext() {
        return new OperationContext(MathContext.DECIMAL64, 8, false, new MemoizedSupplier<>(ZonedDateTime::now),
                new DefaultFormattedConversionService(), new OperationSupportData(), new OperationSupportData(),
                false, ZoneId.systemDefault());
    }

    public static LambdaContext getLambdaContext() {
        return new LambdaContext(MathContext.DECIMAL64, null, ZoneOffset.UTC);
    }

    public static MathSentenceOptions getFastMathSentenceOptions() {
        return new MathSentenceOptions(MathContext.DECIMAL64, 8, new DefaultFormattedConversionService(), new OperationSupportData(),
                ZoneId.systemDefault(), false);
    }

    public static OperationContext getFastOperationContext(boolean allowingNull) {
        return new OperationContext(MathContext.DECIMAL64, 8, allowingNull, new MemoizedSupplier<>(ZonedDateTime::now),
                new DefaultFormattedConversionService(), new OperationSupportData(), new OperationSupportData(),
                false, ZoneId.systemDefault());
    }

}
