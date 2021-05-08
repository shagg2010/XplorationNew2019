package com.yadas.code.java.ds;

import java.util.HashSet;

public class XCircularLinkedList<T extends Comparable<T>> {
	
	private Node<T> last = null;
	private int size = -1;
	public HashSet<Node<T>> set=new HashSet<Node<T>>();
	
	public void add(T data) {
		if(data==null)
			throw new NullPointerException("Null Data for XCircularLinkedList Not Allowed!");
		Node<T> node = new Node<>(data);
		set.add(node);
		System.out.println("[LOG] Adding " + data + " ...!");
		if(last==null) {
			last = node;
			node.setNext(last);
		}
		else {
			Node<T> temp = last.getNext();
			last.setNext(node);
			node.setNext(temp);
			last=node;
		}
	}
	
	public void addSorted(T data) {
		if(data==null)
			throw new NullPointerException("Null Data for XCircularLinkedList Not Allowed!");
		Node<T> node = new Node<>(data);
		set.add(node);
		System.out.println("[LOG] Adding " + data + " ...!");
		if(last==null) {
			last = node;
			node.setNext(last);
		}
		else {
			if(node.getData().compareTo(last.getData())>=0) {
				Node<T> temp = last.getNext();
				last.setNext(node);
				node.setNext(temp);
				last=node;
			}
			else {
				Node<T> curr = last;
				while(curr.getNext().getData().compareTo(node.getData())<0&&curr.getNext()!=last) {
					curr=curr.getNext();
				}
				Node<T> temp = curr.getNext();
				curr.setNext(node);
				node.setNext(temp);
			}
		}
	}
	
	public Node<T> search(T data) {
		System.out.println("[LOG] Searching " + data + " ...!");
		return findElement(last.getNext(), data);
	}
	private Node<T> findElement(Node<T> curr, T data) {
		if(curr==last)
			return null;
		else {
			if(curr.data.compareTo(data)==0)
				return curr;
			else
				return findElement(curr.next, data);
		}
	}
	public void traverse() {
		Node<T> curr = last.getNext();
		System.out.println("\t\t>>>>>> *Head: " + last.getNext() + "\t\t*Last: " + last + "\t*Size:" + size() + " <<<<<<<");
		while(curr!=last) {
			System.out.print(curr.data);
			System.out.print(" -> ");
			curr = curr.next;
		}
		System.out.print(last.data);
		System.out.println();
	}
	
	public int size() {
		return this.size==-1?getLength(last.getNext()):0;
	}
	
	private int getLength(Node<T> node) {
		if(node==last) {
			return 0;
		}
		return 1 + getLength(node.next);
	}
	
	public void clear() {
		this.last = null;
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

}
