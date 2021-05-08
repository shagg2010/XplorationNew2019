package com.saurabh.dada.iq.impl;

public class WaitNotifyInJava {
    public static void main(String[] args){
        ThreadA a1 = new ThreadA();
        a1.start();
 
        synchronized(a1){
            try{
                System.out.println("Waiting for a to complete...");
                a1.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Total is: " + a1.total + "[a1]");
    }
}
 
class ThreadA extends Thread{
    int total;
    ThreadB b1;
    @Override
    public void run(){
    	try{
    		b1 = new ThreadB();
            b1.start();
            synchronized (b1) {
            	System.out.println("Waiting for b to complete...");
                b1.wait();
			}
        }
        catch(InterruptedException e){
        	e.printStackTrace();
        }
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            System.out.println("Total is: " + b1.total + "[b1]");
           notify();
        }
    }
}
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
           notify();
        }
    }
}

