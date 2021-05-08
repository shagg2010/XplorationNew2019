package com.saurabh.java.spring.impl;

import com.saurabh.java.spring.interfaces.HelloWorldInterface;

public class HelloWorldTwo implements HelloWorldInterface {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = "Your message was: " + "\"" + message + "\"";
	}
}
