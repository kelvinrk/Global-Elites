package com.charles.elites.epic;

public class TicTacToe {
	public static void main(String[] args) {

		char[][] matrix = { { 'r', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'r' },
				{ 'b', 'r', 'r', 'b' }, { 'b', 'r', 'b', 'b' } };
		int red_count = findCount(matrix, 4, 4, 'r');
		int blue_count = findCount(matrix, 4, 4, 'b');
		System.out.println("Count of red triplets: " + red_count);
		System.out.println("Count of blue triplets: " + blue_count);
	}
	private static int findCount(char[][] matrix, int row, int col, char c) {
		/**
		 * As we need to count horizontal triplets, we must look at all rows but
		 * stop two columns before, otherwise we would get IndexOutOfBound since
		 * we need to count only triplets.
		 */
		int count = 0;
		// For all horizontal triplets.
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - 2; j++) {
				if (matrix[i][j] == c && matrix[i][j + 1] == c
						&& matrix[i][j + 2] == c)
					count++;
			}
		}
		/**
		 * As we need to count vertical triplets, we must look at all columns
		 * but stop two rows before, otherwise we would get IndexOutOfBound
		 * since we need to count only triplets.
		 */
		// for all vertical triplet
		for (int i = 0; i < row - 2; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == c && matrix[i + 1][j] == c
						&& matrix[i + 2][j] == c)
					count++;
			}
		}
		/**
		 * As we need to count diagonal triplets from top to bottom, we must but
		 * stop two rows and two columns before, otherwise we would get
		 * IndexOutOfBound since we need to count only triplets.
		 */
		// for all top down diagonal triplets
		for (int i = 0; i < row - 2; i++) {
			for (int k = 0; k < col - 2; k++) {
				if (matrix[i][k] == c && matrix[i + 1][k + 1] == c
						&& matrix[i + 2][k + 2] == c)
					count++;
			}
		}
		/**
		 * As we need to count diagonal triplets from bottom to top, we must but
		 * stop two rows and two columns before, otherwise we would get
		 * IndexOutOfBound since we need to count only triplets. And we start
		 * from bottom.
		 */
		// for all bottom to top diagonal triples
		for (int i = row - 1; i > 1; i--) {
			for (int k = 0; k < col - 2; k++) {
				if (matrix[i][k] == c && matrix[i - 1][k + 1] == c
						&& matrix[i - 2][k + 2] == c)
					count++;
			}
		}
		return count;
	}
}