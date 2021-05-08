package com.saurabh.dada.iq.impl.gfg;

import java.util.Stack;

public class LinkedList {
	
	private Node head;
    private Node tail;
    private int len;
    
    public LinkedList(){
    	this.head = null;
    	this.tail=null;
    }
    
    public void add(Integer data){
    	Node node = new Node(data);
    	if(head==null){
    		head = node;
    		tail=head;
    		len++;
    		return;
    	}
    	this.tail.next=node;
    	this.tail=node;
    	this.len++;
    }
    
    public void reverse(){
    	Stack<Node> stack = new Stack<Node>();
    	Node curr=head;
    	while(curr!=null){
    		stack.push(curr);
    		curr=curr.next;
    	}
    	Node n=null;
    	head=stack.peek();
    	while(!stack.isEmpty()){
    		n=stack.pop();
    		if(stack.size()>0)
    			n.next=stack.peek();
    		else{
    			n.next=null;
    			tail=n;
    		}
    	}
    	System.out.println("New Head: " + head + ", New Tail: " + tail);
    }
    
    public void reverseRecursively(){
    	reverseRecur(head,null);
    }
	
    private void reverseRecur(Node curr,Node prev){
    	if(curr==null){
    		head=prev;
    		return;
    	}
    	Node next=curr.next;
    	reverseRecur(next,curr);
    	curr.next=prev;
    }
    public void swapNodes(int data1,int data2){
    	
    	Node n1=null;
		Node n2=null;
    	Node prev1=null;
    	Node prev2=null;
    	boolean f1=false;
    	boolean f2=false;
    	
    	Node curr=head;
    	
    	while(curr!=null){
    		if(curr.data==data1){
    			f1=true;
    			n1=curr;
    		}
    		if(curr.data==data2){
    			f2=true;
    			n2=curr;
    		}
    		if(n1!=null&&n2!=null){
    			Node temp=null;
    			/*System.out.print("prev1: " + prev1+"\t");
    			System.out.println("n1: " + n1);
    			System.out.print("prev2: " + prev2+"\t");
    			System.out.println("n2: " + n2);*/
    			if(prev1==null){
    				//this means n1 is head node, and now n2 should be head
    				prev2.next=n1;
    				temp=n1.next;
    				n1.next=n2.next;
    				n2.next=temp;
    				head=n2;
    			}
    			else if(prev2==null){
    				//this means n2 is head node, and now n1 should be head
    				prev1.next=n2;
    				temp=n2.next;
    				n2.next=n1.next;
    				n1.next=temp;
    				head=n1;
    			}
    			else{
    				prev1.next=n2;
    				temp=n2.next;
    				n2.next=n1.next;
    				n1.next=temp;
    				prev2.next=n1;
    			}
    			break;
    		}
    		if(!f1)
    			prev1=curr;
    		if(!f2)
    			prev2=curr;
    		curr=curr.next;
    	}
    }
    
    public int getLen() {
		return len;
	}

	public boolean searchDataPoints(int... data){
    	if(data.length>len)
    		return false;
    	boolean[] list = new boolean[data.length];
    	for(int i=0;i<data.length;i++){
    		Node curr = head;
    		boolean res=false;
    		//System.out.print(data[i]+"==");
    		while(curr!=null){
    			if(data[i]==curr.data){
    				res=true;
    				list[i]=true;
    				//System.out.println(curr.data);
    			}
    			curr=curr.next;
        	}
    		if(!res)
    			break;
		}
    	boolean ans = true;
    	for(int i=0;i<list.length;i++){
    		if(!list[i]){
    			ans=false;
    			break;
    		}
    	}
    	return ans;
    }
    
    private Node findNode(int data){
    	Node curr=head;
    	while(curr!=null){
    		if(curr.data==data){
    			return curr;
    		}
    		curr=curr.next;
    	}
    	return null;
    }
	
    public void display(){
    	Node curr=head;
    	System.out.print("* -> ");
    	while(curr!=null){
    		System.out.print(curr);
    		if(curr.next!=null){
    			System.out.print(" -> ");
    		}
    		curr=curr.next;
    	}
    	System.out.println();
    }
    
    public static class Node{
    	private Node next=null;
    	private Integer data;
    	
    	public Node(){
    		data=null;
    	}
    	
    	public Node(Integer data){
    		this.data=data;
    	}
    		
    	public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
			this.data = data;
		}
		
		public String toString(){
			if(data==null)
				return "*";
			return data.toString();
		}
    	
    }
}
