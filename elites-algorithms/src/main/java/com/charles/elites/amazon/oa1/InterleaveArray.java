package com.charles.elites.amazon.oa1;

public class InterleaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,7,9,2,4,6,8,10};
		interleave(a);
		for(Integer i : a)
			System.out.println(i);
	}
	
	public static void interleave(int arr[]) {
		int n = arr.length / 2;
		for (int i = 1; i < n; i++) { // my step no.
			for (int j = 0; j < i; j++) { // no. of swaps
				swap(arr, n - i + 2 * j, n - i + 2 * j + 1);
				for(int x : arr)
					System.out.print(x + " ");
				System.out.println();
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
