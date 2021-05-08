package com.saurabh.dada.ctci.impl.chapters.logic;

public class Chapter03_StackQueuesProblems {
	
	public static Object findMinInStack(Class clazz,Integer[] items){
		
		Stack<Integer> stack = new Stack<>(clazz,items.length+1);
		for(Integer i: items){
			stack.push(i);
		}
		System.out.println("Stack: ");
		stack.display();
		System.out.println("minStack: ");
		stack.displayMinStack();
		return stack.min();
	}
	
	public static void mimicQueueUsingStacks(){
		QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
		queue.enqueue(1);queue.enqueue(2);queue.enqueue(3);queue.enqueue(4);queue.enqueue(5);
		System.out.println("dq: " + queue.dequeue());
		queue.enqueue(6);queue.enqueue(7);queue.enqueue(8);
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
		System.out.println("dq: " + queue.dequeue());
	}
	
	public static java.util.Stack<Integer> sortStack(Integer[] items){
		java.util.Stack<Integer> stack =  new java.util.Stack<>();
		java.util.Stack<Integer> stackStore = new java.util.Stack<>();
		java.util.Stack<Integer> tStack = new java.util.Stack<>();
		
		for(Integer i: items){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			stackStore.push(stack.pop());
		}
		
		while(!stackStore.isEmpty()){
			if(stack.isEmpty()){
				stack.push(stackStore.pop());
			}
			else{
				while(!stack.isEmpty()&&stack.peek()>stackStore.peek()){
					tStack.push(stack.pop());
				}
				stack.push(stackStore.pop());
				while(!tStack.isEmpty()){
					stack.push(tStack.pop());
				}
			}
		}
		return stack;
	}

}
