package com.charles.elites.amazon.oa1;

import java.util.Arrays;

//Return number of pairs
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,3,5,0,4,1,9,-4,7,-2,2,3,5,0};
//		int[] a = {3,3,3};
		System.out.println("Total pair number is: " + find(a, 6));
	}
	public static int find(int[] a, int target) {
		if(a == null || a.length < 2)
			return 0;
		Arrays.sort(a);
		int left = 0;
		int right = a.length - 1;
		int count = 0;
		while(left < right) {
			if(a[left] + a[right] == target) {
				count++;
				System.out.println("This pair is " + a[left] + " " + a[right]);
				left++;
				right--;
				while(left < right && a[left] == a[left - 1])    left++;
                while(left < right && a[right] == a[right + 1])    right--;
			} else if(a[left] + a[right] < target)
				left++;
			else
				right--;
		}
		return count;
	}
}
