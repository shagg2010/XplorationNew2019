package com.saurabh.dada.iq.impl;

public class LinkedList_PairwiseSwap {

	//http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
	
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(new LinkedList.Node("8"));
		linkedList.add(new LinkedList.Node("9"));
		linkedList.add(new LinkedList.Node("10"));
		
		pairwiseSwapSimple(linkedList);
		
		pairwiseLinkSwap(linkedList);
	}
	
	public static void pairwiseLinkSwap(LinkedList linkedList){
		displayLinkedList(linkedList.head);
		LinkedList.Node prev = linkedList.head;
		linkedList.head=prev.next;
		pairwiseLinkSwapImpl(prev,null);
		displayLinkedList(linkedList.head);
	}
	
	public static void pairwiseLinkSwapImpl(LinkedList.Node prev,LinkedList.Node old){
		LinkedList.Node curr = prev.next;
		LinkedList.Node next = curr.next;
		LinkedList.Node temp = prev;
		//System.out.println("prev:" + prev.data + ", curr: " + curr.data + ", next: " + next.data);
		prev.next=next;
		curr.next=prev;
		prev=next;
		if(old!=null)
			old.next=curr;
		if(prev!=null&&prev.next!=null){
			pairwiseLinkSwapImpl(prev,temp);
		}
	}
	
	public static void pairwiseSwapSimple(LinkedList linkedList){
		displayLinkedList(linkedList.head());
		pairwiseSimpleSwapImpl(linkedList.head);
		displayLinkedList(linkedList.head());
		System.out.println("--------------------------------------");
	}
	
	public static void pairwiseSimpleSwapImpl(LinkedList.Node first){
		if(first!=null && first.next!=null){
			String temp=first.data;
			first.data=first.next.data;
			first.next.data=temp;
			pairwiseSimpleSwapImpl(first.next.next);
		}
	}
	
	static class LinkedList{
	    private Node head=null;
	    private Node tail=null;
	  
	    public LinkedList(){
	        tail = head;
	    }
	  
	    public Node head(){
	        return head;
	    }
	    
	    public Node tail(){
	        return tail;
	    }
	  
	    public void add(Node node){
	    	if(head==null){
	    		this.head = node;
	    		this.tail = node;
	    	}
	    	this.tail.next = node;
	    	this.tail = node;
	    }
	  
	    public static class Node{
	        public Node next=null;
	        private String data;

			public Node(String data){
	            this.data = data;
	        }
	      
	        public String data() {
	            return data;
	        }

	        public void setData(String data) {
	            this.data = data;
	        }

	        public Node next() {
	            return next;
	        }

	        public void setNext(Node next) {
	            this.next = next;
	        }
	      
	        public String toString(){
	            return this.data + "->" + super.toString().substring(64);
	        }
	    }
	}
	
	public static void displayLinkedList(LinkedList.Node first){
		LinkedList.Node current = first;
		while(current!=null){
			System.out.print(current.data + "  ");
			current = current.next;
		}
		System.out.println();
	}
}

