package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;

public class NextHigherNumberUsingSameDigits {
	
	//http://www.ardendertat.com/2012/01/02/programming-interview-questions-24-find-next-higher-number-with-same-digits/

	public static void main(String[] args) {
		int num = nextHigherNumber(25431);
		System.out.println(num);
	}

	public static int nextHigherNumber(int num){
		int temp=num;
		List<Integer> list = new ArrayList<Integer>();
		while(temp>0){
			list.add(temp%10);
			temp=temp/10;
		}
		System.out.println(list);
		for(int i=list.size()-2;i>0;i--){
			if(list.get(i)<list.get(i-1)){
				swap(list,i,i-1);
				break;
			}
				
		}
		System.out.println(list);		
		return 0;
	}
	
	public static void swap(List<Integer> list,int i,int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}
