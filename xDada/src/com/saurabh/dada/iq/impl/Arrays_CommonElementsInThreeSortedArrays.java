package com.saurabh.dada.iq.impl;

import java.util.Arrays;

public class Arrays_CommonElementsInThreeSortedArrays {

	public static void main(String[] args) {

		int[] array1 = {1, 5, 10, 20, 40, 80};
		int[] array2 = {6, 7, 20, 80, 100};
		int[] array3 = {3, 4, 15, 20, 30, 70, 80, 120};
		int length1 = array1.length;
		for (int i = 0; i < length1; i++) {
			if (Arrays.binarySearch(array2, array1[i]) < 0) {
				continue;
			} else if (Arrays.binarySearch(array3, array1[i]) < 0) {
				continue;
			} else {
				System.out.println(array1[i]);
			}
		}

	}

}
