package com.charles.elites.epic;

public class AverageNumber {
	public static void main(String[] args) {
		int[] a = new int[]{17,18,19,1,2,3,4,11};
		System.out.println(average(a));
	}
	private static double average(int[] a) {
		int m1 = Integer.MIN_VALUE;
		int m2 = Integer.MIN_VALUE;
		int m3 = Integer.MIN_VALUE;
		int sum = 0;
		double avg = 0;
		
		if(a.length <= 3)
			return 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > m1) {
				m3 = m2;
				m2 = m1;
				m1 = a[i];
			}
			else if(a[i] > m2) {
				m3 = m2;
				m2 = a[i];
			}
			else if(a[i] > m3)
				m3 = a[i];
			sum += a[i];
		}
		avg = (double)(sum - m1 - m2 - m3) /(a.length - 3);
		return avg;
	}
}
