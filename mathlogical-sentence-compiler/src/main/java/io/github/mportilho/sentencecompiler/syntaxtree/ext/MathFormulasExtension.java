package io.github.mportilho.sentencecompiler.syntaxtree.ext;

import io.github.mportilho.sentencecompiler.formulas.ExcelFinancialFunction;
import io.github.mportilho.sentencecompiler.syntaxtree.function.OperationLambdaCaller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MathFormulasExtension {


    private static Map<String, OperationLambdaCaller> internalMathFunctionsFactory() {
        Map<String, OperationLambdaCaller> extensions = new HashMap<>();

        extensions.put("eir_3", (context, params) -> ExcelFinancialFunction.eir(
                context.conversionService().convert(params[0], BigDecimal.class),
                context.conversionService().convert(params[1], BigDecimal.class),
                context.conversionService().convert(params[2], BigDecimal.class),
                context.mathContext()));

//          | 'max' LPAREN mathExpression (COMMA mathExpression)* RPAREN # maxOfExpression
//                | 'min' LPAREN mathExpression COMMA mathExpression (COMMA mathExpression)* RPAREN # minOfExpression
//                | 'avg' LPAREN mathExpression (COMMA mathExpression)* RPAREN # averageOfExpression
//                | 'median' LPAREN mathExpression COMMA mathExpression (COMMA mathExpression)* RPAREN # medianOfExpression
//                | 'rule3' LPAREN mathExpression COMMA mathExpression COMMA mathExpression RPAREN # ruleThreeOfExpression
//        ;

        // string: trim(string), contat('', '', ''), daysBetween

        return extensions;
    }


}
