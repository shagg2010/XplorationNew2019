package com.saurabh.dada.iq.impl;

import java.util.HashSet;

public class Array_PairEqualToGivenSum {

	public static int[] arr = {18,1,5,8,10,11,7,2,3,13,17,0};
	public static int sum = 18;
	
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length;i++){
			set.add(arr[i]);
		}
		//assume left+right=sum;
		for(int i=0;i<arr.length;i++){
			int left =  arr[i]; 
			int right=sum-left;
			if(set.contains(right)){
				System.out.println("Pair: {" +left + "," + right + "}");
				set.remove(left);
			}
		}
		
	}

}
