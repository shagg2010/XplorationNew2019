package com.saurabh.dada.iq.impl.companies.tesco;

public class FindFirstIndexOfOneInAnArray {

	//public static int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1};
	//public static int[] arr = {0,1,1,1,1,1};
	//public static int[] arr = {1,1,1,1,1,1};
	//public static int[] arr = {0,0,0,0,0,0};
	public static int[] arr = {0,0,0,0,0,1};
	
	
	
	public static void main(String[] args) {
		//simple approach
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				System.out.println("Index of 1st 1 found @: " + i);
				break;
			}
		}
		
		//binary search approach
		int start = 0;
		int end = arr.length -1;
		int mid = (start+end)/2;
		
		while(start<=end) {
			System.out.println("\tstart: " + start + ", end: " + end + ", mid: " + mid);
			if((mid>0 && (arr[mid]==1 && arr[mid-1]==0)) || (mid==0 && arr[mid]==1)) {
				System.out.println("Index of 1st 1 found @: " + mid);
				break;
			}
			if(arr[mid]==0) {
				start = mid+1;
				mid = (start+end)/2;
			}
			else if(arr[mid]==1) {
				end = mid-1;
				mid = (start+end)/2;
			}
		}
	}

}
