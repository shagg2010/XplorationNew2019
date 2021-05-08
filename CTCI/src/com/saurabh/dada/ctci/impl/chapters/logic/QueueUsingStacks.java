package com.saurabh.dada.ctci.impl.chapters.logic;

import java.util.Stack;

public class QueueUsingStacks<T> {
	
	private Stack<T> stackPush;
	private Stack<T> stackPop;
	
	public QueueUsingStacks(){
		stackPush = new Stack<T>();
		stackPop = new Stack<T>();
	}
	
	public void enqueue(T item){
		stackPush.push(item);
	}
	
	public T dequeue(){
		if(stackPop.isEmpty()&&stackPush.isEmpty())
			return null;
		else if(stackPop.isEmpty()&&!stackPush.isEmpty()){
			while(!stackPush.isEmpty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}

}
