package io.github.mportilho.sentencecompiler.sentence.formulas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static io.github.mportilho.sentencecompiler.syntaxtree.formulas.ExcelFinancialFunction.*;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

public class TestExcelFinancialFormulas {

    private static final BigDecimal r = valueOf(0.05);
    private static final int per = 12;
    private static final int nper = 10;
    private static final BigDecimal pv = valueOf(5000);
    private static final BigDecimal fv = valueOf(22000);
    private static final BigDecimal pmt = valueOf(100);
    private static final MathContext mc = MathContext.DECIMAL64;

    @Test
    public void test_pmt() {
        assertThat(pmt(r, nper, pv, fv, 0, mc))
                .isEqualByComparingTo("-2396.623524067332");

        assertThat(pmt(r, nper, pv, fv, mc)).isEqualByComparingTo("-2396.623524067332");
        assertThat(pmt(r, nper, pv, mc)).isEqualByComparingTo("-647.5228748272837");
    }

    @Test
    public void test_ipmt() {
        assertThat(ipmt(r, per, nper, pv, fv, 0, mc)).isEqualByComparingTo("1274.831176203366");
        assertThat(ipmt(r, per, nper, pv, fv, mc)).isEqualByComparingTo("1274.831176203366");
        assertThat(ipmt(r, per, nper, pv, mc)).isEqualByComparingTo("32.37614374136415");
    }

    @Test
    public void test_ppmt() {
        assertThat(ppmt(r, per, nper, pv, fv, 0, mc)).isEqualByComparingTo("-3671.454700270698");
        assertThat(ppmt(r, per, nper, pv, fv, mc)).isEqualByComparingTo("-3671.454700270698");
        assertThat(ppmt(r, per, nper, pv, mc)).isEqualByComparingTo("-679.8990185686478");
    }

    @Test
    public void test_fv() {
        assertThat(fv(r, 1, nper, ZERO, pv, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("-8144.473133887205");

        assertThat(fv(r, 1, nper, pmt, pv, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("-9402.262387442087");

        assertThat(fv(r, per, nper, ZERO, pv, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("-8235.047488451745");

        assertThat(fv(r, per, nper, pmt, pv, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("-23763.27543302012");
    }

    @Test
    public void test_fvs() {
        assertThat(fvs(r, per, nper, pmt, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("15528.22794456837");

        assertThat(fvs(valueOf(0.1), 12, 1, pmt, 4, 0, MathContext.DECIMAL64))
                .isEqualByComparingTo("418.8522697651720");
    }

}
