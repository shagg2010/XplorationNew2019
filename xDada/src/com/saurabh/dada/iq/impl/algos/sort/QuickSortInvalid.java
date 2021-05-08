package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class QuickSortInvalid extends AbstractSort {

	//private static int[] list = {18,10,1,75,3,0,26,55,35,14,3};
	public static int[] listLong = {42,35,67,77,64,12,71,95,22,64,84,15,74,69,54,19,45,26,44,87,91,76,37,7,27,34,18,53,50,85,59,24,98,30,54,12,96,26,40,59,93,1,72,2,12,85,74,4,23,41,79,3,5,28,8,25,40,32,24,88,78,67,52,6,14,100,22,98,75,4,35,88,83,100,17,25,92,65,25,94,99,28,93,10,18,83,26,38,31,29,95,70,40,18,21,23,41,77,54,64};
	private static int[] list = {42,35,67,77,12,71,95,22,64,84,15,74,69,54,19};
	public static void main(String[] args) throws Exception {
		quickSortMine(list,0,list.length-1);
		
		//System.out.print("Sorted List: ");
		//displayArray(list);
		System.out.println("\n"+BinarySearch.isSorted(list));
	}
	
	public static void quickSortMine(int x[], int first, int last) throws InterruptedException {
		int i = first;
		int j = last;
		System.out.println("\ni:" + i + "   j:" +j);
		//Thread.sleep(5000);
		if(first<last){
			int pivot = x[first+(last-first)/2];
			displayArray(x);
			System.out.println("--------");
			System.out.println("pivot:" + pivot);
			System.out.println("--------");
			//Thread.sleep(250);
			while(i<=j && j>=first && i <= last){
				while (x[i] < pivot) {
					System.out.print(x[i] + "<" + pivot + " | ");
					//Thread.sleep(500);
					i++;
				}
				System.out.println("\nchecking left-array complete, i:"+i);
				while (x[j] > pivot) {
					System.out.print(x[j] + ">" + pivot + " | ");
					//Thread.sleep(500);
					j--;
				}	
				System.out.println("\nchecking right-array complete, j:"+j);
				System.out.println("i:" + i + "   j:" +j);
				//Thread.sleep(5000);
				if (i<=j) {
					System.out.println("swapping: " + x[i] + " & " + x[j]);
					//Thread.sleep(500);
					swap(x, i, j);
					i++;
					j--;
				}
				displayArray(x);
			}
			//Thread.sleep(20000);
			System.out.println("Element:" +x[j] + " sorted\n");
			quickSortMine(x, first, j-1);
			quickSortMine(x, j+1, last);
		}
		
		
	}
	
	public static void displayArray(int[] x){
		for(int item: x){
			System.out.print(item + " ");
		}
		System.out.println("\n");
	}
}
