package com.saurabh.dada.iq.impl;

public class String_Palindrome {

	public static void main(String[] args) {
		
		String str = "malayalam";
		char[] carr = str.toCharArray();
		
		int i=0;
		int j=carr.length-1;
		boolean flag=true;
		while(i<=j){
			if(carr[i]!=carr[j]){
				flag=false;
				break;
			}
			i++;
			j--;
		}

		if(flag){
			System.out.println("Palindrome!");
		}
		else{
			System.out.println("Not Palindrome!");
		}
	}

}
