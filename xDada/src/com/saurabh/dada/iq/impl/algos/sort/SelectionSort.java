package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class SelectionSort extends AbstractSort {

	private static int[] list = {18,92,76,45,27,81,34,58,66,5};
	
	public static void main(String[] args) {
		
		sort(list);
		System.out.print("Sorted List: ");
		for(int item: list){
			System.out.print(item + " ");
		}
		System.out.println("\n"+BinarySearch.isSorted(list));
	}
	
	public static void sort(int[] list){
		
		int n=list.length;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				compareAndSwap(list, i, j, ASCENDING);
			}
		}
	}
}
