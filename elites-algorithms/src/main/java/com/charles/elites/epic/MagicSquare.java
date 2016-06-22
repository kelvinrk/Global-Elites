package com.charles.elites.epic;

public class MagicSquare {
	public static void main(String[] args) {
		int[][] a = new int[3][3];
		fill(a);
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void fill(int[][] a) {
		int n = a.length;
		int x = 0;
		int y = n/2;
		for(int i = 1; i <= n*n; i++) {
			a[x][y] = i;
			if(i == n*n)
				break;
			int[] pos = getNext(x - 1, y + 1, a);
			x = pos[0];
			y = pos[1];
		}
	}
	private static int[] getNext(int x, int y, int[][] a) {
		int n = a.length;
		if(x < 0)
			x = n - 1;
		if(y > n - 1)
			y = 0;
		while(a[x][y] != 0) {
			x++;
		}
		int[] res = new int[]{x, y};
		return res;
	}
}
