package com.saurabh.dada.iq.impl.companies;

public class MatrixSumProblem_Oracle {

	//https://www.geeksforgeeks.org/center-element-of-matrix-equals-sums-of-half-diagonals/
	//matrix of 2n+1 * 2n+1 = odd square matrix
	static int matrix[][] = { {2,   9,   1,   4,   -2} , 
						      {6,   7,   2,   11,   4},
						      {4,   2,   9,   2,    4},
						      {1,   9,   2,   4,    4},
						      {0,   2,   4,   2,    5}
							};
	
	
	
	public static void main(String[] args) {
		
		findHalfDiagonalSumEqualtoMiddle(matrix);
		
	}
	
	public static boolean findHalfDiagonalSumEqualtoMiddle(int[][] matrix) {
		int middleIndex = (matrix.length-1)/2;
		int center = matrix[middleIndex][middleIndex];
		System.out.println("Center: " + center);
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + "[" + i +"," + j+"]\t");
			}
			System.out.println();
		}
		
		int item = 0;
		int item2 = 0;
		boolean flag = true;
		for(int i=0,j1=0,j2=matrix.length-1;i<matrix.length;) {	
				System.out.println("curr, i:" + i + "  j1:" + j1 + "   j2:"+ j2);
				if(i==middleIndex) {
					//System.out.println("middleIndex, i:" + i + "  j1:" + j1 + "   j2:"+ j2);
					if(item!=center || item2!=center) {
						flag = false;
						break;
					}
					item = 0;
					item2 = 0;
					i++;
					j1++;
					j2--;
				}
				else {
					//System.out.println("adding: " +  matrix[i][j1]);
					//System.out.println("adding: " + matrix[i][j2]);
					item = item + matrix[i][j1];
					item2 = item2 + matrix[i][j2];					
					//System.out.println("item: " + item + "  item2: " + item2);
					i++;
					j1++;
					j2--;
				}
				if(i==matrix.length) {
					//System.out.println("endIndex, i:" + i + "  j1:" + j1 + "   j2:"+ j2);
					if(item!=center || item2!=center) {
						flag = false;
						break;
					}
				}
		}
		
		System.out.println("flag: " + flag);
		return flag;
	}

}
