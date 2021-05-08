package com.saurabh.dada.iq.impl.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * https://www.hackerearth.com/problem/algorithm/girlfriends-demands/
 * @author yadas
 *
 */
public class SameElementAtTheGivenIndexes {

	public static void main(String[] args) throws Exception {
		
		ExecutorService xecutor = Executors.newCachedThreadPool();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String wish = br.readLine();
		long len = (long) wish.length();
		
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int[] indx1 = new int[N];
		int[] indx2 = new int[N];
		List<ModCalculator> tasks1 = new ArrayList<>(N);
		List<ModCalculator> tasks2 = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			String[] items = line.split(" ");
			//long start = System.nanoTime();
			long l1 = Long.parseLong(items[0]);
			long l2 = Long.parseLong(items[1]);
			
			ModCalculator task1 = new ModCalculator(len);
			task1.setNum(l1-1);
			tasks1.add(task1);
			
			ModCalculator task2 = new ModCalculator(len);
			task2.setNum(l2-1);
			tasks2.add(task2);
			//long end = System.nanoTime() - start;
			//System.out.println("Total time taken: " + end);
		}
		List<Future<Long>> ans1 = calculateMod(xecutor, tasks1);
		List<Future<Long>> ans2 = calculateMod(xecutor, tasks2);
		xecutor.shutdown();
		//long start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			indx1[i]=ans1.get(i).get().intValue();
			indx2[i]=ans2.get(i).get().intValue();
			if(indx1[i]==indx2[i]){
				System.out.println("Yes");
			}
			else{
				System.out.println(giveAnswerYesOrNo(wish,indx1[i],indx2[i]));
			}
		}
		//long end = System.currentTimeMillis() - start;
		//System.out.println("Total time taken: " + end);
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
	
}
