package com.charles.elites.collections;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * Created by Kelvin.R.K on 5/16/2016.
 */
public class ListsTest {
    public static void main(String[] args) {
//        testLists();
//        testStringList();
        testSubstring();
    }

    public static void testLists() {
        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}

        List<List<Integer>> parts = Lists.partition(countUp, 2); // {{1, 2}, {3, 4}, {5}}

        System.out.println(countUp);
        System.out.println(countDown);
        System.out.println(parts);
    }

    public static void testStringList() {
        List<String> list = Lists.newArrayList();
        list.add("GrossExecuted $");

        String[] temp = new String[list.size()];
        list.toArray(temp);
        for(String s : temp)
            System.out.println(s);

        System.out.println(list.indexOf("GrossExecuted ."));
    }

    public static void testSubstring() {
        String s = "abcdefg";
        System.out.println(s.substring(0 ,4));
        System.out.println(s.substring(1 ,1));
        System.out.println(s.substring(0));
        System.out.println(s.substring(2, 5));
    }
}
