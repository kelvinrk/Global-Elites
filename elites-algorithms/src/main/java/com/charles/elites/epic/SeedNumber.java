package com.charles.elites.epic;

public class SeedNumber {
	public static void main(String[] args) {
		seed(1536);
	}
	private static void seed(int num) {
	    int product = 1;
	    int seed = (int) Math.sqrt(num);

	    while (seed <= num){
	        if (num % seed == 0){
	            int factor = seed;
	            product = factor;
	            while(!(factor == 0)){
	                int mod = factor % 10;
	                factor = factor / 10;
	                product *= mod;
	            }
	            if (product == num){
	                System.out.println("The seed of " + num + " is " + seed);
	            }
	        }
	        seed++;
	    }
	}
}
