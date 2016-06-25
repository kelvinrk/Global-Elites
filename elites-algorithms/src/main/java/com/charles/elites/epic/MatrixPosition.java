package com.charles.elites.epic;

public class MatrixPosition {
	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
		find(a);

	}
	private static void find(int[][] a) {
		int n = a.length;
		if(n == 1)
			return;
		int[] mins = new int[n];
		int[] maxs = new int[n];
		for(int i = 0; i < n; i++)
			maxs[i] = a[i][0];
		for(int i = 0; i < n; i++)
			mins[i] = a[0][i];
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n; j++)
				maxs[i] = Math.max(maxs[i], a[i][j]);
		}
		
		for(int j = 0; j < n; j++) {
			for(int i = 1; i < n; i++)
				mins[i] = Math.min(mins[i], a[i][j]);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++){
				if(a[i][j] == maxs[i] && a[i][j] == mins[j])
					System.out.println((i + 1) + "," + (j + 1));
			}
		}
	}
}
