package com.saurabh.dada.iq.impl.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		//int streams
		IntStream.range(1, 11).forEach(System.out::println);
		System.out.println("-----------------");
		
		IntStream.range(1, 11).skip(5).forEach(x -> System.out.println(x));
		System.out.println("-----------------");
		
		System.out.println(IntStream.range(1, 5).sum());
		System.out.println("-----------------");
		
		Stream.of("Ava","Aneri", "Alberto").sorted().findFirst().ifPresent(str -> System.out.println(str));
		System.out.println("-----------------");
		
		int[] arr = {4,6,3,1,8,5,7,9,0,2};		
		Arrays.stream(arr).filter(x -> x%2==0).sorted().forEach(n -> System.out.println(n));
		System.out.println("-----------------");
		
		Arrays.stream(new int[] {4,6,3,1,8,5,7,9,0,2}).map(x->x*x).forEach(x->System.out.println(x));
		System.out.println("-----------------");
		
		double total = Stream.of(7.3,1.5,4.8,1.9).reduce(0.0, (Double a, Double b) -> a+b);
		System.out.println("Total: " + total);
		
		IntSummaryStatistics summary = IntStream.of(8,10,2,19,88,15,21,35,81,100).summaryStatistics();
		System.out.println("IntSummaryStatistics: " + summary);
				
		//filter sort and return new list
		List<Integer> list = Arrays.asList(4,6,3,1,8,5,7,9,0,2);
		List<Integer> sortedList =  list.stream().filter(x -> x%2==0).sorted().collect(Collectors.toList());
		System.out.println(sortedList + "\n-----------------");
		
		System.out.println("Normal Stream...");
		IntStream.rangeClosed(1, 10).forEach(System.out::println);

        System.out.println("Parallel Stream...");
        IntStream.rangeClosed(1, 10).sorted().parallel().forEach(System.out::println);
        System.out.println("-----------------");
        
        System.out.println("Normal Stream...");
        getAlphabets().stream().forEach(System.out::println);

        System.out.println("Parallel Stream...");
        getAlphabets().parallelStream().forEach(System.out::println);
        System.out.println("-----------------");
        
        System.out.println("Normal Stream...");
        IntStream.rangeClosed(1, 10).forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });

        System.out.println("Parallel Stream...");
        IntStream.rangeClosed(1, 10).parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + ", value: " + x);
        });
        System.out.println("-----------------");
        
	}

	
	private static List<String> getAlphabets() {
		List<String> alpha = new ArrayList<>();
		int n = 97; // 97 = a , 122 = z
		while (n <= 122) {
			char c = (char) n;
			alpha.add(String.valueOf(c));
			n++;
		}
		return alpha;
	}
}
