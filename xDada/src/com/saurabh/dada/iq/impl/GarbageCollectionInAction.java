package com.saurabh.dada.iq.impl;

public class GarbageCollectionInAction {
	
	private String name;
	
	public GarbageCollectionInAction(String name){
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException {
		GarbageCollectionInAction s1=new GarbageCollectionInAction("s1");
		GarbageCollectionInAction s2=new GarbageCollectionInAction("s2");
		s1=s2;
		System.gc();
		Thread.sleep(5000);
	}
	
	public void finalize(){System.out.println(this.name+" object is garbage collected");}  

}
