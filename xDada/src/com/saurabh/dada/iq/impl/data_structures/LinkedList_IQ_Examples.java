package com.saurabh.dada.iq.impl.data_structures;

import java.util.Stack;

import com.saurabh.dada.iq.impl.data_structures.LinkedList.Node;

public class LinkedList_IQ_Examples {

	public static void main(String[] args) throws Exception {
		
		LinkedList<Integer> num1 = new LinkedList<>();
		LinkedList<Integer> num2 = new LinkedList<>();
		num1.addNode(5);num1.addNode(6);num1.addNode(7);num1.addNode(9);num1.addNode(9);num1.addNode(9);
		num2.addNode(8);num2.addNode(9);num2.addNode(5);
		
		num1.addLinkedListUsingStack(num2);
		LinkedList<Integer> result = num1.addLinkedListRecursively(num2);
		System.out.println("Sum result: " + result);

		LinkedList<String> ll1 = new LinkedList<String>();
		Node<String> n1 = new Node<String>("1");
		Node<String> n2 = new Node<String>("2");
		Node<String> n3 = new Node<String>("3");
		Node<String> n4 = new Node<String>("4");
		Node<String> n5 = new Node<String>("5");
		Node<String> n6 = new Node<String>("6");
		Node<String> n7 = new Node<String>("7");
		Node<String> n8 = new Node<String>("8");
		Node<String> n9 = new Node<String>("9");
		Node<String> n10 = new Node<String>("10");
		ll1.addNode(n1);ll1.addNode(n2);ll1.addNode(n3);ll1.addNode(n4);ll1.addNode(n5);ll1.addNode(n6);ll1.addNode(n7);ll1.addNode(n8);
		ll1.addNode(n9);ll1.addNode(n10);
		ll1.getTail().setNext(n3);
		
		ll1.detectLoopAndRemove();
		System.out.println(ll1);
		
		ll1.reverseAlternativeKNodes(3);
		System.out.println("Reverse alternative k node: " + ll1);
		
		System.out.println("Printing reversed linked list: ");
		ll1.printReversedLinkedList();
		
		ll1.reverseLinkedListRecursively();
		System.out.println("Reversed recursive: " + ll1);
		
		System.out.println("3 node from last: " + ll1.nthNodeFromLast(3));
		System.out.println("11 node from last: " + ll1.nthNodeFromLast(11));		
		System.out.println("LinkedList Sorted: " + ll1.isSorted());
		ll1.reverseLinkedList();
		System.out.println(ll1);
		ll1.removeNode("8");
		System.out.println(ll1);
		
		
		LinkedList<String> ll = new LinkedList<String>();
		ll.addNode("a");
		ll.addNode("b");
		ll.addNode("b");
		ll.addNode("a");
		/*for(int i=65;i<91;i++) {
			ll.addNode(new String("" + (char)i));
		}*/
		System.out.println(ll);
		System.out.println("Size: " + ll.getSize());
		System.out.println("Palindrome: " + ll.checkIfPalindrom());
		
	}

}

class LinkedList<T> implements Comparable<T>{

	private Node<T> head, tail = null;
	private int maxSize = 0;
	private int size = 0;
	
	public LinkedList() {
		this(Integer.MAX_VALUE);
	}
	public LinkedList(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getSize() {
		return size;
	}
	
	public void addNode(Node<T> node) {
		if(this.size<=this.maxSize) {
			if(head==null) {
				head = node;
				tail = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			this.size++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Max size reached for linked list.");
		}
	}
	public void printReversedLinkedList() {
		printReverse(head);
		System.out.println("\n");
	}
	public void printReverse(Node<T> node) {
		if(node!=null) {
			printReverse(node.next);
			System.out.print(node.data + " -> ");
		}
	}
	public boolean isSorted() {
		return checkSorted(head);
	}
	private boolean checkSorted(Node<T> node) {
		while(node!=null && node.next!=null) {
			if(Integer.valueOf(node.data.toString()) > Integer.valueOf(node.next.data.toString()))
				return false;
			else {
				return checkSorted(node.next);
			}
		}
		return true;
	}
	public T nthNodeFromLast(int n) {
		Node<T> curr = head;
		Node<T> curr1 = head;
		for(int i=0;i<n;i++) {
			if(curr==null)
				return null;
			curr=curr.next;
		}
		while(curr!=null) {
			curr=curr.next;
			curr1=curr1.next;
		}
		return curr1.data;
	}
	public void removeAllDuplicates() {
		//TODO: unimplemented
	}
	public boolean removeNode(T data) {
		Node<T> curr = head;
		Node<T> prev = null;
		System.out.println("Trying to remove: " + data.toString() + "... \n");
		if(head==null)
			return false;
		while(curr!=null) {
			if(data.equals(curr.data)) {
				//remove head and update new head
				if(curr.data.equals(head.data))
					head = curr.next;
				else if(curr.data.equals(tail.data) && prev!=null ) {
					//remove tail and update tail
					prev.next = null;
					tail = prev;
				}
				else {
					//remove node from the middle of list
					prev.next = curr.next;
				}							
			}
			prev = curr;
			curr = curr.next;	
		}
		return false;
	}
	public boolean removeNode(Node<T> node) {
		return false;
	}
	
	public void addNode(T data) {
		if(this.size<=this.maxSize) {
			Node<T> node = new Node<T>(data);
			if(head==null) {
				head = node;
				tail = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			this.size++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("Max size reached for linked list.");
		}
	}
	public Node<T> getHead() {
		return this.head;
	}
	public Node<T> getTail() {
		return this.tail;
	}
	public void addLinkedListUsingStack(LinkedList<T> list2) {
		addLinkedListUsingStacks(head, list2.head);
	}
	
	public LinkedList<Integer> addLinkedListRecursively(LinkedList<T> list2) {
		//addLinkedList(head, list2.head);
		int carry = 0;
		Node<T> newHead = null;
		LinkedList<Integer> result = new LinkedList();
		if(this.size==list2.size) {
			carry = addLinkedListRecursively(head, list2.head, carry, result);
		}
		else if(this.size>list2.size) {
			int diff = size - list2.size;
			newHead = head; 
			while(diff>0) {
				newHead = newHead.next;
				diff--;
			}
			carry = addLinkedListRecursively(newHead, list2.head, carry, result);
			carry = addLinkedListRecursively2(head, newHead ,carry, result);
		}
		else {
			int diff = list2.size - size;
			newHead = list2.head; 
			while(diff>0) {
				newHead = newHead.next;
				diff--;
			}
			carry = addLinkedListRecursively(head, newHead, carry, result);
			carry = addLinkedListRecursively2(list2.head, newHead ,carry, result);
		}
		if(carry>0) {
			result.addNode(new Integer(carry));
		}
		return result;
	}
	private int addLinkedListRecursively(Node<T> curr1, Node<T> curr2, int carry, LinkedList<Integer> result) {
		if(curr1!=null) {
			System.out.println("c1: " + curr1 + ", c2: " + curr2);
			carry = addLinkedListRecursively(curr1.next,curr2.next,carry, result);
			int sum = (int) curr1.data + (int)curr2.data + carry;
			if(sum>9)
				carry = 1;
			else
				carry = 0;
			sum = sum % 10;
			result.addNode(sum);
		}
		return carry;
	}
	private int addLinkedListRecursively2(Node<T> curr1, Node<T> endNode, int carry, LinkedList<Integer> result) {
		if(curr1!=endNode) {
			carry = addLinkedListRecursively2(curr1.next, endNode,carry, result);
			int sum = (int) curr1.data + carry;
			if(sum>9)
				carry = 1;
			else
				carry = 0;
			sum = sum % 10;
			result.addNode(sum);
		}
		return carry;
	}
	
	private LinkedList<T> addLinkedListUsingStacks(Node<T> curr1, Node<T> curr2) {
		Stack<T> s1 = new Stack<>();
		Stack<T> s2 = new Stack<>();
		Stack<Integer> result = new Stack<>();
		while(curr1!=null) {
			s1.push(curr1.data);
			curr1=curr1.next;
		}
		while(curr2!=null) {
			s2.push(curr2.data);
			curr2=curr2.next;
		}
		int carry = 0;
		do {
			int data1 = 0;
			int data2 = 0;
			if(!s1.isEmpty())
				data1 = (int) s1.pop();
			if(!s2.isEmpty())
				data2 = (int) s2.pop();
			int sum = carry + data1 + data2;
			if(sum>9)
				carry = 1;
			else
				carry = 0;
			sum = sum % 10;
			result.push(sum);
		}while(!s1.isEmpty()||!s2.isEmpty());
		if(carry>0)
			result.push(carry);
		System.out.println(result);
		return null;
	}
	
	/*private LinkedList<T> addLinkedListRecursively(Node<T> curr1, Node<T> curr2) {
		
		return null;
	}*/
	
	public void reverseAlternativeKNodes(int k) {
		reverseAlternativeKNodes(head, k);
	}
	
	private void reverseAlternativeKNodes(Node<T> curr, int k) {
		Node<T> tHead = null;
		Node<T> tTail = null;
		
		Stack<Node<T>> stack = new Stack<>();
		while(curr!=null) {
			int i = k;
			while(i>0 && curr!=null) {
				stack.push(curr);
				curr=curr.next;
				i--;
			}
			if(tHead==null) {
				tHead = stack.peek();
			}
			if(tTail!=null) {
				tTail.next = stack.peek();
			}
			while(!stack.isEmpty()) {
				Node<T> node = stack.pop();
				if(!stack.isEmpty()) {
					node.next = stack.peek();
				}
				tTail = node;
			}
		}
		head=tHead;
		tail=tTail;
		
		//1-2-3-4-5-6
	}
	
	public void detectLoopAndRemove() {
		Node<T> tortoise = head;
		Node<T> hare = head;
		
		boolean cyclic = false;
		while(hare!=null && hare.next!=null) {
			if(hare!=head && (hare==tortoise)) {
				cyclic = true;
				break;
			}
			hare=hare.next.next;
			tortoise = tortoise.next;
		};
		
		if(cyclic) {
			System.out.println("Cyclic: " + tortoise);
			tortoise = head;
			while(tortoise.next!=hare.next) {
				tortoise=tortoise.next;
				hare = hare.next;
			}
			hare.setNext(null);
		}
		else {
			System.out.println("Not cyclic");
		}
		
	}
	public void reverseLinkedList() {
		Node<T> curr = head;
		Stack<Node<T>> stack = new Stack<>();
		while(curr!=null) {
			stack.push(curr);
			curr=curr.next;
		}
		head = stack.peek();
		Node<T> node = null;
		while(!stack.isEmpty()) {
			node = stack.pop();
			if(!stack.isEmpty())
				node.setNext(stack.peek());
			else
				node.setNext(null);
		}
		tail = node;
	}

	public void reverseLinkedListRecursively() {
		tail = reverserRecursively(head);
	}
	private Node<T> reverserRecursively(Node<T> node) {
		Node<T> n = null;
		if(node.next==null) { //got tail, make it head
			head = node;
			return node;
		}
		else {
			n = reverserRecursively(node.next);
			n.next = node;
			//System.out.println("n: " + n + "\nnode: " + node);
		}
		node.next = null;
		return node;
	}
	public boolean checkIfPalindrom() {
		Node<T> tortoise = head;
		Node<T> hare = head;
		Stack<Node<T>> stack = new Stack<>();
		do {
			stack.push(tortoise);
			hare=hare.next;
			if(hare!=null) {
				tortoise = tortoise.next;
				hare = hare.next;
			}
		}while(tortoise!=null && hare!=null);
		
		if(stack.size()>0) {
			boolean result = true;
			while(tortoise!=null) {
				Node<T> top = stack.pop();
				if(!top.data.equals(tortoise.data)) {
					result = false;
					break;
				}
				tortoise = tortoise.next;
			}
			return result;
		}
		return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("Linked List: [");
		Node<T> curr = head;
		while(curr!=null) {
			sb.append(curr.toString() + "  ->  ");
			if(sb.length()%30==0) {
				sb.append("\n");
			}
			curr = curr.next;
		}
		return sb.append("]").toString();
	}
	
	public static class Node<T> implements Comparable<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		public String toString() {
			return data.toString();
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		@Override
		public int compareTo(T o) {
			return this.data.hashCode() - this.data.hashCode();
		}
		public void finalize() {
			System.out.println("Removing node from heap: " + this.data.toString());
		}
	}
	@Override
	public int compareTo(T o) {
		if(o.equals(this))
			return 0;
		return -1;
	}
	
}