package com.saurabh.dada.iq.impl;

public class Arrays_NextGreaterElement_Solia {


	public static void main(String[] args) {
		long start =System.nanoTime();
		int[] list={0,0,0,0,0}; //{2,1,5,3,7,6}
		int max= list[list.length-1];
		int currindexplusone=max;
		MyStack stackObj = new MyStack(list.length);
		stackObj.push(-1);
		for (int i = list.length - 2; i >= 0; i--) {
			if (list[i] > currindexplusone) {
				if (list[i] <= stackObj.peek()) {
					stackObj.push(stackObj.peek());
				} else if (list[i] > max) {
					stackObj.push(-1);
					max = list[i];
				} else if (list[i] > max) {
					stackObj.push(-1);
					max = list[i];
				}

				else {
					stackObj.push(max);
				}

			} else {
				stackObj.push(currindexplusone);
			}
			currindexplusone=list[i];
		}
		while (!stackObj.isEmpty()) {
	         long value = stackObj.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
		System.out.println("time taken: " + (System.nanoTime() - start));
	      System.out.println("");

	}
	
}

class MyStack {
	   private int maxSize;
	   private long[] stackArray;
	   private int top;
	   public MyStack(int s) {
	      maxSize = s;
	      stackArray = new long[maxSize];
	      top = -1;
	   }
	   public void push(long j) {
	      stackArray[++top] = j;
	   }
	   public long pop() {
	      return stackArray[top--];
	   }
	   public long peek() {
	      return stackArray[top];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	   public static void main(String[] args) {
		      MyStack theStack = new MyStack(10); 
		      theStack.push(10);
		      theStack.push(20);
		      theStack.push(30);
		      theStack.push(40);
		      theStack.push(50);
		      while (!theStack.isEmpty()) {
		         long value = theStack.pop();
		         System.out.print(value);
		         System.out.print(" ");
		      }
		      System.out.println("");
		   }
}	   