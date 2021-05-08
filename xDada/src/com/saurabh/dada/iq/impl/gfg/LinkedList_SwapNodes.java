package com.saurabh.dada.iq.impl.gfg;

public class LinkedList_SwapNodes {

	private static Integer[] INT_ITEMS = {10,15,12,13,20,14};
	
	public static void main(String[] args) {
		LinkedList list = createDummyLinkedList(INT_ITEMS);
		System.out.println("Original List: ");
		list.display();
		System.out.print("Reverse: \n");
		list.reverse();
		list.display();
		System.out.print("Reverse using recursion: \n");
		list.reverseRecursively();
		list.display();
		System.out.print("Swap Node (10,20): \n");
		int d1=10,d2=20;
		list.swapNodes(d1, d2);
		list.display();
		
		
	}

	public static LinkedList createDummyLinkedList(Integer[] items){
		LinkedList list = new LinkedList();
		for(Integer o: items){
			list.add(o);
		}
		return list;
	}

}
