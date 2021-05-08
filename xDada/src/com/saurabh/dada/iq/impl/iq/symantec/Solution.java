package com.saurabh.dada.iq.impl.iq.symantec;

import java.util.Arrays;
import java.util.Scanner;


public class Solution {


	//private static int[] list = {5,6,7,8,9};
	private static int[] list = {1,2,3,4,6};
	
	public static void main(String[] args) throws Exception{
		
		
		System.out.println(checkPrimes(11));
		System.out.println(getNumberOfPrimes(1000));  // Answer should be 168
		System.out.println(getNumberOfPrimes(7919));  // Answer should be 1000
		
		System.out.println(triplets(8, list));
		
		/*Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] inputs = new int[n];
		
		for(int i=0;i<n;i++){
			inputs[i]=sc.nextInt();
		}*/

	}
	
	static int triplets(int t,int[] d){
		int result=0;
		boolean flag=true;
		Arrays.sort(list);
		for(int i=0;i<d.length&&flag;i++){
			for(int j=i+1;j<d.length&&flag;j++){
				if(d[i]+d[j]>t){
					flag=false;
					break;
				}
				else{
					for(int k=j+1;k<d.length;k++){
						int sum2=d[i]+d[j]+d[k];
						if(sum2>t){
							break;
						}
						else{
							result++;
						}
					}
				}
			}
		}
		return result;
	}
	
	static int triplets2(int t,int[] d){
		int result=0;
		int i=0;
		boolean iflag=true;
		Arrays.sort(list);
		while(i<d.length&&iflag){
			int j=i+1;
			while(j<d.length){
				if(d[i]+d[j]>t){
					iflag=false;
					break;
				}
				else{
					for(int k=j+1;k<d.length;k++){
						int sum2=d[i]+d[j]+d[k];
						if(sum2>t){
							break;
						}
						else{
							result++;
						}
					}
				}
				j++;
			}
			i++;
		}
		
		
		return result;
	}
	
	static int getNumberOfPrimes(int N) {
		int result=0;
		for(int j=2;j<=N;j++){
			int i=2;
			int num=j;
			int loop=num;
			boolean flag=true;
			while(i<loop){
				if(loop%i==0){
					flag=false;
					loop=loop%i;
				}
				i++;
			}
			if(flag==true){
				result=result+1;
			}
		}
		return result;
    }

	
	static boolean checkPrimes(int N) {
		int i=2;
		boolean flag=true;
		int num=N;
		int loop=num;
		while(i<loop){
			
			if(loop%i==0){
				flag=false;
				loop=loop%i;
			}
			i++;
		}
		return flag;
	}
	
}
