package com.saurabh.dada.ctci.impl.chapters;

import com.saurabh.dada.ctci.impl.chapters.logic.Chapter02_LinkedListProblems;
import com.saurabh.dada.ctci.impl.chapters.logic.LinkedList;
import com.saurabh.dada.ctci.impl.chapters.logic.LinkedList.Node;

public class DriverChapter02 {
	
	private static Integer[] INT_ITEMS = {1,2,3,4,5,6,7,8,1};
	private static String[] STR_ITEMS = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
	
	public static void main(String ...strings){
		
		LinkedList<Object> list = createDummyLinkedList(INT_ITEMS);
		LinkedList<Object> slist = createDummyLinkedList(STR_ITEMS);
		
		//iterate all elements
		list.iterate(-1);
		
		//find the nth item from the last
		Object ans = Chapter02_LinkedListProblems.nthItemFromLast(list, 10);
		System.out.println("Ans: " + ans);
		System.out.println(list.detectLoop());
		
		//find the loop in the linked list and also the start of the loop
		slist.iterate();
		Chapter02_LinkedListProblems.detectLoop(slist, "8");
		
		
		//delete the single copy of a specified item
		Chapter02_LinkedListProblems.deleteSingleCopy(list, 1);
		
	}
	
	public static LinkedList<Object> createDummyLinkedList(Object[] items){
		LinkedList<Object> list = new LinkedList<Object>();
		for(Object o: items){
			list.add(o);
		}
		return list;
	}

}
