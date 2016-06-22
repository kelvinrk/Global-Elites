package com.charles.elites.epic;

public class TwoPalindrome {
	public static void main(String[] args) {
		getTwoTypePalindrom(1000);
	}
	public static boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	public static String DecimaltoOctal(int decimal) {
		StringBuilder sb = new StringBuilder();
		int reminder;
		while (decimal != 0) {
			reminder = decimal % 8;
			decimal /= 8;
			sb.append(String.valueOf(reminder));
		}
		return sb.toString();
	}
	public static void getTwoTypePalindrom(int bound) {
		for (int i = 0; i < bound; i++) {
			String test1 = Integer.toString(i);
			if (isPalindrom(test1)) {
				String test2 = DecimaltoOctal(i);
				if (isPalindrom(test2)) {
					System.out.println(i);
				}
			}
		}
	}
}