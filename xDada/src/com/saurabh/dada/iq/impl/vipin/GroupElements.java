package com.saurabh.dada.iq.impl.vipin;

/**
 * Given an unsorted array with repetitions, the task is to group multiple occurrence of individual 
 * elements. The grouping should happen in a way that the order of 
 * first occurrences of all elements is maintained.
 * 
 * Ex : Input: arr[] = {5, 3, 5, 1, 3, 3} ,     Output:        {5, 5, 3, 3, 3, 1}
 * Input: arr[] = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4},  Output:        {4, 4, 4, 6, 6, 9, 9, 2, 3, 10}
 */

public class GroupElements {

	static private int[] inputArray = {4, 6, 9, 2, 3, 4, 9, 6, 10, 4 };
	static int nextNumber[] = new int[inputArray.length];
	static boolean checkExist[] = new boolean[100];
	static int flag[] = new int[100];
	static int output[] = new int[100];

	static public void getDistincts() {
		for (int k = 0, j = 0; k < inputArray.length; k++) {
			int temp = flag[inputArray[k]];
			flag[inputArray[k]] = ++temp;
			if (checkExist[inputArray[k]] != true) {
				nextNumber[j++] = inputArray[k];
				checkExist[inputArray[k]] = true;
			}
		}
	}

	public static void main(String[] args) {
		getDistincts();
		int j =0,m=0;
		 x:
		for (int h = 0; h <= flag[nextNumber[j]] && nextNumber[j]!=0 ; ) {
			//output[m] = nextNumber[j];m++;
			System.out.print(" "+nextNumber[j]+" ,");m++;
			if(h==flag[nextNumber[j]]-1){
				j++;
				 h = 0;
				 continue x;
			}
		
			h++;		}
		
	}
}
