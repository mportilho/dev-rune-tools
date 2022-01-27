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

package io.github.mportilho.dfr.core.operation;

import io.github.mportilho.dfr.core.operation.type.Between;
import io.github.mportilho.dfr.core.operation.type.Equals;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TestFilterData {

    private List<Object[]> wrap(Object[] arr) {
        return List.<Object[]>of(arr);
    }

    @Test
    public void test_NoValueDataFilter() {
        FilterData fdNoValues = new FilterData("ap", "p", new String[]{"p1", "p2"}, null,
                Equals.class, false, false, List.of(), null, null);

        assertThat(fdNoValues.values()).isEmpty();
        assertThat(fdNoValues.findOneValue()).isNull();
        assertThat(fdNoValues.findModifier("teste")).isNull();
        assertThat(fdNoValues.findOneValueOnIndex(0)).isNull();

        assertThat(fdNoValues.findOneValueOnIndex(1)).isNull();
    }

    @Test
    public void test_SingleValueDataFilter() {
        FilterData fdSingleValue = new FilterData("ap", "p", new String[]{"p1", "p2"}, null,
                Equals.class, false, false, wrap(new Integer[]{1}), null, Map.of("JoinType", "INNER"));

        assertThat(fdSingleValue.values()).isNotEmpty().containsExactly(new Integer[]{1});
        assertThat(fdSingleValue.findOneValue()).isNotNull().isEqualTo(1);
        assertThat(fdSingleValue.findModifier("teste")).isNull();
        assertThat(fdSingleValue.findModifier("JoinType")).isEqualTo("INNER");
    }

    @Test
    public void test_MultiValueDataFilter() {
        FilterData fdMultipleValues = new FilterData("ap", "p", new String[]{"p1", "p2"}, null,
                Equals.class, false, false, wrap(new Integer[]{1, 2, 3}), null,
                Map.of("a", "1", "b", "2"));

        assertThat(fdMultipleValues.values()).isNotEmpty().contains(new Integer[]{1, 2, 3});
        assertThatThrownBy(fdMultipleValues::findOneValue).isInstanceOf(IllegalStateException.class)
                .hasMessage("Multiple values found while fetching a single one for path [p]");
        assertThat(fdMultipleValues.findModifier("teste")).isNull();
        assertThat(fdMultipleValues.findModifier("a")).isEqualTo("1");
        assertThat(fdMultipleValues.findModifier("b")).isEqualTo("2");
    }

    @Test
    public void test_DataFilter_ForBetweenOperation() {
        FilterData fdValuesOnBetweenOps = new FilterData("", "p",
                new String[]{"date1", "date2"}, null,
                Between.class, false, false, List.of
                (
                        new Object[]{LocalDate.of(2000, 1, 1)},
                        new Object[]{LocalDate.of(2020, 12, 31)}
                ),
                null, Map.of());

        assertThat(fdValuesOnBetweenOps.values()).isNotEmpty().contains(
                new Object[]{LocalDate.of(2000, 1, 1)},
                new Object[]{LocalDate.of(2020, 12, 31)});
        assertThat(fdValuesOnBetweenOps.findOneValueOnIndex(0)).isEqualTo(LocalDate.of(2000, 1, 1));
        assertThat(fdValuesOnBetweenOps.findOneValueOnIndex(1)).isEqualTo(LocalDate.of(2020, 12, 31));
        assertThatThrownBy(fdValuesOnBetweenOps::findOneValue).isInstanceOf(IllegalStateException.class)
                .hasMessage("Multiple values found while fetching a single one for path [p]");
        assertThat(fdValuesOnBetweenOps.findModifier("teste")).isNull();
    }

    @Test
    public void test_MultiDimensional_DataFilter() {
        FilterData fdMultiDataArray = new FilterData("", "p",
                new String[]{"date1", "date2"}, null,
                Between.class, false, false, List.of
                (
                        new Object[]{new Integer[]{1, 2, 3}},
                        new Object[]{new Integer[]{5, 6, 7}},
                        new Object[]{new Object[]{new Integer[]{1, 3, 5}}, new Object[]{7, 11, 13}}
                ),
                null, Map.of());

        assertThat(fdMultiDataArray.values()).isNotEmpty().contains(new Object[]{new Integer[]{1, 2, 3}},
                new Object[]{new Integer[]{5, 6, 7}});
        assertThat(fdMultiDataArray.findOneValueOnIndex(0)).isEqualTo(new Object[]{1, 2, 3});
        assertThat(fdMultiDataArray.findOneValueOnIndex(1)).isEqualTo(new Object[]{5, 6, 7});
        assertThatThrownBy(() -> fdMultiDataArray.findOneValueOnIndex(2)).isInstanceOf(IllegalStateException.class)
                .hasMessage("Multiple values found while fetching a single one for path [p]");
        assertThatThrownBy(() -> fdMultiDataArray.findOneValueOnIndex(3)).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("Accessing nonexistent value index [3] for path [p]");
    }

}
