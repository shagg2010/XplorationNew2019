package com.saurabh.dada.iq.impl;

import java.util.concurrent.Exchanger;

public class Exchanger_ShareDataBetweenThreads {

	public static void main(String[] args) {
		
		Exchanger<Object> exchanger = new Exchanger<Object>();

		CommunicatingThread t1 = new CommunicatingThread(exchanger, new String("A value"),"T1");

		CommunicatingThread t2 = new CommunicatingThread(exchanger, new String("B value"),"T2");

		new Thread(t1).start();
		new Thread(t2).start();

	}

}

class CommunicatingThread implements Runnable{

    Exchanger<Object> exchanger = null;
    Object    object    = null;
    String name;

    public CommunicatingThread(Exchanger<Object> exchanger, Object object, String name) {
        this.exchanger = exchanger;
        this.object = object;
        this.name = name;
    }

    public void run() {
        try {
            Object previous = this.object;
            this.object = this.exchanger.exchange(this.object);
            System.out.println(this.name + " exchanged " + previous + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
