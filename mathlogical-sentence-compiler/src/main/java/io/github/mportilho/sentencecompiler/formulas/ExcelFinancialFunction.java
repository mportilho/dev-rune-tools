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

package io.github.mportilho.sentencecompiler.formulas;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import static ch.obermuhlner.math.big.BigDecimalMath.log;
import static ch.obermuhlner.math.big.BigDecimalMath.pow;
import static java.math.BigDecimal.*;

/**
 * Emulated financial formulas from Microsoft Excel, using BigDecimal class instead of double
 * <p>
 * Based on Apache Poi implementation (https://github.com/apache/poi), adapted to use BigDecimal with MathContext
 * and adapted formulas to consider different values for number of compounding periods, number of payments and
 * total number of periods
 */
public class ExcelFinancialFunction {

    /**
     * Equivalent Interest Rate => ((1+r/per)^(per*nper)) - 1
     *
     * @param r    Rate value for the period
     * @param per  period (payment number) to check value at. Number of compounding periods
     * @param nper number of total payments / periods
     * @param mc   provided math context
     * @return Equivalient interest rate
     */
    public static BigDecimal eir(BigDecimal r, BigDecimal per, BigDecimal nper, MathContext mc) {
        return pow(ONE.add(r.divide(per, mc), mc), per.multiply(nper, mc), mc).subtract(ONE, mc);
    }

    /**
     * Calculate present value from future one
     *
     * @param r    Periodic interest rate represented as a decimal.
     * @param per  period (payment number) to check value at. Number of compounding periods
     * @param nper number of total payments / periods.
     * @param fv   future value of loan or annuity.
     * @param mc   provided math context
     * @return present value
     */
    public static BigDecimal pv(BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal fv, MathContext mc) {
        return fv.divide(eir(r, per, nper, mc).add(ONE, mc), mc);
    }

    /**
     * @param per  period (payment number) to check value at. Number of compounding periods
     * @param nper number of total payments / periods.
     * @param pv   present value -- borrowed or invested principal.
     * @param fv   future value of loan or annuity.
     * @param mc   provided math context
     * @return interest rate
     */
    public static BigDecimal r(BigDecimal per, BigDecimal nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return per.multiply(pow(fv.divide(pv, mc), ONE.divide(per.multiply(nper, mc), mc), mc).subtract(ONE, mc));
    }

    /**
     * Find invest time number
     *
     * @param r   periodic interest rate represented as a decimal.
     * @param per period (payment number) to check value at. Number of compounding periods
     * @param pv  present value -- borrowed or invested principal.
     * @param fv  future value of loan or annuity.
     * @param mc  provided math context
     * @return number of total periods.
     */
    // ln(A/P) / n[ln(1 + r/n)]
    public static BigDecimal nper(BigDecimal r, BigDecimal per, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return log(fv.divide(pv, mc), mc).divide(per.multiply(log(ONE.add(r.divide(per, mc), mc), mc), mc), mc);
    }

    public static BigDecimal fv(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pmt, BigDecimal pv, BigDecimal type,
            MathContext mc) {
        BigDecimal fv = pv.multiply(eir(r, per, nper, mc).add(ONE, mc), mc);
        return fv.add(fvs(r, per, nper, pmt, type, mc), mc).negate(mc);
    }

    /**
     * Emulates Excel/Calc's FV(interest_rate, number_payments, payment, PV,
     * Type) function, which calculates future value or principal at period N.
     *
     * @param r    periodic interest rate represented as a decimal.
     * @param nper number of total payments / periods.
     * @param pmt  periodic payment amount.
     * @param pv   present value -- borrowed or invested principal.
     * @param type when payment is made: beginning of period is 1; end, 0.
     * @param mc   provided math context
     * @return <code>double</code> representing future principal value.
     */
    //http://en.wikipedia.org/wiki/Future_value
    public static BigDecimal fv(
            BigDecimal r, BigDecimal nper, BigDecimal pmt, BigDecimal pv, BigDecimal type, MathContext mc) {
        return fv(r, ONE, nper, pmt, pv, type, mc);
    }

    /**
     * Overloaded fv() call omitting type, which defaults to 0.
     */
    public static BigDecimal fv(BigDecimal r, BigDecimal nper, BigDecimal pmt, BigDecimal pv, MathContext mc) {
        return fv(r, nper, pmt, pv, ZERO, mc);
    }

    /**
     * Future value of a series
     *
     * @param r    periodic interest rate represented as a decimal.
     * @param per  period (payment number) to check value at. Number of compounding periods
     * @param nper number of total payments / periods.
     * @param pmt  periodic payment amount.
     * @param type when payment is made: beginning of period is 1; end, 0.
     * @param mc   provided math context
     * @return Future value of investment
     */
    //https://www.thecalculatorsite.com/articles/finance/compound-interest-formula.php
    public static BigDecimal fvs(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pmt, BigDecimal type, MathContext mc) {
        return fvs(r, per, nper, pmt, per, type, mc);
    }

    /**
     * Different periodic payments and compounding
     * <p>
     * An amount of $100 is deposited quarterly into a savings account at an annual interest rate of 10%,
     * compounded monthly. The value of the investment after 12 months can be calculated as follows...
     *
     * @param r    periodic interest rate represented as a decimal.
     * @param per  period (payment number) to check value at. Number of compounding periods
     * @param nper number of total payments / periods.
     * @param pmt  periodic payment amount.
     * @param pper number of period payment in the compounding period
     * @param type when payment is made: beginning of period is 1; end, 0.
     * @param mc   provided math context
     * @return Future value of investment
     */
    public static BigDecimal fvs(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pmt, BigDecimal pper, BigDecimal type,
            MathContext mc) {
        // p = number of periodic payments in the compounding period, divided by [per]
        BigDecimal p = per.compareTo(pper) == 0 ? ONE : pper.divide(per, mc);
        BigDecimal ratePerPeriod = r.divide(per, mc);
        BigDecimal equivRateOfPeriod = eir(r, per, nper, mc);
        return pmt.multiply(p, mc).multiply(equivRateOfPeriod.divide(ratePerPeriod, mc)
                .multiply(ONE.add(r.multiply(type, mc).divide(per, mc), mc)), mc);
    }

    /**
     * Net Present Value
     *
     * @param r    internal rate of return
     * @param pv   Total initial investment costs
     * @param pmts cash flow
     * @param mc   provided math context
     * @return Net present values
     */
    public static BigDecimal npv(BigDecimal r, BigDecimal pv, List<BigDecimal> pmts, MathContext mc) {
        BigDecimal sum = ZERO;
        for (int i = 0, pmtsSize = pmts.size(); i < pmtsSize; i++) {
            sum = sum.add(pmts.get(i).divide(pow(ONE.add(r, mc), valueOf(i + 1), mc), mc), mc);
        }
        return sum.subtract(pv, mc);
    }

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
    public static BigDecimal pmt(
            BigDecimal r, BigDecimal nper, BigDecimal pv, BigDecimal fv, BigDecimal type, MathContext mc) {
        BigDecimal equivInterestRate = eir(r, ONE, nper, mc);
        BigDecimal totalFv = pv.multiply(equivInterestRate.add(ONE, mc), mc).add(fv, mc);
        BigDecimal pmtAtBeginning = ONE.add(r.multiply(type, mc), mc).multiply(equivInterestRate, mc);
        return r.negate(mc).multiply(totalFv, mc).divide(pmtAtBeginning, mc);
    }

    /**
     * Overloaded pmt() call omitting type, which defaults to 0.
     */
    public static BigDecimal pmt(BigDecimal r, BigDecimal nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, ZERO, mc);
    }

    /**
     * Overloaded pmt() call omitting fv and type, which both default to 0.
     */
    public static BigDecimal pmt(BigDecimal r, BigDecimal nper, BigDecimal pv, MathContext mc) {
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
     * @return interest portion of payment.
     */
    // http://doc.optadata.com/en/dokumentation/application/expression/functions/financial.html
    public static BigDecimal ipmt(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, BigDecimal fv, BigDecimal type,
            MathContext mc) {
        BigDecimal ipmt = fv(r, per.subtract(ONE, mc), pmt(r, nper, pv, fv, type, mc), pv, type, mc).multiply(r, mc);
        if (ONE.compareTo(type) == 0) {
            ipmt = ipmt.divide(ONE.add(r, mc), mc);
        }
        return ipmt;
    }

    public static BigDecimal ipmt(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return ipmt(r, per, nper, pv, fv, ZERO, mc);
    }

    public static BigDecimal ipmt(BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, MathContext mc) {
        return ipmt(r, per, nper, pv, ZERO, mc);
    }

    /**
     * Emulates Excel/Calc's PPMT(interest_rate, period, number_payments, PV,
     * FV, Type) function, which calculates the portion of the payment at a
     * given period that will call to principal.
     *
     * @param r    periodic interest rate represented as a decimal.
     * @param per  period (payment number) to check value at (capitalização).
     * @param nper number of total payments / periods.
     * @param pv   present value -- borrowed or invested principal.
     * @param fv   future value of loan or annuity.
     * @param type when payment is made: beginning of period is 1; end, 0.
     * @return principal portion of payment.
     */
    public static BigDecimal ppmt(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, BigDecimal fv, BigDecimal type,
            MathContext mc) {
        return pmt(r, nper, pv, fv, type, mc).subtract(ipmt(r, per, nper, pv, fv, type, mc), mc);
    }

    public static BigDecimal ppmt(
            BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, BigDecimal fv, MathContext mc) {
        return pmt(r, nper, pv, fv, mc).subtract(ipmt(r, per, nper, pv, fv, mc), mc);
    }

    public static BigDecimal ppmt(BigDecimal r, BigDecimal per, BigDecimal nper, BigDecimal pv, MathContext mc) {
        return pmt(r, nper, pv, mc).subtract(ipmt(r, per, nper, pv, mc), mc);
    }


}
