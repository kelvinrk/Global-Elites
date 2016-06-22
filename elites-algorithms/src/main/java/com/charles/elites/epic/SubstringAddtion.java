package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;

 
public class SubstringAddtion {
	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7,8};//{1, 7, 6, 3, 5, 8, 9};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int target = 15;
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(a[i]);
			sum = a[i];
			for(int j = i + 1; j < a.length; j++) {
				cur.add(a[j]);
				sum += a[j];
				if(sum == target)
					res.add(new ArrayList<Integer>(cur));
			}
		}
		for(List<Integer> each : res)
			System.out.println(each);
	}
}
