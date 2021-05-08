package com.saurabh.dada.iq.impl;

public class Array_SortOnesAndTwos {

	private static int[] array =  {0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1};
	
	public static void main(String[] args) {
		
		int i=0,j=array.length-1;
		while(i<=j){
			System.out.print("["+i+","+j+"]\t");
			if(array[i]==1&&array[j]==0){
				System.out.print("Swaping current indexes!");
				int temp = array[i];
				array[i]=array[j];
				array[j]=temp;
			}
			if(array[i]==0)
				i++;
			if(array[j]==1)
				j--;
			
			System.out.println("");
		}
		System.out.println("\n");
		for(int item:array){
			System.out.print(item+ ", ");
		}
	}

}
