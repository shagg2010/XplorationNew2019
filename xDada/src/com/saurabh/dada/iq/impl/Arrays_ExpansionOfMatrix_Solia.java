package com.saurabh.dada.iq.impl;

public class Arrays_ExpansionOfMatrix_Solia {

	public static void main(String[] args) {
		int row = 3, column = 3, growthFactor = 3, i, j, k = 0, l;
		int[][] inputArray = new int[row][column];

		// Populate the [row][column] array
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				k++;
				inputArray[i][j] = k;
			}
		}
		// Original Input
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				System.out.print(inputArray[i][j] + "\t");
			}
			System.out.println();
		}

		// Implementing Logic
		k = -1;
		for (i = 0; i < row * growthFactor; i++) {
			if (i % growthFactor == 0)
				k++;
			l = -1;
			for (j = 0; j < column * growthFactor; j++) {
				if (j % growthFactor == 0)
					l++;
				System.out.print(inputArray[k][l] + "\t");
			}
			System.out.println();
		}
	}

}
