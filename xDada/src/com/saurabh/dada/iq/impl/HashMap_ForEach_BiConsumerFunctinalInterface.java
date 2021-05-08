package com.saurabh.dada.iq.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;



public class HashMap_ForEach_BiConsumerFunctinalInterface {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", null);
		map.put(null, "100");

		BiConsumer<String, String> action = new MyBiConsumer();
		map.forEach(action);
		
		//lambda expression example
		System.out.println("\nHashMap forEach lambda example\n");
		map.forEach((k, v) -> {
			System.out.println("Key = " + k + ", Value = " + v);
		});
		
		System.out.println("---------------------------");
		Map<String, String> map1 = new HashMap<>();
		map1.put("1", "10");
		map1.put("2", "20");
		map1.put(null, "100");

		Function<String, String> function = new MyFunction();
		map1.computeIfAbsent("3", function); //key not present
		map1.computeIfAbsent("2", function); //key already present
		
		//lambda way
		map1.computeIfAbsent("4", (v) -> {return v;});
		map1.computeIfAbsent("5", (v) -> {return null;}); //null value won't get inserted
		System.out.println(map1);
	}

}

class MyBiConsumer implements BiConsumer<String, String> {

	@Override
	public void accept(String t, String u) {
		System.out.print("Key = " + t + "\t");
		if(t!=null)
			System.out.print("\t");
		System.out.println("Processing on value = " + u);
	}

}
class MyFunction implements Function<String, String> {

	@Override
	public String apply(String t) {
		return t;
	}
	
}