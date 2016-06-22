package com.charles.elites.epic;

public class TelephoneNumber {
	private static String digits = "0134568";
	private static int numLength;

	private static void printPhoneNums(String prefix) {
		if (prefix.length() == numLength) {
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < digits.length(); i++) {
			if (prefix.length() > 0) {
				if (prefix.charAt(prefix.length() - 1) == digits.charAt(i))
					continue;
				if (digits.charAt(i) == '4' && prefix.charAt(0) != '4')
					continue;
			}
			printPhoneNums(prefix + digits.charAt(i));
		}
	}
	public static void printPhoneNums(int length) {
		numLength = length;
		printPhoneNums("");
	}
	public static void main(String[] args) {
		printPhoneNums(5);
	}
}
