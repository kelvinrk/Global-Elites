package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;


public class UniqueNumber {
	public static void main(String[] args) {
		int[] a = new int[]{1, 1, 3, 3, 3, 5, 5, 5, 9, 9, 9, 9};
		List<Integer> res = unique(a);
		for(Integer i : res)
			System.out.println(i);
		
	}
	private static List<Integer> unique(int[] a) {
		List<Integer> res = new ArrayList<Integer>();
		int pre = 0;
		int cur = 1;
		while(cur < a.length) {
			if(a[cur] == a[pre])
				cur++;
			else
				a[++pre] = a[cur++];
		}
		for(int i = 0; i < pre + 1; i++) {
			res.add(a[i]);
		}
		return res;
	}
}
