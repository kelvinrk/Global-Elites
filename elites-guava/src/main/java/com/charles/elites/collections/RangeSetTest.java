package com.charles.elites.collections;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class RangeSetTest {
    public static void main(String[] args) {
        testRangeSet();
    }

    public static void testRangeSet() {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();

        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}

        System.out.println("rangeSet: " + rangeSet);

        System.out.println("rangeSet.complement(): " + rangeSet.complement());

        System.out.println("rangeSet.contains(15): " + rangeSet.contains(15));

        System.out.println("rangeSet.rangeContaining(16): " + rangeSet.rangeContaining(16));

        System.out.println("rangeSet.encloses(Range.closed(15, 19)): " + rangeSet.encloses(Range.closed(15, 19)));

        System.out.println("rangeSet.span(): " + rangeSet.span());
    }

    public static void testRange() {
        Range.closedOpen(4, 4).isEmpty(); // returns true
        Range.openClosed(4, 4).isEmpty(); // returns true
        Range.closed(4, 4).isEmpty(); // returns false
        Range.open(4, 4).isEmpty(); // Range.open throws IllegalArgumentException

        Range.closed(3, 10).lowerEndpoint(); // returns 3
        Range.open(3, 10).lowerEndpoint(); // returns 3
        Range.closed(3, 10).lowerBoundType(); // returns CLOSED
        Range.open(3, 10).upperBoundType(); // returns OPEN

        Range.closed(3, 5).isConnected(Range.open(5, 10)); // returns true
        Range.closed(0, 9).isConnected(Range.closed(3, 4)); // returns true
        Range.closed(0, 5).isConnected(Range.closed(3, 9)); // returns true
        Range.open(3, 5).isConnected(Range.open(5, 10)); // returns false
        Range.closed(1, 5).isConnected(Range.closed(6, 10)); // returns false

        Range.closed(3, 5).intersection(Range.open(5, 10)); // returns (5, 5]
        Range.closed(0, 9).intersection(Range.closed(3, 4)); // returns [3, 4]
        Range.closed(0, 5).intersection(Range.closed(3, 9)); // returns [3, 5]
        Range.open(3, 5).intersection(Range.open(5, 10)); // throws IAE
        Range.closed(1, 5).intersection(Range.closed(6, 10)); // throws IAE

        Range.closed(3, 5).span(Range.open(5, 10)); // returns [3, 10)
        Range.closed(0, 9).span(Range.closed(3, 4)); // returns [0, 9]
        Range.closed(0, 5).span(Range.closed(3, 9)); // returns [0, 9]
        Range.open(3, 5).span(Range.open(5, 10)); // returns (3, 10)
        Range.closed(1, 5).span(Range.closed(6, 10)); // returns [1, 10]

        ImmutableSortedSet<Integer> set = ContiguousSet.create(Range.open(1, 5), DiscreteDomain.integers());
        // set contains [2, 3, 4]

        ContiguousSet.create(Range.greaterThan(0), DiscreteDomain.integers());
        // set contains [1, 2, ..., Integer.MAX_VALUE]
    }
}
