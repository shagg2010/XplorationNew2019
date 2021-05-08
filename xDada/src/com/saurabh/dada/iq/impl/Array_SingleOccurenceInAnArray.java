package com.saurabh.dada.iq.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Array_SingleOccurenceInAnArray {
	
	private static int[] list = {1,2,3,4,1,2,3};
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(Integer i:list){
			if(map.containsKey(i)){
				Integer count = map.get(i);
				count++;
				map.put(new Integer(i), count);
			}
			else{
				map.put(new Integer(i), new Integer(1));
			}
		}
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()){
			int i = it.next();
			if(map.get(i)==1){
				System.out.println(i);
			}
		}
	}
}

