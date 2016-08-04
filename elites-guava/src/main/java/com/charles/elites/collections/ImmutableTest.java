package com.charles.elites.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

/**
 * Created by Kelvin.R.K on 5/13/2016.
 */
public class ImmutableTest {
    public static void main(String[] args) {
//        testImmutableList();
        testImmutableSet();
    }

    private static void testImmutableList() {
        ImmutableList<String> hugeList = ImmutableList.of("Apple", "Orange", "Peach");
        ImmutableList<String> copy = ImmutableList.copyOf(hugeList.subList(0, 2));
        System.out.println(copy);
    }

    public static void testImmutableSet() {
        ImmutableSet<String> set = ImmutableSet.of("Apple", "Orange", "Peach", "Banana");
        System.out.println(set);

        ImmutableSortedSet<String> copy = ImmutableSortedSet.copyOf(set);
        System.out.println(copy);
    }
}
