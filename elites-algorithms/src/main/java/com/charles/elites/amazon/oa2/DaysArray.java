package com.charles.elites.amazon.oa2;

import java.util.Arrays;

public class DaysArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 0, 0, 0, 0, 1, 0, 0};
//			{1,13,12,13,4,2,1,0,0};
		int[] res = day(input, 1);
		for(Integer i : res)
			System.out.print(i + " ");
	}

	public static int[] day(int[] input, int day) {
		if(day <= 0 || input == null || input.length < 2)
			return input;
		int[] res = new int[input.length];
		
		for(int i = 0; i < day; i++) {
			res[0] = input[1] == 0 ? 0 : 1;
			for(int j = 1; j < res.length - 1; j++) {
				res[j] = input[j - 1] == input[j + 1] ? 0 : 1;
			}
			res[res.length - 1] = input[input.length - 2] == 0 ? 0 : 1;
			input = Arrays.copyOf(res, res.length);
		}
		return res;
	}
}
