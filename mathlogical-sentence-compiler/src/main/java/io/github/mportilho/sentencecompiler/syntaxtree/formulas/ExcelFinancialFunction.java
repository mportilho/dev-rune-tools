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
    static public double pmt(double r, int nper, double pv, double fv, int type) {
        return -r * (pv * Math.pow(1 + r, nper) + fv) / ((1 + r * type) * (Math.pow(1 + r, nper) - 1));
    }

    public static BigDecimal pmt(BigDecimal r, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        // pv * Math.pow(1 + r, nper) + fv
        BigDecimal amount = pv.multiply(pow(ONE.add(r, mc), valueOf(nper), mc), mc).add(fv, mc);

        // ((1 + r * type) * (Math.pow(1 + r, nper) - 1))
        BigDecimal f1 = ONE.add(r.multiply(valueOf(type), mc), mc)
                .multiply(pow(ONE.add(r, mc), valueOf(nper), mc).subtract(ONE, mc), mc);

        // -r * amount / f1
        return r.negate(mc).multiply(amount, mc).divide(f1, mc);
    }

    /**
     * Overloaded pmt() call omitting type, which defaults to 0.
     *
     * @see #pmt(double, int, double, double, int)
     */
    static public double pmt(double r, int nper, double pv, double fv) {
        return pmt(r, nper, pv, fv, 0);
    }

    public static BigDecimal pmt(BigDecimal r, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, 0, mc);
    }

    /**
     * Overloaded pmt() call omitting fv and type, which both default to 0.
     *
     * @see #pmt(double, int, double, double, int)
     */
    static public double pmt(double r, int nper, double pv) {
        return pmt(r, nper, pv, 0);
    }

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
     * @see #pmt(double, int, double, double, int)
     * @see #fv(double, int, double, double, int)
     */
    // http://doc.optadata.com/en/dokumentation/application/expression/functions/financial.html
    static public double ipmt(double r, int per, int nper, double pv, double fv, int type) {
        double ipmt = fv(r, per - 1, pmt(r, nper, pv, fv, type), pv, type) * r;
        if (type == 1) ipmt /= (1 + r);
        return ipmt;
    }

    public static BigDecimal ipmt(
            BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        BigDecimal ipmt = fv(r, per - 1, pmt(r, nper, pv, fv, type, mc), pv, type, mc).multiply(r, mc);
        if (type == 1) {
            ipmt = ipmt.divide(ONE.add(r, mc), mc);
        }
        return ipmt;
    }

    static public double ipmt(double r, int per, int nper, double pv, double fv) {
        return ipmt(r, per, nper, pv, fv, 0);
    }

    public static BigDecimal ipmt(BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return ipmt(r, per, nper, pv, fv, 0, mc);
    }

    static public double ipmt(double r, int per, int nper, double pv) {
        return ipmt(r, per, nper, pv, 0);
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
     * @param per  - period (payment number) to check value at.
     * @param nper - number of total payments / periods.
     * @param pv   - present value -- borrowed or invested principal.
     * @param fv   - future value of loan or annuity.
     * @param type - when payment is made: beginning of period is 1; end, 0.
     * @return <code>double</code> representing principal portion of payment.
     * @see #pmt(double, int, double, double, int)
     * @see #ipmt(double, int, int, double, double, int)
     */
    static public double ppmt(double r, int per, int nper, double pv, double fv, int type) {
        return pmt(r, nper, pv, fv, type) - ipmt(r, per, nper, pv, fv, type);
    }

    public static BigDecimal ppmt(
            BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, int type, MathContext mc) {
        return pmt(r, nper, pv, fv, type, mc).subtract(ipmt(r, per, nper, pv, fv, type, mc), mc);
    }

    static public double ppmt(double r, int per, int nper, double pv, double fv) {
        return pmt(r, nper, pv, fv) - ipmt(r, per, nper, pv, fv);
    }

    public static BigDecimal ppmt(BigDecimal r, int per, int nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, mc).subtract(ipmt(r, per, nper, pv, fv, mc), mc);
    }

    static public double ppmt(double r, int per, int nper, double pv) {
        return pmt(r, nper, pv) - ipmt(r, per, nper, pv);
    }

    public static BigDecimal ppmt(BigDecimal r, int per, int nper, BigDecimal pv, MathContext mc) {
        return pmt(r, nper, pv, mc).subtract(ipmt(r, per, nper, pv, mc), mc);
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
    public static double fv(double r, int nper, double pmt, double pv, int type) {
        return -(pv * Math.pow(1 + r, nper) + pmt * (1 + r * type) * (Math.pow(1 + r, nper) - 1) / r);
    }

    public static BigDecimal fv(BigDecimal r, int nper, BigDecimal pmt, BigDecimal pv, int type, MathContext mc) {
        BigDecimal amount = pv.multiply(pow(ONE.add(r, mc), valueOf(nper), mc), mc); // pv * Math.pow(1 + r, nper)
        BigDecimal payment = pmt.multiply(ONE.add(r.multiply(valueOf(type), mc), mc), mc) //pmt * (1 + r * type)
                .multiply(pow(ONE.add(r, mc), valueOf(nper), mc).subtract(ONE, mc), mc) // * (Math.pow(1 + r, nper) - 1)
                .divide(r, mc); // / r
        return amount.add(payment, mc).negate(mc);
    }

    /**
     * Overloaded fv() call omitting type, which defaults to 0.
     *
     * @see #fv(double, int, double, double, int)
     */
    public static double fv(double r, int nper, double c, double pv) {
        return fv(r, nper, c, pv, 0);
    }

    public static BigDecimal fv(BigDecimal r, int nper, BigDecimal c, BigDecimal pv, MathContext mc) {
        return fv(r, nper, c, pv, 0, mc);
    }

}
