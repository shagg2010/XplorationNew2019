package com.saurabh.dada.iq.impl.vipin;

import java.util.Arrays;

public class VipinStringSort {

	public static void main(String[] args) {
		
		String str = "01201210202102";  //size=13
		//String str = "012102";
		//Output Provided - 00000111122222
		
		
		char[] arr = str.toCharArray();
		//replace 0's with 2's
		for(int i=0,j=arr.length-1;i<arr.length;i++){
			if(arr[i]=='2'){
				while(j>i&&!(arr[j]=='0')){
					j--;
				}
				System.out.println(i+" " + j);
				swap(arr, j, i);
			}
			//System.out.println(new String(arr));
		}
		
		for(char c:arr){
			System.out.print(c);
		}
		
		//replace 0's with 1's
		for(int i=0,j=arr.length-1;i<arr.length;i++){
			if(arr[i]=='1'){
				while(j>i&&!(arr[j]=='0')){
					j--;
				}
				System.out.println(i+" " + j);
				swap(arr, j, i);
			}
			//System.out.println(new String(arr));
		}
		
		for(char c:arr){
			System.out.print(c);
		}
	}
	
	public static void swap(char[] arr,int index1,int index2){
		char c = arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=c;
		
	}

}
