package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;

public class Permutations_Integer {

	private static List<Integer> list = new ArrayList<Integer>();
	private static StringBuilder sb = new StringBuilder("1234");
	
	/***************
	 * 
	 * This implementation is WRONG, recursive way is very complex
	 * https://www.geeksforgeeks.org/johnson-trotter-algorithm/
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder(sb.toString());
		
		for(int i=0;i<sb.length();i++) {
			char iChar = sb.charAt(i); // put this constant in all places/indexes
			for(int j=0;j<sb.length();j++) {
				char jChar = sb.charAt(j);
				sb.setCharAt(j, iChar); // put i in place of j
				sb.setCharAt(i, jChar); // put j in place of i
				System.out.println(sb);
				sb = new StringBuilder(sb1.toString());
				//System.out.println(i + "," + j);
			}
			
		}

	}

}
