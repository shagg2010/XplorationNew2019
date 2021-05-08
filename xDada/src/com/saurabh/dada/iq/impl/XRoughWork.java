package com.saurabh.dada.iq.impl;

import java.util.ArrayList;
import java.util.List;

public class XRoughWork {

	public static void main(String[] args) {
		
		Subject subject = new Subject();
		Observer binObserver = new BinaryObserver(subject);
		Observer hexObserver = new HexObserver(subject);
		subject.setState(10);
		subject.setState(15);
		
	}
	

	
}

enum EmpCode {

	// also implement this method properly
//	public static EmpCode getEnum(int code) {
//	         
//	         
//	   }

}

abstract class Observer{
	public Subject subject;
	public abstract void update();
}
class Subject{
	
	public int state = 0;
	public List<Observer> observers = new ArrayList<Observer>();
	
	public int getState() {
		return this.state;
	}
	public void setState(int state) {
		this.state = state;
		notifyObservers();
	}
	public void attach(Observer  observer) {
		observers.add(observer);
	}
	public void notifyObservers() {
		for(Observer ob: observers) {
			ob.update();
		}
	}
}
class BinaryObserver extends Observer{

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toBinaryString(this.subject.getState()));
	}
	
}
class HexObserver extends Observer{
	
	public HexObserver(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(this.subject.getState()));
	}
}