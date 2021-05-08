package com.saurabh.dada.iq.impl;

public class Method_Overloading {

	public static void main(String[] args) {
		sum(10,10);

	}
	
	public static void sum(double a,double b){
		System.out.println("two args");
	}

	public static void sum(double a,double ... arr){
		System.out.println("many args");
	}
}
