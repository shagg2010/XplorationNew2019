package com.saurabh.dada.iq.impl.companies.oracle;

import java.util.Stack;

public class ReverseStackWithoutUsingAnyDataStructure {

	private static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Stack: " + stack);
		reverseStack();
		System.out.println("Stack [Reversed]: " + stack);

	}

	public static Stack<Integer> reverseStack(){
		if(!stack.isEmpty()) {
			Integer popped = stack.pop();
			reverseStack();
			insertAtTheBottom(popped);
		}
		return stack;
	}
	
	public static void insertAtTheBottom(Integer element){
		if(stack.isEmpty()) {
			stack.add(element);
		}
		else {
			Integer popped = stack.pop();
			insertAtTheBottom(element);
			stack.push(popped);
		}
	}
}
