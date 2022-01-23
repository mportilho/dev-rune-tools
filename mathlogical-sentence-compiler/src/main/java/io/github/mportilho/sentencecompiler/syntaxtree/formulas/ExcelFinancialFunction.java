package io.github.mportilho.sentencecompiler.syntaxtree.formulas;

import java.math.BigDecimal;
import java.math.MathContext;

import static ch.obermuhlner.math.big.BigDecimalMath.pow;
import static java.math.BigDecimal.*;

/**
 * Emulated financial formulas from Microsoft Excel, using BigDecimal class instead of double
 * <p>
 * Based on Apache Poi implementation: https://github.com/apache/poi
 */
public class ExcelFinancialFunction {

    /**
     * Emulates Excel/Calc's PMT(interest_rate, number_payments, PV, FV, Type)
     * function, which calculates the payments for a loan or the future value of an investment
     *
     * @param r    - periodic interest rate represented as a decimal.
     * @param nper - number of total payments / periods.
     * @param pv   - present value -- borrowed or invested principal.
     * @param fv   - future value of loan or annuity.
     * @param type - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing periodic payment amount.
     */
    // http://arachnoid.com/lutusp/finance.html
    public static BigDecimal pmt(BigDecimal r, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        BigDecimal amount = pv.multiply(pow(ONE.add(r, mc), valueOf(nper), mc), mc).add(fv, mc);
        BigDecimal f1 = ONE.add(r.multiply(valueOf(type), mc), mc)
                .multiply(pow(ONE.add(r, mc), valueOf(nper), mc).subtract(ONE, mc), mc);
        return r.negate(mc).multiply(amount, mc).divide(f1, mc);
    }

    /**
     * Overloaded pmt() call omitting type, which defaults to 0.
     */
    public static BigDecimal pmt(BigDecimal r, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, 0, mc);
    }

    /**
     * Overloaded pmt() call omitting fv and type, which both default to 0.
     */
    public static BigDecimal pmt(BigDecimal r, int nper, BigDecimal pv, MathContext mc) {
        return pmt(r, nper, pv, ZERO, mc);
    }

    /**
     * Emulates Excel/Calc's IPMT(interest_rate, period, number_payments, PV,
     * FV, Type) function, which calculates the portion of the payment at a
     * given period that is the interest on previous balance.
     *
     * @param r    - periodic interest rate represented as a decimal.
     * @param per  - period (payment number) to check value at.
     * @param nper - number of total payments / periods.
     * @param pv   - present value -- borrowed or invested principal.
     * @param fv   - future value of loan or annuity.
     * @param type - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing interest portion of payment.
     */
    // http://doc.optadata.com/en/dokumentation/application/expression/functions/financial.html
    public static BigDecimal ipmt(
            BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        BigDecimal ipmt = fv(r, per - 1, pmt(r, nper, pv, fv, type, mc), pv, type, mc).multiply(r, mc);
        if (type == 1) {
            ipmt = ipmt.divide(ONE.add(r, mc), mc);
        }
        return ipmt;
    }

    public static BigDecimal ipmt(BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return ipmt(r, per, nper, pv, fv, 0, mc);
    }

    public static BigDecimal ipmt(BigDecimal r, int per, int nper, BigDecimal pv, MathContext mc) {
        return ipmt(r, per, nper, pv, ZERO, mc);
    }

    /**
     * Emulates Excel/Calc's PPMT(interest_rate, period, number_payments, PV,
     * FV, Type) function, which calculates the portion of the payment at a
     * given period that will apply to principal.
     *
     * @param r    - periodic interest rate represented as a decimal.
     * @param per  - period (payment number) to check value at (capitalização).
     * @param nper - number of total payments / periods.
     * @param pv   - present value -- borrowed or invested principal.
     * @param fv   - future value of loan or annuity.
     * @param type - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing principal portion of payment.
     */
    public static BigDecimal ppmt(
            BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        return pmt(r, nper, pv, fv, type, mc).subtract(ipmt(r, per, nper, pv, fv, type, mc), mc);
    }

    public static BigDecimal ppmt(BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, mc).subtract(ipmt(r, per, nper, pv, fv, mc), mc);
    }

    public static BigDecimal ppmt(BigDecimal r, int per, int nper, BigDecimal pv, MathContext mc) {
        return pmt(r, nper, pv, mc).subtract(ipmt(r, per, nper, pv, mc), mc);
    }

    public static BigDecimal fv(
            BigDecimal r, int per, int nper, BigDecimal pmt, BigDecimal pv, int type, MathContext mc) {
        BigDecimal ratePerPeriod = pow(ONE.add(r.divide(valueOf(per), mc), mc), valueOf((long) per * nper), mc);
        BigDecimal p1 = pv.multiply(ratePerPeriod, mc);
        return p1.add(fvs(r, per, nper, pmt, type, mc), mc).negate(mc);
    }

    /**
     * Emulates Excel/Calc's FV(interest_rate, number_payments, payment, PV,
     * Type) function, which calculates future value or principal at period N.
     *
     * @param r    - periodic interest rate represented as a decimal.
     * @param nper - number of total payments / periods.
     * @param pmt  - periodic payment amount.
     * @param pv   - present value -- borrowed or invested principal.
     * @param type - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing future principal value.
     */
    //http://en.wikipedia.org/wiki/Future_value
    public static BigDecimal fv(BigDecimal r, int nper, BigDecimal pmt, BigDecimal pv, int type, MathContext mc) {
        return fv(r, 1, nper, pmt, pv, type, mc);
    }

    /**
     * Overloaded fv() call omitting type, which defaults to 0.
     */
    public static BigDecimal fv(BigDecimal r, int nper, BigDecimal pmt, BigDecimal pv, MathContext mc) {
        return fv(r, nper, pmt, pv, 0, mc);
    }

    /**
     * Future value of a series
     *
     * @param r
     * @param per
     * @param nper
     * @param pmt
     * @param type
     * @param mc
     * @return
     */
    //https://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php
    public static BigDecimal fvs(
            BigDecimal r, int per, int nper, BigDecimal pmt, int type, MathContext mc) {
        return fvs(r, per, nper, pmt, per, type, mc);
    }

    /**
     * Different periodic payments and compounding
     * <p>
     * An amount of $100 is deposited quarterly into a savings account at an annual interest rate of 10%,
     * compounded monthly. The value of the investment after 12 months can be calculated as follows...
     *
     * @param r
     * @param per
     * @param nper
     * @param pmt
     * @param pper number of period payment in the compounding period
     * @param type
     * @param mc
     * @return
     */
    public static BigDecimal fvs(
            BigDecimal r, int per, int nper, BigDecimal pmt, int pper, int type, MathContext mc) {
        // p = number of periodic payments in the compounding period, divided by [per]
        BigDecimal p = per == pper ? ONE : valueOf(pper).divide(valueOf(per), mc);
        BigDecimal ratePerPeriod = pow(ONE.add(r.divide(valueOf(per), mc), mc), valueOf((long) per * nper), mc);
        return pmt.multiply(p, mc).multiply(ratePerPeriod.subtract(ONE, mc).divide(r.divide(valueOf(per), mc), mc)
                .multiply(ONE.add(r.multiply(valueOf(type), mc).divide(valueOf(per), mc), mc)), mc);
    }

}
