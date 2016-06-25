package com.charles.elites.epic;

public class ValidPassword {
	public static void main(String[] args) {
		System.out.println(checkValid("164", "186848"));
		
	}
	public static boolean checkValid(String actual, String expected) {
		char faultKey = '\0';
		int i = 0, j = 0;
		for (; i < actual.length() && j < expected.length(); j++) {
			if (actual.charAt(i) != expected.charAt(j)) {
				if (faultKey == '\0') {
					faultKey = expected.charAt(j);
				} else {
					if (faultKey != expected.charAt(j))
						return false;
				}
				i--;
			}
			i++;
		}
		while (j < expected.length() && expected.charAt(j) == faultKey)
			j++;
		return i == actual.length() && j == expected.length();
	}
}
