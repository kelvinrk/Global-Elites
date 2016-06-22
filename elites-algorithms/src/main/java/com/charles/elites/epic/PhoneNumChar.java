package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumChar {
	private static String[] letter = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		builder(res, 0, sb, digits);
		return res;
	}

	private static void builder(List<String> res, int index, StringBuilder sb,
			String digits) {
		if (index == digits.length()) {
			res.add(sb.toString());
//			System.out.println(sb.toString());
			return;
		}
		int num = digits.charAt(index) - '0';
		for (int i = 0; i < letter[num].length(); i++) {
			sb.append(letter[num].charAt(i));
			builder(res, index + 1, sb, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	public static void main(String args[]) {
		List<String> res = letterCombinations("834");
		for(String i : res)
			System.out.println(i);
	}
}