package com.saurabh.dada.iq.impl;

public class LinkedList_ReverseInOnePass {

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
		
		
		LinkedList.Node head = linkedList.head();
		
		LinkedList.Node prev = null;
		LinkedList.Node curr = head;
		LinkedList.Node next = null;
		
		while(curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		linkedList.head = prev;
		
		LinkedList.Node current = linkedList.head;
		while(current!=null){			
			System.out.print(current.data);
			if(current.next!=null)
				System.out.print(" - ");
			current = current.next;
		}
		
	}
	
	public static class LinkedList{
	    public Node head=null;
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
	        public String data;

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
	            return this.data;
	        }
	    }
	}

}
