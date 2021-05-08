package com.saurabh.dada.iq.impl.companies;

public class ExpansionOfMatrixForGivenK_SoftwareAG {

	public static int[][] arr = {{1,2,7},{3,4,8},{5,6,9}};
	
	public static void main(String[] args) {
		int k = 5;
		display2DArray(arr, 3, 3);
		int[][] ans = expandArray(arr,k,arr.length,arr[0].length);
		display2DArray(ans, 3*k, 3*k);

	}
	
	public static int[][] expandArray(int[][] arr, int k, int rows, int cols){
		int rowsI = rows * k;
		int colsI = cols * k;
		int[][] retArr = new int[rowsI][colsI];
		
		int x=-1;
		int y=-1;
		for(int i=0;i<rowsI;i++) {
			y=-1;
			if(i%k==0)
				x++;
			for(int j=0;j<colsI;j++) {
				if(j%k==0)
					y++;
				retArr[i][j] = arr[x][y];
			}
		}
		
		return retArr;
	}
	
	
	public static void display2DArray(int[][] arr, int rows, int cols){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
