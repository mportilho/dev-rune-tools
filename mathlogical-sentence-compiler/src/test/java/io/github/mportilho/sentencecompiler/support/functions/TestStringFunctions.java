package io.github.mportilho.sentencecompiler.support.functions;

import io.github.mportilho.sentencecompiler.support.function.generics.StringFunctionExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class TestStringFunctions {
    @Test
    public void testConcatStringFunction() {
        String[] str = {"a", "mo"};
        Assertions.assertThat(StringFunctionExtension.concat(str)).isEqualTo("amo");
    }

    @Test
    public void testConcaStringFunction2() {
        String[] strAll = {"Re", "mo", "ca", "da"};
        Assertions.assertThat(StringFunctionExtension.concat(strAll)).isEqualTo("Remocada");
    }

    @Test
    public void testJoinStringFunction() {
        String[] str = {"bem", "vindo"};
        String a = "-";
        Assertions.assertThat(StringFunctionExtension.join(a, str)).isEqualTo("bem-vindo");
    }

    @Test
    public void testJoinStringFunction2() {
        String[] joinS = {"me", "wonderguy"};
        String r = "=";
        Assertions.assertThat(StringFunctionExtension.join(r, joinS)).isEqualTo("me=wonderguy");
    }

    @Test
    public void testTrimFunction(){
        String best = "   as you long   ";
        Assertions.assertThat(StringFunctionExtension.trim(best)).isEqualTo("as you long");
    }

    @Test
    public void testTrimFunction2(){
        String are = "                                               wuia ";
        Assertions.assertThat(StringFunctionExtension.trim(are)).isEqualTo("wuia");
    }

    @Test
    public void testStringLenght(){
        String p = "paralelepipedo";
        Assertions.assertThat(StringFunctionExtension.stringLength(p)).isEqualTo(14);
    }

    @Test
    public void testStringLenght2(){
        String a = "pneumoultramicroscopicossilicovulcanoconiótico";
        Assertions.assertThat(StringFunctionExtension.stringLength(a)).isEqualTo(46);
    }
}
