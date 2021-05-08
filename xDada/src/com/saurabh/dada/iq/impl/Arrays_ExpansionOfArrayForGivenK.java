package com.saurabh.dada.iq.impl;

public class Arrays_ExpansionOfArrayForGivenK {

	public static int[][] arr = {{1,2,7},{3,4,8},{5,6,9}};
	
	public static void main(String[] args) {
		int a = 0%3;
		System.out.println(a);
		int k = 3;
		display2DArray(arr, 3, 3);
		int[][] ans = expandArray(arr,k,arr.length,arr[0].length);
		display2DArray(ans, 3*k, 3*k);

	}
	
	public static int[][] expandArray2(int[][] arr, int k, int rows, int cols){
		int rowsI = rows * k;
		int colsI = cols * k;
		int[][] retArr = new int[rowsI][colsI];
		
		return retArr;
	}
	
	public static int[][] expandArray(int[][] arr, int k, int rows, int cols){
		
		int rowsI = rows * k;
		int colsI = cols * k;
		//System.out.println(rowsI+" " + colsI);
		int[][] retArr = new int[rowsI][colsI];
		
		try{
			int i=-1;
			int j=-1;	
			
			for(int x=0;x<rowsI;x++){
				j=-1;
				if(x%k==0){
					i++;
				}
				for(int z=0;z<colsI;z++){
					if(z%k==0)
						j++;
					//System.out.print(x+"," +z + "  [" + i + "," + j + "] | ");
					retArr[x][z]=arr[i][j];
				}
				//System.out.println();
			}
		}
		catch(Throwable e){
			e.printStackTrace();
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
