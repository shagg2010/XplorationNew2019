package com.saurabh.dada.ctci.impl.chapters.logic;

public class Chapter01_StringAndArrayProblems {

	//checking duplicates in string
	public static boolean problem1(String word){	
		boolean[] bitmap = new boolean[256];
		
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			if(!bitmap[(int)c]){
				bitmap[(int)c]=true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	//one string is permutation of the other
	public static boolean problem3(String str1,String str2){
		if(str1.length()!=str2.length())
			return false;
		char[] characters = str1.toCharArray();
		StringBuilder sbSecond = new StringBuilder(str2);
		for (char ch : characters) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				//remove the char which is found
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}
	
	//compress string for duplicate sequences of char
	public static String problem5(String str){
		if(str.length()<2){
			return str;
		}
		char[] carrI = str.toCharArray();
		int count=1;
		char c=carrI[0];
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<carrI.length;i++){
			//System.out.print("c"+i+": " + c + ",");
			if(carrI[i]!=c){
				sb.append(c).append(count);
				c=carrI[i];
				count=1;
			}
			else{
				count++;
			}
			//System.out.print(sb + "  ");
			if(i==carrI.length-1){
				sb.append(c).append(count);
			}
			if(sb.length()>=str.length()){
				return str;
			}
		}
		return sb.toString();
	}
	
	//delete duplicates chars from String without additional memory
	public static String problem3_1_v1(String str){
		StringBuilder out = new StringBuilder();
		boolean[] ascii = new boolean[255];
		for(int i=0;i<str.length();i++){
			if(!ascii[str.charAt(i)]){
				ascii[str.charAt(i)]=true;
				out.append(str.charAt(i));
			}
		}
		return out.toString();
	}
	
	//delete duplicates chars from String without additional memory - without additional boolean array
	public static String problem3_1_v2(String str) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (out.indexOf(""+str.charAt(i))==-1) {
				out.append(str.charAt(i));
			}
		}
		return out.toString();
	}
	
	//write a method isSubstring which checks if one word is a substring of another. 
	//Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to 
	//isSubstring 
	//input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap
	public static boolean problem8_isSubString(String str,String sub) {
		StringBuilder sb = new StringBuilder(sub);
		sb.append(sub);
		if(sb.indexOf(str)==-1)
			return false;
		else
			return true;
	}
	
}
