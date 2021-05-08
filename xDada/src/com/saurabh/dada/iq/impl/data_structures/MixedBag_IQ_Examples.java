package com.saurabh.dada.iq.impl.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.saurabh.dada.iq.impl.WorkerFileMain;

public class MixedBag_IQ_Examples {

	public static void main(String[] args) {
		nextGreaterElement();
		int arr [] = {1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8};
		System.out.println("\tlen: " + arr.length);
		quickSort(arr,0 , arr.length-1);
		displayArray(arr);
		System.out.println("\tlen: " + arr.length);
		//System.out.println("Sorted: " + isSorted(arr));
		//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 1, 4, 5, 2, 3, 6));
		List<Integer> result = slidingWindowMaximumOfSizeK(list, 3);
		System.out.println("Sliding Window Maximums are: " + result);
		
		List<Integer> list1 = new ArrayList<>();
		list1.addAll(Arrays.asList(8, 5, 10, 7, 9, 4, 15, 12, 90, 13));
		List<Integer> result1 = slidingWindowMaximumOfSizeK(list1, 3);
		System.out.println("Sliding Window Maximums are: " + result1);
		
		//https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
		List<Integer> list10 = new ArrayList<>();
		list10.addAll(Arrays.asList(2, 5, -1, 7, -3, -1, -2));
		List<Integer> result10 = slidingWindowMaximumSumOfSizeK(list10, 4);
		System.out.println("Sliding Window Maximums Sum is: " + result10);
		
		//int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] matrix = {{1,2},{3,4}};
		
		displayMatrix(matrix);
		maxProfit(Arrays.asList(100, 180, 260, 310, 40, 535, 695));
		
		//https://stackoverflow.com/questions/32395648/largest-5-in-array-of-10-numbers-without-sorting
		int array[] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
		largest5ElementsInAnArray(array);
		
		
		decimalToHex(305445566); //1234BABE
	}
	
	public static void displayMatrix(int[][] arr) {
		for (int[] innerArray: arr) {
	        for(int data: innerArray) {
	           System.out.print(data + "\t");
	        }
	        System.out.println();
	     }
	}
	
	public static void expandMatrixByK(int[][] arr, int k) {
		for (int[] innerArray: arr) {
	        for(int data: innerArray) {
	           System.out.print(data + "\t");
	        }
	        System.out.println();
	     }
	}
	
	public static void maxProfit(List<Integer> price) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = Integer.MIN_VALUE;
		int buyDay = -1;
		int sellDay = -1;
		for(int i=0;i<price.size();i++) {
			if(minPrice>=price.get(i))
				buyDay = i + 1;
			minPrice = Math.min(minPrice, price.get(i));
			int profit = price.get(i) - minPrice;
			if(maxProfit<profit)
				sellDay = i + 1;
			maxProfit = Math.max(maxProfit, profit);
		}
		if(maxProfit>0)
			System.out.println("maxProfit: " + maxProfit + "\tBuy on: " + buyDay + " & Sell on: " + sellDay);
		else
			System.out.println("Profit not possible in any case.");
	}
	
	public static void quickSort(int[] arr,int low,int high){
		if(low<high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}
	
	private static int partition(int[] arr,int low,int high){
		int pI = high;
		int pivot = arr[pI];
		int newIndex=low;
		System.out.println("Pivot: " + pivot);
		
		for(int i=low;i<high;i++) {
			int curr = arr[i];
			if(curr<pivot) {
				System.out.println("Ex " + arr[i] + " -> " + arr[newIndex] +  "\tcurr: " + curr);
				exchange(arr, i, newIndex);
				newIndex++;
			}
		}
		exchange(arr, pI, newIndex);
		return newIndex;
	}
	private static void exchange(int[] list, int i, int j) {
	    int temp = list[i];
	    list[i] = list[j];
	    list[j] = temp;
	}
	
	public static List<Integer> slidingWindowMaximumOfSizeK(List<Integer> list, int k) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;(i<k && i<list.size());i++) {
			Integer item = list.get(i);
			queue.add(item);
			max = Math.max(max, item);
			min = Math.min(min, item);
		}
		result.add(max);
		for(int i=k;i<list.size();i++) {
			Integer item = list.get(i);
			//System.out.print("currently processing: " + item + "\t queue: " + queue + "\t result: "  +result + "\n");
			queue.poll();
			queue.add(item);
			max = Math.max(max, item);
			result.add(max);
		}
		return result;
	}
	
	public static List<Integer> slidingWindowMaximumSumOfSizeK(List<Integer> list, int k) {
		List<Integer> resultMax = new ArrayList<>();
		List<Integer> resultMin = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0;(i<k && i<list.size());i++) {
			Integer item = list.get(i);
			queue.add(item);
			max = Math.max(max, item);
			min = Math.min(min, item);
		}
		resultMax.add(max);
		resultMin.add(min);
		for(int i=k;i<list.size();i++) {
			Integer item = list.get(i);
			//System.out.print("currently processing: " + item + "\t queue: " + queue + "\t result: "  +result + "\n");
			queue.poll();
			queue.add(item);
			max = Math.max(max, item);
			min = Math.min(min, item);
			resultMax.add(max);
			resultMin.add(min);
		}
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<resultMax.size();i++) {
			result.add(resultMax.get(i) + resultMin.get(i));
		}
		return result;
	}
	
	public static void largest5ElementsInAnArray(int array[]) {
		int i;
	    int large[] = new int[5];
	    int max = 0, index;
	    for (int j = 0; j < 5; j++) {
	        max = array[0];
	        index = 0;
	        for (i = 1; i < array.length; i++) {
	            if (max < array[i]) {
	                max = array[i];
	                index = i;
	            }
	        }
	        large[j] = max;
	        array[index] = Integer.MIN_VALUE;

	        System.out.println("Largest " + j +  " : " + large[j]);
	    }
	}
	
	public static void decimalToHex(int num) {
		
		StringBuffer str2 = new StringBuffer();
		
		char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		 
	     while(num>0)
	     {
	       int rem=num%16; 
	       str2=new StringBuffer(hex[rem]+str2.toString()); 
	       num=num/16;
	     }
	     System.out.println("Method 2: Decimal to hexadecimal: "+str2);
	}
	
	public static void nextGreaterElement() {
		
		//List<Integer> list = WorkerFileMain.generateRandomIntegerData(15);
		List<Integer> list = Arrays.asList(11, 6,34, 1,70, 4,18, 3,21, 0,13);
		Stack<Integer> stack = new Stack<>();
		stack.push(list.get(0));
		
		
			for(int i=1;i<list.size();i++) {
				Integer curr = list.get(i);
				Integer popped = stack.peek();
				if(curr>popped) {
					while(!stack.isEmpty()) {
						popped = stack.pop();
						System.out.println(popped + " -> " + curr);
						if(!stack.isEmpty() && stack.peek()> curr)
							break;
					}
				}
				stack.push(curr);
			}
			for(Integer i: stack) {
				System.out.println(i + " -> -1");
			}
		}
	
	public static boolean isSorted(int[] a) 
	{

	    int i;
	    for(i = 0; i < a.length-1; i ++);{
	    	if (a[i] > a[i + 1]) {
	            return false; // It is proven that the array is not sorted.
	        }
	    }
	    return false;
	}
	
	public static void displayArray(int[] x){
		for(int item: x){
			System.out.print(item + " ");
		}
		System.out.println("\n");
	}
	
}


