package com.charles.elites.epic;

public class CoinChange {
	private static final double[] deno= new double[]{5.0, 1.0, 0.25, 0.01};

	public static void main(String[] args) {
		System.out.println(change(9.75));
	}
	private static int change(double money) {
		int count = 0;
		int i = 0;
		while(money > 0) {
			int num = (int)(money / deno[i]);
			count += num;
			money -= num * deno[i];
			i++;
		}
		return count;
	}
}
