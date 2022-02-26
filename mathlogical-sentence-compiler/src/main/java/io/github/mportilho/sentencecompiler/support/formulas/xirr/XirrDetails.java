/*******************************************************************************
 * MIT License
 *
 * Copyright (c) 2022. Marcelo Silva Portilho
 *
 * Copyright (c) 2017 Raymond DeCampo <ray@decampo.org>
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

package io.github.mportilho.sentencecompiler.support.formulas.xirr;

import java.time.Instant;
import java.util.stream.Collector;

/**
 * Converts a stream of {@link Transaction} instances into the data needed for
 * the {@link Xirr} algorithm.
 */
class XirrDetails {
    public static Collector<Transaction, XirrDetails, XirrDetails> collector() {
        return Collector.of(
            XirrDetails::new,
            XirrDetails::accumulate,
            XirrDetails::combine,
            Collector.Characteristics.IDENTITY_FINISH,
            Collector.Characteristics.UNORDERED);
    }

    Instant start;
    Instant end;
    double minAmount = Double.POSITIVE_INFINITY;
    double maxAmount = Double.NEGATIVE_INFINITY;
    double total;
    double deposits;

    public void accumulate(final Transaction tx) {
        start = start != null && start.isBefore(tx.when) ? start : tx.when;
        end = end != null && end.isAfter(tx.when) ? end : tx.when;
        minAmount = Math.min(minAmount, tx.amount);
        maxAmount = Math.max(maxAmount, tx.amount);
        total += tx.amount;
        if (tx.amount < 0) {
            deposits -= tx.amount;
        }
    }

    public XirrDetails combine(final XirrDetails other) {
        start = start.isBefore(other.start) ? start : other.start;
        end = end.isAfter(other.end) ? end : other.end;
        minAmount = Math.min(minAmount, other.minAmount);
        maxAmount = Math.max(maxAmount, other.maxAmount);
        total += other.total;
        return this;
    }

    public void validate() {
        if (start == null) {
            throw new IllegalArgumentException("No transactions to anaylze");
        }

        if (start.equals(end)) {
            throw new IllegalArgumentException(
                "Transactions must not all be on the same day.");
        }
        if (minAmount >= 0) {
            throw new IllegalArgumentException(
                "Transactions must not all be nonnegative.");
        }
        if (maxAmount < 0) {
            throw new IllegalArgumentException(
                "Transactions must not be negative.");
        }
    }

}
