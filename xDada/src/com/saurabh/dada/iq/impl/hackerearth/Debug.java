package com.saurabh.dada.iq.impl.hackerearth;

import java.util.Arrays;

public class Debug {
	

	public static void main(String[] args) {
		
		int a1=10;
		int b1=20;
		int c = subtract(a1,b1);
		System.out.println("Ans: " + c);
		
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Long.MIN_VALUE, 0.0d));
		
		char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        System.out.println("str: " + str);
        byte[] bytes = str.getBytes();
        System.out.println("bytes.toString: "+Arrays.toString(bytes));
		
		double ans = 1.0/0.0;
		System.out.println(ans);
	
		Integer val=1/0;
		System.out.println(val);
		
		long x=9223372036854775807l;
		int d=8;
		
		long start = System.nanoTime();
		long a = x % d ;
		long end = System.nanoTime() - start;
		System.out.println("Total time taken: " + end + " a: " + a);
		
		start = System.nanoTime();
		
		a = fastModulo(x, d);
		end = System.nanoTime() - start;
		System.out.println("Total time taken: " + end + " a: " + a);
		
		
		
	}
	
	public static long fastModulo(long num, int divisor) {
		return num - (num/divisor) * divisor;
	}
	
	
	public static int subtract(int a,int b){
		int c = ~b;
		c++;
		System.out.println("b after negation (~): " + c);
		return a+c;
	}
}
