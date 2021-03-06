package com.yadas.code.java.ds;

import java.util.Stack;

public class XStack<T extends Comparable<T>> extends Stack<T>{

	private static final long serialVersionUID = 738909371233751855L;
	private Stack<T> minStack = new Stack<T>();
	private Stack<T> maxStack = new Stack<T>();
	
	public T push(T item) {
		if(minStack.isEmpty())
			minStack.push(item);
		else {
			if(item.compareTo(minStack.peek())<0)
				minStack.push(item);
			else
				minStack.push(minStack.peek());
		}
		if(maxStack.isEmpty())
			maxStack.push(item);
		else {
			if(item.compareTo(maxStack.peek())>0)
				maxStack.push(item);
			else
				maxStack.push(maxStack.peek());
		}
		return super.push(item);
	}
	
	public T pop() {
		minStack.pop();
		maxStack.pop();
		return super.pop();
	}
	
	public T peek() {
		return super.peek();
	}
	
	public boolean empty() {
        return super.size() == 0;
    }
	
	public int size() {
        return super.size();
    }
	
	public synchronized int search(Object o) {
		return super.search(o); 
	}
	public T getMin() {
		return minStack.peek();
	}
	public T getMax() {
		return maxStack.peek();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		int i = size()-1;
		for(int x=i;x>=0;x--) {
			System.out.println("| " + super.elementData[x] + " |" + "\n ----");
		}
		sb.append("\n*Min: " + getMin());
		sb.append("\tMax:" + getMax());
		return sb.toString();
	}
}
