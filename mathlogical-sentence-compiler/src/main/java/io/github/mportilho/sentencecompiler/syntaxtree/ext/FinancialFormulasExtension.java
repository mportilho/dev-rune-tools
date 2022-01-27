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

package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.formulas.ExcelFinancialFunction;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FinancialFormulasExtension {

    private static final Map<String, OperationLambdaCaller> FORMULA_MAP = Collections.unmodifiableMap(internalFinancialFunctionsFactory());

    public static Map<String, OperationLambdaCaller> financialFunctionsFactory() {
        return FORMULA_MAP;
    }

    private static Map<String, OperationLambdaCaller> internalFinancialFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put("eir_3", (context, params) -> ExcelFinancialFunction.eir(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.mathContext()));

        extensions.put("pv_4", (context, params) -> ExcelFinancialFunction.pv(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        extensions.put("r_4", (context, params) -> ExcelFinancialFunction.r(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        extensions.put("nper_4", (context, params) -> ExcelFinancialFunction.nper(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        extensions.put("fv_6", (context, params) -> ExcelFinancialFunction.fv(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.conversionService().convert(params[5], BigDecimal.class),
                context.mathContext()));

        extensions.put("fv_5", (context, params) -> ExcelFinancialFunction.fv(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.mathContext()));

        extensions.put("fv_4", (context, params) -> ExcelFinancialFunction.fv(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        extensions.put("fvs_5", (context, params) -> ExcelFinancialFunction.fvs(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.mathContext()));

        extensions.put("fvs_6", (context, params) -> ExcelFinancialFunction.fvs(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.conversionService().convert(params[5], BigDecimal.class),
                context.mathContext()));

        extensions.put("pmt_5", (context, params) -> ExcelFinancialFunction.pmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.mathContext()));

        extensions.put("pmt_4", (context, params) -> ExcelFinancialFunction.pmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        extensions.put("pmt_3", (context, params) -> ExcelFinancialFunction.pmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.mathContext()));

        extensions.put("ipmt_6", (context, params) -> ExcelFinancialFunction.ipmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.conversionService().convert(params[5], BigDecimal.class),
                context.mathContext()));

        extensions.put("ipmt_5", (context, params) -> ExcelFinancialFunction.ipmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.mathContext()));

        extensions.put("ipmt_4", (context, params) -> ExcelFinancialFunction.ipmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));


        extensions.put("ppmt_6", (context, params) -> ExcelFinancialFunction.ppmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.conversionService().convert(params[5], BigDecimal.class),
                context.mathContext()));

        extensions.put("ppmt_5", (context, params) -> ExcelFinancialFunction.ppmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.conversionService().convert(params[4], BigDecimal.class),
                context.mathContext()));

        extensions.put("ppmt_4", (context, params) -> ExcelFinancialFunction.ppmt(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.conversionService().convert(params[3], BigDecimal.class),
                context.mathContext()));

        return extensions;
    }

}
