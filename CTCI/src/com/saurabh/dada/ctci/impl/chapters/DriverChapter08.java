package com.saurabh.dada.ctci.impl.chapters;

import java.util.List;

import com.saurabh.dada.ctci.impl.chapters.logic.Chapter08_RecursionProblems;

public class DriverChapter08 {
	
	private static int[] SET_ITEMS = {1,2,3};
	
	public static void main(String[] args) {
		
		
		
		int ans = Chapter08_RecursionProblems.generateNthFibonacciNumber(6);
		System.out.println("Ans: " + ans);
		
		List<List<Integer>> ansList = Chapter08_RecursionProblems.findAllSubsets(SET_ITEMS);
		System.out.println("Ans: ");
		for(List<Integer> set: ansList){
			System.out.print(set + "  ");
		}
		System.out.println();
		
		List<String> ans1 = Chapter08_RecursionProblems.getAllPermutations("abc");
		System.out.println("Ans: " + ans1);
		
		
	}

}
