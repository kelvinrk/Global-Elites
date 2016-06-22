package com.charles.elites.epic;

public class MountainPoint {
	public static void main(String[] args) {
		int[][] a = new int[][]{{1,2,3,4}, {5,8,7,6}, {1,2,3,3}, {1,2,2,2}};
		mountainPoint(a);

	}
	public static void mountainPoint(int[][] matrix) {
		// start from the second element in the second row
		for (int i = 1; i < matrix.length - 1; i++) {
			for (int j = 1; j < matrix[0].length - 1; j++) {
			     if (matrix[i][j] > matrix[i - 1][j - 1]
				        && matrix[i][j] > matrix[i - 1][j]
				        && matrix[i][j] > matrix[i - 1][j + 1]
				        && matrix[i][j] > matrix[i][j - 1]
                        && matrix[i][j] > matrix[i][j + 1]
				        && matrix[i][j] > matrix[i + 1][j - 1]
				        && matrix[i][j] > matrix[i + 1][j]
				        && matrix[i][j] > matrix[i + 1][j + 1]) {
                    System.out.println("(" + i + "," + j + ")");
                    j++; //skip the next column
                 }	
            }
        }
	}
}
