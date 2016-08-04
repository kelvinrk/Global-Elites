package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
    private List<Integer> internalList;
    private Set<Integer> sumSet;

    public Sum3() {
        internalList = new ArrayList<>();
        sumSet = new HashSet<>();
    }

    /**
     * Adds/appends internalList of integers at the end of internal internalList.
     */
    public void addLast(int[] list) {
        for(int num : list) {
            this.internalList.add(num);
            if(internalList.size() >= 3) {
                int p = internalList.size() - 3;
                int sum = internalList.get(p) + internalList.get(p + 1) + internalList.get(p + 2);
                sumSet.add(sum);
            }
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal internalList have given sum.
     */
    public boolean containsSum3(int sum) {
        return sumSet.contains(sum);
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();

        s.addLast(new int[] { 1, 2, 3 });

        System.out.println(s.containsSum3(6));
        System.out.println(s.containsSum3(9));

        s.addLast(new int[] { 4 });

        System.out.println(s.containsSum3(9));
    }
}