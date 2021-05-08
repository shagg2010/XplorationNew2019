package com.saurabh.dada.iq.impl.algos.sort;

public abstract class AbstractSort implements Sort {

	public static boolean compareAndSwap(int[] list, int index1, int index2, String order){
		if(order.equalsIgnoreCase(Sort.DESCENDING)){
			if(list[index1]<list[index2]){
				list[index1] = list[index1] + list[index2];
				list[index2] = list[index1] - list[index2];
				list[index1] = list[index1] - list[index2];
				return true;
			}
		}
		else{
			if(list[index1]>list[index2]){
				list[index1] = list[index1] + list[index2];
				list[index2] = list[index1] - list[index2];
				list[index1] = list[index1] - list[index2];
				return true;
			}
		}
		return false;
	}
	
	public static void swap(int[] list,int i, int j){
		int temp = list[i];
		list[i]=list[j];
		list[j]=temp;
	}
	public static void swap(Integer[] list,int i, int j){
		int temp = list[i];
		list[i]=list[j];
		list[j]=temp;
	}
	
	public static boolean isFirstNumberBigger(int i, int j){
		if(i>j){
			return true;
		}
		return false;
	}
	
}
