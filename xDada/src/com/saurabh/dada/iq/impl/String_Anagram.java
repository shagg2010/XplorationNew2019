package com.saurabh.dada.iq.impl;

import java.util.Arrays;

public class String_Anagram {

	/**
	 * By the way two String are called anagram, if they contains same characters but on different order e.g. army and mary, stop and pots etc. 
	 * Anagrams are actually mix-up of characters in String. If you are familiar with String API, i.e. java.lang.String than you can easily solve 
	 * this problem. In order to check if  Strings are anagram, you need to get there character array and see if they are equal or not. 
	 * Though you can also use indexOf(), substring() and StringBuffer or StringBuilder  class to solve this question.
	 */
	public static void main(String[] args) {
		
		System.out.println(checkAnagram("yadav", "davay"));

	}
	
	public static boolean iAnagram(String word, String anagram) {
		char[] charFromWord = word.toCharArray();
		char[] charFromAnagram = anagram.toCharArray();
		Arrays.sort(charFromWord);
		Arrays.sort(charFromAnagram);
		return Arrays.equals(charFromWord, charFromAnagram);
	}
	
	public static boolean checkAnagram(String first, String second) {
		char[] characters = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);
		for (char ch : characters) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				//remove the char which is found
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}
	
	//string memory leak with this approach but not from Java 6
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		char[] chars = word.toCharArray();
		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				//remove the char which is found
				anagram = anagram.substring(0, index)
						+ anagram.substring(index + 1, anagram.length());
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

}
