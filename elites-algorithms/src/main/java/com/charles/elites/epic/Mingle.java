package com.charles.elites.epic;

public class Mingle {
	int[][] matrix = new int[10][10];
	static int count = 0;
	static boolean diagChecked = false;
	void initial() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	void printMingle() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "    ");
			}
			System.out.println();
		}
	}
	void isMingo(int[][] matrix) {
		int value = 0;
		int row = 0;
		int col = 0;
		int data = 0;
		for (int i = 0; i < 100; i++) {
			value = (int) (Math.random() * 100);
			row = value / 10;
			col = value - row * 10;
			while (matrix[row][col] != 0) {
				value = (int) (Math.random() * 100);
				row = value / 10;
				col = value - row * 10;
			}
			data = (int) (Math.random() * 1000);
			matrix[row][col] = data;
			checkMingle(matrix, row, col);
		}
	}
	void checkMingle(int[][] matrix, int row, int col) {
		// check row
		int index = 0;
		while (index < matrix[row].length && matrix[row][index] != 0) {
			index++;
		}
		if (index == matrix[row].length) {
			count++;
			System.out.println("Number " + count + " mingle" + " row:" + row);
		}
		// check column
		index = 0;
		while (index < matrix.length && matrix[index][col] != 0) {
			index++;
		}
		if (index == matrix.length) {
			count++;
			System.out.println("Number " + count + " mingle" + " col: " + col);
		}
		// check diag
		if (!diagChecked) {
			index = 0;
			while (index < matrix.length && matrix[index][index] != 0) {
				index++;
			}
			if (index == matrix.length) {
				count++;
				System.out.println("Number " + count + " mingle" + " row:"
						+ row + " col: " + col + " It is diag!!!!");
				diagChecked = true;
			}
		}
	}
	public static void main(String[] args) {
		Mingle cm = new Mingle();
		cm.initial();
		cm.isMingo(cm.matrix);
		cm.printMingle();
	}
}