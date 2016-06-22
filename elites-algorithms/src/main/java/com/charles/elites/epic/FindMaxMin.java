package com.charles.elites.epic;

import java.util.Scanner;

public class FindMaxMin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, i = 0;
		System.out.print("Enter the numbers: ");
		while (true) {
			i = scan.nextInt();

			if (i == 0)
				break;
			if (i % 2 == 0) {
				if (i < min)
					min = i;
			}
			else if (i > max) {
				max = i;
			}
		}
		System.out.println("Min even " + min);
		System.out.println("Max odd " + max);
	}
}
