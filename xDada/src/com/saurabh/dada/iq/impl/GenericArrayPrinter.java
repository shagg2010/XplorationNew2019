package com.saurabh.dada.iq.impl;

public class GenericArrayPrinter {

	public static <T> void printArray(T[] array, String separator) {
		StringBuilder sb = new StringBuilder("Array: ");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + separator);
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

}
