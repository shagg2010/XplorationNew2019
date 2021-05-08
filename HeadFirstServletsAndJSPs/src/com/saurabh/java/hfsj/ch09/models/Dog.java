package com.saurabh.java.hfsj.ch09.models;

import java.io.Serializable;

public class Dog implements Serializable {

	private static final long serialVersionUID = 1040940627679608924L;
	
	private String dogname;
	private String breed;
	
	public Dog() {
		super();
	}
	
	public Dog(String dogname, String breed) {
		super();
		this.dogname = dogname;
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Dog [name=" + dogname + ", age=" + breed + "]";
	}

	public String getDogname() {
		return dogname;
	}

	public void setDogname(String dogname) {
		this.dogname = dogname;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
