package com.charles.elites.amazon.oa2;

import java.util.*;

public class WindowSum {

	public static void main(String[] args) {
		int[] a = {4, 2, 73, 11, -5};
		List<Integer> res = windowSum(a, 3);
		for(Integer each : res)
			System.out.println(each);
	}

	public static List<Integer> windowSum(int[] a, int size) {
		if(a == null || a.length == 0 || size > a.length)
			return null;
		List<Integer> res = new ArrayList<Integer>();
		int sum = 0;
		int firstIndex = 0;
		int len = size;
		int i = 0;
		while(len > 0) {
			sum += a[i++];
			len--;
		}
		res.add(sum);
		while(i < a.length) {
			sum = sum - a[firstIndex++] + a[i++];
			res.add(sum);
		}
		return res;
	}
}
