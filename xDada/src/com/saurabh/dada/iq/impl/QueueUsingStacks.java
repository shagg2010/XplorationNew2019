package com.saurabh.dada.iq.impl;

import java.util.Stack;

public class QueueUsingStacks {

	public static void main(String[] args) {
		StackQ<String> queue1 = new StackQ<String>();
		queue1.push("1");
		queue1.push("2");
		queue1.push("3");
		queue1.push("4");
		queue1.push("5");
		
		System.out.println(queue1.pop()+"->"+queue1.pop()+"->"+queue1.pop()+"->"+queue1.pop()+"->"+queue1.pop());
		
		SimulatedQueue<String> queue2 = new SimulatedQueue<>();
		queue2.push("1");
		queue2.push("2");
		queue2.push("3");
		queue2.push("4");
		queue2.push("5");
		
		System.out.println(queue2.pop()+"->"+queue2.pop()+"->"+queue2.pop()+"->"+queue2.pop()+"->"+queue2.pop());
		
	}

}

//using recursion and single stack
class SimulatedQueue<E> {
    private java.util.Stack<E> stack = new java.util.Stack<E>();

    public void push(E elem) {
        if (!stack.empty()) {
            E topElem = stack.pop();
            push(elem);
            stack.push(topElem);
        }
        else
            stack.push(elem);
    }

    public E pop() {
        return stack.pop();
    }
}

class StackQ<T> extends Stack<T>{
	
	private static final long serialVersionUID = -7571381787028688956L;

	public T push(T item){
		Stack<T> stack = new Stack<T>();
		while(!isEmpty()){
			stack.push(pop());
		}
		super.push(item);
		while(!stack.isEmpty()){
			super.push(stack.pop());
		}
		return item;
	}
}

