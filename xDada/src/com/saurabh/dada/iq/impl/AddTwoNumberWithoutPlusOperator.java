package com.saurabh.dada.iq.impl;

public class AddTwoNumberWithoutPlusOperator {

	public static void main(String[] args) {
		//System.out.println(sum(-10,-8));
		System.out.println(sum(15,10));
	}
	
	public static int sum(int x,int y){
		while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	        System.out.println("carry: " + Integer.toBinaryString(carry));
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	        System.out.println("x: " + Integer.toBinaryString(x));
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	        System.out.println("y: " + Integer.toBinaryString(y));
	    }
	    return x;
	}

}
