package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingletonDoubleCheck {

	public static void main(String[] args) throws Exception {
		
		List<Future<String>> results = new ArrayList<Future<String>>();
		ExecutorService xecutor = Executors.newFixedThreadPool(25);
		for(int i=0;i<200;i++){
			Future<String> result = xecutor.submit(new SearchBox());
			results.add(result);
		}
		xecutor.shutdown();
		
		for(Future<String> fut: results){
			if(fut.isDone())
				System.out.println(fut.get());
		}
	}
	
	public static class SearchBox implements Callable<String>{
      
		private static volatile SearchBox searchBox;
        private static String[] list=null;

        static{
        	list = new String[]{"Stack", "Overflow"};
        }

        
        private SearchBox() {}

        // static method to get instance
        public static SearchBox getInstance() {
            if (searchBox == null) { // first time lock
                synchronized (SearchBox.class) {
                    if (searchBox == null) {  // second time lock
                        searchBox = new SearchBox();
                        System.out.println("New SearchBox Object Created........!");
                    }
                }
            }
            return searchBox;
        }

		@Override
		public String call() throws Exception {
			getInstance();
			return list[0].concat(" ").concat(list[1]).concat(" [hash: " + searchBox.hashCode() +"]");
		}
      
	}
}