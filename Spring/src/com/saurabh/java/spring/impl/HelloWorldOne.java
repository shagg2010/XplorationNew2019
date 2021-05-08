package com.saurabh.java.spring.impl;

import com.saurabh.java.spring.interfaces.HelloWorldInterface;

public class HelloWorldOne implements HelloWorldInterface {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = "\"" + message + "\"";
	}

}
