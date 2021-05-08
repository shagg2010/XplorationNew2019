package com.saurabh.dada.iq.impl.vipin;

/**
 *Rearranging string with 0,1,2 with all Zeroes on left Side Ones in midddle and twos on right side. 
 *
 */

public class Rearrangement {
	private String inputString = "01201210202102";
 
	public void rearrangeString() {
		char[] charArray = inputString.toCharArray();
		int i = 0, j = inputString.length();
 
		while (i < inputString.length() && j > 0 && i < j) {
			if (charArray[j - 1] != '0') {
				i++;
			}
			if (charArray[i] != '2') {
				j--;
			}
			if (charArray[i] == '2' && charArray[j] == '0') {
				swap(charArray, i, j);
			}
		}
 
		for (int m = 0; m < inputString.length() - 1; m++) {
			if ((charArray[m] == '1' && charArray[m + 1] == '0')
					|| (charArray[m] == '2' && charArray[m + 1] == '1')) {
				swap(charArray, m, m + 1);
				m = 0;
			}
		}
 
		System.out.println("Input Provided - " + inputString);
		System.out.print("Output Provided - ");
		System.out.print(charArray);
 
	}
 
	public void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
 
	public static void main(String[] args) {
		new Rearrangement().rearrangeString();
	}
}