package com.charles.elites.amazon.oa2;

import java.util.*;

public class CacheMissTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4, 1, 6, 7, 10, 2, 7, 11, 12, 1};
		System.out.println(cacheMiss(input, 5));
	}

	public static int cacheMiss(int[] input, int size) {
		int res = 0;
		List<Integer> cache = new ArrayList<Integer>();
		for(int i = 0; i < input.length; i++) {
			int val = input[i];
			int pos = cache.indexOf(val);
			if(pos != -1) {
				cache.remove(pos);
				cache.add(val);
			} else {
				res++;
				if(cache.size() == size) {
					cache.remove(0);
					cache.add(val);
				} else {
					cache.add(val);
				}
			}
		}
		return res;
	}
}
