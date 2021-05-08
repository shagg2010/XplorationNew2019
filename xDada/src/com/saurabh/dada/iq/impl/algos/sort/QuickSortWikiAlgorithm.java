package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class QuickSortWikiAlgorithm {

	private static int[] list = {1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8};
	
	public static void main(String[] args) {
		QuickSortInvalid.displayArray(list);
		quickSort(list,0, list.length - 1);
		System.out.print("Sorted List: ");
		for(int item: list){
			System.out.print(item + " ");
		}
		System.out.println("\n"+BinarySearch.isSorted(list));

	}
	
	public static void quickSort(int[] arr,int low,int high){
		if(low<high){
			int p=partition(arr, low, high);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}
	
	private static int partition(int[] arr,int low,int high){
		int pivotI = high;
		int pivot = arr[pivotI];
		System.out.println("Pivot: " + pivot);
		int p=low;
		for(int i=low;i<high;i++){
			//int temp = arr[i];
			if(arr[i]<pivot){
				System.out.println("Exchaging: " + arr[i] + ","+arr[p] + "\tcurr: " + arr[i]);
				exchange(arr, i, p);
				p++;
			}
		}
		exchange(arr, p, pivotI);
		QuickSortInvalid.displayArray(list);
		return p;
	}
	
	private static void exchange(int[] list, int i, int j) {
	    int temp = list[i];
	    list[i] = list[j];
	    list[j] = temp;
	  }

}
