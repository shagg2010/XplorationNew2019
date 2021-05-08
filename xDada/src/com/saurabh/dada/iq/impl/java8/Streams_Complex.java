package com.saurabh.dada.iq.impl.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Complex {

	public static void main(String[] args) {

		 try {
	        	Stream<String> fileLines = Files.lines(Paths.get("streams_file.txt"));
	        	fileLines.sorted().filter(x -> x.length()>15).forEach(x -> System.out.println(x));
	        	fileLines.close();
	        }
	        catch(IOException e) {
	        	//do nothing
	        }
	        System.out.println("-----------------");
	              
	        try {
	        	//get lines which are in correct CSV format and every row has complete data
	        	Stream<String> fileLines = Files.lines(Paths.get("csv_data.txt"));
	        	System.out.println("No of correct rows: " + fileLines.map(x -> x.split(",")).filter(x -> x.length == 3).count());
	        	fileLines.close();
	        }
	        catch(IOException e) {
	        	//do nothing
	        }
	        System.out.println("-----------------");
	        
	        try {
	        	//get lines which are in correct CSV format and print it with integer column of value > 15
	        	Stream<String> fileLines = Files.lines(Paths.get("csv_data.txt"));
	        	fileLines.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) >= 15).forEach(x -> System.out.println(x[0] + "\t" + x[1] + "\t" + x[2]));
	        	fileLines.close();
	        }
	        catch(IOException e) {
	        	//do nothing
	        }
	        System.out.println("-----------------");
	        
	        try {
	        	Map<String,Integer> hashMap = new HashMap<>();
	        	//get lines which are in correct CSV format and print it with integer column of value >= 10 and store in Hashmap
	        	Stream<String> fileLines = Files.lines(Paths.get("csv_data.txt"));
	        	hashMap = fileLines.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) >= 10).collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
	        	fileLines.close();
	        	for(String key: hashMap.keySet()) {
	        		System.out.println(key + " = " + hashMap.get(key));
	        	}
	        }
	        catch(IOException e) {
	        	//do nothing
	        }
	        System.out.println("-----------------");

	}

}
