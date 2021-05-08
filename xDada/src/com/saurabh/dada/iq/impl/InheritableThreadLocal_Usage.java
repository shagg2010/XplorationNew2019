package com.saurabh.dada.iq.impl;

public class InheritableThreadLocal_Usage {

	public static void main(String[] args) throws Exception {
		ParentThread gfg_pt = new ParentThread(); 
        gfg_pt.start(); 
        
        Thread.currentThread().sleep(1000);
        
        ParentThread_ThreadLocal gfg_pt1 = new ParentThread_ThreadLocal(); 
        gfg_pt1.start(); 

	}

}

class ParentThread extends Thread { 
    // anonymous inner class  for overriding childValue method. 
    public static InheritableThreadLocal gfg_tl = new InheritableThreadLocal() { 
        public Object childValue(Object parentValue) 
        { 
            return "child data [" +  parentValue +  "]"; 
        } 
    }; 
    public void run() 
    { 
        // setting the new value 
        gfg_tl.set("parent data"); 
        // parent data 
        System.out.println("Parent Thread Value :" + gfg_tl.get()); 
  
        ChildThread gfg_ct = new ChildThread(); 
        gfg_ct.start(); 
    } 
} 
class ChildThread extends Thread { 
	  
    public void run() 
    { 
        // child data 
        System.out.println("Child Thread Value :" + ParentThread.gfg_tl.get()); 
    } 
} 


class ParentThread_ThreadLocal extends Thread { 
    public static ThreadLocal<String> gfg_tl = new ThreadLocal<>(); 
    public void run() 
    { 
  
        // setting the new value 
        gfg_tl.set("parent data"); 
  
        // returns the ThreadLocal value associated with current thread 
        System.out.println("Parent  Thread Value :" + gfg_tl.get()); 
  
        ChildThread_ThreadLocal gfg_ct = new ChildThread_ThreadLocal(); 
        gfg_ct.start(); 
    } 
}
class ChildThread_ThreadLocal extends Thread { 
    public void run() 
    { 
  
        // returns  the ThreadLocal value associated with current thread 
        System.out.println("Child Thread Value :" + ParentThread_ThreadLocal.gfg_tl.get()); 
        /* null (parent thread variable  
        thread local value is not available to child thread ) */
    } 
} 