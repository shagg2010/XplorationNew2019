package com.saurabh.dada.iq.impl.gfg;

public class Array_BinarySearchInSortedRotatedArray {

	/**
	 * Note this code works for both rotated and normal sorted arrays as well
	 * @param args
	 */
	public static void main(String[] args) {
		
		int list[] = {4,5,6,7,8,9,10,0,1,2,3};
		int list2[] ={0,1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(list, 5, 0, list.length-1));
		System.out.println(binarySearch(list2, 9, 0, list2.length-1));
	}
	
	public static int binarySearch(int[] list,int key,int low,int high){
		
		while(low<=high){
			//Avoid overflow, same as M=(L+R)/2
			int mid=low+((high-low)/2);
			System.out.println("low: " + list[low] + "\thigh: "+ list[high] +"\tmid: " + list[mid] + "["+mid+"]");
			if(list[mid]==key)
				return mid;
			//the bottom half is sorted
			if(list[low]<=list[mid]){
				if(list[low]<=key&&key<list[mid])
					high=mid-1;
				else
					low=mid+1;
			}
			//the upper half is sorted
			else{
				if(list[mid]<key&&key<=list[high])
					low=mid+1;
				else
					high=mid-1;
			}
		}
		return -1;
	}

}
