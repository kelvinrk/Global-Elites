package com.charles.elites.leetcode;

/**
 * Created by Kelvin.R.K on 7/31/2016.
 */
public class PlayGround {
    public static void main(String[] args) {
        String t = "aaa";
        int val = 0;
        for(int i = 0; i < t.length(); i++) {
            val |= 1 << (t.charAt(i) - 'a');
        }
        System.out.println(val);
    }
}
