package com.charles.elites.quest;

import java.util.HashSet;
import java.util.Set;

public class TreeLeaves {
    public static int getNumOfLeaves(int[] tree) {
        int len = tree.length;
        Set<Integer> set = new HashSet<>();

        for(int i : tree) {
            set.add(i);
        }

        return len - set.size() + 1;
    }

    public static void main(String[] args) {
        System.out.println(TreeLeaves.getNumOfLeaves(new int[] { 1, 3, 1, -1, 3 }));
    }
}