package com.saurabh.dada.iq.impl;

public class String_Temp {

	public static void main(String[] args) {
		
		/*Integer[][] ints = { { 1, 2, 3 }, {}, { 7, 8, 9 } };
		System.out.println("value = " + ints[1][0].intValue());//ArrayIndexOutOfBoundsException
		
		Integer[][] ints1 = { { 1, 2, 3 }, {null}, { 7, 8, 9 } };
		System.out.println("value = " + ints1[1][0].intValue());//NullPointerException
		
		Integer[][] ints2 = { { 1, 2, 3 }, { null }, { 7, 8, 9 } };
		System.out.println("value = " + ints2[1][1].intValue());//ArrayIndexOutOfBoundsException
		*/
		
		String str = reverse("HelloWorld!");
		System.out.println(str);
	}

	public static String reverse(String str) {
		if(str==null||str.length()==0)
			return str;
		
		String reverse = "";
		reverse = reverse(str.substring(1)) + str.charAt(0);
		return reverse;
	}
}
