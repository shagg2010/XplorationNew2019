package com.yadas.code.java.ds;

public class CircularLinkedList_G4GExamples {

	public static void main(String[] args) {
		basicOperations();

	}
	
	private static void basicOperations() {
		XCircularLinkedList<Integer> cll1 = initializeLinkedList("17->15->8->12->10->5->4->1->7->6->NULL", "->", true);
		cll1.traverse();
	}
	
	public static XCircularLinkedList<Integer> initializeLinkedList(String itemsStr, String delimiter, boolean sorted){
		XCircularLinkedList<Integer> cll = new XCircularLinkedList<Integer>();
		String[] itemArray = itemsStr.split(delimiter);
		for(int i=0;i<itemArray.length;i++) {
			if(!itemArray[i].equalsIgnoreCase("null"))
				if(!sorted)
					cll.add(Integer.valueOf(itemArray[i]));
				else
					cll.addSorted(Integer.valueOf(itemArray[i]));
		}
		return cll;
	}

}
