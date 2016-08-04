package com.charles.elites.lintcode;

/**
 * Created by Kelvin.R.K on 7/31/2016.
 */
public class BackPackII {

    public static void main(String[] args) {
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        BackPackII pack = new BackPackII();
        int res = pack.backPackII(10, A, V);
        System.out.println(res);
    }

    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] res = new int[m + 1];
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = m; j >= A[i]; j--) {
                res[j] = Math.max(res[j], res[j - A[i]] + V[i]);
                max = Math.max(res[j], max);
            }
            System.out.print("Value = " + V[i] + " : ");
            for(int val : res)
                System.out.print(val + " ");
            System.out.println();
        }
        return max;
    }
}
