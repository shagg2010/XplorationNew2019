package com.saurabh.dada.iq.impl;

public class Array_ProductOfAllElementsExceptCurrent {

	private static int arr[] = {1,2,3,4};
	// output = {2*3*4,1*3*4,....}
	private static int totalLoops=0;
	
	public static final strictfp synchronized void main(String[] args) {
		long start = System.nanoTime();
		soliaApproach();
		long end = System.nanoTime() - start;
		System.out.println("total time (s): " + end);
		//simpleApproach();
		start = System.nanoTime();
		withoutDivision();
		end = System.nanoTime() - start;
		System.out.println("total time (a): " + end);
	}
	
	public static void soliaApproach() {
		int[] a={1,2,3,4}; //if a=[1,2,3,4] then aLeft={1,1,2,6} aRight=[24,12,4,1] and output=[24,12,8,6]
		int[] aLeft=new int[a.length];
		int[] aRight=new int[a.length];
		aLeft[0]=1;
		aRight[a.length-1]=1;
		for(int counter=1;counter<a.length;counter++){
			aLeft[counter]=aLeft[counter-1]*a[counter-1];
			aRight[a.length-(counter+1)]=aRight[a.length-counter]*a[a.length-counter];
		}
		for(int counter=0;counter<a.length;counter++){
			//System.out.println("a["+counter+"] = " + a[counter] + "\t aLeft["+counter+"] = " + aLeft[counter] + "\t aRight["+counter+"] = " + aRight[counter] + "\t -  Output For this  -  " + aLeft[counter]*aRight[counter]);
					System.out.print(aLeft[counter]*aRight[counter]+" ");
					
		}
	}
	
	public static void withoutDivision(){
		int ans[]=new int[arr.length];
		/*int temp[]=new int[arr.length];
		for(int i=0;i<temp.length;i++){
			temp[i]=1;			
		}*/
		
		int prodLeftArr=1;
		int prodRightArr=0;
		prodLeftArr = 1;
		int prev=1;
		
		for(int i=0;i<arr.length;i++){
			prodLeftArr = prodLeftArr * prev;
			prodRightArr = product(arr,i+1);
			//System.out.print("i: "+i + " c: " + (i+1));
			//System.out.println(" - " + prodRightArr + "," + prodLeftArr);
			prev=arr[i];
			ans[i]=prodRightArr*prodLeftArr;
			//totalLoops++;
			System.out.print(ans[i] + " ");
		}
		/*System.out.println("---------");
		for(int i:ans){
			System.out.print(i + " ");
		}*/
		System.out.println("\n---------");
		//System.out.println("Total loops: " + totalLoops);
	}

	//simple algo - multiply all elements first, and then divide with current, we need to find other logic
	public static void simpleApproach(){
	
		int ans[] = new int[arr.length];
		int start=0;
		int end=arr.length-1;
		
		for(int i=start;i<=end;i++){
			if(i==start){
				int j=i+1;
				ans[i]=1;
				while(j<=end){					
					ans[i]=ans[i]*arr[j];
					j++;
				}
			}
			else if(i==end){
				int j=end-1;
				ans[i]=1;
				while(j>=0){					
					ans[i]=ans[i]*arr[j];
					j--;
				}
			}
			else{
				int j=0;
				ans[i]=1;
				while(j<i){					
					ans[i]=ans[i]*arr[j];
					j++;
				}
				j=i+1;
				while(j<=end){					
					ans[i]=ans[i]*arr[j];
					j++;
				}
			}		
		}
		
		for(int i:ans){
			System.out.print(i + " ");
		}
	
	}
	
	public static int product(int[] array, int start){
		int prod = 1;
		for(int i=start;i<array.length;i++){
			prod=prod*array[i];
			//totalLoops++;
		}
		return prod;
	}
}
