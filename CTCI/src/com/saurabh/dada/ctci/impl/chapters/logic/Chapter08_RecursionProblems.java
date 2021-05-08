package com.saurabh.dada.ctci.impl.chapters.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter08_RecursionProblems {
	
	
	public static int generateNthFibonacciNumber(int n){
		return fibonacci(n);
	}
	
	private static int fibonacci(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else if(n>1)
			return fibonacci(n-1)+fibonacci(n-2);
		else
			return -1; //error condition
	}
	
	public static List<List<Integer>> findAllSubsets(int[] set){
		List<List<Integer>> ansList = new ArrayList<>();
		boolean[][] subsetMatrix = getSubsetMatrix(set.length);
		for(int i=0;i<subsetMatrix.length;i++){
			List<Integer> subset = new ArrayList<>();
			for(int j=0;j<subsetMatrix[i].length;j++){
				if(subsetMatrix[i][j]){
					//System.out.println(set[j]);
					subset.add(set[j]);
				}
			}
			ansList.add(subset);
		}
		return ansList;
	}
	
	private static boolean[][] getSubsetMatrix(int n){
		
		int rows=(int)Math.pow(2, n);
		int cols=Integer.toString(rows,2).length()-1;
		
		boolean[][] subsetMatrix = new boolean[rows][cols];
		char z = '0';
		for(int i=0;i<rows;i++){
			String str = Integer.toString(i, 2);
			if(str.length()<n){
				StringBuilder sb = new StringBuilder();
				int zeros = n-str.length();
				for(int p=0;p<zeros;p++){
					sb.append(z);
				}
				str=sb.toString()+str;
			}
			//System.out.println(str);
			for(int j=0;j<cols;j++){
				char[] items = str.toCharArray();
				if(items[j]=='1')
					subsetMatrix[i][j]=true;
				//System.out.print(subsetMatrix[i][j]+ "  ");
			}
			//System.out.println();
		}
		return subsetMatrix;
	}

	public static ArrayList<String> getAllPermutations(String str){
		ArrayList<String> permutations = new ArrayList<String>();
		if (str == null) { // error case
			return null;
		} else if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the first character
		ArrayList<String> words = getAllPermutations(remainder);
		//System.out.println("words: " + words);
		//System.out.println("permutations: " + permutations);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}
	
	private static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void allPossibleDenominations(int[] denoms, int balance, List<Integer> combinations,int startIndex){
		if(balance==0){
			System.out.println(combinations);
			return;
		}
		for(short i=0;i<denoms.length;i++){
			int remain=balance-denoms[i];
			if(remain<0)
				break;
			if(remain==0){
				System.out.println(combinations);
			}
			else{
				
			}
		}
	}
}
