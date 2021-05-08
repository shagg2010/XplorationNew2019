package com.saurabh.dada.iq.impl;

public class Lock_JavaMonitorReentrant {

	public static void main(String[] args) {
		
		Reentrant reentrant = new Reentrant();
		reentrant.a();

	}

	//http://journals.ecs.soton.ac.uk/java/tutorial/java/threads/reentrant.html
	static class Reentrant {
	    public synchronized void a() {
		b();
		System.out.println("here I am, in a()");
	    }
	    public synchronized void b() {
		System.out.println("here I am, in b()");
	    }
	}
}
