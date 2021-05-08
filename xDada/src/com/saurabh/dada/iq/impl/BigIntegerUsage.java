package com.saurabh.dada.iq.impl;

import java.math.BigInteger;

public class BigIntegerUsage {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int N = 150;
		System.out.println(factorial(N));
		long end = System.nanoTime(); 
        System.out.println("Operation took: " + (end - start) + " nano-seconds!"); 

	}
	
	static BigInteger factorial(int N){ 
        // Initialize result 
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE 
  
        // Multiply f with 2, 3, ...N 
        for (int i = 2; i <= N; i++) 
            f = f.multiply(BigInteger.valueOf(i)); 
  
        return f; 
    } 

}
