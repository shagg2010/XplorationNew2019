package com.saurabh.dada.ctci.impl.chapters.logic;

import com.saurabh.dada.ctci.impl.chapters.logic.LinkedList.Node;

public class Chapter02_LinkedListProblems {
	
	public static void deleteSingleCopy(LinkedList<Object> list, Object o){
		list.display();
		list.deleteOne(o);
		list.display();
	}
	
	public static void iterate(LinkedList<Object> list,int n){
		list.iterate();
		if(n>0)
			list.iterate(n);
	}
	
	public static Object nthItemFromLast(LinkedList<Object> list,int n){
		Object ans = list.nthItemFromLast(n);
		if(ans==null){
			String r = new String("NO SOLUTION");
			return (Object)r;
		}
		else
			return ans;
	}
	
	private static void createLoop(LinkedList<Object> list,Object data){
		Node node = list.getNode(data);
		if(node!=null){
			list.getTail().setNext(node);
		}
	}
	
	public static void detectLoop(LinkedList<Object> list,Object data){
		createLoop(list, data);
		if(list.detectLoop()){
			Object ans=list.detectLoopStart();
			System.out.println("Loop starts at: " + ans);
		}
		else{
			System.out.println("No loop exists in the linked list.");
		}
	}

}
