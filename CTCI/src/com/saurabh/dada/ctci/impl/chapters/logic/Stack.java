package com.saurabh.dada.ctci.impl.chapters.logic;

import java.lang.reflect.Array;

public class Stack<T extends Comparable<T>> {
	
	private int top=-1;
	private int minTop=-1;
	private T[] stack=null;
	private final int max;
	private static final String OVERFLOW="STACK OVERFLOW!";
	private static final String UNDERFLOW="STACK UNDERFLOW!";
	
	private T[] minStack=null;
	//private Stack(){}
	
	@SuppressWarnings("unchecked")
	public Stack(Class<? extends Comparable<T>> type,int max) throws IllegalArgumentException{
		if(max<1){
			throw new IllegalArgumentException("Stack size can't be less than 1.");
		}
		this.max=max;
		this.stack = (T[]) Array.newInstance(type, max);
		//this.minStack = (T[]) new Object[max];
		this.minStack = (T[]) Array.newInstance(type, max);
	}
	
	public void push(T item){
		if(top==max){
			System.out.println(OVERFLOW);
			return;
		}
		synchronized (stack) {
			stack[++top]=item;
			if(minTop==-1){
				minStack[++minTop]=item;
			}
			else{
				if(minStack[minTop].compareTo(item)>=0){
					minStack[++minTop]=item;
				}
			}
			//System.out.println(stack[top-1]);
		}
	}
	
	public T pop(){
		if(stack==null||top==-1){
			System.out.println(UNDERFLOW);
			return null;
		}
		synchronized (stack) {
			if(minStack[minTop].compareTo(stack[top])==0){
				minTop--;
			}
			return stack[top--];
		}
	}
	
	public boolean isEmpty(){
		return top==0?true:false;
	}
	
	public T peek(){
		return top==-1?null:stack[top];
	}
	
	public void display(){
		for(int i=top;i>=0;i--){
			System.out.println(stack[i]);
		}
	}
	
	public void displayMinStack(){
		for(int i=minTop;i>=0;i--){
			System.out.println(minStack[i]);
		}
	}
	
	public int size(){
		return this.top+1;
	}
	
	public T min(){
		return minTop==-1?null:minStack[minTop];
	}
}
