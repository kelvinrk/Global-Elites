package com.charles.elites.epic;

import java.util.HashSet;
import java.util.Set;


public class CowsAndBulls {
	public static void main(String[] args) {
		String a = "forum";
		String b = "four";
		count(a, b);
	}
	private static void count(String a, String b) {
		if(a == null || a.length() == 0)
			return;
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < a.length(); i++)
			set.add(a.charAt(i));
		int cow = 0;
		int bull = 0;
		for(int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if(set.contains(c)) {
				if(i < a.length() && a.charAt(i) == c)
					bull++;
				else
					cow++;
			}
		}
		System.out.println(bull + " Bulls and " + cow + " Cows");
	}
}
