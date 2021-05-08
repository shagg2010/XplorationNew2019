package com.saurabh.dada.iq.impl;

public class SwappingWithXOROperator {

	public static void main(String[] args) {
		
		int x=10;
		int y=20;
		
		System.out.println("x: " +x + ",y:" + y);
		x=x^y;
		y=x^y;
		x=x^y;
		
		System.out.println("x: " +x + ",y:" + y);

		int a=0;
		int b=-5;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		
	}

}
