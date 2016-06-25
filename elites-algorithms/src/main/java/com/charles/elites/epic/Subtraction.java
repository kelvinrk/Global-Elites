package com.charles.elites.epic;

import java.util.ArrayList;
import java.util.List;


public class Subtraction {
	public static void main(String[] args) {
		int[] a = new int[]{4,6,2,5};
		int[] b = new int[]{4,5,3,5};
		List<Integer> res = subtract(a, b);
		System.out.println(res);
	}
	private static List<Integer> subtract(int[] a, int[] b) {
		List<Integer> res = new ArrayList<Integer>();
		int la = a.length;
		int lb = b.length;
		boolean sign = false;
		int i = 0;
		if(lb > la)
			sign = true;
		else if(lb == la) {
			while(i < la && a[i] == b[i])
				i++;
			if(i == la) {
				res.add(0);
				return res;
			} else {
				if(b[i] > a[i]) 
					sign = true;
			}
		}
		int pa = la - 1;
		int pb = lb - 1;
		int carry = 0;
		int val = 0;
		if(sign) {
			while(pa >= 0 || pb >= 0) {
				int numB = b[pb];
				int numA = pa >= 0 ? a[pa] : 0;
				
				if(carry + numB - numA >= 0) {
					val = carry + numB - numA;
					carry = 0;
				} else {
					val = 10 + carry + numB - numA;
					carry = -1;
				}
				res.add(0, val);
				pa--;
				pb--;
			}
			i = 0;
			while(res.get(i) == 0) {
				res.remove(i);
			}
			res.set(0, -res.get(0));
		}else {
			while(pa >= 0 || pb >= 0) {
				int numB = pb >= 0 ? b[pb] : 0;
				int numA = a[pa];
				
				if(carry + numA - numB >= 0) {
					val = carry + numA - numB;
					carry = 0;
				} else {
					val = 10 + carry + numA - numB;
					carry = -1;
				}
				res.add(0, val);
				pa--;
				pb--;
			}
			i = 0;
			while(res.get(i) == 0) {
				res.remove(i);
			}
		}
		return res;
	}
}
