package com.saurabh.dada.iq.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPossibleNumbersForArithmeticProgression {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String line = br.readLine();
		String line = "2";
        int T = Integer.parseInt(line);	
        //String l = br.readLine();
        String l = "1 2";
        String[] inputStr = l.split(" ");
        
        List<Integer> inputs = new ArrayList<Integer>();
        for (int i = 0; i < T; i++) {
          	inputs.add(Integer.valueOf(inputStr[i]));
        }
		
        Integer[] series = inputs.toArray(new Integer[inputs.size()]);
		int n = series.length;
		int[] diffs = new int[n-1];
		
		Arrays.sort(series);
		
		for(int i=0;i<n-1;i++){
			diffs[i] = series[i+1]-series[i];
		}
		
		Arrays.sort(diffs);
		int d = diffs.length>=1?diffs[0]:0;
		boolean valid = true;
		for(int k:diffs){
			//System.out.println("k:" + k);
			if(d!=0){
				if(k%d!=0){
					valid = false;
				}
				if((k!=d)){
					if(k!=(d*2))
						valid = false;
				}
			}
			else{
				valid = false;
			}						
		}
		
		int a1 = series[0];
		int an = series[n-1];
		int solution=0;
		int totalMissing=0;
		
		
		for(int i=0;i<n;i++){
			int ai= a1+(((i))*d);
			//System.out.print(ai + " "); 
			if(Arrays.binarySearch(series, ai)<0){
				//System.out.println("Missing number: " + ai);				
				solution = ai;
				totalMissing++;
			}
		}
		//System.out.println("\n---Ans---");
		if(!valid){
			System.out.println("0");
		}
		else if(series.length<2 || totalMissing > 1){
			System.out.println("-1");
		}		
		else if(series.length==2 && d%2==0){
			System.out.println("3");
			solution = (a1 + an)/2;
			System.out.println((a1-d) + " " + solution + " " + (an +d));
		}
		else if((totalMissing==0) && (series.length>=2)){
			System.out.println("2");
			System.out.println((series[0]-d) + " " + (series[n-1]+d));
		}
		else if(totalMissing == 1){
			System.out.println(totalMissing);
			System.out.println(solution);
		}

	}
	
}
