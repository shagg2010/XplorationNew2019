package com.saurabh.dada.iq.impl;

import java.util.Observable;
import java.util.Observer;

public class Observable_InJava {

	public static void main(String[] args) {
		MessageBoard board = new MessageBoard();
	    Student bob = new Student("Bob");
	    Student joe = new Student("Joe");
	    board.addObserver(bob);
	    board.addObserver(joe);
	    board.changeMessage("Homework!");
	    board.changeMessage("More Homework!");
	}

}

class MessageBoard extends Observable {
	private String message;

	public String getMessage() {
		return message;
	}

	public void changeMessage(String message) {
		this.message = message;
		setChanged();
		notifyObservers(message);
	}
}

class Student implements Observer {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public void update(Observable o, Object arg) {
		System.out.println("Message: " + arg + " seen by -" + this.name);
	}
}
