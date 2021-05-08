package com.yadas.code.java.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LinkedList_G4GExamples {
	
	private static XLinkedList<String> ll = null;
	private static XLinkedList<String> ll1 = null;
	private static XLinkedList<String> ll2 = null;
	private static XLinkedList<String> ll3 = null;
	private static XLinkedList<String> ll4 = null;
	
	
	public static void main(String[] args) {
		//basicOperations();
		//detectAndRemoveLoop();
		//swapNodes();
		//reverse();
		//swapByGrouping(2);
		//intersectionAndUnionOfTwoLists();
		//segregateEvenAndOddAndMaintainOrder();
		//intersectionPointOfLinkedLists();
		//swapByGroupingRecursivelyMain();
		//swapKthNode(10);
	
		
	}
	
	private static void swapKthNode(int k) {
		XLinkedList<String> ll5 = initializeLinkedList("17->15->8->12->10->5->4->1->7->6->NULL", "->");
		int m = ll5.size() - k;
		int n = k;
		System.out.println("m:" + m + " n: " + n);
		if(m<0)
			return;
		if(m==n)//same nodes
			return;
		if(m==0) {//swap first and last node
			XLinkedList.Node<String> head = ll5.getHeadNode();
			XLinkedList.Node<String> tail = ll5.getTailNode();
			XLinkedList.Node<String> pTail = ll5.getHeadNode();
			while(pTail.getNext()!=tail) {
				pTail=pTail.getNext();
			}
			pTail.setNext(head);
			ll5.setHeadNode(tail);
			tail.setNext(head.getNext());
			head.setNext(null);
			ll5.setTailNode(head);
		}
		else {
			XLinkedList.Node<String> mPrev = ll5.getHeadNode();
			XLinkedList.Node<String> nPrev = ll5.getHeadNode();
			while(m>1) {
				mPrev=mPrev.getNext();
				m--;
			}
			n=1;
			while(n<k-1) {
				nPrev=nPrev.getNext();
				n++;
			}
			System.out.println("mPrev:" + mPrev);
			System.out.println("nPrev:" + nPrev);
			swapNextOfGivenNodes(mPrev, nPrev);
		}
		ll5.traverse();
	}
	
	private static void swapNextOfGivenNodes(XLinkedList.Node<String> prev1, XLinkedList.Node<String> prev2) {
		XLinkedList.Node<String> n1 = prev1.getNext();
		XLinkedList.Node<String> n2 = prev2.getNext();
		XLinkedList.Node<String> temp = n2.getNext();
		prev1.setNext(n2);
		n2.setNext(n1.getNext());
		prev2.setNext(n1);
		n1.setNext(temp);
	}
	
	
	private static void swapByGroupingRecursivelyMain(){
		XLinkedList<String> ll5 = initializeLinkedList("17->15->8->12->10->NULL", "->");
		XLinkedList.Node<String> newHead = swapByGroupingRecursively(ll5.getHeadNode(),2);
		ll5.setHeadNode(newHead);
		ll5.updateTailNodeAndRecalculateSize();
		ll5.traverse();
	}
	
	private static XLinkedList.Node<String> swapByGroupingRecursively(XLinkedList.Node<String> curr,int groupingSize) {
		
		if(curr==null||curr.getNext()==null)////curr=17 , curr=8
			return curr; 
		XLinkedList.Node<String> head = curr;//head=17, head=8
		int i=1;
		while(i<groupingSize) {
			if(curr==null)
				break;
			curr=curr.getNext();
			i++;
		}
		XLinkedList.Node<String> rem = curr.getNext(); //rem=8, rem=null / curr=15, curr=12 (curr will also be tail node of non-reversed list
		curr.setNext(null);//17->15->NULL, 8->12->NULL
		XLinkedList.Node<String> newTail = swapByGroupingRecursively(rem, groupingSize); //swapByGroupingRecursively(8,2)
		XLinkedList.Node<String> ret = reverseRecursively(head); //ret=15->17->, ret=12->8->, is the new head
		head.setNext(newTail);
		return ret;
	}
	
	private static XLinkedList.Node<String> intersectionPointOfLinkedLists() {
		XLinkedList<String> ll1 = initializeLinkedList("3->6->9->15->30->NULL", "->");
		XLinkedList<String> ll2 = initializeLinkedList("10->NULL", "->");
		XLinkedList.Node<String> n1 = ll1.search("15");
		XLinkedList.Node<String> n2 = ll2.search("10");
		n2.setNext(n1);
		ll2.updateTailNodeAndRecalculateSize();
		ll1.traverse();
		ll2.traverse();
		
		XLinkedList.Node<String> curr1 = ll1.getHeadNode();
		XLinkedList.Node<String> curr2 = ll2.getHeadNode();
		XLinkedList.Node<String> ret = null;
		
		int s1 = ll1.size();
		int s2 = ll2.size();
		if(s1>s2) {
			curr1 = ll1.getHeadNode();
			while(s1>s2) {
				curr1 = curr1.getNext();
				s1--;
			}
		}
		else if(s2>s1) {
			curr2 = ll2.getHeadNode();
			while(s2>s1) {
				curr2 = curr2.getNext();
				s2--;
			}
		}
		while(curr1!=null||curr2!=null) {
			if(curr1==curr2) {
				ret = curr1;
				break;
			}
			else {
				curr1 = curr1.getNext();
				curr2 = curr2.getNext();
			}	
		}
		System.out.println("Intersection Point: " + ret);
		return ret;
	}
	
	private static void segregateEvenAndOddAndMaintainOrder() {
		XLinkedList<String> ll1 = initializeLinkedList("17->15->8->12->10->5->4->1->7->6->NULL", "->");
		XLinkedList.Node<String> newHead = segregateEvenAndOdd(ll1.getHeadNode());
		System.out.println(newHead);
		ll1.setHeadNode(newHead);
		ll1.updateTailNodeAndRecalculateSize();
		ll1.traverse();
	}
	private static XLinkedList.Node<String> segregateEvenAndOdd(XLinkedList.Node<String> curr){
		XLinkedList.Node<String> evenTail = null;
		XLinkedList.Node<String> oddHead = null;
		XLinkedList.Node<String> oddTail = null;
		XLinkedList.Node<String> newHead = null;
		while(curr!=null) {
			if(Integer.valueOf(curr.getData())%2!=0) {//odd node
				if(oddHead==null) {
					oddHead = curr;
					oddTail = curr;
				}
				else {
					oddTail.setNext(curr);
					oddTail = curr;
				}
			}
			else {
				if(newHead==null) {
					newHead = curr;
				}
				if(evenTail==null) {
					evenTail = curr;
				}
				else {
					evenTail.setNext(curr);
					evenTail = curr;
				}
			}
			curr = curr.getNext();
		}
		evenTail.setNext(oddHead);
		oddTail.setNext(null);
		return newHead;
	}
	private static void intersectionAndUnionOfTwoLists() {
		XLinkedList<String> ll1 = new XLinkedList<String>();
		ll1.add("1");ll1.add("2");ll1.add("3");ll1.add("4");ll1.add("6");
		XLinkedList<String> ll2 = new XLinkedList<String>();
		ll2.add("2");ll2.add("4");ll2.add("6");
		//union = 1->2->3->4->6    (all elements but do not duplicate)
		//intersection = 2->4->6 (all common elements in both the lists)
		
		HashSet<String> set = new HashSet<String>();
		XLinkedList.Node<String> curr1 = ll1.getHeadNode();
		XLinkedList.Node<String> curr2 = ll2.getHeadNode();
		
		XLinkedList<String> union = new XLinkedList<String>();
		XLinkedList<String> intersection = new XLinkedList<String>();
		
		//union
		while(curr1!=null) {
			if(!set.contains(curr1.getData())) {
				set.add(curr1.getData());
				union.add(curr1.getData());
			}
			curr1=curr1.getNext();
		}
		while(curr2!=null) {
			if(!set.contains(curr2.getData())) {
				set.add(curr2.getData());
				union.add(curr2.getData());
			}
			else
				intersection.add(curr2.getData());
			curr2=curr2.getNext();
		}
		
		System.out.println("Union: ");union.traverse();
		System.out.println("Intersection: "); intersection.traverse();;
		
	}
	
	private static void swapByGrouping(int groupingSize) {
		
		ll4 = initializeLinkedList(14);
		ll4.traverse();
		
		XLinkedList.Node<String> newHead = swapByGrouping2(ll4,groupingSize);
		ll4.setHeadNode(newHead);
		ll4.traverse();
		
	}
	private static XLinkedList.Node<String> swapByGrouping2(XLinkedList<String> ll, int groupingSize){
		XLinkedList.Node<String> curr = ll.getHeadNode();
		XLinkedList.Node<String> prev = null;
		XLinkedList.Node<String> newHead = null;
		XLinkedList.Node<String> newTail = null;
		while(curr!=null) {
			XLinkedList.Node<String> stackTop = null;
			Stack<XLinkedList.Node<String>> stack = new Stack<XLinkedList.Node<String>>();
			for(int i=0;i<groupingSize;i++) {
				if(curr!=null) {
					stack.push(curr);
					curr=curr.getNext();
				}	
			}
			if(newHead==null && !stack.isEmpty()) {
				newHead = stack.peek();
				ll.setHeadNode(newHead);
			}
			while(!stack.isEmpty()) {
				if(stackTop==null)
					stackTop = stack.peek();
				if(prev!=null && stackTop!=null)
					prev.setNext(stackTop);
				XLinkedList.Node<String> top=stack.pop();
				if(!stack.isEmpty())
					top.setNext(stack.peek());
				else {
					if(curr==null&&stack.isEmpty()) {
						newTail = top;
						newTail.setNext(null);
						ll.setTailNode(newTail);
					}
					else {
						top.setNext(prev);
						prev = top;
					}
				}
			}
			
		}
		return newHead;
	}
	
	private static void reverse() {
		ll3 = initializeLinkedList(10);
		ll3.traverse();
		reverseRecursively(ll3.getHeadNode(),ll3);
		ll3.traverse();
		ll3.traverseFrom(ll3.search("5"));
	}
	
	private static XLinkedList.Node<String> reverseRecursively(XLinkedList.Node<String> curr, XLinkedList<String> ll) {
		if(curr.getNext()==null)
			return curr; //new head
		XLinkedList.Node<String> ret = reverseRecursively(curr.getNext(),ll);
		curr.getNext().setNext(curr);
		curr.setNext(null);
		ll.setHeadNode(ret);
		ll.setTailNode(curr);
		return ret;
	}
	
	private static XLinkedList.Node<String> reverseRecursively(XLinkedList.Node<String> curr) {
		if(curr.getNext()==null)
			return curr; //new head
		XLinkedList.Node<String> ret = reverseRecursively(curr.getNext(),ll);
		curr.getNext().setNext(curr);
		curr.setNext(null);
		return ret;
	}
	
	private static void swapNodes() {
		//swap nodes without swapping data
		ll2 = initializeLinkedList(10);
		ll2.traverse();
		XLinkedList.Node<String> curr = ll2.getHeadNode();
		XLinkedList.Node<String> t1=ll2.search("4");
		XLinkedList.Node<String> t2=ll2.search("3");
		XLinkedList.Node<String> p1=null;
		XLinkedList.Node<String> p2=null;
		boolean setP1 = false;
		boolean setP2 = false;
		XLinkedList.Node<String> head = ll2.getHeadNode();
		XLinkedList.Node<String> tail = ll2.getTailNode();
		
		while(curr!=null) {
			if(curr.compare(t1)==0) {
				setP1=true;
			}
			if(curr.compare(t2)==0) {
				setP2=true;
			}
			if(!setP1)
				p1=curr;
			if(!setP2)
				p2=curr;
			curr=curr.getNext();
		}
		System.out.println("t1: " + t1);
		System.out.println("t2: " + t2);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);

		if(t1==head) {
			//t1 is head
			p2.setNext(t1);
			ll2.setHeadNode(t2);
			XLinkedList.Node<String> temp = t2.getNext();
			t2.setNext(t1.getNext());
			t1.setNext(temp);
			ll2.setHeadNode(t2);
		}
		else if(t2==head) {
			//t2 is head
			p1.setNext(t2);
			ll2.setHeadNode(t1);
			XLinkedList.Node<String> temp = t1.getNext();
			t1.setNext(t2.getNext());
			t2.setNext(temp);
			ll2.setHeadNode(t1);
		}
		else {
			p1.setNext(t2);
			p2.setNext(t1);
			XLinkedList.Node<String> temp = t2.getNext();
			t2.setNext(t1.getNext());
			t1.setNext(temp);
		}
		if(t1==tail) {
			ll2.setTailNode(t2);
		}
		if(t2==tail) {
			ll2.setTailNode(t1);
		}
		ll2.traverse();
		
	}

	private static void detectAndRemoveLoop() {
		//Detect Loop
		ll1 = initializeLinkedList(10);
		XLinkedList.Node<String> node = ll1.search("10");
		ll1.traverse();
		node.setNext(ll1.search("5"));
		//ll1.traverse();
		//find loop size using tortoise and hare algo
		//or detect using hashmap
		int i = 1;
		HashMap<XLinkedList.Node<String>, Integer> map = new HashMap<XLinkedList.Node<String>, Integer>();
		XLinkedList.Node<String> curr = ll1.getHeadNode();
		XLinkedList.Node<String> prev = null;
		while(curr!=null) {
			if(map.get(curr)!=null) {
				System.out.println("Loop detected @ " + curr + " & " + prev);
				System.out.println("Loop Size: " + (map.get(prev) - map.get(curr)));
				break;
			}
			else {
				map.put(curr, i++);
			}
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(null);
		System.out.println(ll1);
	}
	
	private static void basicOperations() {
		// Basic Operations
		
		ll = initializeLinkedList(8);
		ll.traverse();
		System.out.println("Size: " + ll.size());

		System.out.println("Search Result: " + ll.search("8"));
		System.out.println("Search Result: " + ll.search("9"));
		System.out.println("Search Result: " + ll.search("1"));

		ll.remove("1");
		ll.traverse();

		ll.remove("4");
		ll.traverse();

		ll.remove("8");
		ll.traverse();

		System.out.println("Size: " + ll.size());

		ll.removeAtIndex(0);
		System.out.println(ll);
		ll.removeAtIndex(3);
		System.out.println(ll);
		ll.removeAtIndex(1);
		System.out.println(ll);
		ll.removeAtIndex(0);
		System.out.println(ll);
		ll.removeAtIndex(0);
		System.out.println(ll);

		System.out.println("Size: " + ll.size());

	}
	
	public static XLinkedList<String> initializeLinkedList(int noOfItems){
		XLinkedList<String> ll = new XLinkedList<String>();
		for(int i=1;i<=noOfItems;i++) {
			ll.add(String.valueOf(i));
		}
		return ll;
	}
	public static XLinkedList<String> initializeLinkedList(String itemsStr, String delimiter){
		XLinkedList<String> ll = new XLinkedList<String>();
		String[] itemArray = itemsStr.split(delimiter);
		for(int i=0;i<itemArray.length;i++) {
			if(!itemArray[i].equalsIgnoreCase("null"))
				ll.add(itemArray[i]);
		}
		return ll;
	}
	
	public static class Pair<T,N>{
		private T tail;
		private N next;
		
		public Pair(T tail, N next) {
			super();
			this.tail = tail;
			this.next = next;
		}
		public T getTail() {
			return tail;
		}
		public void setTail(T tail) {
			this.tail = tail;
		}
		public N getNext() {
			return next;
		}
		public void setNext(N next) {
			this.next = next;
		}
		@Override
		public String toString() {
			return "Pair [tail=" + tail + ", next=" + next + "]";
		}		
	}
}
