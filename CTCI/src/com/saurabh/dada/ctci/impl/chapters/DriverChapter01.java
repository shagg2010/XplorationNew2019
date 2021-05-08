package com.saurabh.dada.ctci.impl.chapters;

import com.saurabh.dada.ctci.impl.chapters.logic.Chapter01_StringAndArrayProblems;

public class DriverChapter01 {
	
	public static void main(String[] args){
		//checking duplicates in String
		boolean ans1 = Chapter01_StringAndArrayProblems.problem1("DriverD");
		System.out.println("Answer 1: " + ans1);
		
		//one string is permutation of the other
		boolean ans3 = Chapter01_StringAndArrayProblems.problem3("lala", "laal");
		System.out.println("Answer 3: " + ans3);
		
		//compress string for duplicate sequences of char
		String ans5 = Chapter01_StringAndArrayProblems.problem5("aabbccc");
		System.out.println("Answer 5: " + ans5);
		
		//delete duplicates chars from String without additional memory
		String ans3_1_v1 = Chapter01_StringAndArrayProblems.problem3_1_v1("aabbcccd");
		System.out.println("Answer 3: " + ans3_1_v1);
		
		//delete duplicates chars from String without additional memory - without additional boolean array
		String ans3_1_v2 = Chapter01_StringAndArrayProblems.problem3_1_v2("aabbcccd");
		System.out.println("Answer 3: " + ans3_1_v2);
			
		//check substring with help of only call to isSubString method
		boolean ans8 = Chapter01_StringAndArrayProblems.problem8_isSubString("apple", "pleap");
		System.out.println("Answer 8: " + ans8);
		ans8 = Chapter01_StringAndArrayProblems.problem8_isSubString("apple", "ppale");
		System.out.println("Answer 8: " + ans8);
		
	}

}


