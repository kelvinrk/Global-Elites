package com.charles.elites.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import static java.util.Collections.frequency;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class MultisetTest {

    public static void main(String[] args) {
//        ImmutableMultisetTest();
        testTwoMultiSets();
//        testCopy();
    }

    public static void ImmutableMultisetTest() {
        System.out.println("\n************************* ImmutableMultiset Test *************************\n");

        ImmutableMultiset<String> multiset = ImmutableMultiset.<String>builder()
                .add("Apple")
                .add("Apple")
                .add("Apple")
                .add("Apple")
                .add("Apple")
                .add("Banana", "Pineapple", "Pineapple")
                .add("Orange")
                .add("Orange")
                .add("Orange")
                .add("Orange")
                .add("Peach")
                .build();

        System.out.println("multiset.size() = " + multiset.size());
        System.out.println("multiset.elementSet().size() = " + multiset.elementSet().size());
        System.out.println("multiset.count(\"Apple\") = " + multiset.count("Apple"));
        System.out.println("multiset = " + multiset);
        System.out.println("multiset.asList() = " + multiset.asList());
        System.out.println("frequency(multiset, \"Apple\") = " + frequency(multiset, "Apple"));
    }

    public static void testTwoMultiSets() {
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);

        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        multiset2.add("b", 6);

        System.out.println("Multisets.intersection(multiset2, multiset1) = " + Multisets.intersection(multiset2, multiset1));

        System.out.println("Multisets.containsOccurrences(multiset1, multiset2) = " + Multisets.containsOccurrences(multiset1, multiset2));
        System.out.println("Multisets.containsOccurrences(multiset2, multiset1) = " + Multisets.containsOccurrences(multiset2, multiset1));

        System.out.println("Multisets.removeOccurrences(multiset2, multiset1) = " + Multisets.removeOccurrences(multiset2, multiset1) + " " + multiset2);

        System.out.println("Multisets.retainOccurrences(multiset2, multiset1) = " + Multisets.retainOccurrences(multiset2, multiset1) + " " + multiset2);
    }

    public static void testCopy() {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a", 3);
        multiset.add("b", 5);
        multiset.add("c", 1);

        ImmutableMultiset<String> highestCountFirst = Multisets.copyHighestCountFirst(multiset);
        System.out.println(highestCountFirst);
    }
}
