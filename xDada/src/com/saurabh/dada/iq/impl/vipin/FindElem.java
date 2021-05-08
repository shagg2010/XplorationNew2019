package com.saurabh.dada.iq.impl.vipin;

import java.util.Arrays;

/**
 *	Suppose you have a sorted array of infinite numbers, 
 *	how would you search an element in the array
 */

public class FindElem {
	
	static Integer arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
	static int key = 10;

	static public void findElem(Integer [] arr, int key){
		int low = 0,high = 1;
		int resTemp=0;
		while(low < high){
			if(arr[low] > key){
				high = low;
				low = Arrays.asList(arr).indexOf(key);
				resTemp = Arrays.binarySearch(arr, low, high, key);
				if(resTemp != -1){
					System.out.println(resTemp);
				}
			}else if(arr[high] < key){
				low = high;
				high = Arrays.asList(arr).indexOf(key);
				resTemp = Arrays.binarySearch(arr, low, high, key);
				if(resTemp != -1){
					System.out.println(resTemp);
				}
			}else if (arr[low]<key && arr[high] > key){
				resTemp = Arrays.binarySearch(arr, low, high, key);
				if(resTemp != -1){
					System.out.println(resTemp);
				}
			}else{
				low ++;
				high++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		findElem(arr, 10);
	}

}
