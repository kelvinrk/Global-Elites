package com.charles.elites.amazon.oa2;

import java.util.Arrays;

public class LongestArithmeticProgression {

	public static void main(String[] args) {
		int[] a = {-1,1,3,3,3,2,1,0};
//		int[] a = {2,1,4,12,10,-7,8,6,-1};
		int res = findLAP(a);
		System.out.println(res);
	}

	public static int findLAP(int[] a) {
		if(a == null || a.length <= 2)
			return a.length;
		Arrays.sort(a);
		int res = 2;
		int l = a.length;
		int[][] dp = new int[l][l];
		for(int i = 0; i < l; i++)
			dp[i][l - 1] = 2;
		for(int j = l - 2; j >= 0; j--) {
			int i = j - 1; 
			int k = j + 1;
			while(i >= 0 && k < a.length) {
				if(a[i] + a[k] < 2 * a[j])
					k++;
				else if(a[i] + a[k] > 2 * a[j]) {
					dp[i][j] = 2;
					i--;
				}
				else {
					dp[i][j] = dp[j][k] + 1;
					res = Math.max(res, dp[i][j]);
					i--;
					k++;
				}
			}
			while(i >= 0) {
				dp[i][j] = 2;
				i--;
			}
		}
		return res;
	}
}
