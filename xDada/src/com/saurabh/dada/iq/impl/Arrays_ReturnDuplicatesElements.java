package com.saurabh.dada.iq.impl;

public class Arrays_ReturnDuplicatesElements {

	private static int[] arr = {1,2,3,4,5,6,7,8,9,1,2,3};
	
	public static void main(String[] args) {
		int max = getMaxVal(arr);
		boolean[] bits = new boolean[max+1];
		for(int i:arr){
			if(!bits[i]){
				bits[i]=true;
			}
			else{
				System.out.println(i);
			}
		}

	}
	
	public static int getMaxVal(int[] arr){
		int max=arr.length==0?0:Integer.MIN_VALUE;
		for(int i:arr){
			max = Math.max(max, i);
		}
		return max;
	}

}
