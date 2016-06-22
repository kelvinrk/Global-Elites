package com.charles.elites.epic;

import java.util.HashSet;
import java.util.Set;

public class ReplaceAEIOU {
	public static void main(String[] args) {
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('A');
		set.add('e');
		set.add('E');
		set.add('i');
		set.add('I');
		set.add('o');
		set.add('O');
		set.add('u');
		set.add('U');
		String s = "greateribblizing";
		replace(s, set);
	}
	private static void replace(String s, Set<Character> set) {
		int exem = 3;
		int replace = 4;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c))
				sb.append(c);
			else {
				if (exem > 0) {
					sb.append(c);
					exem--;
					continue;
				} else if (replace > 0) {
					sb.append(c).append('^');
					replace--;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
