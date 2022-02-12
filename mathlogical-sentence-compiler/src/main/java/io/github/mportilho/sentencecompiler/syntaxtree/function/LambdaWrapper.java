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

package io.github.mportilho.sentencecompiler.syntaxtree.function;

public class LambdaWrapper {

    public interface Function1 {
        Object call(Object p1);
    }

    public interface Function2 {
        Object call(Object p1, Object p2);
    }

    public interface Function3 {
        Object call(Object p1, Object p2, Object p3);
    }

    public interface Function4 {
        Object call(Object p1, Object p2, Object p3, Object p4);
    }

    public interface Function5 {
        Object call(Object p1, Object p2, Object p3, Object p4, Object p5);
    }

    public interface Function6 {
        Object call(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);
    }

    public interface Function7 {
        Object call(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);
    }

    public interface Function8 {
        Object call(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);
    }

    public interface Function9 {
        Object call(Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);
    }

    public interface Function10 {
        Object call(
                Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9,
                Object p10);
    }

    public interface Function11 {
        Object call(
                Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9,
                Object p10, Object p11);
    }

    public static OperationLambdaCaller createLambdaCaller(Object lambda, Object instance, Class<?>[] parameterTypes) {
        if (lambda instanceof LambdaWrapper.Function1 f) {
            return (context, p) -> f.call(instance);
        } else if (lambda instanceof LambdaWrapper.Function2 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null));
        } else if (lambda instanceof LambdaWrapper.Function3 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null));
        } else if (lambda instanceof LambdaWrapper.Function4 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null));
        } else if (lambda instanceof LambdaWrapper.Function5 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null));
        } else if (lambda instanceof LambdaWrapper.Function6 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null));
        } else if (lambda instanceof LambdaWrapper.Function7 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null));
        } else if (lambda instanceof LambdaWrapper.Function8 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null));
        } else if (lambda instanceof LambdaWrapper.Function9 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[6], parameterTypes[7], null));
        } else if (lambda instanceof LambdaWrapper.Function10 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[6], parameterTypes[7], null),
                    context.conversionService().convert(p[6], parameterTypes[8], null));
        } else if (lambda instanceof LambdaWrapper.Function11 f) {
            return (context, p) -> f.call(instance,
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[6], parameterTypes[7], null),
                    context.conversionService().convert(p[6], parameterTypes[8], null),
                    context.conversionService().convert(p[6], parameterTypes[9], null));
        }
        throw new IllegalArgumentException(String.format("Class [%s] not illegible as lambda operationSupplier", lambda.getClass().getName()));
    }

    public static OperationLambdaCaller createStaticLambdaCaller(Object lambda, Class<?>[] parameterTypes) {
        if (lambda instanceof LambdaWrapper.Function1 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null));
        } else if (lambda instanceof LambdaWrapper.Function2 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[0], parameterTypes[1], null));
        } else if (lambda instanceof LambdaWrapper.Function3 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[0], parameterTypes[2], null));
        } else if (lambda instanceof LambdaWrapper.Function4 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[0], parameterTypes[3], null));
        } else if (lambda instanceof LambdaWrapper.Function5 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[0], parameterTypes[4], null));
        } else if (lambda instanceof LambdaWrapper.Function6 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[0], parameterTypes[5], null));
        } else if (lambda instanceof LambdaWrapper.Function7 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[0], parameterTypes[6], null));
        } else if (lambda instanceof LambdaWrapper.Function8 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[0], parameterTypes[7], null));
        } else if (lambda instanceof LambdaWrapper.Function9 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[0], parameterTypes[7], null),
                    context.conversionService().convert(p[0], parameterTypes[8], null));
        } else if (lambda instanceof LambdaWrapper.Function10 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[0], parameterTypes[7], null),
                    context.conversionService().convert(p[0], parameterTypes[8], null),
                    context.conversionService().convert(p[0], parameterTypes[9], null));
        } else if (lambda instanceof LambdaWrapper.Function11 f) {
            return (context, p) -> f.call(
                    context.conversionService().convert(p[0], parameterTypes[0], null),
                    context.conversionService().convert(p[1], parameterTypes[1], null),
                    context.conversionService().convert(p[2], parameterTypes[2], null),
                    context.conversionService().convert(p[3], parameterTypes[3], null),
                    context.conversionService().convert(p[4], parameterTypes[4], null),
                    context.conversionService().convert(p[5], parameterTypes[5], null),
                    context.conversionService().convert(p[6], parameterTypes[6], null),
                    context.conversionService().convert(p[0], parameterTypes[7], null),
                    context.conversionService().convert(p[0], parameterTypes[8], null),
                    context.conversionService().convert(p[0], parameterTypes[9], null),
                    context.conversionService().convert(p[0], parameterTypes[10], null));
        }
        throw new IllegalArgumentException(String.format("Class [%s] not illegible as lambda operationSupplier", lambda.getClass().getName()));
    }

}
