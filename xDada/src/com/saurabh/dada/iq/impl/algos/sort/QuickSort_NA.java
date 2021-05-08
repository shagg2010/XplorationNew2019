package com.saurabh.dada.iq.impl.algos.sort;

import com.saurabh.dada.iq.impl.algos.search.BinarySearch;

public class QuickSort_NA extends AbstractSort {

	//private static int[] list = QuickSort.listLong;
	//private static int[] list = {42,35,67,77,12,71,95,22,64,84,15,74,69,54,19};
	private static int[] list = {5,18,2,10,1,26};
	
	public static void main(String[] args) {
		quicksort(0, list.length - 1);
		System.out.print("Sorted List: ");
		for(int item: list){
			System.out.print(item + " ");
		}
		System.out.println("\n"+BinarySearch.isSorted(list));
	}
	
	private static void quicksort(int low, int high) {
	    int i = low, j = high;
	    // Get the pivot element from the middle of the list
	    int pivotV = low + (high-low)/2;
	    int pivot = list[pivotV];
	    System.out.println("\n\tPivot: " + pivot+"\n");

	    // Divide into two lists
	    while (i <= j) {
	      // If the current value from the left list is smaller then the pivot
	      // element then get the next element from the left list
	    	 QuickSortInvalid.displayArray(list);
	    	 //System.out.println();
	      while (list[i] < pivot) {
	    	  System.out.print(list[i] + "<" + pivot + " | ");
	        i++;
	      }
	      //System.out.println("\ni stopped: " + i);
	      // If the current value from the right list is larger then the pivot
	      // element then get the next element from the right list
	      while (list[j] > pivot) {
	    	  System.out.print(list[j] + ">" + pivot + " | ");
	        j--;
	      }
	     // System.out.println("\nj stopped: " + j);
	      // If we have found a values in the left list which is larger then
	      // the pivot element and if we have found a value in the right list
	      // which is smaller then the pivot element then we exchange the
	      // values.
	      // As we are done we can increase i and j
	      
	      System.out.println("\ni & j status: " + i + "," + j);	     
	      if (i <= j) {
	    	System.out.println("\nExchanging: " + list[i] + " & " + list[j]);  
	        exchange(i, j);	
	        	i++;
	        	j--;
	        //System.out.println("\ni & j status (post exchange): " + i + "," + j);
	      }
	      else{
	    	  System.out.println("No Exchange");
	    	  System.out.println();
	      }
	      QuickSortInvalid.displayArray(list);
	      System.out.println("\n-------------------------------------------------");
	    }
	    // Recursion
	    if (low < j)
	      quicksort(low, j);
	    if (i < high)
	      quicksort(i, high);
	  }

	  private static void exchange(int i, int j) {
	    int temp = list[i];
	    list[i] = list[j];
	    list[j] = temp;
	  }

}
