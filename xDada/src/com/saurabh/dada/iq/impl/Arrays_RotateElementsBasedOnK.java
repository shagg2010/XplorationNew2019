package com.saurabh.dada.iq.impl;

public class Arrays_RotateElementsBasedOnK {

	public static int[] arr = {1,2,3,4,5,6,7,8};
	
	public static void main(String[] args) {
		
		rotate(arr, 2);
		for(int i:arr){
			System.out.print(i + " ");
		}

	}
	
	public static int[] rotate(int[] arr,int k){
		
		int temp = arr[arr.length-1];
		for(int i=(arr.length-1);i>0;i--){
			arr[i]=arr[i-1];
		}
		arr[0]=temp;
		k--;
		if(k>0)
			rotate(arr, k);
		return arr;
	}

}
