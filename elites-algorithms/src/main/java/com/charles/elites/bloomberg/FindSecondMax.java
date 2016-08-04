package com.charles.elites.bloomberg;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 */
public class FindSecondMax {
    public static void main(String[] args) {
        int[][] inputs = {{1, 2, 3}, {1}, {1, 1}, {1, 2, 3, 3}};
        for(int[] input : inputs)
            System.out.println(findSecondMax(input));
    }

    private static int findSecondMax(int[] input) {
        if(input == null || input.length == 0)
            return Integer.MIN_VALUE;
        int m = input[0];
        int n = m;

        for(int i : input) {
            if(i == m) {
                continue;
            } else if(i > m) {
                n = m;
                m = i;
            } else if(i > n) {
                n = i;
            }
        }
        return n;
    }
}
