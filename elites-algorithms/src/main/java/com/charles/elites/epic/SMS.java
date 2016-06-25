package com.charles.elites.epic;

public class SMS {
	public static String[] keypad = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	public static void main(String[] args) {
		message("2#22#2223*32453");

	}
	private static void message(String s) {
		if(s == null || s.length() == 0)
			return;
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < c.length; i++) {
			int count = 1;
			int num = c[i] - '0';
			while(i < c.length - 1 && c[i] == c[i + 1] && c[i] != '*') {
				count++;
				i++;
			}
			if(c[i] == '#')
				continue;
			if(c[i] == '*') {
				sb.append(' ');
				continue;
			}
			int pos = count % keypad[num].length() == 0 ? keypad[num].length() - 1 : count % keypad[num].length() - 1 ;
			sb.append(keypad[num].charAt(pos));
		}
		System.out.println(sb.toString());
	}
}
