package com.saurabh.dada.iq.impl.vipin;

/**
 *Find Lowest Common Ancestor of nodes.
 **/

public class LowCommonAnc {
	
	public int ancestorLowest(int a,int b){
		int tempA =a;
		int tempB =b;
		int parentA = (tempA-1)/2;
		int parentB = (tempB-1)/2;
		while(parentA != parentB && parentA >=0 && parentB>=0){
			tempA =  parentA;
			tempB=  parentB;
			parentA = (tempB-1)/2;
			parentB = (tempB-1)/2;
		}
		return parentA;
	}
 
	public void showAnc(){
		int a[] = {1,2,3,4,6,9,11,54};
		
		int i = ancestorLowest(5, 6);
		System.out.println(a[i]);
		
	}
	
	public static void main(String[] args) {
		LowCommonAnc a = new LowCommonAnc();
		a.showAnc();
		
	}
 
}