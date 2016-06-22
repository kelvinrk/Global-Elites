package com.charles.elites.epic;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Stack;


public class BalancedString {
	public static void main(String[] args) {
		System.out.println(isValid("{a[(b)]}"));
	}
	private static boolean isValid(String s) {
		if(s == null || s.length() == 0 || s.length() % 2 != 0)
            return false;
        Map<Character, Character> map = Maps.newHashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        char[] string = s.toCharArray();
        for(Character c : string) {
            if(map.containsKey(c))
                stack.push(c);
            else if(map.values().contains(c) && !stack.isEmpty() && map.get(stack.pop()) != c)
                return false;
        }
        return stack.isEmpty();
	}
}
