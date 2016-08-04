package com.charles.elites.collections;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class RangeMapTest {
    public static void main(String[] args) {
        testRangeMap();
    }

    public static void testRangeMap() {
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}

        System.out.println("rangeMap: " + rangeMap);
        System.out.println("rangeMap.subRangeMap(Range.closed(1, 8)): " + rangeMap.subRangeMap(Range.closed(1, 8)));

        System.out.println("rangeMap.subRangeMap(Range.closed(15, 21)): " + rangeMap.subRangeMap(Range.closed(15, 21)));
    }

}
