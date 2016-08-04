package com.charles.elites.leetcode;

/**
 * Created by Kelvin.R.K on 7/6/2016.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "Hello World How are you";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        char[] array = s.toCharArray();
        reverse(array, 0, s.length() - 1);
        for(int i = 0, j = 0; j <= s.length(); j++) {
            if(j == s.length() || array[j] == ' ') {
                reverse(array, i, j - 1);
                i = j + 1;
            }
        }
        return new String(array);
    }

    private static void reverse(char[] s, int l, int r) {
        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
