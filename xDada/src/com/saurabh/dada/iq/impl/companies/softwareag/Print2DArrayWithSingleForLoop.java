package com.saurabh.dada.iq.impl.companies.softwareag;

public class Print2DArrayWithSingleForLoop {

	private static int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
	
	public static void main(String[] args) {
		
		for(int i=0;i<arr.length*arr.length;i++) {
			int r = i/arr.length;
			int c = i%arr.length;
			System.out.print(r + "," + c);
			System.out.print("\t"+arr[r][c] + "\n");
		}

	}

}
