package com.charles.elites.epic;

public class SwappingString {
	public static void main(String[] args) {
		swap("zhiyangwang", "wangzhiyang");
	}
	private static void swap(String s1, String s2) {
		char a[] = s1.toCharArray();
		char b[] = s2.toCharArray();
		char temp;
		int n = b.length;
		int j, i = 0;
		while (n > i) {
			j = i;
			while (a[j] != b[i]) {
				j++;
			}
			while (j > i) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				System.out.println(a);
				j--;
			}
			i++;
		}
	}
}
