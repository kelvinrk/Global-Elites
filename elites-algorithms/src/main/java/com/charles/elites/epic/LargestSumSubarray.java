package com.charles.elites.epic;

public class LargestSumSubarray {
	public static void main(String[] args) {
		int[] a = new int[]{1,3,-2,9,-17,6};
		int[] res = solution(a);
		for(Integer i : res)
			System.out.println(i);
	}
	private static int[] solution(int[] n){
		if(n.length < 2)
			return null;
		if(n.length == 2)
			return n;
		int start = 0;
		int end = 1;
		int tempStart = 0;
		int tempEnd = 1;
		int tempMax = n[0] + n[1];
		int max = tempMax;
		for(int i = 2; i < n.length ; i++){
			if(n[i]+n[i-1] > (tempMax + n[i]))
			{
				tempMax = n[i]+n[i-1];
				tempEnd = i;
				tempStart = i-1;
			}else
			{
				tempMax = tempMax + n[i];
				tempEnd = i;
			}
			if(tempMax > max){
				max = tempMax;
				start = tempStart;
				end = tempEnd;
			}
		}
		int[] result = new int[end - start + 1];
		for(int k = 0; k<= (end-start); k++){
			result[k] = n[k+start];
		}
		return result;
	}
}
