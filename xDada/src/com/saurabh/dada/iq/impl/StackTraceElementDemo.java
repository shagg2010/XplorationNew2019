package com.saurabh.dada.iq.impl;

public class StackTraceElementDemo {

	public static void main(String[] arg) { 
		OZumba oz = new OZumba();
		oz.someMethod();
    }

}
class OZumba{
	public void someMethod() {
		Zumba zumba = new Zumba();
		new Thread(zumba).start();;		
	}
}

class Zumba implements Runnable{

	@Override
	public void run() {
		System.out.println("Class name of each thread involved:"); 
        for(StackTraceElement ste: Thread.currentThread().getStackTrace()) {    
            System.out.println(ste.getClassName() + "\t\t" + ste.getMethodName() + "\t" + ste.getLineNumber()); 
        } 
		
	}
	
}