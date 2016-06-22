package com.charles.elites.epic;

public class SteppingNumber {

	public static void main(String[] args) {
		stepping(1, 1000);
	}
	private static void stepping(long s, long e) {
//		int ls = (int) Math.floor(Math.log10(s) + 1);
//		int le = (int) Math.floor(Math.log10(e) + 1);
		int ls = String.valueOf(s).length();
		int le = String.valueOf(e).length();
		for (int i = ls; i <= le; i++)
			for (long j = 1; j < 10; j++)
				dfs(s, e, i, j);
	}
	private static void dfs(long s, long e, int length, long num) {
		if (length - 1 == 0) {
			if (s <= num && num <= e)
				System.out.println(num);
			return;
		}
		long last = num % 10;
		if (last == 0)
			dfs(s, e, length - 1, num * 10 + 1);
		else if (last == 9)
			dfs(s, e, length - 1, num * 10 + 8);
		else {
			dfs(s, e, length - 1, num * 10 + last - 1);
			dfs(s, e, length - 1, num * 10 + last + 1);
		}
	}
}
