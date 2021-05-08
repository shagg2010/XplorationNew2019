package com.saurabh.dada.iq.impl;

public class KthHighestElementInArray {
	
	
	//private static int[] list = {1,11,27,5,18,10,43,26,58,37,39,28,8,51,14,86,13,6,93,92,81,2,8};
	private static int[] list = {80,5,10,11,13,21,7,6,25,81};
	
	public static void main(String[] args) {
		//find 3rd largest
		//use MAX_HEAP for this
		
		int val = findElement(list, 3);
		System.out.println("Answer: " + val);
		
	
	}
	
	public static int findElement(int[] list, int k){
		
		int val=-1;
		MaxHeap maxHeap = new MaxHeap(list.length);
		for(int i:list){
			maxHeap.insert(i);
		}
		//maxHeap.printHeap();
		for(int i=0;i<k;i++){
			val=maxHeap.remove();
			System.out.println("val: "+val);
		}
		return val;
	}

}
