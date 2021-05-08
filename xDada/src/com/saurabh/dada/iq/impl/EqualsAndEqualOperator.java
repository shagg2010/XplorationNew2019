package com.saurabh.dada.iq.impl;

public class EqualsAndEqualOperator {

	public static void main(String[] args) {
		
		String obj1 = new String("xyz");
		String obj2 = new String("xyz");

		if(obj1 == obj2)
		   System.out.println("obj1==obj2 is TRUE");
		else
		  System.out.println("obj1==obj2 is FALSE");
		
		obj2 = obj1;
		
		if(obj1 == obj2)
			   System.out.println("obj1==obj2 is TRUE");
			else
			  System.out.println("obj1==obj2 is FALSE");
		
		String str1 = new String("xyz");
		String str2 = new String("xyz");

		if(str1.equals(str2))
		   System.out.println("str1==str2 is TRUE");
		else
		  System.out.println("str1==str2 is FALSE");

	}

}
