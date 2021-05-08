package com.saurabh.dada.iq.impl;

public class Array_ReverseOfAnArray {

	private static int[] list = {2,3,1,4,5,6,8,10,10};
	
	public static void main(String[] args) {
		int i=0,j=list.length-1;
		
		while(i<=j){
			int temp=list[i];
			list[i]=list[j];
			list[j]=temp;
			i++;
			j--;
		}

		for(int item:list){
			System.out.print(item+ ", ");
		}
	}

}
