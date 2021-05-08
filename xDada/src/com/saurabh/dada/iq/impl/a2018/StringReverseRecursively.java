package com.saurabh.dada.iq.impl.a2018;

public class StringReverseRecursively {

	public static void main(String[] args) {
		String str = "0123456789";
		String str1 = reverse(str);
		System.out.println(str);
		System.out.println(str1);
	}

	public static String reverse(String string) {
		if(string.length()<2) {
			return string;
		}
		return reverse(string.substring(1)) + string.charAt(0);
	}
}
