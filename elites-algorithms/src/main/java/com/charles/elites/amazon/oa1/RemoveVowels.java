package com.charles.elites.amazon.oa1;

public class RemoveVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Charles";
		String v = "aeiou";
		System.out.println(remove(s, v));
	}
	
	public static String remove(String s, String v) {
		StringBuilder sb = new StringBuilder();
		String s1 = s.toLowerCase();
		String v1 = v.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			if(v1.indexOf(s1.charAt(i)) != -1)
				continue;
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
