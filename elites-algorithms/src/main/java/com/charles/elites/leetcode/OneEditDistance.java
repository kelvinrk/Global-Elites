package com.charles.elites.leetcode;

/**
 * Created by Kelvin.R.K on 7/6/2016.
 */
public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("abc", "abc"));
        System.out.println(isOneEditDistance("abd", "abc"));
        System.out.println(isOneEditDistance("abcd", "abc"));
        System.out.println(isOneEditDistance("bca", "abc"));

    }

    private static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m > n)
            return isOneEditDistance(t, s);
        if(n - m > 1)
            return false;
        int i = 0;
        int shift = n - m;
        while(i < m && s.charAt(i) == t.charAt(i))
            i++;
        if(m == n)
            return shift > 0;
        if(shift == 0)
            i++;
        while(i < m && s.charAt(i) == t.charAt(i + shift))
            i++;
        return i == m;
    }
}
