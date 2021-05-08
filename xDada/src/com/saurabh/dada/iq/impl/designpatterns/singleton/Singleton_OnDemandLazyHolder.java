package com.saurabh.dada.iq.impl.designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Singleton_OnDemandLazyHolder {

	public static final strictfp synchronized void main(String[] args) throws Exception {
		
		System.out.println(Singleton.INSTANCE);
		System.out.println(1+2+"3"); //33
		System.out.println ("1"+2+3); //123

		List<Future<String>> results = new ArrayList<Future<String>>();
		ExecutorService xecutor = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			Future<String> result = xecutor.submit(SearchBox.getInstance());
			results.add(result);
		}
		xecutor.shutdown();
		
		for(Future<String> fut: results){
			if(fut.isDone())
				System.out.println(fut.get());
		}
		
	}

}

enum Singleton {
    INSTANCE;

    public static Singleton getInstance() {
        return INSTANCE;
    }
    private Singleton() {
        System.out.println("Here");
    }
    
    // all the methods you want specify for a singleton class
}

class SearchBox implements Callable<String>{
    
    private static String[] list=null;

    static{
    	System.out.println("Static Block");
    	list = new String[]{"Stack", "Overflow"};
    }

    
    private SearchBox() {System.out.println("Constructor");}

    private static class LazyHolder {
    	static{
    		System.out.println("LazyHolder loaded!");
    	}
        private static final SearchBox INSTANCE = new SearchBox();
    }
    public static SearchBox getInstance() {
        return LazyHolder.INSTANCE;
    }

	@Override
	public String call() throws Exception {
		return list[0].concat(" ").concat(list[1]).concat(" [hash: " + System.identityHashCode(getInstance()) +"]");
	}
  
}