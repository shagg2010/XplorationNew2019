package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class QuicksortPractice {

	//private static int[] list = {5,18,2,10,1,26,6};
	private static int[] list = {1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8};
	
	public static void main(String[] args) {
		QuickSortInvalid.displayArray(list);
		quicksort(list,0, list.length - 1);
		System.out.print("Sorted List: ");
		for(int item: list){
			System.out.print(item + " ");
		}
		System.out.println("\n"+BinarySearch.isSorted(list));
	}
	
	public static void quicksort(int[] arr, int low, int high){
		if(low<high){
			int p = partition(arr, low, high);
			quicksort(arr, low, p-1);
			quicksort(arr, p+1, high);
		}
				
	}
	
	private static int partition(int[] arr,int low,int high){
		int pivotI = high;
		int pivot = arr[pivotI];
		exchange(arr, pivotI, high);
		int p=low;
		for(int i=low;i<high;i++){
			if(arr[i]<=pivot){
				exchange(arr, i, p);
				p++;
			}
		}
		exchange(arr, p, high);
		return p;
	}
	
	private static void exchange(int[] list, int i, int j) {
	    int temp = list[i];
	    list[i] = list[j];
	    list[j] = temp;
	  }

}
