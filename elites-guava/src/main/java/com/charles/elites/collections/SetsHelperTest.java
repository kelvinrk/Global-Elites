package com.charles.elites.collections;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.elementsEqual;
import static com.google.common.collect.Sets.difference;
import static com.google.common.collect.Sets.symmetricDifference;
import static com.google.common.collect.Sets.union;

/**
 * Created by Kelvin.R.K on 5/12/2016.
 */
public class SetsHelperTest {
    public static void main(String[] args) {
        Set<String> seta = Sets.newHashSet();
        Set<String> setb = Sets.newHashSet();
        Set<Integer> setc = Sets.newHashSet();

        addContentA(seta);
        addContentB(setb);
        addContentC(setc);

        Set<List<String>> product =  Sets.cartesianProduct(seta, setb);
        System.out.println("product = " + product);

        Set<String> animals = ImmutableSet.of("gerbil", "hamster");
        Set<Set<String>> animalSets = Sets.powerSet(animals);

        System.out.println("\n**************** animalSets ****************");
        for(Set<String> s: animalSets)
            System.out.println(s);

        System.out.println("\nseta " + seta);
        System.out.println("setb " + setb);
        System.out.println("union(seta, setb) = " + union(seta, setb));
        System.out.println("difference(seta, setb) = " + difference(seta, setb));
        System.out.println("difference(setb, seta) = " + difference(setb, seta));
        System.out.println("symmetricDifference(seta, setb) = " + symmetricDifference(seta, setb));

        System.out.println("elementsEqual(seta, seta) = " + elementsEqual(seta, seta));
        System.out.println("elementsEqual(seta, setb) = " + elementsEqual(seta, setb));

        verifyContent(seta, setb);
    }

    public static void addContentA(Set<String> set) {
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("M");
    }

    public static void addContentB(Set<String> set) {
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("Z");
    }

    public static void addContentC(Set<Integer> set) {
        set.add(1);
        set.add(2);
        set.add(3);
    }

    public static void verifyContent(Set<? extends Object> actualSet, Set<? extends Object> expectedSet) {
        Set<Object> intersection = Sets.newHashSet(actualSet);
        intersection.retainAll(expectedSet);

        if(!actualSet.containsAll(expectedSet) || !expectedSet.containsAll(actualSet)) {
            expectedSet.removeAll(intersection);
            actualSet.removeAll(intersection);
            System.out.println("Content mismatch! Missing contents are: "
                    + expectedSet.toString() + " Redundant contents are: " + actualSet.toString());
        }
    }
}
