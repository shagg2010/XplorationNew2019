package com.saurabh.dada.iq.impl;

public class MinimumWithoutUsingComparisonAndIf {

	public static void main(String[] args) {
		System.out.println(getMax(5, 10));

	}
	
	public static int getMax(int a, int b) {
	    int c = a - b;
	    int k = (c >> 31) & 0x1;
	    int max = a - k * c;
	    return max;
	}
	/** Let's dissect this. This first line is straightforward - it stores the difference of a and b. 
	 * This value is negative if a < b and is nonnegative otherwise.
	 */
	/** here idea is to check if the value of c is negative. In virtually all modern computers, 
	 * numbers are stored in a format called two's complement in which the highest bit of the number is 0 
	 * if the number is positive and 1 if the number is negative. Moreover, most ints are 32 bits.  (c >> 31) shifts the number down 31 bits, 
	 * leaving the highest bit of the number in the spot for the lowest bit. The next step of taking this number 
	 * and ANDing it with 1 (whose binary representation is 0 everywhere except the last bit) erases all the higher bits 
	 * and just gives you the lowest bit. Since the lowest bit of c >> 31 is the highest bit of c, 
	 * this reads the highest bit of c as either 0 or 1. Since the highest bit is 1 iff c is 1, 
	 * this is a way of checking whether c is negative (1) or positive (0). 
	 * Combining this reasoning with the above, k is 1 if a < b and is 0 otherwise
	 */
	
}
