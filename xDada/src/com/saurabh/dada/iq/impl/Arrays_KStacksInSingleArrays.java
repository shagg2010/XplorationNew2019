package com.saurabh.dada.iq.impl;

import java.util.Arrays;

public class Arrays_KStacksInSingleArrays {

	public static void main(String[] args) {

		KStacks stacks = new KStacks(15, 3);
		stacks.push(5, 0); //0
		stacks.push(6, 0); //1
		stacks.push(1, 1); //2
		stacks.push(7, 0); //3
		stacks.push(8, 2); //4
		stacks.push(9, 2); //5
		stacks.push(11, 1); //6
		stacks.push(4, 0); //7
		stacks.push(2, 2); //8
		
		stacks.display();
		
		System.out.println(stacks.pop(0)+ "->"+stacks.pop(0)+"->" + stacks.pop(0) + "->"+stacks.pop(0) + "->"+stacks.pop(0));
		stacks.push(12, 0);
		stacks.push(13, 0);
		stacks.display();
		System.out.println(stacks.pop(0));
		stacks.display();
	}

}

class KStacks{
	//arr - actual array, k representing top of all stacks, preTop denotes previous top in the stack
	private int[] arr;
	private int[] kTop;
	private int[] prevTop;
	private int size=0;
	private int maxSize=0;
	private int[] free;
	
	public KStacks(int maxSize,int k){
		if(k>maxSize){
			throw new IllegalArgumentException("internal array size is too small to hold " + k + " stacks");
		}
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
		this.kTop = new int[k];
		this.prevTop = new int[maxSize];
		Arrays.fill(prevTop, -2);
		Arrays.fill(kTop,-1);
	}
	
	public void push(int element, int stackNo){
		if(size>=maxSize){
			throw new StackOverflowError("Stack Overflow");
		}
		arr[size]=element;
		prevTop[size] = kTop[stackNo];
		kTop[stackNo]=size;
		size++;
	}
	
	public void display(){
		System.out.println("Backing Array: ");
		displayArray(arr,size);
		System.out.println("Top Pointer: ");
		displayArray(kTop,kTop.length);
		System.out.println("Previous Top: ");
		displayArray(prevTop,size);
	}
	
	public int pop(int stackNo){
		if(kTop[stackNo]!=-1){
			int element = arr[kTop[stackNo]];
			kTop[stackNo] = prevTop[kTop[stackNo]];
			return element;
		}
		return Integer.MIN_VALUE;
	}
	/*public int pop(int stackNo){
		if(stackNo<kTop.length-1){
			if(kTop[stackNo]!=-1){
				int element = arr[kTop[stackNo]];
				kTop[stackNo] = prevTop[kTop[stackNo]];
				prevTop[kTop[stackNo]]=-1;
				return element;
			}
		}
		else{
			System.out.println("Stack underflow!");
		}
		return -99;
	}*/
	
	public static void displayArray(int[] x, int size){
		for(int i=0;i<size;i++){
			System.out.print(x[i] + " ");
		}
		System.out.println("\n");
	}
	
}
