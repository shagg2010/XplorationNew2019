package com.yadas.code.java.ds;

import java.util.HashSet;

import com.yadas.code.java.ds.XLinkedList.Node;

public class XDoublyLinkedList<T extends Comparable<T>> {
	
	private Node<T> head=null;
	private Node<T> tail=null;
	public HashSet<Node<T>> set=new HashSet<Node<T>>();
	private int size = -1;
	
	
	public void add(T data) {
		if(data==null)
			throw new NullPointerException("Null Data for XDoublyLinkedList Not Allowed!");
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
			node.prev = curr;
			tail = node;
		}
	}
	
	public void addSorted(T data) {
		if(data==null)
			throw new NullPointerException("Null Data for XDoublyLinkedList Not Allowed!");
		Node<T> node = new Node<>(data);
		set.add(node);
		System.out.println("[LOG] Adding " + data + " ...!");
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			if(node.getData().compareTo(tail.getData())>=0) {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			else if(node.getData().compareTo(tail.getData())<0) {
				if(node.getData().compareTo(head.getData())<=0) {
					//less than head
					Node<T> curr = head;
					node.setNext(curr);
					curr.setPrev(node);
					head = node;
				}
				else {
					//bigger than head
					Node<T> curr = head;
					while(curr.getNext()!=null&&node.getData().compareTo(curr.getNext().getData())>0) {
						curr=curr.next;
					}
					Node<T> currNext = curr.getNext();
					curr.setNext(node);
					node.setNext(currNext);
					if(currNext!=null)
						currNext.setPrev(node);
					node.setPrev(curr);
					
				}
			}
		}
	}
	
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
	
	public void traverseReverse() {
		Node<T> curr = tail;
		System.out.println("\t\t>>>>>> *Head: " + this.getHead() + "\t\t*Tail: " + this.getTail() + "\t*Size:" + size() + " <<<<<<<");
		while(curr!=null) {
			System.out.print(curr.data);
			if(curr.prev!=null)
				System.out.print(" -> ");
			curr = curr.prev;
		}
		System.out.println();
	}
	
	public static class Node<T extends Comparable<T>>{
		private T data;
		private Node<T> next = null;
		private Node<T> prev = null;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
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
		public Node<T> getPrev() {
			return prev;
		}
		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
		public String toString() {
			return "[" + data.toString() + "]";
		}
		/*
		 * public String toString() { return prev.getData() + " <- [" + data.toString()
		 * + "]" + " -> " + next.getData(); }
		 */
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
}
