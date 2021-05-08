package com.saurabh.dada.iq.impl;

import java.util.Stack;

public class Array_NextGreaterElementInTheRight_StackVersion {

	private static int[] list1 =    {4, 5, 2,25,20,11,21,13,23, 3}; 
								// ={5,25,25,-1,21,21,23,23,-1,-1}
	
	private static int[] list2  =   {11, 6,34, 1,70, 4,18, 3,21, 0,13}; 
								 //={34,34,70,70,-1,18,21,21,-1,13,-1}
	
	public static void main(String[] args) {
		
		//http://www.crazyforcode.com/greater-element-array/
		int len = list1.length;
		Stack<Integer> stack = new Stack<>();
		stack.push(list1[0]);

		
		for(int i=1;i<len;i++){
			int currItem = list1[i];
			//System.out.println("Item processed: " + currItem);
			int top = stack.peek();
			if(currItem>top){
				while(true){
					top = stack.pop();
					System.out.println(top+"-> " + currItem);
					if(stack.isEmpty())
						break;
					if(stack.peek()>currItem)
						break;
				}
				stack.push(currItem);
			}
			else{
				stack.push(currItem);
			}
				
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+"-> -1");
		}
	}
	
	

}
