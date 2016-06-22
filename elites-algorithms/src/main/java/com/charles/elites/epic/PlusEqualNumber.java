package com.charles.elites.epic;

public class PlusEqualNumber {
	public static int count = 0;
	public static boolean check(int n1, int n2, int n3) {
		count++;
		if (n1 + n2 == n3) {
			System.out.println(n1 + "+" + n2 + "=" + n3);
			return true;
		} else if (n2 + n3 == n1) {
			System.out.println(n2 + "+" + n3 + "=" + n1);
			return true;
		} else if (n1 + n3 == n2) {
			System.out.println(n1 + "+" + n3 + "=" + n2);
			return true;
		} else
			return false;
	}
	public static void main(String args[]) {
		String f = "1578";
		int n = f.length() / 2;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n + i; j++) {
				int num1 = Integer.parseInt(f.substring(0, i + 1));
				int num2 = Integer.parseInt(f.substring(i + 1, j + 1));
				int num3 = Integer.parseInt(f.substring(j + 1, f.length()));
				boolean temp = check(num1, num2, num3);
				if (!temp)
					continue;
				else
					break;
			}
	}
}
