package com.charles.elites.amazon.oa2;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}, {0,2,4}};
		int[][] a = rotate(input, true);
		printMatrix(a);
	}

	private static void printMatrix(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
	
	private static int[][] transpose(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] res = new int[n][m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				res[j][i] = input[i][j];
			}
		}
		return res;
	}
	
	public static int[][] rotate(int[][] input, boolean isClockWise) {
		int[][] t = transpose(input);
		int m = t.length;
		int n = t[0].length;
		if(isClockWise) {
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n / 2; j++) {
					int temp = t[i][j];
					t[i][j] = t[i][n - 1 - j];
					t[i][n - 1 - j] = temp;
				}
			}
		} else {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m / 2; j++) {
					int temp = t[j][i];
					t[j][i] = t[m - 1 - j][i];
					t[m - 1 - j][i] = temp;
				}
			}
		}
		return t;
	}
}
