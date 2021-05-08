package com.saurabh.dada.iq.impl;

public class LinkedList_GFG {

	public static void main(String[] args) {
		try{

			LinkedList<Integer> ll = new LinkedList<>();
			ll.add(10); ll.add(11); ll.add(15); ll.add(18); ll.add(21);
			ll.display(true);
			//System.out.println("Length: "+ll.length());
			LinkedList<Integer> ll2 = new LinkedList<>();
			ll2.add(11); ll2.add(12); ll2.add(13); ll2.add(14); ll2.add(15);
			
			//merge sorted linkedlist
			ll.merge(ll2, true);
			ll.display(true);
			
			ll.reverse(3);
			
			////ll.display(true);
			
			//reverse list
			//ll.reverse();
			
			//swap items
			//ll.swap(11,21);
			
			//remove item
			//ll.remove(15);
			
			//remove item at given index
			//ll.removeAtIndex(4);
			
			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}


