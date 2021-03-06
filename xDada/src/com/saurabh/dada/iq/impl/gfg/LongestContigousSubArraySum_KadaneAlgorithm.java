package com.saurabh.dada.iq.impl.gfg;

public class LongestContigousSubArraySum_KadaneAlgorithm {

	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        System.out.println("Maximum contiguous sum is " + maxSubArraySum_Optimized(a, a.length)); 

	}
	
	static int maxSubArraySum_Optimized(int a[], int size) {

		int max_so_far = 0, max_ending_here = 0;
		
		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			/*
			 * Do not compare for all elements. Compare only when max_ending_here > 0
			 */
			if (max_ending_here < 0)
				max_ending_here = 0;			
			else if (max_ending_here > max_so_far)
				max_so_far = max_ending_here;

		}
		return max_so_far;
	}
	
	private static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}
	
	

}
