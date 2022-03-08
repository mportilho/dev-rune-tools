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

package io.github.mportilho.sentencecompiler.support.lambdacallsite.ext;

import io.github.mportilho.sentencecompiler.exceptions.SentenceConfigurationException;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSiteFactory;

import java.math.BigDecimal;
import java.util.Map;

import static java.math.BigDecimal.valueOf;
import static java.math.MathContext.DECIMAL64;

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

    public static BigDecimal avg(BigDecimal[] p) {
        if (p.length == 1) {
            return p[0];
        } else if (p.length == 2) {
            return p[0].add(p[1]).divide(valueOf(2), DECIMAL64);
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal param : p) {
            sum = sum.add(param);
        }
        return sum.divide(BigDecimal.valueOf(p.length), DECIMAL64);
    }

    public static BigDecimal rule3d(BigDecimal origin1, BigDecimal result1, BigDecimal origin2) {
        return origin2.multiply(result1, DECIMAL64).divide(origin1, DECIMAL64);
    }

    public static BigDecimal rule3i(BigDecimal origin1, BigDecimal result1, BigDecimal origin2) {
        return origin1.multiply(result1, DECIMAL64).divide(origin2, DECIMAL64);
    }

    private static Map<String, LambdaCallSite> internalMathFunctionsFactory() {
        try {
            //TODO implementar função para o [valor médio - median]
            return LambdaCallSiteFactory.createLambdaCallSites(MathFormulasExtension.class);
        } catch (Throwable e) {
            throw new SentenceConfigurationException("Error while loading math formulas", e);
        }
    }


}
