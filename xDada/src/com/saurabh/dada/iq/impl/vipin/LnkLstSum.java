package com.saurabh.dada.iq.impl.vipin;

import java.util.LinkedList;

/**
 *	Given two numbers represented by two linked lists, write a function that returns sum list. 
 *	The sum list is linked list representation of addition of two input numbers. It is not allowed 
 *	to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
 *
 *			Example:
 *				Input : First List: 5->6->3  Second List: 4->2 //  
 *				Output : 1->0->5
 * 
 *
 */

public class LnkLstSum {
	
	LinkedList<Integer> listOne = new LinkedList<Integer>();
	LinkedList<Integer> listTwo = new LinkedList<Integer>();
	
	public LnkLstSum() {
		listOne.add(5);
		listOne.add(6);
		listOne.add(3);
		listTwo.add(4);
		listTwo.add(2);
	}
	
	public void computeSum(){
		int diff = listOne.size()-listTwo.size();
		
		
	}
	
	public static void main(String[] args) {
		
	}

}
