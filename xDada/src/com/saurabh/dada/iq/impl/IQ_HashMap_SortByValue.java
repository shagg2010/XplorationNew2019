package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IQ_HashMap_SortByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);

        //simple approach
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        	public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
        		return obj1.getValue().compareTo(obj2.getValue());
        	}
		});
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
        
        //or
        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
        	public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
        		return obj1.getValue().compareTo(obj2.getValue());
        	}
		};
        TreeSet<Map.Entry<String, Integer>> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(entrySet);
        System.out.println("Values: " + treeSet);
        
        //Rahul's approach
        Comparator<String> comparator1 = new Comparator<String>() {
        	public int compare(String obj1, String obj2) {
        		return map.get(obj1).compareTo(map.get(obj2));
        	}
		};
        
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>(comparator1);
        tm.putAll(map);
        
        System.out.println("Map tm: " + tm);
	}

}
