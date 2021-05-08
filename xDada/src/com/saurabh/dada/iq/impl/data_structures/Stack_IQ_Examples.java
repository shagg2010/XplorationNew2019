package com.saurabh.dada.iq.impl.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.ISUB;

public class Stack_IQ_Examples {

	public static void main(String[] args) {
		
		String str1 = "Many more happy returns of the day ABC 🎉🎊";
		System.out.println(str1);
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.addAll(generateRandomIntegerData(5));
		System.out.println("s1: " + s1);
		Stack<Integer> s2 = new Stack<Integer>();
		s2.addAll(generateRandomIntegerData(5));
		System.out.println("s2: " + s2);
		
		Stack<Integer> sorted = mergeAndSortSets(s1, s2);
		System.out.println("sorted: " + sorted);
		
		
		MyStack theStack = new MyStack();
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);
		
		MyStackArray<Integer> stack = new MyStackArray<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println("Original Stack: " + stack);
		
		MyStackArray<Integer> stackR = removeMiddleOfStack(stack);
		System.out.println("After removing middle: " + stackR);
		
		MyStackArray<String> post = new MyStackArray<String>();
		String prefixNotation = "*+AB-CD";  //Ans: AB+CD-*
		//https://www.geeksforgeeks.org/prefix-postfix-conversion/
		char[] cArr = prefixNotation.toCharArray();
		for(int i=cArr.length-1;i>=0;i--) {
			if(!isOperator(cArr[i])) {
				post.push(new String(Character.valueOf(cArr[i]).toString()));
			}
			else {//operator encountered
				String str = new String(post.pop().toString() + post.pop().toString() + cArr[i]);
				post.push(str);
			}
		}
		System.out.println("Prefix Notation: " + prefixNotation);
		System.out.println("Postfix Notation: " + post);
	}
	
	public static MyStackArray<Integer> removeMiddleOfStack(MyStackArray<Integer> stack) {
		return removeMiddle(stack, stack.size() ,0);
	}
	
	private static MyStackArray<Integer> removeMiddle(MyStackArray<Integer> stack, int size, int curr) {
		Integer item = null;
		if(stack!=null&&!stack.isEmpty()) {
			item = stack.pop();
			removeMiddle(stack, size, curr+1);
		}
		if(item!=null && (size/2)!=curr) {
			stack.push(item);
		}
		return stack;
	}
	
	public static boolean isOperator(char x) {
		  switch (x) {
		  case '+':
		  case '-':
		  case '/':
		  case '*':
		    return true;
		  }
		  return false;
		}
	
	public static Stack<Integer> mergeAndSortSets(Stack<Integer> s1, Stack<Integer> s2){
		Stack<Integer> sorted = new Stack<Integer>();
		while(!s1.isEmpty()) {
			insertItemInSortedStack(s1.pop(), sorted);
		}
		while(!s2.isEmpty()) {
			insertItemInSortedStack(s2.pop(), sorted);
		}
		return sorted;
	}
	
	public static void insertItemInSortedStack(Integer item, Stack<Integer> stack) {
		if(!stack.isEmpty()&&stack.peek()>item) {
			Integer data = stack.pop();
			insertItemInSortedStack(item, stack);
			stack.push(data);
		}
		else {
			stack.push(item);
		}
	}
	
	public static List<Integer> generateRandomIntegerData(int n){
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		int low = 1;
		int high = 100;
		for(int i=0;i<n;i++) {
			int result = r.nextInt(high-low) + low;
			list.add(result);
		}
		return list;
	}

}

class MyStack {
	private int maxSize = 100;
	private int[] stackArray;
	private int top;

	public MyStack() {
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int item) {
		stackArray[++top] = item;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public void clear() {
		stackArray = new int[maxSize];
		top = -1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("\nStack: [\n");
		for (int i = top; i >= 0; i--)
			sb.append(stackArray[i] + "\n");
		return sb.append("]").toString();
	}
}

class MyStackArray<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyStackArray() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    
    public void addAll(E[] items) {
    	for(E e: items) {
    		push(e);
    	}
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    
    public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == Integer.MAX_VALUE - 2147403647);
	}
	
	public int size() {
		return size;
	}
    
    public String toString() {
		StringBuilder sb = new StringBuilder("Stack: [");
		for (int i = size-1; i >= 0; i--)
			sb.append(elements[i] + "\t");
		//sb = sb.toString().trim();
		return sb.append("]").toString();
	}
}