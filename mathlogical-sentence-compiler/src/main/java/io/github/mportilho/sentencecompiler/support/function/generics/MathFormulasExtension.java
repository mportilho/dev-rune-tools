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

package io.github.mportilho.sentencecompiler.support.function.generics;

import ch.obermuhlner.math.big.BigDecimalMath;
import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaSupplier;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

import static java.math.BigDecimal.*;

public class MathFormulasExtension {

    private static final Map<String, LambdaCallSite> INSTANCE = internalMathFunctionsFactory();

    public static Map<String, LambdaCallSite> mathFunctionsFactory() {
        return INSTANCE;
    }

    public static BigDecimal max(BigDecimal[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) >= 0 ? p[0] : p[1];
        }
        BigDecimal maxOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            BigDecimal param = p[i];
            if (maxOne.compareTo(param) < 0) {
                maxOne = param;
            }
        }
        return maxOne;
    }

    public static BigDecimal min(BigDecimal[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].compareTo(p[1]) <= 0 ? p[0] : p[1];
        }
        BigDecimal minOne = p[0];
        for (int i = 1, parametersLength = p.length; i < parametersLength; i++) {
            BigDecimal parameter = p[i];
            if (minOne.compareTo(parameter) > 0) {
                minOne = parameter;
            }
        }
        return minOne;
    }

    static BigDecimal mean(BigDecimal[] p, MathContext mc) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].add(p[1]).divide(valueOf(2), mc);
        }
        BigDecimal sum = ZERO;
        for (BigDecimal param : p) {
            sum = sum.add(param);
        }
        return sum.divide(BigDecimal.valueOf(p.length), mc);
    }

    static BigDecimal geometricMean(BigDecimal[] p, MathContext mc) {
        BigDecimal x = ONE;
        for (BigDecimal param : p) {
            x = x.multiply(param, mc);
        }
        return BigDecimalMath.root(x, valueOf(p.length), mc);
    }

    static BigDecimal harmonicMean(BigDecimal[] p, MathContext mc) {
        BigDecimal x = ZERO;
        for (BigDecimal param : p) {
            x = x.add(ONE.divide(param, mc), mc);
        }
        return valueOf(p.length).divide(x, mc);
    }

    /**
     * @param p
     * @param type Value 0: Population Standard Deviation; Value 1: Sample Standard Deviation
     * @param mc
     * @return
     */
    static BigDecimal variance(BigDecimal[] p, int type, MathContext mc) {
        BigDecimal mean = mean(p, mc);
        BigDecimal x = ZERO;
        for (BigDecimal param : p) {
            x = x.add(BigDecimalMath.pow(param.subtract(mean, mc), 2, mc), mc);
        }
        return ONE.divide(valueOf(p.length - type), mc).multiply(x, mc);
    }

    static BigDecimal stdDev(BigDecimal[] p, int type, MathContext mc) {
        return BigDecimalMath.sqrt(variance(p, type, mc), mc);
    }

    static BigDecimal meanDev(BigDecimal[] p, MathContext mc) {
        BigDecimal mean = mean(p, mc);
        BigDecimal x = ZERO;
        for (BigDecimal param : p) {
            x = x.add(param.subtract(mean, mc).abs(mc), mc);
        }
        return ONE.divide(valueOf(p.length), mc).multiply(x, mc);
    }


    static BigDecimal rule3d(MathContext mc, BigDecimal origin1, BigDecimal result1, BigDecimal origin2) {
        return origin2.multiply(result1, mc).divide(origin1, mc);
    }

    static BigDecimal rule3i(MathContext mc, BigDecimal origin1, BigDecimal result1, BigDecimal origin2) {
        return origin1.multiply(result1, mc).divide(origin2, mc);
    }

    private static Map<String, LambdaCallSite> internalMathFunctionsFactory() {
        Map<String, LambdaCallSite> extensions;
        LambdaCallSite callSite;
        LambdaSupplier supplier;

        try {
            extensions = LambdaCallSiteFactory.createLambdaCallSites(MathFormulasExtension.class);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while loading math formulas", e);
        }

        supplier = (context, parameters) -> mean((BigDecimal[]) parameters[0], context.mathContext());
        callSite = new LambdaCallSite("avg", MethodType.methodType(BigDecimal.class, BigDecimal[].class), supplier);
        extensions.put(callSite.getKeyName(), callSite);
        callSite = new LambdaCallSite("mean", MethodType.methodType(BigDecimal.class, BigDecimal[].class), supplier);
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("variance", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> variance((BigDecimal[]) parameters[0], 0, context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("sampleVariance", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> variance((BigDecimal[]) parameters[0], 1, context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("stdDev", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> stdDev((BigDecimal[]) parameters[0], 0, context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("sampleStdDev", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> stdDev((BigDecimal[]) parameters[0], 1, context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("meanDev", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> meanDev((BigDecimal[]) parameters[0], context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("geometricMean", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> geometricMean((BigDecimal[]) parameters[0], context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("harmonicMean", MethodType.methodType(BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> harmonicMean((BigDecimal[]) parameters[0], context.mathContext()));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("rule3d", MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> rule3d(context.mathContext(), (BigDecimal) parameters[0], (BigDecimal) parameters[1], (BigDecimal) parameters[2]));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("rule3i", MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> rule3i(context.mathContext(), (BigDecimal) parameters[0], (BigDecimal) parameters[1], (BigDecimal) parameters[2]));
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }


}
