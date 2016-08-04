package com.charles.elites.amazon.oa1;

import java.util.*;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{}[]()[]((()))";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {
		if(s == null || s.length() == 0 || s.length() % 2 != 0)
			return false;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		char[] string = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(Character c : string) {
			if(map.containsKey(c))
				stack.push(c);
			else if(stack.isEmpty() || map.get(stack.pop()) != c)
				return false;
		}
		return stack.isEmpty();
	}
}
