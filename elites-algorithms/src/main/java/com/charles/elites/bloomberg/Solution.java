package com.charles.elites.bloomberg;

/**
 * Created by Kelvin.R.K on 7/19/2016.
 */
public class Solution {
    static int[][] cache;

    public static void main(String[] args) {
        int[][] nums = {{3,4,5}, {3,2,6}, {2,2,1}};
        new Solution().longestIncreasingPath(nums);
        for(int i = 0; i < cache.length; i++) {
            for(int j = 0; j < cache[0].length; j++)
                System.out.print(cache[i][j] + " ");
            System.out.println();
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                max = Math.max(max, find(i, j, matrix, Long.MIN_VALUE));
        }
//        max = Math.max(max, find(2, 1, matrix, Long.MIN_VALUE));
        return max;
    }

    private int find(int i, int j, int[][] m, long last) {
        if(i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] <= last)
            return 0;
        if(cache[i][j] != 0)
            return cache[i][j];

        int max = find(i + 1, j, m, m[i][j]) + 1;
        max = Math.max(max, find(i - 1, j, m, m[i][j]) + 1);
        max = Math.max(max, find(i, j - 1, m, m[i][j]) + 1);
        max = Math.max(max, find(i, j + 1, m, m[i][j]) + 1);
        cache[i][j] = max;
        return max;
    }
}
