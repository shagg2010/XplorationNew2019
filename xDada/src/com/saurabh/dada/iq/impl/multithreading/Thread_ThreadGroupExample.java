package com.saurabh.dada.iq.impl;

public class Thread_ThreadGroupExample {

	public static void main(String[] args) {

		WorkerThread workerThread = new WorkerThread();
		ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");  
        
        Thread t1 = new Thread(tg1, workerThread,"one");  
        t1.start();  
        Thread t2 = new Thread(tg1, workerThread,"two");  
        t2.start();  
        Thread t3 = new Thread(tg1, workerThread,"three");  
        t3.start(); 
        
        System.out.println("Active Thread Count: "  +tg1.activeCount());
        System.out.println("Thread Group Name: "+tg1.getName());  
        tg1.list();
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());;
        
	}

}
class WorkerThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}

/*int marks[][]={{50,60,55,67,70},{62,65,70,70},{72,66,77,80,69}};
for(int i=0;i<marks.length;i++) {
	for(int j=0;j<marks[i].length;j++) {
		System.out.print(marks[i][j] + " " );
	}
	System.out.println();
}

int [][] marks2 = {{1,2,3},{}, {7,8,9}};
for(int i=0;i<marks2.length;i++) {
	for(int j=0;j<marks2[i].length;j++) {
		System.out.print(marks2[i][j] + "[" + i + "," + j +"]\t");
	}
	System.out.println();
}

int [][] e = {{1,2,3},{}, {7,8,9}};
System.out.println(e[1][2]);*/