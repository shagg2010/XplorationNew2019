package com.saurabh.dada.iq.impl.collections;

import java.util.TreeMap;

public class SomeDataComparable {

	private static TreeMap<Integer, SomeData> map = new TreeMap<Integer, SomeData>();
	
	public static void main(String[] args) {
		for(SomeData data: CollectionData.sData){
			map.put(data.getCaseId(), data);
		}
		System.out.println(map);
	}
}
