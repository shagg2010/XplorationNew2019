package com.saurabh.dada.iq.impl;

public class String_AllPermutations {

	//http://javarevisited.blogspot.in/2015/08/how-to-find-all-permutations-of-string-java-example.html
	
	public static void main(String[] args) {
		permutation("1234");
	}

	public static void permutation(String input) {
		permutation2("", input);
	}
	
	public static void permutation(String constantChars, String word) {
		if(word.isEmpty()) {
			System.out.println(constantChars);
		}
		else {
			for(int i=0;i<word.length();i++) {
				permutation(constantChars + word.charAt(i), word.substring(0, i) + word.substring(i+1, word.length()));
			}
		}
	}

	private static void permutation2(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println(perm);
		} else {
			for (int i = 0; i < word.length(); i++) {
				String split1 = word.substring(0, i);
				String split2 = word.substring(i + 1, word.length());
				char c = word.charAt(i);
				//System.out.println("p: " + perm + " c:" + c + " s1:" + split1 + " s2:" + split2);
				permutation2(perm + c, split1 + split2);
			}
		}
	}

}
