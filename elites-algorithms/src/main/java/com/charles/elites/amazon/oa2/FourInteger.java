package com.charles.elites.amazon.oa2;
import java.util.*;
public class FourInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] res = fourInt(0,2,5,9);
		int value = Math.abs(res[0] - res[1]) + Math.abs(res[1] - res[2]) + Math.abs(res[2] - res[3]);
		System.out.println(value);
	}

	public static int[] fourInt(int a, int b, int c, int d) {
		int[] arr = new int[4];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		Arrays.sort(arr);
		swap(arr, 0, 1);
		swap(arr, 2, 3);
		swap(arr, 0, 3);
		return arr;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
