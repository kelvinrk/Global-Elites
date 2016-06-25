package com.charles.elites.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kelvin.R.K on 6/24/2016.
 */
public class Solution {
    public static int[] findTwoSum(int[] list, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = null;
        for(int i = 0; i < list.length; i++) {
            int find = sum - list[i];
            if(map.containsKey(find)) {
                res = new int[2];
                res[0] = i;
                res[1] = map.get(find);
            } else {
                map.put(list[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
