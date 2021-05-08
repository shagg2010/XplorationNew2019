package com.saurabh.dada.iq.impl;

import java.util.HashSet;
import java.util.Set;

public class String_AllPossibleSubStrings {

	private static String str = "madam";
	
	public static void main(String[] args) {
		subStrings(str);
		
		subString(str, str.length());
		subStringGFG(str, str.length());
	}
	
	public static void subStrings(String str){
		Set<String> set  = new HashSet<String>();
		char[] chars = str.toCharArray();
		String sub;
		for(int c=0 ;c<chars.length;c++){
	         for(int i=1;i<=chars.length-c;i++){
	            sub = str.substring(c, c+i);
	            //System.out.print(sub+", ");
	            set.add(sub);
	         }
	         //System.out.println();
	      }
		System.out.println(set + "\nTotal: " + set.size());
	}

	public static void subString(String str, int n) {
		Set<String> set  = new HashSet<String>();
		for (int i = 0; i < n; i++) 
           for (int j = i+1; j <= n; j++) {
        	   String sub = str.substring(i, j);
        	   //System.out.println(sub);
        	   set.add(sub);
                // Please refer below article for details
                // of substr in Java
                // https://www.geeksforgeeks.org/java-lang-string-substring-java/
           }
       System.out.println(set + "\nTotal: " + set.size());
	}
	
	public static void subStringGFG(String str, int n) {
		Set<String> set  = new HashSet<String>();
		for(int i=0;i<n;i++)
			for(int j=i+1;j<=n;j++) {
				set.add(str.substring(i, j));
			}
		 System.out.println(set + "\nTotal2: " + set.size());
	}
}
