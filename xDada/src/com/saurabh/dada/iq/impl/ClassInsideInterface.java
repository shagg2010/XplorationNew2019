package com.saurabh.dada.iq.impl;

interface M{  
    class A{
    	public void method(){
    		System.out.println("Method...!");
    	}
    }  
  }  
public class ClassInsideInterface {
	
	public static void main(String[] args){
		M.A a = new M.A();
		a.method();
	}

}
