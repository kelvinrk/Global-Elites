package com.charles.elites.amazon.oa1;

public class RightRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abcd";
		String b = "cdab";
		System.out.println(rightRotate(a, b));
	}
	
	private static int rightRotate(String a, String b) {
		if(a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length())
			return -1;
		String s = a + a;
		return s.indexOf(b) != -1 ? 1 : -1;
	}
}
