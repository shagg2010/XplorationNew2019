package com.saurabh.dada.iq.impl;

import java.util.Locale;

public class String_SwapAndModifyBehavior {

	public static void main(String[] args) {
		String a = "ABC";
		String b = "XYZ";
		swap(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		modify(a, b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void swap(String a,String b){
		String temp=a;
		a=b;
		b=temp;
		System.out.println("a.s: " + a);
		System.out.println("b.s: " + b);
	}
	
	public static void modify(String a,String b){
		a.toLowerCase();
		b=b.toLowerCase();
		System.out.println("a.m: " + a);
		System.out.println("b.m: " + b);
	}

}
