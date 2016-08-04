package com.charles.elites.collections;

import com.charles.elites.io.Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Kelvin.R.K on 7/1/2016.
 */
public class PlayTest {
    public static void main(String[] args) {
//        for(int i = 0; i < 1000; i++)
//            testMidPoint();
//        testTreeSet();
        testArrayList();
    }

    public static void testMidPoint() {
        int start = Generator.generateIneger(0, 100);
        int end = Generator.generateIneger(start, 200);
        int m = start + (end - start) / 2;
        int n = (start + end) / 2;

        assertEquals(m, n);
    }

    private static void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(7);
        set.add(9);
        set.add(2);
        set.add(10);
        for(int i = 0; i < 3; i++) {
            System.out.println(set.pollFirst() + " treeSet size : " + set.size());
        }
    }

    private static void testArrayList() {
        int size = 100;
        for(int i = 1; i < 1000; i++) {
            int hash = i ^ (i >>> 16);
            int location = (size - 1) & hash;
            System.out.println("i = " + i + ", hash = " + hash + ", location = " + location);
        }

        Map<Integer, Integer> map  = new HashMap<>();
        map.put(1,2);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for(int i = 0; i < list.size(); i++) {
            list.remove(i);
            System.out.println("list.size() = " + list.size() + ", i = " + i);
        }
    }
}
