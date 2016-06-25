package com.charles.elites.epic;

public class End4 {

	public static void main(String[] args) {
		generate(0);
	}

	private static int MAX = 4;
	private static int[] digits = new int[4];

	private static void  print() {
		for (int i = 0; i < digits.length; i++)
			System.out.print(digits[i]);
		System.out.println();
	}

	private static void generate(int index) {
		if (index == MAX)
			print();
		else {
			if (digits[0] == 4 && index == MAX - 1) {
				digits[index] = 4;
				generate(index + 1);
			} else {
				for (int i = 0; i < 10; i++) {
					if (index == 0 || digits[index - 1] != i) {
						digits[index] = i;
						generate(index + 1);
					}
				}
			}
		}
	}

}
