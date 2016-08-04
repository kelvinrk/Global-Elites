package com.charles.elites.leetcode;

/**
 * Created by Kelvin.R.K on 7/12/2016.
 */
public class MaxProduct {
    public static void main(String[] args) {
        maxProduct(new int[] {2,3,-2,4,5});
    }
    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int copy = max;
            max = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(copy * nums[i], nums[i]));
            System.out.println("nums[i] = " + nums[i] + " Min = " + min + " Max = " + max);
            res = Math.max(max, res);
        }
        return res;
    }
}
