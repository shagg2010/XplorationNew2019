package com.saurabh.dada.iq.impl;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicateElementsInSortedArray {
	
	public static void main(String a[]){
		int[] input1 = {2,3,6,6,8,9,10,10,10,12,12}; // Sorted array
		/*int[] output = removeDuplicates(input1);
		for(int i:output){
			System.out.print(i+" ");
		}*/

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:input1){
			set.add(new Integer(i));
		}
		System.out.println(set);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i:input1){
			Integer key = new Integer(i);
			Integer val = map.get(key);
			if(val==null){
				map.put(key, key);
			}
			
		}
		Integer[] arr = new Integer[map.size()];
		map.keySet().toArray(arr);
		
		for(Object i:arr){
			System.out.print(i+" ");
		}
	}	

 public static int[] removeDuplicates(int[] input){
	
		int j = 0;
		int i = 1;
		// return if the array length is less than 2
		if (input.length < 2) {
			return input;
		}
		while (i < input.length) {
			if (input[i] == input[j]) {
				i++;
			} else {
				input[++j] = input[i++];
			}
		}
		int[] output = new int[j + 1];
		for (int k = 0; k < output.length; k++) {
			output[k] = input[k];
		}
		return output;
	}
	
}

