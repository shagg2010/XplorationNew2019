package com.yadas.code.java.ds;

import java.util.HashSet;

public class XLinkedList<T extends Comparable<T>> {
	
	private Node<T> head=null;
	private Node<T> tail=null;
	public HashSet<Node<T>> set=new HashSet<Node<T>>();
	private int size = -1;
	
	public Node<T> search(T data) {
		System.out.println("[LOG] Searching " + data + " ...!");
		return findElement(head, data);
	}
	private Node<T> findElement(Node<T> curr, T data) {
		if(curr==null)
			return null;
		else {
			if(curr.data.compareTo(data)==0)
				return curr;
			else
				return findElement(curr.next, data);
		}
	}
	
	
	public int size() {
		return this.size==-1?getLength(head):0;
	}
	
	private int getLength(Node<T> node) {
		if(node==null) {
			return 0;
		}
		return 1 + getLength(node.next);
	}
	
	public void clear() {
		this.head = null;
	}
	
	public void add(T data) {
		if(data==null)
			throw new NullPointerException("Null Data for XLinkedList Not Allowed!");
		Node<T> node = new Node<>(data);
		set.add(node);
		System.out.println("[LOG] Adding " + data + " ...!");
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			Node<T> curr = head;
			while(curr.next!=null) {
				curr=curr.next;
			}
			curr.next = node;
			tail = node;
		}
	}
	
	public T remove(T data) {
		System.out.println("[LOG] Trying to Remove " + data + " ...!");
		if(data==null)
			throw new NullPointerException("Null Data for XLinkedList Not Allowed!");
		Node<T> curr = head;
		Node<T> prev = null;
		T result = null;
		while(curr!=null) {
			if(data.compareTo(curr.data)==0) {
				result = curr.data;
				if(prev==null){
					//removing head
					head.data = null;
					head = head.next;
				}
				else {
					prev.next = curr.next;
					//if removing tail
					if(curr==tail) {
						tail = prev;
					}
				}
			}
			prev=curr;	
			curr=curr.next;
		}
		return result;
	}
	
	public T removeAtIndex(int index) {
		if(index<0)
			throw new NullPointerException("Index Less Than 0 Not Allowed!");
		System.out.println("[LOG] Trying to Remove Node At Index: " + index + " ...!");
		Node<T> curr = head;
		Node<T> prev = null;
		T result = null;
		int i=0;
		while(curr!=null) {
			if(i==index) {
				result = curr.data;
				if(prev==null){
					//removing head
					head.data = null;
					head = head.next;
				}
				else {
					prev.next = curr.next;
					//if removing tail
					if(curr==tail) {
						tail = prev;
					}
				}
			}
			prev=curr;	
			curr=curr.next;
			i++;
		}
		
		return result;
	}
	
	public T remove(Node<T> node) {
		if(node.data==null)
			throw new NullPointerException("Null Data for XLinkedList Not Allowed!");
		System.out.println("[LOG] Trying to Remove " + node.data + " ...!");
		Node<T> curr = head;
		Node<T> prev = null;
		T result = null;
		while(curr!=null) {
			if(node.data.compareTo(curr.data)==0) {
				result = curr.data;
				if(prev==null){
					//removing head
					head.data = null;
					head = head.next;
				}
				else {
					prev.next = curr.next;
					//if removing tail
					if(curr==tail) {
						tail = prev;
					}
				}
			}
			prev=curr;	
			curr=curr.next;
		}
		return result;
	}

	
	public static class Node<T extends Comparable<T>>{
		private T data;
		private Node<T> next = null;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		
		public String toString() {
			return "[Node: " + data.toString() + "]" + " -> " + next.getData();
		}
		public int compare(Node<T> node) {
			return data.compareTo(node.data);
		}
	}
	
	public T getHead() {
		if(head!=null)
			return head.data;
		return null;
	}
	public T getTail() {
		if(head!=null)
			return tail.data;
		return null;
	}
	public Node<T> getHeadNode() {
		if(head!=null)
			return head;
		return null;
	}
	public Node<T> getTailNode() {
		if(tail!=null)
			return tail;
		return null;
	}
	public void setHeadNode(Node<T> head) {
		this.head = head;
	}
	public void setTailNode(Node<T> tail) {
		this.tail = tail;
	}
	
	public void traverse() {
		Node<T> curr = head;
		System.out.println("\t\t>>>>>> *Head: " + this.getHead() + "\t\t*Tail: " + this.getTail() + "\t*Size:" + size() + " <<<<<<<");
		while(curr!=null) {
			System.out.print(curr.data);
			if(curr.next!=null)
				System.out.print(" -> ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public void updateTailNodeAndRecalculateSize() {
		Node<T> curr = head;
		while(curr.getNext()!=null) {
			curr = curr.getNext();
		}
		this.tail = curr;
		this.size = -1;
		size();
	}
	
	public void traverseFrom(Node<T> node) {
		Node<T> curr = node;
		if(curr==null)
			throw new NullPointerException("Null Node Cannot Be An Argument!");
		System.out.println("*Head: " + this.getHead() + "\t^Tail: " + this.getTail());
		while(curr!=null) {
			System.out.print(curr.data);
			if(curr.next!=null)
				System.out.print(" -> ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public String toString() {
		traverse();
		return "";
	}
}
