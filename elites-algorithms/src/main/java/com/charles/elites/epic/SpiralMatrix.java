package com.charles.elites.epic;

public class SpiralMatrix {
	public static void main(String[] args) {
		String[][] a = new String[][]{{"C","I","P","E"}, {"R","N","K","U"}, {"U","O","W","O"}, {"L","E","S","Y"}};
		String[][] b = new String[][] {{"W", "O", "H"}, {"A", "U", "O"}, {"R", "E", "Y"}};
		spiral(b);
	}
	public static void spiral(String[][] matrix) {
		int n = matrix.length;
		int x = 0;
		int y = n - 1;
		int i = 0;
		while(n > 0) {
			if(n == 1)
				System.out.println(matrix[x][y--]);
			for(i = 0; i < n - 1; i++)
				System.out.println(matrix[x][y--]);
			for(i = 0; i < n - 1; i++)
				System.out.println(matrix[x++][y]);
			for(i = 0; i < n - 1; i++)
				System.out.println(matrix[x][y++]);
			for(i = 0; i < n - 1; i++)
				System.out.println(matrix[x--][y]);
			x++;
			y--;
			n -= 2;
		}
	}
}
