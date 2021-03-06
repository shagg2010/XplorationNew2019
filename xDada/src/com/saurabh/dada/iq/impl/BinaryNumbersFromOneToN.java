package com.saurabh.dada.iq.impl;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersFromOneToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		generatePrintBinary(1000, 1);

	}
	
	public static void generatePrintBinary(int n, int index)
	{
	    // Create an empty queue of strings
	    LinkedList<String> queue = new LinkedList<String>();
	 
	    // Enqueue the first binary number
	    queue.add("1");
	 
	    // This loops is like BFS of a tree with 1 as root
	    // 0 as left child and 1 as right child and so on
	    while (n-->0){
	        // print the front of queue
	        String s1 = new String(queue.peek());
	        queue.remove();
	        System.out.println(index + " ->\t" + s1);index++;	 
	        String s2 = s1;  // Store s1 before changing it
	        // Append "0" to s1 and enqueue it
	        queue.add(s1 + "0");
	 
	        // Append "1" to s2 and enqueue it. Note that s2 contains
	        // the previous front
	        queue.add(s2 + "1");
	    }
	}

}
