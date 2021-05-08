package com.saurabh.dada.iq.impl.iq.hcl;

import java.util.Arrays;

public class LongestSubStringWithUniqueCharacters {
	
	static boolean[] bits = new boolean[256];
	//static String str = "abcdeabcdefg"; 
	static String str = "ababcdef";

	public static void main(String[] args) {
		System.out.println(getLengthOfLongestUniqueCharSubstring(str));
	}

	public static int getLengthOfLongestUniqueCharSubstring(String str){
		int max=1;
		char[] carr = str.toCharArray();
		for(int i=0;i<carr.length;i++){
			resetBits(bits);
			int temp=0;
			bits[(int)carr[i]] = true;
			System.out.println("starting element: " + carr[i]);
			for(int j=i+1;j<carr.length;j++){
				if(!bits[(int)carr[j]]){
					temp=(j+1)-i;
					System.out.print(j+ "["+temp+"] " );
				}
				else{										
					resetBits(bits);
					break;
				}
			}
			max = max>temp?max:temp;
			System.out.println();
		}
		return max;
	}
	public static void resetBits(boolean[] bits){
		Arrays.fill(bits, false);
	}
}
