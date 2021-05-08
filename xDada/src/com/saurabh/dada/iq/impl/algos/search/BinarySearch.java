package com.saurabh.dada.iq.impl.algos.search;

public class BinarySearch {

	private static int[] list = {8,9,10,11,12,13,14,15,16,17,18};
	
	
	public static void main(String[] args) {
		
		if(isSorted(list) && sortOrderAsc(list)){
			int resultIndex = binarySearch(10, list, 0, list.length-1);
			System.out.println("Answer: " + resultIndex);
		}
		else{
			System.out.println("List is either not sorted or not in ascending order!");
		}
		
	}

	public static int binarySearch(int item,int[] list,int startIndex, int endIndex){
		int resultIndex = -1;
		int midIndex = midOf(startIndex, endIndex);
		System.out.println(startIndex + " " + midIndex + " " + endIndex);		
		if (list[midIndex] == item) {
			resultIndex = midIndex;
			return midIndex;
		} else if (item < list[midIndex]) {
			//System.out.println("<");
			return binarySearch(item, list, 0, midIndex - 1);			
		} else if (item > list[midIndex]) {
			//System.out.println(">");
			return binarySearch(item, list, midIndex + 1, endIndex);			
		}
		if(midIndex==startIndex || midIndex==endIndex){
			return resultIndex;
		}
		return resultIndex;
	}
	
	public static boolean isSorted(int[] list){
		boolean sortedAsc=true;
		boolean sortedDesc=true;
		for(int i=0;i<list.length-1;i++){
			if(list[i]>list[i+1]){
				sortedAsc = false;
				break;
			}
		}
		if(sortedAsc){
			return true;
		}
		else{
			for(int i=0;i<list.length-1;i++){
				if(list[i]<list[i+1]){
					sortedDesc = false;
					break;
				}
			}
		}
		//System.out.println(sortedAsc + " " + sortedDesc);
		if(!sortedDesc){
			return false;
		}
		return true;
	}
	
	public static boolean isSorted(Integer[] list){
		boolean sortedAsc=true;
		boolean sortedDesc=true;
		for(int i=0;i<list.length-1;i++){
			if(list[i]>list[i+1]){
				sortedAsc = false;
				break;
			}
		}
		if(sortedAsc){
			return true;
		}
		else{
			for(int i=0;i<list.length-1;i++){
				if(list[i]<list[i+1]){
					sortedDesc = false;
					break;
				}
			}
		}
		//System.out.println(sortedAsc + " " + sortedDesc);
		if(!sortedDesc){
			return false;
		}
		return true;
	}
	
	private static boolean sortOrderAsc(int[] list){
		boolean sortedAsc=true;
		for(int i=0;i<list.length-1;i++){
			if(list[i]>list[i+1]){
				sortedAsc = false;
				break;
			}
		}
		if(sortedAsc){
			return true;
		}
		return false;
	}
	
	public static int midOf(int startIndex, int endIndex){
		int index=-1;		
		index = (startIndex+endIndex)/2;		
		return index;
	}
}
