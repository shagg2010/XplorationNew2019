package com.yadas.code.java.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Stacks_G4GExamples {

	public static int[][] arr = {{1,2,7},{3,4,8},{5,6,9}};
	
	public static void main(String[] args) {
		//basicOperations();
		//stockSpanProblem();
		//stockSpanProblemMyVersion();
		//stockSpanProblemMyVersion2();
		//nextGreaterElement();
		//expandMatrixByK(arr, 3, 3, 3);
		//reverseStack();
		//deleteMiddleElementOfStack();
		//sortArrayWithStack();
		//maximumDepthOfNestedParenthesis();
		//longestValidSubstring();
		reverseFirstKElementsInQueue();
		//minimumNumberFromGivenSequence();
	}
	private static void reverseFirstKElementsInQueue() {
		Queue<String> q = initializeQueue("10, 20, 30, 40, 50, 60, 70, 80, 90, 100", ",");		
		System.out.println("q: " + q);
		q = reverseFirstKElements(q, 5);
		System.out.println("q: " + q);
	}
	private static Queue<String> reverseFirstKElements(Queue<String> q, int k) {
		Stack<String> st1 = new Stack<String>();
		int slide = q.size() - k;
		for(int i=0;i<k;i++)
			st1.push(q.poll());
		while(!st1.isEmpty())
			q.offer(st1.pop());
		System.out.println("q1: " + q);
		for(int i=0;i<slide;i++) {
			q.offer(q.poll());
		}
		
		return q;
	}
	public static Queue<String> initializeQueue(String itemsStr, String delimiter){
		Queue<String> ll = new LinkedList<String>();
		String[] itemArray = itemsStr.split(delimiter);
		for(int i=0;i<itemArray.length;i++) {
			if(!itemArray[i].equalsIgnoreCase("null"))
				ll.add(itemArray[i]);
		}
		return ll;
	}
	
	private static void minimumNumberFromGivenSequence() {
		String seq = "DDIDDIID";
		char[] arr1 = seq.toCharArray();
		Stack<String> st1 = new Stack<String>();
		for(int i=9;i>0;i--)
			st1.push(i+"");
		System.out.println(st1.peek());
		StringBuffer sBuff = new StringBuffer();
		Stack<Character> st2 = new Stack<Character>();
		st2.push(arr1[0]);
		
		for(int i=0;i<arr1.length;i++) {
			char c= arr1[i];
			if(c==st2.peek()||c=='I') {
				st2.push(c);
			}
			else {
				char t = '0';
				int nos = st2.size();
				if(!st2.isEmpty())
					t = st2.peek();
				while(!st2.isEmpty()) {
					t = st2.pop();
				}
				if(t!='0'&&t=='D') {
					Stack<String> ts = new Stack<String>();
					for(int j=0;j<nos;j++) {
						String d = st1.pop();
						ts.push(d);
					}
					/*
					 * if(sBuff.length()==0) ts.push(st1.pop());
					 */
					while(!ts.isEmpty())
						sBuff.append(ts.pop());
				}
				else if(t!='0'&&t=='I') {
					for(int j=0;j<nos;j++) {
						sBuff.append(st1.pop());
					}
				}
				st2.push(c);
			}
		}
		System.out.println("sBuff: " + sBuff);
	}
	
	private static void longestValidSubstring() {
		
		String[] arrays = new String[]{"()(()))))",")()())","((()"};
		for(String eq: arrays) {
			char[] arr1 = eq.toCharArray();
			
			Stack<Character> st1 = new Stack<Character>();
			int maxValidLength = 0;
			int maxValidLengthResult = 0;
			
			for(int i=0;i<arr1.length;i++) {
				char c= arr1[i];
				if(c=='(') {
				st1.push(c);	
				}
				if(c==')') {
					if(!st1.isEmpty()&&st1.peek()=='(') {
						st1.pop();
						maxValidLength=maxValidLength+2;
						maxValidLengthResult = maxValidLength>maxValidLengthResult?maxValidLength:maxValidLengthResult;
					}
					else {// invalid ')' bracket
						maxValidLengthResult = maxValidLength>maxValidLengthResult?maxValidLength:maxValidLengthResult;
						maxValidLength = 0;
						st1.clear();
					}
				}
			}
			System.out.println("Equation: " + eq +"\tmaxValidLengthResult: " + maxValidLengthResult);
		}	
	}
	
	private static void maximumDepthOfNestedParenthesis() {
		String eq = "(((X))(((Y))))";
		char[] arr = eq.toCharArray();
		
		Stack<Character> st1 = new Stack<Character>();
		int maxDepth = -1;
		for(char c: arr) {
			if(c=='(') {
			st1.push(c);	
			}
			if(c==')') {
				if(!st1.isEmpty()&&st1.peek()=='(') {
					maxDepth = st1.size()>maxDepth?st1.size():maxDepth;
					//System.out.println("c: " + c + "\tmaxDepth: " + maxDepth);
					st1.pop();
				}
				else
					break;
			}
		}
		if(st1.size()>0)
			maxDepth = -1;
		System.out.println("maxDepth: " + maxDepth);
	}
	
	//8 5 7 1 9 12 10
	private static void sortArrayWithStack() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(8);list.add(5);list.add(7);list.add(1);list.add(9);list.add(12);list.add(10);
		sortArrayWithStack(list);
	}
	private static void sortArrayWithStack(List<Integer> list) {
		System.out.println("List (Before): " + list);
		Stack<Integer> s = new Stack<Integer>();
		s.add(list.get(0));
		for(int i=1;i<list.size();i++) {
			if(list.get(i)>s.peek()) {
				//start removing items from stack until we find the stack top that is smaller or equal to current item
				Stack<Integer> t = new Stack<Integer>();
				while(!s.isEmpty()) {
					if(s.peek()<=list.get(i))
						t.push(s.pop());
					else
						break;
				}
				s.push(list.get(i));
				while(!t.isEmpty())
					s.push(t.pop());				
			}
			else {
				s.push(list.get(i));
			}
		}
		list.clear();
		while(!s.isEmpty()) {
			list.add(s.pop());
		}
		System.out.println("List (After): " + list);
	}
	
	private static void deleteMiddleElementOfStack() {
		Stack<String> s1 = new Stack<String>();
		s1.push("1");s1.push("2");s1.push("3");s1.push("4");s1.push("5");
		System.out.println("s1: " + s1);
		System.out.println("s1: " + deleteMiddleElementOfStackRecursively(s1, s1.size(), 0));
	}
	private static Stack<String> deleteMiddleElementOfStackRecursively(Stack<String> s1, int size, int curr) {
		if(!s1.isEmpty()) {
			String top = s1.pop();
			deleteMiddleElementOfStackRecursively(s1, size, curr+1);
			if(curr!=(size-1)/2) {
				s1.push(top);
			}
		}
		return s1;
	}
	
	private static void reverseStack() {
		Stack<String> s1 = new Stack<String>();
		s1.push("1");s1.push("2");s1.push("3");s1.push("4");s1.push("5");
		System.out.println("s1: " + s1);
		System.out.println("s1 (rev): " + reverseStackRecursively(s1));
	}
	
	private static Stack<String> reverseStackRecursively(Stack<String> s1) {
		String top = null;
		if(!s1.isEmpty()) {
			top = s1.pop();
			reverseStackRecursively(s1);
		}
		if(top!=null) {
			s1.push(null);
			int i = s1.size()-1;
			while(i>=1) {
				s1.set(i, s1.get(i-1));
				i--;
			}
			s1.setElementAt(top, 0);
		}
		return s1;
	}
	
	private static void expandMatrixByK(int[][] matrix, int r, int c, int k) {
		int rows = r * k;
		int cols = c * k;
		int[][] retMatrix = new int[rows][cols];
		
		int x=-1;
		int y=-1;
		for(int i=0;i<rows;i++){
			y=-1;
			if(i%k==0)
				x++;
			for(int j=0;j<cols;j++){
				if(j%k==0)
					y++;
				retMatrix[i][j] = matrix[x][y];
			}
		}
		
		display2DArray(retMatrix, rows, cols);
	}
	public static void display2DArray(int[][] arr, int rows, int cols){
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void nextGreaterElement() {
		int arr[] = {13,7,6,12,14};
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(arr[0]);
		for(int i=1;i<arr.length;i++) {
			int curr =arr[i];
			if(curr<s1.peek()) {
				s1.push(curr);
			}
			if(curr>s1.peek()) {
				while(!s1.isEmpty()&&curr>s1.peek()) {
					System.out.println(s1.pop() + " -> " + curr);
				}
			}
		}
		s1.push(arr[arr.length-1]);
		while(!s1.isEmpty()) {
			System.out.println(s1.pop() + " -> -1");
		}
	}
	private static void stockSpanProblemMyVersion2() {
		//int price[]={ 0,  1,  2,  3,  4,  5,  6 };
		int price[] = {100, 80, 60, 70, 60, 75, 85 }; //solution: {1, 1, 1, 2, 1, 4, 6}
		int span[] = new int[price.length];
		Stack<Integer> stack = new Stack<Integer>();
		int s=0;
		span[s]=1;
		stack.push(price[0]);
		s++;
		for(int i=1;i<price.length;i++) {
			int curr = price[i];
			int j=1;
			System.out.print("curr: " + curr + " " + "i: " + i);
			if(curr<=price[i-1]) {
				stack.push(curr);
			}
			else{
				while(!stack.isEmpty() && stack.peek()<price[i]) {
					stack.pop();
				}
				//logically if all values are in decreasing order then stack.size() and value of i should match
				//but in this case value 60 is removed and stack size has became 2
				if(stack.size()<i) {//that means we have removed some smaller values
					//now calculate how many smaller values have been removed by calculating the stack size and 
					//the index of the item 
					int smaller = i - stack.size();
					j = j + smaller;
				}
				stack.push(curr);
			}
			span[i]=j;
			System.out.print(" [ ");
			for(int k=0;k<=i;k++) {
				System.out.print(span[k] + "  ");
			}
			System.out.print("]  ");
			System.out.println(stack);
		}
		for(int i:span) {
			System.out.print(i + "  ");
		}
	}
	
	private static void stockSpanProblemMyVersion() {
		int price[] = {100, 80, 60, 70, 60, 75, 85 }; //solution: {1, 1, 1, 2, 1, 4, 6}
		int span[] = new int[price.length];
		Stack<Integer> stack = new Stack<Integer>();
		int s=0;
		span[s]=1;
		stack.push(price[0]);
		s++;
		for(int i=1;i<price.length;i++) {
			int stackSize=stack.size();
			if(price[i]>=price[i-1]) {
				stack.push(price[i]);
			}
			else {//price is reduced
				//remove all prices which is small than current day
				for(int j=0;j<stack.size();j++) {
					if(stack.get(j)<price[i])
						stack.remove(j);
					else {
						stackSize--;
					}
				}
			}
			span[i]=stackSize+1;
			System.out.println("curr: " + price[i] + " stack: " + stack);
		}
		for(int i:span) {
			System.out.print(i + "  ");
		}
	}

	private static void stockSpanProblem() { //https://www.geeksforgeeks.org/the-stock-span-problem/
		int price[] = {100, 110, 80, 60, 70, 60, 75, 85 }; //solution: {1, 2, 1, 1, 2, 1, 4, 6}
		int span[] = new int[price.length];
		Stack<Integer> stack = new Stack<Integer>();
		int s=0;
		span[s]=1;
		stack.push(1);
		s=s+1;
		for(int i=1;i<price.length;i++) {
			int curr = price[i];
			while(!stack.isEmpty()&&price[stack.peek()] <= curr)
				stack.pop();
			span[i]=stack.isEmpty()?(i+1):(i-stack.peek());
			stack.push(i);
		}
		for(int i:span) {
			System.out.print(i + "  ");
		}
	}
	private static void basicOperations() {
		XStack<Integer> stack1 = initializeStack("18->19->29->15->16->NUll", "->");
		System.out.println(stack1);
		
		
		for(int i=0;i<=stack1.size();i++) {
			System.out.println("Popping: " + stack1.pop());
			System.out.println("New Min: " + stack1.getMin());
			System.out.println("New Max:" + stack1.getMax());
		}
	}
	
	public static XStack<Integer> initializeStack(String itemsStr, String delimiter){
		XStack<Integer> stack = new XStack<Integer>();
		String[] itemArray = itemsStr.split(delimiter);
		for(int i=0;i<itemArray.length;i++) {
			if(!itemArray[i].equalsIgnoreCase("null"))
				stack.push(Integer.valueOf(itemArray[i]));
		}
		return stack;
	}
}
