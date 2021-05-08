package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class BubbleSort extends AbstractSort{
	
	private static int[] list = {18,92,76,45,27,81,34,58,66,5};

	public static void main(String[] args) {
		
		bubbleSort(list);
		System.out.print("Sorted List: ");
		for(int item: list){
			System.out.print(item + " ");
		}
		System.out.println("\n"+BinarySearch.isSorted(list));
	}
	
	public static int[] bubbleSort(int[] list){
		int n = list.length-1;
		if(n>1){
			int i = 0;
			while(i<n){
				int j=0;
				while(j<n-i){
					//System.out.println("j:" + j + ", i:" +i);
					compareAndSwap(list, j, j+1,Sort.ASCENDING);
					j++;
				}
				i++;
			}			
		}	
		return list;
	}
	
}
