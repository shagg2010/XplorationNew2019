package com.saurabh.dada.iq.impl;

import java.util.concurrent.atomic.AtomicBoolean;

public class Lock_ComapreAndSwap {

	public static void main(String[] args) {
		CASLock lock=new CASLock();
		for(int i=0;i<10000;i++){
			new OperationZ().doOperation(lock, i+"");
		}

	}

}

class OperationZ extends Thread{
	private CASLock lock;
	public void doOperation(CASLock lock, String name){
		this.setName(name);
		this.lock=lock;
		if(lock!=null){
			while(lock.isLocked()){
				//do nothing
			}
			try{
				lock.lock();
				System.out.println("Thead: " + this.getName());
			}
			finally{
				lock.unlock();
			}
		}
	}
}

class CASLock {
    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean isLocked(){
    	return locked.get();
    }
    
    public boolean lock() {
        return locked.compareAndSet(false, true);
    }
    public boolean unlock() {
        return locked.compareAndSet(true, false);
    }

}