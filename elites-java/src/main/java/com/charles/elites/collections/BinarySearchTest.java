package com.charles.elites.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kelvin.R.K on 7/31/2016.
 */
public class BinarySearchTest {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        loadList();
        System.out.println(Collections.binarySearch(list, 99));
    }

    private static void loadList() {
        list.add(3);
        list.add(8);
        list.add(12);
        list.add(100);
    }
}
