package com.charles.elites.epic;

public class Goldbach {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Goldbach");
		int check_value = 100;
		int i;
		if(check_value%2 != 0){
			System.out.println("Invalid input");
		}
		else{
			for(i=3; i<check_value/2; i=i+2){
				if(isPrime(i) && isPrime(check_value-i)){
					System.out.println("Goldbach of "+ check_value +"= "+ i + " & "+(check_value-i));
				}
			}
		}
	}
	public static boolean isPrime(int n){
		int i;
		if(n%2 == 0){
			return false;
		}
		for(i=3; i<Math.sqrt(n); i=i+2){
			if(n%i ==0){
				return false;
			}
		}
		return true;
	}
}
