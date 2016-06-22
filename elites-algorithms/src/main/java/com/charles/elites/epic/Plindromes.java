package com.charles.elites.epic;

public class Plindromes {
	public static void main(String[] args) {
		palindrome("abddbascdcs");
	}
	private static void palindrome(String s) {
		if (s == null || s.length() == 0)
			return;
		for (int i = 0; i < s.length(); i++) {
			String temp = helper(s, i, i);
			if (temp.length() >= 3)
				System.out.println(temp);
			temp = helper(s, i, i + 1);
			if (temp.length() >= 3)
				System.out.println(temp);
		}
	}
	private static String helper(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}
}
