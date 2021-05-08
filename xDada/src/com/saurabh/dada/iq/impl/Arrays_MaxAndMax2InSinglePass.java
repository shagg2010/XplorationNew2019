package com.saurabh.dada.iq.impl;

public class Arrays_MaxAndMax2InSinglePass {

	static int[] list = {0,1,2,3,4,5};
			//{-2,-3,-4,-5};
			//{5,4,3,2,1,0};
			//{0,1,2,3,4,5};
			//{-10,-3,-5,-1,-2,-8,-1};
			//{-10,-10,-10,-10,0};
			//{-5,-3,-1,-2,-4};
	
	public static void main(String[] args) {
	
		int max = list[0];
		int max2 = list[0];
		int prevMax = list[0];
		for(int i:list){
			if(i>max){
				prevMax=max;
				max=i;				
			}
			if(max2==max&&i<max)
				max2=i;
			if(prevMax>max2&&prevMax!=max)
				max2=prevMax;
			if(i>max2&&i<max)
				max2=i;
			//System.out.println(max + " " + max2 + " [" + i + "]");
		}
		if(max==max2)
			System.out.println("max: " + max + ", max2: null");
		else
			System.out.println("max: " + max + ", max2: " + max2);
		main2(list);
		maxTwo(list);
	}
	
	public static void main2(int[] array1){
        //int[] array1 = {10,2,3,7,5,12,12};
		Integer highest=array1[0];
		Integer secondHighest=null, counter; //Using Integer instead of int let us use null value otherwise we need to assign min value to secondHighest
		for(counter=array1.length-1;counter>0;counter--){
			if(highest<array1[counter]){
				secondHighest=highest;
				highest=array1[counter];				
			}else if(highest!=array1[counter] && secondHighest==null){
				secondHighest=array1[counter];
			}else if(highest!=array1[counter] && secondHighest<array1[counter]){
				secondHighest=array1[counter];
			}
		}
		System.out.print("Highest : " + highest);
		if(secondHighest != null);
		System.out.println(" 2nd Highest : " + secondHighest);
  }
	
	public static void maxTwo(int[] input) {
		int maxOne = input[0], maxTwo = -1;
		for (int i = 0; i < input.length; i++) {
			if (maxOne < maxTwo && maxOne != maxTwo) {
				// swap(maxOne,maxTwo);
				int temp = maxOne;
				maxOne = maxTwo;
				maxTwo = temp;
			} else if (input[i] > maxOne) {
				maxOne = input[i];
				maxTwo = maxOne;
			} else if (input[i] > maxTwo && input[i] != maxOne) {
				maxTwo = input[i];
			}
		}
		System.out.println("maxOne " + maxOne + " maxTwo " + maxTwo);

	}


}
