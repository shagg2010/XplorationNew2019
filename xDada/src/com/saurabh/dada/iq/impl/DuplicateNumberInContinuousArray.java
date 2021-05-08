package com.saurabh.dada.iq.impl;

public class DuplicateNumberInContinuousArray {

	//number 25 is duplicate
	public static int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
	
	public static void main(String[] args) {
		
		long actualSum = 0;
		for(int i=0;i<list.length;i++)
			actualSum+=list[i];

		System.out.println(actualSum);
		//Use Arithmetic Progression (A.P.) sum formula  (n*(a1+an))/2  
		long expectedSum = (list.length * (list[0] + list[list.length-1]))/2;
		//long expectedSum = ((list.length-1) * ((list.length-1) + 1)/2);
		//list.lenght-1 = because one number is duplicate
		System.out.println(expectedSum);
		
		long diff = expectedSum - actualSum;
		System.out.println(diff);
	}

}
