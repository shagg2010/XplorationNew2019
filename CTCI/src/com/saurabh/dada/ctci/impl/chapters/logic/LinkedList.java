package com.saurabh.dada.ctci.impl.chapters.logic;

public class LinkedList<T> {
	
	private Node<T> head;
    private Node<T> tail;
    
    public LinkedList(){
    	this.head = new Node<T>();
    	this.tail=this.head;
    }
    
    public void add(T data){
    	Node<T> node = new Node<T>(data);
    	this.tail.next=node;
    	this.tail=node;
    }
    
    public boolean deleteOne(T data){
    	Node<T> curr=head;
    	Node<T> prev=curr;
    	while(curr!=null){
    		if(curr.getData()!=null && curr.getData().equals(data)){
    			prev.next=curr.next;
    			return true;
    		}
    		prev=curr;
    		curr=curr.next;
    	}
    	return false;
    }
    
    public Node<T> getTail(){
    	return this.tail;
    }
    
    public Node<T> getHead(){
    	return this.head;
    }
    
    public void display(){
    	Node<T> curr=head;
    	while(curr!=null){
    		System.out.print(curr);
    		if(curr.next!=null){
    			System.out.print(" -> ");
    		}
    		curr=curr.next;
    	}
    	System.out.println();
    }
    
    public T nthItemFromLast(int n){
    	Node<T> curr=head;
    	while(n>0){
    		curr=curr.next;
    		n--;
    		if(curr==null){
    			break;
    		}
    	}
    	//System.out.println("curr: " + curr.getData());
    	if(n>0){
			return null;
		}
    	else{
    		Node<T> runner=head;
    		while(curr!=null){
    			curr=curr.next;
    			runner=runner.next;
    		}
    		return runner.getData();
    	}
    }
    
    public void iterate(){
    	iterate(-1);
    }
    
    public void iterate(int limit){
    	if(limit<0){
    		//iterate all
    		Node<T> curr=head;
        	while(curr!=null){
        		System.out.print(curr);
        		if(curr.next!=null){
        			System.out.print(" -> ");
        		}
        		curr=curr.next;
        	}
        	System.out.println();
    	}
    	else{
    		Node<T> curr=head;
        	while(limit>=0){
        		System.out.print(curr);
        		if(curr.next!=null&&limit>0){
        			System.out.print(" -> ");
        		}
        		limit--;
        		curr=curr.next;
        		if(curr==null)
        			break;
        	}
        	System.out.println();
    	}
    }
    
    public Node<T> getNode(T data){
    	Node<T> curr=head;
    	while(curr!=null){
    		if(curr.getData()==data){
    			return curr;
    		}
    		curr=curr.next;
    	}
    	return null;
    }
    
    public boolean detectLoop(){
    	Node<T> curr=head;
    	Node<T> runner=head.next;
    	while(true){
    		if(curr==null||runner==null){
    			return false;
    		}
    		if(runner==curr&&runner!=null)
    			return true;
    		curr=curr.next;
    		runner=runner.next;
    		if(runner!=null)
    			runner=runner.next;
    	}
    }
    
    public T detectLoopStart(){
    	if(!detectLoop())
    		return null;
    	
    	Node<T> curr=head;
    	Node<T> runner=head.next;
    	Node<T> temp=null;
    	while(curr!=null&&runner!=null){
    		if(runner==curr){
    			//System.out.println("curr: " + curr + ",runner: " + runner);
    			temp=curr;
    			break;
    		}
    		curr=curr.next;
    		runner=runner.next;
    		if(runner!=null)
    			runner=runner.next;
    	}
    	curr=temp.next;
    	int i=1;
    	while(curr!=runner){
    		curr=curr.next;
    		i++;
    	}
    	//the perimeter of the loop is i
    	System.out.println("Loop size: " + i);
    	//Then we put a node at the head and let it go P steps, and put another node at the head. 
    	//We advance these two nodes both one step each time, when they first meet, it's the start point of the cycle.
    	curr=head;
    	while(i>0){
    		curr=curr.next;
    		i--;
    	}
    	runner=head;
    	while(curr!=null&&runner!=null){
    		if(runner==curr){
    			//System.out.println("curr: " + curr + ",runner: " + runner);
    			temp=curr;
    			break;
    		}
    		curr=curr.next;
    		runner=runner.next;
    	}
    	return temp.getData();
    }
    
    /*public Node<T> getNodeAtIndex(int i){
    	Node<T> curr=head;
    	while(curr!=null||i>0){
    		curr=curr.next;
    		i--;
    	}
    	return curr;
    }*/
    
    public static class Node<T>{
    	private Node<T> next=null;
    	private T data;
    	
    	public Node(){
    		data=null;
    	}
    	
    	public Node(T data){
    		this.data=data;
    	}
    		
    	public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		
		public String toString(){
			if(data==null)
				return "*";
			return data.toString();
		}
    	
    }

}
