package com.saurabh.dada.iq.impl.iq.walmart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class FrequentDigits {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] L = new int[N];
        int[] R = new int[N];
        StringBuilder[] sbs = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
        	line = br.readLine();
        	String[] nums = line.split(" ");
        	L[i] = Integer.parseInt(nums[0]);
        	R[i] = Integer.parseInt(nums[1]);
        }
        for(int i=0;i<N;i++){
        	sbs[i]=new StringBuilder("");
        	for(int j=L[i];j<=R[i];j++){
        		if(isPrime(j)){
        			sbs[i].append(""+j);
        			System.out.print(j+ " ");
        		}
        	}
        }
        
        for(int i=0;i<N;i++){
        	char[] series = sbs[i].toString().toCharArray();
        	int[] digitFreqArr = new int[10];
        	for(int j=0;j<series.length;j++){		
        		int index = Integer.parseInt(series[j]+"");
        		int freq = digitFreqArr[index];
        		digitFreqArr[index]=freq+1;
        	}
        	//PriorityQueue queue is min-heap by default therefore use compareTo() method in reverse manner
        	System.out.println("\n"+createAndGetFromMaxHeap(digitFreqArr));
        }
	}
	
	public static DigitFrequencyCount createAndGetFromMaxHeap(int[] arr){
		//PriorityQueue queue is min-heap by default therefore use compareTo() method in reverse manner
		PriorityQueue<DigitFrequencyCount> queue = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++){
			//System.out.println("digit:"+i+"\tfreq: " + arr[i]);
			queue.add(new DigitFrequencyCount(i, arr[i]));
		}
		return queue.poll();
	}

	
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
		if(n==1) return false;
		if(n==2) return true;
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	    	//System.out.println(n+" checking with: " + i);
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}

class DigitFrequencyCount implements Comparable<DigitFrequencyCount>{
	
	private int digit;
	private int frequency;
	
	public DigitFrequencyCount(int digit,int frequency){
		this.digit=digit;
		this.frequency=frequency;
	}
	
	public String toString(){
		return "Digit: " + this.digit + "\tFrequency: " + this.frequency;
	}

	@Override
	public int compareTo(DigitFrequencyCount o) {
		if(this.frequency>o.frequency)
			return -1;
		else if(this.frequency<o.frequency)
			return 1;
		else {
			if(this.digit>o.digit)
				return -1;
			else
				return 0;
		}
	}
	
}
