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

import io.github.mportilho.sentencecompiler.support.function.financial.ExcelFinancialFunction;
import io.github.mportilho.sentencecompiler.support.function.xirr.Transaction;
import io.github.mportilho.sentencecompiler.support.function.xirr.Xirr;
import io.github.mportilho.sentencecompiler.support.lambdacallsite.LambdaCallSite;

import java.lang.invoke.MethodType;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FinancialFormulasExtension {

    private FinancialFormulasExtension() {
    }

    private static Map<String, LambdaCallSite> formulaMap = Collections.unmodifiableMap(internalFinancialFunctionsFactory());

    public static Map<String, LambdaCallSite> financialFunctionsFactory() {
        if (formulaMap == null) {
            formulaMap = Collections.unmodifiableMap(internalFinancialFunctionsFactory());
        }
        return formulaMap;
    }

    private static Map<String, LambdaCallSite> internalFinancialFunctionsFactory() {
        LambdaCallSite callSite;
        Map<String, LambdaCallSite> extensions = new HashMap<>();

        callSite = new LambdaCallSite("eir",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.eir(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("r",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.r(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pv",
                MethodType.methodType(BigDecimal.class,
                        BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        (BigDecimal) parameters[5],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pv",
                MethodType.methodType(BigDecimal.class,
                        BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pv",
                MethodType.methodType(BigDecimal.class,
                        BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("r",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.r(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("nper",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.nper(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("fv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.fv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        (BigDecimal) parameters[5],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("fv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.fv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("fv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.fv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("fvs",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.fvs(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("fvs",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.fvs(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        (BigDecimal) parameters[5],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("pmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.pmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ipmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ipmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        (BigDecimal) parameters[5],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ipmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ipmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ipmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ipmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ppmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ppmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        (BigDecimal) parameters[5],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ppmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ppmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        (BigDecimal) parameters[4],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("ppmt",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.ppmt(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        (BigDecimal) parameters[3],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("npv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal[].class),
                (context, parameters) -> ExcelFinancialFunction.npv(
                        (BigDecimal) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal[]) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("xnpv",
                MethodType.methodType(BigDecimal.class, BigDecimal.class, BigDecimal[].class, ZonedDateTime[].class),
                (context, parameters) -> ExcelFinancialFunction.xnpv(
                        (BigDecimal) parameters[0],
                        (BigDecimal[]) parameters[1],
                        (ZonedDateTime[]) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("irr",
                MethodType.methodType(BigDecimal.class, BigDecimal[].class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.irr(
                        (BigDecimal[]) parameters[0],
                        (BigDecimal) parameters[1],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("mirr",
                MethodType.methodType(BigDecimal.class, BigDecimal[].class, BigDecimal.class, BigDecimal.class),
                (context, parameters) -> ExcelFinancialFunction.mirr(
                        (BigDecimal[]) parameters[0],
                        (BigDecimal) parameters[1],
                        (BigDecimal) parameters[2],
                        context.mathContext()
                ));
        extensions.put(callSite.getKeyName(), callSite);

        callSite = new LambdaCallSite("xirr",
                MethodType.methodType(BigDecimal.class, BigDecimal[].class, ZonedDateTime[].class, BigDecimal.class),
                (context, parameters) -> {
                    BigDecimal[] values = (BigDecimal[]) parameters[0];
                    ZonedDateTime[] dates = (ZonedDateTime[]) parameters[1];
                    Transaction[] transactions = new Transaction[values.length];
                    for (int i = 0; i < transactions.length; i++) {
                        transactions[i] = new Transaction(values[i].doubleValue(), dates[i].toInstant());
                    }
                    return Xirr.builder().withTransactions(transactions)
                            .withGuess(((BigDecimal) parameters[2]).doubleValue()).xirr();
                });
        extensions.put(callSite.getKeyName(), callSite);

        return extensions;
    }

}
