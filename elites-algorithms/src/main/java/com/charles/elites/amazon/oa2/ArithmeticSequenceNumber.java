package com.charles.elites.amazon.oa2;

public class ArithmeticSequenceNumber {

	public static void main(String[] args) {
//		int[] a = {-1, 1, 3, 3, 3, 2, 1, 0};
//		int[] a = {1,2,3,4,5,6,7,8,9,10};
		int[] a = {1, 2, 4, 6, 8, 9, 12, 15};
		System.out.println(findAS(a));
	}
	
	public static int findAS(int[] a) {
		if(a == null || a.length < 3)
			return 0;
		int res = 0;
		int diff = Integer.MIN_VALUE;
		int start = 0;
		for(int i = 1; i < a.length; i++) {
			int curDiff = a[i] - a[i - 1];
			if(curDiff == diff) {
				res += i - start - 1 > 0 ? i - start - 1 : 0;
			} else {
				start = i - 1;
				diff = curDiff;
			}
		}
		return res > 1000000000 ? -1 : res;
	}

}
