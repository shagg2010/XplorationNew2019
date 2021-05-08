package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


public class EvenNumbers {

	public static void main(String[] args) {

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	        
	        LinkedList<Long> results = new LinkedList<>();
	        do{
	        	String line = br.readLine();
	        	long num = Long.parseLong(line);
	        	if(num==-1)
	        		break;
	        	if(num%2==0){
	        		results.addLast(num);
	        	}	        
	        }while(true);
	        
	        Iterator<Long> it = results.iterator();
	        while(it.hasNext()){
	        	System.out.println(it.next());
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
