package com.saurabh.dada.iq.impl;

public class LinkedList<T extends Comparable<T>> {

	private Node<T> head=null;
	private Node<T> tail=null;
	private int size=0;
	
	public LinkedList(){
	}
	
	public void add(T data){
		final Node<T> last=tail;
		final Node<T> node = new Node<>(data);
		tail=node;
		if(last==null)
			head=node;
		else
			last.setNext(node);
		size++;
	}
	
	public void addAfter(Node<T> prev,Node<T> node){
		for(Node<T> x=head;x!=null;x=x.getNext()){
			if(x.equals(prev)){
				Node<T> t = x.getNext();
				t.setNext(node);
				node.setNext(t);
			}
		}
	}
	public void remove(T data){
		if(head!=null&head.getData()==data){
			head=head.getNext();
			size--;
			return;
		}
		
		for (Node<T> x=head; x!=null; x=x.next) {
			if (x.getNext()!=null && x.getNext().getData()==data) {
				Node<T> r = x.getNext();
				if(r==tail){
					tail=x;
				}
				x.setNext(x.getNext().getNext());
				r.setData(null);
				r.setNext(null);
				r=null;
				size--;
				return;
			}
		}
	}
	
	public void removeAtIndex(int index){
		if(index+1>size||index<0)
			return;
		else{
			if(index==0){
				head=head.getNext();
				size--;
				return;
			}
			else{
				int i=0;
				Node<T> x=head;
				while(i<index-1) {
					//go to the previous index 
					x=x.getNext();
					i++;
				}
				if(x.getNext()!=null){
					if(x.getNext()==tail){
						tail=x;
					}
					x.setNext(x.getNext().getNext());
				}
				size--;
			}
		}
	}
	
	public void swap(T node1, T node2){
		Node<T> prev=null;
		Node<T> prev1=null;
		Node<T> prev2=null;
		Node<T> n1=null;
		Node<T> n2=null;
		for(Node<T> x=head;x!=null;x=x.getNext()){
			if(x.getData().equals(node1)){
				n1=x;
				prev1=prev;
			}
			if(x.getData().equals(node2)){
				n2=x;
				prev2=prev;
			}
			prev=x;
		}
		if(prev1==null&&!node1.equals(head.getData())){
			//given node not found and given node is also NOT head
			return;
		}
		if(prev2==null&&!node2.equals(head.getData())){
			//given node not found and given node is also NOT head
			return;
		}
		if(prev1==null){
			//node1 is head
			prev2.setNext(n1);
			Node<T> t=n1.getNext();
			n1.setNext(n2.getNext());
			n2.setNext(t);
			head=n2;
		}
		else if(prev2==null){
			//node2 is head
			prev1.setNext(n2);
			Node<T> t=n2.getNext();
			n2.setNext(n1.getNext());
			n1.setNext(t);
			head=n1;
		}
		else{
			//just swap
			prev2.setNext(n1);
			prev1.setNext(n2);
			Node<T> t = n2.getNext();
			n2.setNext(n1.getNext());
			n1.setNext(t);
			if(n1.getNext()==null){
				tail=n1;
			}
			if(n2.getNext()==null){
				tail=n2;
			}
		}
		
		System.out.println("\nprev1: " + prev1 + ", n1: " + n1 +"\tprev2: " + prev2 + ", n2: " + n2);
	}
	
	public void reverse(){
		Node<T> prev = head;
		//use prev, curr and next pointers to reverse a linked list
		if(prev!=null){
			Node<T> curr=prev.getNext();
			while(curr!=null){
				Node<T> next = curr.getNext();
				curr.setNext(prev);
				prev=curr;
				curr=next;
			}
		}
		head.setNext(null);//make old head pointer to point to null as its the last node now
		tail=head;//make tail pointer as head
		head=prev;//update the head pointer to last node
	}
	
	public void reverse(int k){
		if(k<=1)
			return;
		Node<T> prev = head;
		while(prev!=null){
			prev = reverse(prev, k-1,null);
		}
	}
	
	private Node<T> reverse(Node<T> prev,int k, Node<T> last){
		boolean updateHead=false;
		if(prev==null){
			return null;
		}
		if(prev==head){
			updateHead=true;
		}
		Node<T> curr = null;
		curr=prev.getNext();
		while(curr!=null&&k>0){
			Node<T> next = curr.getNext();
			System.out.println("prev: " + prev + "\tcurr: " + curr + "\tnext: " + next);
			curr.setNext(prev);
			prev=curr;
			curr=next;
			k--;
			if(updateHead){
				head=prev;
				System.out.println("head: " + head);
			}
		}
		System.out.println("curr: " + curr);
		return curr;
	}
	
	public void merge(LinkedList<T> ll2,boolean removeDuplicates){
		Node<T> curr1 = this.getHead();
		Node<T> curr2 = ll2.getHead();
		
		while(curr1!=null&&curr2!=null){

			if (curr1.getData().compareTo(curr2.getData()) < 0) {
				//original list node is smaller
				if(curr1.getNext()!=null){
					if(curr2.getData().compareTo(curr1.getNext().getData())<0){
						Node<T> nxt = curr1.getNext();
						curr1.setNext(curr2);
						Node<T> t=curr2.getNext();
						curr2.setNext(nxt);
						curr2=t;
					}
					else{
						curr1=curr1.getNext();
					}
				}
				else{
					//append remaining all nodes
					curr1.setNext(curr2);
				}
				
			} else if (curr1.getData().compareTo(curr2.getData()) == 0) {
				//original list node is equal to secondary list node
				if(removeDuplicates){
					//do not add node
					curr2=curr2.getNext();
				}
				else{
					Node<T> nxt = curr1.getNext();
					curr1.setNext(curr2);
					Node<T> t=curr2.getNext();
					curr2.setNext(nxt);
					curr2=t;
				}
			} else {
				//original list node is bigger
				//add this new node in before to original list
				T data1 = curr1.getData();
				T data2 = curr2.getData();
				Node<T> nxt = curr1.getNext();
				curr1.setNext(curr2);
				Node<T> t=curr2.getNext();
				curr2.setNext(nxt);
				curr2=t;
				curr1.setData(data2);
				curr2.setData(data1);
			}

		}
		
	}
	
	public boolean contains(T data){
		for(Node<T> x=head;x!=null;x=x.getNext()){
			if(x.getData().equals(data)){
				return true;
			}
		}
		return false;
	}
	
	public int length(){
		//return recurLen(head, 0);
		return recurLen_v2(head);
	}
	
	@SuppressWarnings("unused")
	private int recurLen(Node<T> n,int s){
		if(n==null)
			return s;
		else{
			s=s+1;
			return recurLen(n.getNext(), s);
		}
	}
	
	private int recurLen_v2(Node<T> n){
		if(n==null)
			return 0;
		else{
			return 1 + recurLen_v2(n.getNext());
		}
	}
	
	public void display(boolean displayHeadTail){
		if(displayHeadTail)
			System.out.println("\nSize: " + this.getSize() + " Head: " + this.getHead() + " Tail: " + this.getTail());
        for (Node<T> x = head; x != null; x = x.next){
        	System.out.print(x.data);
        	if(x.next!=null)
        		System.out.print(" -> ");
        }
        System.out.println();
	}
	
	public Node<T> getHead() {
		return this.head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public int getSize() {
		return size;
	}



	public static class Node<T>{
		private Node<T> next;
		private T data;
		
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
			return " " + data.toString();
		}
	}
	
}
