package com.saurabh.dada.iq.impl;

public class BitShiftOperators {

	public static void main(String args[]) {
		int x=-4;
		System.out.println(x >> 1);
		System.out.println("Binary of 4: " + Integer.toBinaryString(4));
		System.out.println("HexaDecimal of 1361: " + Integer.toHexString(1358).toUpperCase());
		int y=4; //0100
		System.out.println(y >> 1); //0010
		y=10; //1010
		System.out.println(y >> 2); //0010
	}

}
