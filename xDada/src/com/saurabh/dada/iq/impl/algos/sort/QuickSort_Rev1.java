package com.saurabh.dada.iq.impl.algos.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort_Rev1 {

	private static int[] list = {1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8};
	private static List<Integer> ll = Arrays.asList(1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8);
	
	public static void main(String[] args) {
		quickSort(list,0, list.length - 1);
		System.out.print("Sorted List: [");
		for(int item: list){
			System.out.print(item + ", ");
		}
		System.out.println("]");
		Collections.sort(ll);
		System.out.println("Sorted List: " + ll);
	}

	public static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivotI = high;
		int pivot = arr[pivotI];
		int p = low;
		for(int i=low;i<high;i++) {
			if(arr[i]<pivot) {
				exchange(arr, i, p);
				p++;
			}
		}
		exchange(arr, p, pivotI);
		return p;
	}
	
	public static void exchange(int[] arr,int x, int y) {
		int t = arr[x];
		arr[x]=arr[y];
		arr[y]=t;
	}
}
