package com.saurabh.dada.iq.impl;

public class LoopSpeedWithIncrementAndDecrementOperators {

	//https://stackoverflow.com/questions/4181941/loop-counter-in-java-api
	public static void main(String[] args) {
		
		long start = System.nanoTime();
		for(int i=0;i<Integer.MAX_VALUE;i++){}
		long end = System.nanoTime();
		System.out.println("incement : " + (end-start));

		long start1 = System.nanoTime();
		for(int i=Integer.MAX_VALUE;i>0;i--){}
		long end1 = System.nanoTime();
		System.out.println("decrement : " + (end1-start1));
		
		start = System.nanoTime();
		for(int i=0;i<Integer.MAX_VALUE;i++){}
		end = System.nanoTime();
		System.out.println("incement : " + (end-start));

	}

}
