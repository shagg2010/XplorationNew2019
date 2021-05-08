package com.saurabh.dada.ctci.impl.chapters;

import com.saurabh.dada.ctci.impl.chapters.logic.Chapter03_StackQueuesProblems;
import com.saurabh.dada.ctci.impl.chapters.logic.Stack;

public class DriverChapter03 {
	
	private static Integer[] INT_ITEMS = {8,15,1,6,7,1,5,0,10};
	private static String[] STR_ITEMS = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

	public static void main(String[] args) {
	
		Integer ans = (Integer) Chapter03_StackQueuesProblems.findMinInStack(Integer.class,INT_ITEMS);
		System.out.println("Ans: " + ans);
		
		Chapter03_StackQueuesProblems.mimicQueueUsingStacks();
		
		java.util.Stack<Integer> stack = Chapter03_StackQueuesProblems.sortStack(INT_ITEMS);
		System.out.println("Size: " + stack.size());
		for(Integer i: stack){
			System.out.println(i);
		}
		
	}

}
