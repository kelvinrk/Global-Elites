package com.charles.elites.epic;

public class SecurityKeypad {
	private static int[][] keypad = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
	public static void main(String[] args) {
		String input = "12745";
		String expected = "12345";
		System.out.println(valid(input, expected));
	}
	private static boolean valid(String a, String b) {
		boolean flag = false;
		if(a.length() != b.length())
			return false;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(!flag) {
					flag = true;
					int numA = a.charAt(i) - '0';
					int numB = b.charAt(i) - '0';
					int x = (numA - 1) / 3;
					int y = numA % 3 == 0 ? 2 : numA % 3;
					if(!check(numB, x, y))
						return false;
				}else
					return false;
			}
		}
		return true;
	}
	private static boolean check(int num, int x, int y) {
		if(x - 1 >= 0 && keypad[x - 1][y] == num)
			return true;
		if(x + 1 <= 2 && keypad[x + 1][y] == num)
			return true;
		if(y - 1 >= 0 && keypad[x][y - 1] == num)
			return true;
		if(y + 1 <= 2 && keypad[x][y + 1] == num)
			return true;
		return false;
	}
}
