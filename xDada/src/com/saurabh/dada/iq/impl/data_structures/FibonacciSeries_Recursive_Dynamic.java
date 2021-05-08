package com.saurabh.dada.iq.impl.data_structures;

public class FibonacciSeries_Recursive_Dynamic {

	public static void main(String[] args) {
		//find 8th element in series
		//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
		System.out.println("fibonacciRescursive: " + fibonacciRescursive(8));
		
		System.out.println("fibonacciDynamic: " + fibonacciDynamic(8));
	}

	private static int fibonacciRescursive(int n) {
		if (n == 0 || n == 1)
			return n;
		return fibonacciRescursive(n - 1) + fibonacciRescursive(n - 2);
	}
	
	private static int fibonacciDynamic(int n) {
		/* Declare an array to store Fibonacci numbers. */
		int fibonacci[] = new int[n + 2]; // 1 extra to handle case, n = 0
		int i;

		/* 0th and 1st number of the series are 0 and 1 */
		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (i = 2; i <= n; i++) {
			/*
			 * Add the previous 2 numbers in the series and store it
			 */
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
		}

		return fibonacci[n];
	}
}
