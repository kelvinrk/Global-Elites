package com.charles.elites.amazon.oa1;

public class GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 13;
		byte b = 15;
		System.out.println(checkGray(a, b));
	}
	
	public static int checkGray(byte a, byte b) {
		if(a == b)
			return 0;
		byte x = (byte)(a ^ b);
		x = (byte)(x & (x - 1));
		return x == 0 ? 1 : 0;
	}
}
