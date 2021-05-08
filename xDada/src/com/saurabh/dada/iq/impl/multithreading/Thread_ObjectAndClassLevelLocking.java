package com.saurabh.dada.iq.impl.multithreading;

public class Thread_ObjectAndClassLevelLocking {

	public static void main(String[] args) {
		

	}
	
	/* Object level locking is mechanism when you want to synchronize a non-static method or non-static code block
     *  such that only one thread will be able to execute the code block on given instance of the class. 
     *  This should always be done to make instance level data thread safe.
     */
	public class DemoClass_ObjectLevel
	{
	    public synchronized void demoMethod1(){}
	    public void demoMethod2(){
	        synchronized (this){
	            //other thread safe code
	        }
	    }
	    private final Object lock = new Object();
	    public void demoMethod3(){
	        synchronized (lock){
	            //other thread safe code
	        }
	    }
	}
	/*Class level locking prevents multiple threads to enter in synchronized block in any of all available instances on runtime. 
	 * This means if in runtime there are 100 instances of  DemoClass, then only one thread will be able to execute demoMethod() 
	 * in any one of instance at a time, and all other instances will be locked for other threads. 
	 * This should always be done to make static data thread safe.
	 */
	public static class DemoClass_ClassLevel
	{
		public synchronized static void demoMethod1(){}
		public void demoMethod2(){
	        synchronized (DemoClass_ClassLevel.class){
	            //other thread safe code
	        }
	    }
		 private final static Object lock = new Object();
		    public void demoMethod3(){
		        synchronized (lock){
		            //other thread safe code
		        }
		    }
	}

}
class SomeClass {
	//class level
    public static void m1() {
        synchronized (SomeClass.class) {
           //do something
        }
    }
    //object level
    public void m2() {
        synchronized (this) {
           //do something
        }
    }
}