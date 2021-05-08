package com.saurabh.dada.iq.impl.gfg;

public class Array_Reverse {

	private static int[] ITEMS1 = {0,1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) {
		int i=0,j=ITEMS1.length-1,t;
		
		while(i<j){
			t=ITEMS1[i];
			ITEMS1[i]=ITEMS1[j];
			ITEMS1[j]=t;
			System.out.println("swapping: " + ITEMS1[i] + " & " + ITEMS1[j]);
			i++;
			j--;
		}
		
		for(int k:ITEMS1){
			System.out.print(k+" ");
		}
	}

}
