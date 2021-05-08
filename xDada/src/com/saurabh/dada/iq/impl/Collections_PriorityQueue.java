package com.saurabh.dada.iq.impl;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Collections_PriorityQueue {

	public static void main(String[] args) {
		
		//natural ordering example of priority queue
		System.out.print("Adding: ");
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for(int i=0;i<7;i++){
        	Integer it = new Integer(rand.nextInt(100));
            integerPriorityQueue.add(it);
            System.out.print(it + " ");
        }
        System.out.print("\nPriority Queue: ");
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.print(in + " ");
        }
		System.out.println();
		
		PriorityQueue<HDTVv2> queue = new PriorityQueue<HDTVv2>(10,new SizeComparator());
		
		HDTVv2 tv11 = new HDTVv2(55, "Samsung");
		HDTVv2 tv22 = new HDTVv2(60, "Sony");
		HDTVv2 tv33 = new HDTVv2(42, "Panasonic");
		HDTVv2 tv44 = new HDTVv2(40, "Vu");
		queue.add(tv11);
		queue.add(tv22);
		queue.add(tv33);
		queue.add(tv44);
		int size=queue.size();
		System.out.print("TVs [" + queue.size() + "] = ");
		for(int i=0;i<size;i++){
			System.out.print(queue.poll()+ " ");
		}
	}

}
