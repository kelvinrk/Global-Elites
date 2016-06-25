package com.charles.elites.epic;

public class SeparateTheNumber {
	public static void main(String[] args) {
		String str = "4678912356012356";
		System.out.println(getSequences(str));
	}
	static String getSequences(String str) {
		StringBuffer sb = new StringBuffer();
		boolean flag = false;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) + 1 == str.charAt(i)) {
				sb.append(str.charAt(i - 1));
				flag = true;
			} else {
				if (flag) {
					sb.append(str.charAt(i - 1));
					sb.append(';');
				}
				flag = false;
			}
		}
		if (str.charAt(str.length() - 2) + 1 == str.charAt(str.length() - 1)) {
			sb.append(str.charAt(str.length() - 1));
			sb.append(';');
		}
		return sb.toString();
	}
}
