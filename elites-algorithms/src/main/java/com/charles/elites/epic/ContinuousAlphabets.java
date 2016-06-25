package com.charles.elites.epic;

public class ContinuousAlphabets {
	public static void main(String[] args) {
		printContinue("AbcDexvsMnopasdgTuvWxYz");
	}
	private static void printContinue(String s) {
		s = s.toLowerCase();
		char[] c = s.toCharArray();
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < c.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(c[i]);
			while(i < c.length - 1 && c[i + 1] - c[i] == 1) {
				sb.append(c[i + 1]);
				i++;
			}
			if(sb.length() > 1)
				res.append(sb.toString()).append(";");
//				System.out.println(sb.toString());
		}
		System.out.println(res.toString());
	}
}
