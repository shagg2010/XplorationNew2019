package com.saurabh.dada.iq.impl.vipin;

/**
 *	 program given two strings and print common character from both: 
 *		Input: bangalore mysore 
 *		output: or 
 */

@SuppressWarnings("unused")
public class CommonCharacter {

	boolean [] flag = new boolean[200];
	
	
	public void commonChar(String one, String two){
		
		String temp1 = one;
		String temp2  = two;
		
		for (char c  : one.toCharArray()) {
			if(flag[c] == false)
			flag[c] = true;
		}
		
		for (char c  : two.toCharArray()) {
			if(flag[c]== true)
				System.out.println(c);
		}
	}
	
	
	public static void main(String[] args) {
		new CommonCharacter().commonChar("saurabh", "vipinsh");
	}

}
