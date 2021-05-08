package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.saurabh.dada.iq.impl.hackerearth.SameElementAtTheGivenIndexes.ModCalculator;

/**
 * https://www.hackerearth.com/problem/algorithm/girlfriends-demands/
 * @author yadas
 *
 */
public class SameElementAtTheGivenIndexes_Load {
	
	private static String str = "tcbqxdmhkrwkjjphqxhgtzfnbnfwvnnrndvyrrzbhsozyekzuutodnijoyvrpqjkllzpjnlitpqvcxcjdntlemkhacphfgryazknhlntrofxxricpicepbrrtulmycmgsshkvwwpyozpypwcddimewwdmcterbbbhypjfysqykbzssgesivnnzqvvuyfdvcvinjktudxcmicsjgbgukgazoyscboslhxbwilpgaqcuknmdwpqtfflznxveeuifprzuxkkmtvayplezaqwhiiirquictzxxinptmzqqrsfixxlrmzchbdljtpprbqktxsflkkqefreatczzziyycepuhbfzjcojqjbnrscoskhtivbkqtskzpxnghedblvtzgbrjjojreydocakpokcdtlwatrcnjpeopdejsktjzyuozuwpfprugfhwndcqmxmnrnvmwsdffangdbxwmppnmgtjqobxxqxuzxeofqtrlinovyzqgukdy";
	//private static String str = "abcde";
	private static int cases=68362;
	private static List<Future<Long>> ans1;
	private static List<Future<Long>> ans2;
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService xecutor = Executors.newCachedThreadPool();
		String wish = str;
		long len = (long) wish.length();
		
		long start = System.currentTimeMillis();
		int N = cases;
		int[] indx1 = new int[N];
		int[] indx2 = new int[N];
		readInputFile(xecutor,indx1, indx2,len,N);
		
		
		for (int i = 0; i < N; i++) {
			//System.out.print((i+1)+": ");
			indx1[i]=ans1.get(i).get().intValue();
			indx2[i]=ans2.get(i).get().intValue();
			if(indx1[i]==indx2[i]){
				System.out.println("Yes");
			}
			else{
				System.out.println(giveAnswerYesOrNo(wish,indx1[i],indx2[i]));
			}
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("Total time taken: " + end);
		xecutor.shutdown();
	}
	
	public static String giveAnswerYesOrNo(String wish,int indx1, int indx2){
		//System.out.println("indexes: " + indx1 + " " + indx2);
		//System.out.println("chars: " + wish.charAt((int)indx1) + " " + wish.charAt((int)indx2));
		if (wish.charAt(indx1) != wish.charAt(indx2))
			return "No";
		else
			return "Yes";
	}
	
	public static List<Future<Long>> calculateMod(ExecutorService xecutor, List<ModCalculator> tasks) throws ExecutionException, InterruptedException{
		List<Future<Long>> ans = xecutor.invokeAll(tasks);
		return ans;
	}

	public static long calculateMod(ExecutorService xecutor, ModCalculator task) throws ExecutionException, InterruptedException{
		Future<Long> ans = xecutor.submit(task);
		return ans.get().longValue();
	}
	
	static class ModCalculator implements Callable<Long>{
		private volatile Long num;
		private volatile Long d;
		public ModCalculator(Long d){
			this.d=d;
		}
		
		public void setNum(Long num) {
			this.num = num;
		}

		@Override
		public Long call() throws Exception {
			return num%d;
		}
		
	}
	
	public static void readInputFile(ExecutorService xecutor,int[] indx1,int[] indx2,long len,int N) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		try {
		    String line = br.readLine();
		    int i=0;
		    List<ModCalculator> tasks1 = new ArrayList<>(N);
			List<ModCalculator> tasks2 = new ArrayList<>(N);
		    while (line != null) {
		    	//System.out.println(line);
		    	String[] items = line.split(" ");
			    long l1 = Long.parseLong(items[0]);
				long l2 = Long.parseLong(items[1]);
				ModCalculator task1 = new ModCalculator(len);
				task1.setNum(l1-1);
				tasks1.add(task1);
				
				ModCalculator task2 = new ModCalculator(len);
				task2.setNum(l2-1);
				tasks2.add(task2);
				//System.out.println("\t"+indx1[i]+" "+indx2[i]);
				i++;
				line = br.readLine();
		    }
		    ans1 = calculateMod(xecutor, tasks1);
			ans2 = calculateMod(xecutor, tasks2);
		} finally {
		    br.close();
		}
	}
	
}
