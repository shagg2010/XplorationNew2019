package com.saurabh.dada.iq.impl.iq.fiberlink;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SubPalindromes {

	public static String str = "dddd";
	
	public static void main(String[] args) {
		//System.out.println(checkPalindrome(str.toCharArray()));
		System.out.println(subPalindromes(str));
		
	}

	
	/*public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < N; i++) {
			System.out.println(subPalindromes(arr[i]));
		}

	}*/
    
    public static int subPalindromes(String str){
		int count=0;
		if(str.length()==0)
			return 0;
		else if(str.length()==1)
			return 1;
		else if(str.length()==2){
			char[] chars = str.toCharArray();
			if(chars[0]==chars[1])
				return 2;
			else
				return 0;
		}
		else{
			char[] chars = str.toCharArray();
			HashSet<String> set=new HashSet<String>();
			String sub;
			for(int c=0 ;c<chars.length;c++){
		         for(int i=1;i<=chars.length-c;i++){
		            sub = str.substring(c, c+i);
		            //System.out.println("sub: " + sub);
		            //if(set.add(sub)){
		            	if(checkPalindrome(sub)){
		            		count++;
		            		System.out.println("sub: " + sub);
		            	}
							
		            //}
		         }
		      }
			
		}
		return count;
	}
	
	public static boolean checkPalindrome(String str){
		//System.out.println("palin: " + str);
		char[] chars = str.toCharArray();
		int i=0;
		int j=chars.length-1;
		boolean result=true;
		while(i<j){
			if(chars[i]!=chars[j]){
				result=false;
				break;
			}
			++i;
			--j;
		}
		//System.out.println("[" + result + "]");
		return result;
	}
	
}
