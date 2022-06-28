package io.github.mportilho.sentencecompiler.support.function.financial;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.HALF_EVEN;

public class FinancialFunction {

    private static BigDecimal toDecimal(BigDecimal v) {
        return v.multiply(new BigDecimal("0.01"), DECIMAL64);
    }

    public static BigDecimal peir(BigDecimal r, long sourcePeriod, long targetPeriod) {
        return ExcelFinancialFunction.peir(r, valueOf(targetPeriod), valueOf(sourcePeriod), DECIMAL64);
    }

    public static BigDecimal lpeir(BigDecimal r, long sourcePeriod, long targetPeriod) {
        return ExcelFinancialFunction.lpeir(r, valueOf(targetPeriod), valueOf(sourcePeriod), DECIMAL64);
    }

    /**
     * @param r    periodic interest r represented as a decimal.
     * @param nper number of total payments / periods.
     * @param pv   present value -- borrowed or invested principal.
     * @return payment for a loan
     */
    public static BigDecimal pmt(BigDecimal r, long nper, BigDecimal pv) {
        return ExcelFinancialFunction.pmt(r, valueOf(nper), pv, DECIMAL64).setScale(2, HALF_EVEN).abs();
    }

    public static BigDecimal ppmt(BigDecimal r, long nper, BigDecimal pv) {
        return ExcelFinancialFunction.ppmt(r, ONE, valueOf(nper), pv, DECIMAL64).setScale(2, HALF_EVEN).abs();
    }

    public static BigDecimal ppmt(BigDecimal r, BigDecimal nper, BigDecimal pv) {
        return ExcelFinancialFunction.ppmt(r, ONE, nper, pv, DECIMAL64).setScale(2, HALF_EVEN).abs();
    }

    public static BigDecimal ipmt(BigDecimal r, long nper, BigDecimal pv) {
        return ExcelFinancialFunction.ipmt(r, ONE, valueOf(nper), pv, ZERO, DECIMAL64).setScale(2, HALF_EVEN).abs();
    }

    public static BigDecimal ipmt(BigDecimal r, BigDecimal nper, BigDecimal pv) {
        return ExcelFinancialFunction.ipmt(r, ONE, nper, pv, ZERO, DECIMAL64).setScale(2, HALF_EVEN).abs();
    }

    /**
     * @param r    periodic interest r represented as a decimal.
     * @param nper number of total payments / periods.
     * @param pv   present value -- borrowed or invested principal.
     * @return payment for a loan
     */
    public static BigDecimal fv(BigDecimal r, long nper, BigDecimal pv) {
        return ExcelFinancialFunction.fv(r, valueOf(nper), ZERO, pv, DECIMAL64).abs();
    }

}
