package com.yadas.code.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Labda_G4GExamples {

	public static void main(String[] args) {
		//curryFunctions();
		streamsAPI();
	}
	
	public static void streamsAPI() {
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer sum = integers.stream().reduce(-55, (a, b) -> a + b);
		System.out.println("sum: " + sum);
		
		Integer sum1 = integers.stream().reduce(0, ArithmeticUtils::add);
		System.out.println("sum1: " + sum1);
		
		
		Item item1 = new Item(1, 10);
		Item item2 = new Item(2, 15);
		Item item3 = new Item(3, 25);
		Item item4 = new Item(4, 40);
		         
		List<Item> items = Arrays.asList(item1, item2, item3, item4);
		Integer sum3 = items.stream()
				  .map(x -> x.getPrice())
				  .reduce(0, Integer::sum);

		System.out.println("sum3: " + sum3);
	}
	public static class ArithmeticUtils {
		 
	    public static int add(int a, int b) {
	        return a + b;
	    }
	}
	
	public static class Item {
		 
	    private int id;
	    private Integer price;
	 
	    public Item(int id, Integer price) {
	        this.id = id;
	        this.price = price;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}	    
	}

	public static void curryFunctions() {
		// Using Java 8 Functions  to create lambda expressions for functions and with this, applying Function Currying   
        // Curried Function for Adding u & v 
        Function<Integer, Function<Integer, Integer>>  curryAdder = u -> v -> u + v; 
  
        // Calling Curried Function for Adding u & v 
        System.out.println("Add 2, 3 :"  + curryAdder.apply(2).apply(3));
		
		
        // Using Java 8 Functions to create lambda expressions for functions and with this, applying Function Currying 
  
        // Curried Function for Adding u, v & w 
        Function<Integer, Function<Integer,Function<Integer, Integer>>> 
            triadder = u -> w -> v -> u + w + v; 

        // Calling Curried Function for Adding u, v & w 
        System.out.println("Add 2, 3, 4 :"+ triadder.apply(2).apply(3).apply(4)); 
        
	}
	
	
}
