package com.saurabh.dada.iq.impl;

import java.util.Stack;

public class CustomRuntimeException {

	public static void main(String[] args) {
		//no need to use user try-catch block as Runtime exceptions are unchecked exceptions 
		Stack<Integer> stack = new Stack<Integer>();
		if(stack.isEmpty()){
			throw new StackEmptyRuntimeException("Stack is empty");
		}

	}

}
class StackEmptyRuntimeException extends RuntimeException{

	private static final long serialVersionUID = -6370209126998968868L;
	
	public StackEmptyRuntimeException(){
		super();
	}
	
	public StackEmptyRuntimeException(String msg){
		super(msg);
	}
	
}
