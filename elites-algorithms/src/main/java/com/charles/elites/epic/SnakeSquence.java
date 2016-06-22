package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SnakeSquence {
	public static void main(String[] args) {
		int[][] a = new int[][]{{1, 3, 2, 6, 8}, {0, 8, 1, 0, 2}, {1, 0, 1, 1, 9}};
		int len = snake(a);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				List<Integer> cur = new ArrayList<Integer>();
				cur.add(a[i][j]);
				sequence(a, i, j, res, cur, len);
			}
		}
//		System.out.println(res);
		for(List<Integer> each : res)
			System.out.println(each);
	}
	private static int snake(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int[][] dp = new int[m][n];
		for(int[] row : dp)
			Arrays.fill(row, 1);
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i == 0 && j == 0)
					continue;
				if (j > 0 && Math.abs(a[i][j - 1] - a[i][j]) == 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
					max = Math.max(dp[i][j], max);
				}
				if (i > 0 && Math.abs(a[i - 1][j] - a[i][j]) == 1) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
					max = Math.max(dp[i][j], max);
				}
			}
		}
		System.out.println(max);
		return max;
	}
	private static void sequence(int[][] a, int i, int j, List<List<Integer>> res, List<Integer> cur, int len) {
		if(cur.size() == len) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		if (j < a[0].length - 1 && Math.abs(a[i][j + 1] - a[i][j]) == 1) {
			cur.add(a[i][j + 1]);
			sequence(a, i, j + 1, res, cur, len);
			cur.remove(cur.size() - 1);
		}
		if (i < a.length - 1 && Math.abs(a[i + 1][j] - a[i][j]) == 1) {
			cur.add(a[i + 1][j]);
			sequence(a, i + 1, j, res, cur, len);
			cur.remove(cur.size() - 1);
		}
	}
}
