package com.saurabh.dada.iq.impl;

public class String_InternMethod {

	public static void main(String[] args) {

		String s1 = "Rakesh";
		String s2 = "Rakesh";
		String s4 = new String("Rakesh");
		String s5 = new String("Rakesh").intern();

		if ( s1 == s2 ){
		    System.out.println("s1 and s2 are same");  // 1.
		}

		if ( s1 == s4 ){
		    System.out.println("s1 and s4 are same" );  // 3.
		}
		else {
			System.out.println("s1 and s4 are NOT same" );  // 2.
		}

		if ( s1 == s5 ){
		    System.out.println("s1 and s5 are same" );  // 4.
		}

	}

}
