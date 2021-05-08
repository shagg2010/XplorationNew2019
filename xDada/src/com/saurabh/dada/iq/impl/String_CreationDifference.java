package com.saurabh.dada.iq.impl;

public class String_CreationDifference {

	public static void main(String[] args) {
		String a = "abcd";
		String b = "abcd";
		System.out.println(a == b);  // True - returns true only if both variable points to same variable
		System.out.println(a.equals(b)); // True
		
		String c = new String("abcd");
		String d = new String("abcd");
		System.out.println(c == d);  // False
		System.out.println(c.equals(d)); // True
		System.out.println(a == d); //false
		
		String s1="Welcome";  
		String s2=new String("Welcome"); 
		
		System.out.println("s1 == s2:" + s1 == s2); //false
		s2 = s2.intern();
		System.out.println("s1 == s2: " + s1 == s2);//true
		
		int result = getSum(5);
		System.out.println(result);

	}

	
	static int getSum(int num) {
		int sum=0;
        if(num>0){
        	sum = num + getSum(num-1);
        }
        return sum;

    }
}
