package com.saurabh.dada.iq.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.saurabh.dada.iq.impl.data_structures.Stack_IQ_Examples;

public class Arrays_MinAndMaxInSinglePass {
	
	private static List<Integer> list = Stack_IQ_Examples.generateRandomIntegerData(25);

	public static void main(String[] args) {
		System.out.println("list: " + list);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i: list){
			min=Math.min(min, i);
			max=Math.max(max, i);
		}
		System.out.println("min: " + min + ", max: " + max);

		Collections.sort(list);
		System.out.println("\nsortedList: " + list);
	}

}
