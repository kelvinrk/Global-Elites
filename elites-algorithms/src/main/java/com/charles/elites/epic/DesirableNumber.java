package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;


public class DesirableNumber {

	public static void main(String[] args) {
		List<String> res = new ArrayList<String>();
		for(int i = 0; i <= 9; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			generator(sb, res, 4);
		}
		for(String s : res)
			System.out.println(s);
	}
	private static void generator(StringBuilder sb, List<String> res, int n) {
		if(sb.length() == n) {
			res.add(sb.toString());
			return;
		}
		int num = sb.charAt(sb.length() - 1) - '0';
		for(int i = num + 1; i <= 9; i++) {
			sb.append(i);
			generator(sb, res, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
