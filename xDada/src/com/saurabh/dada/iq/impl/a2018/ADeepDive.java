package com.saurabh.dada.iq.impl.a2018;

public class ADeepDive {

	public static void main(String[] args) {
		for(int i=1;i<=50;i++)
			System.out.print(fibonacci(i) + " ");

	}
	
	public static int fibonacci(int number){
		if(number == 1 || number == 2){ 
			return 1; 
		} 
		return fibonacci(number-1) + fibonacci(number -2); //tail recursion }
	}

	

}
