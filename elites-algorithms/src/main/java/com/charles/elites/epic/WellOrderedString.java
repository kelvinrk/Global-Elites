package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;


public class WellOrderedString {

	public static void main(String[] args) {
		List<String> res = new ArrayList<String>();
		int len = 2;
		for(int i = 0; i < 26; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append((char)('a' + i));
			generator(sb, res, len);
			sb = new StringBuilder();
			sb.append((char)('A' + i));
			generator(sb, res, len);
		}
		for(String s : res)
			System.out.println(s);
	}
	
	private static void generator(StringBuilder sb, List<String> res, int n) {
		if(sb.length() == n) {
			res.add(sb.toString());
			return;
		}
		
		int num = sb.charAt(sb.length() - 1) - 'A';
		if(num >= 0 && num <= 25) {
			for(int i = num + 1; i < 26; i++) {
				sb.append((char)(i + 'A'));
				generator(sb, res, n);
				sb.deleteCharAt(sb.length() - 1);
				sb.append((char)(i + 'a'));
				generator(sb, res, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		else {
			num -= 32;
			for(int i = num + 1; i < 26; i++) {
				sb.append((char)(i + 'A'));
				generator(sb, res, n);
				sb.deleteCharAt(sb.length() - 1);
				sb.append((char)(i + 'a'));
				generator(sb, res, n);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
	}
}
