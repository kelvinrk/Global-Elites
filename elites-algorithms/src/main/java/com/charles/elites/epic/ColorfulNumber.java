package com.charles.elites.epic;

import java.util.HashSet;
import java.util.Set;
public class ColorfulNumber {
	public static boolean isColorful(int number){
		if(number < 10) return true;
		
		String colorString = String.valueOf(number);
		int length = colorString.length();
		
		Set<Integer> colorMap = new HashSet<Integer>();
		
		for(int i =  1; i < length; i++){
			for (int j = 0;  j+i <= length; j++){
				String sub = colorString.substring(j, j+i);
				int product = getProduct(Integer.parseInt(sub));
				if(colorMap.contains(product)) return false;
				else{
					colorMap.add(product);
				}
			}
		}
		return true;
	}
	private static int getProduct(int digits) {
		if(digits < 10) return digits;
		int num = digits;
		int product = 1;
		while(num > 0){
			product = product * (num % 10);
			num = num / 10;
		}
		return product;
	}

	public static void main(String[] args) {
		System.out.println(isColorful(236));
	}
}
