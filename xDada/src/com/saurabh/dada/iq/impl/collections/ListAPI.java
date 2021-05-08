package com.saurabh.dada.iq.impl.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAPI {

	private static String[] list = CollectionData.list;
	
	public static void main(String[] args) {
		
		List<String> arrayList = new ArrayList<String>();
		for(String item:list){
			arrayList.add(item);
		}
		System.out.println(arrayList);
		System.out.println("2nd item: " + arrayList.get(1));
		
		LinkedList<String> queue = new LinkedList<String>();
		for(String item:list){
			queue.addLast(item);
		}
		System.out.println(queue);
		queue.removeFirst();
		System.out.println(queue);
	}

}
