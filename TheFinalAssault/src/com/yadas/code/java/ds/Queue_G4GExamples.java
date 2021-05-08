package com.yadas.code.java.ds;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_G4GExamples {

	public static void main(String[] args) {
		//generateBinaryNumber(50);	
		//smallestMultipleOfGivenNumberMadeOfSpecificDigits();
		//sumOfMinAndMaxOfAllSubArraysOfSizeK(4);

		
	}
	
	private static void smallestMultipleOfGivenNumberMadeOfSpecificDigits() {
		generateNumbersWithSpecificTwoDigits(9,0,5);
		generateNumbersWithSpecificTwoDigits(9,0,11);
	}
	
	private static void sumOfMinAndMaxOfAllSubArraysOfSizeK(int k){
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		Queue<Integer> q = new LinkedList<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i: arr) {
			min = i<min?i:min;
			max = i>max?i:max;
			//System.out.println("min: " + min + "\t" + "max:" + max);
			q.add(i);
			//System.out.println("q: " + q);
			if(q.size()>=k) {
				int o = q.poll();
				//recalculate min & max
				if(o==min && q.size()==k) {
					for(int ele: q) {
						min = Integer.MAX_VALUE;
						min = ele<min?ele:min;
					}
				}
				if(o==max && q.size()==4) {
					for(int ele: q) {
						max = Integer.MIN_VALUE;
						max = ele>max?ele:max;
					}
				}
				//System.out.println("min: " + min + "\t" + "max:" + max + "\t\to: " + o);
				sum = sum + (min+max);
			}
		}
		System.out.println("Sum: " + sum);
	}
	private static void generateNumbersWithSpecificTwoDigits(int digit1, int digit2, int n) {
		Queue<String> q = new LinkedList<String>();
		q.add(""+digit1);
		for(;;) {
			String s1 = q.remove();;
			//System.out.println(s1);
			if(Integer.valueOf(s1)%n==0) {
				System.out.println(s1);
				break;
			}
			String s2=s1;
			q.add(s1 + ""+digit2);
			q.add(s2 + "1"+digit1);
		}
	}

	private static void generateBinaryNumber(int n) {
		Queue<String> q = new LinkedList<String>();
		q.add("1");
		while(n-->0) {
			String s1 = q.remove();;
			System.out.println(s1);
			String s2=s1;
			q.add(s1 + "0");
			q.add(s2 + "1");			
		}
	}
}
