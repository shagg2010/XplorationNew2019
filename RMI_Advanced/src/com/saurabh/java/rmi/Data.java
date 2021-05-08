package com.saurabh.java.rmi;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = -7673147248249889932L;
	
	private Integer value;
	public Data(int value) throws IllegalArgumentException{
		this.value = value;
	}
	public Integer getValue() {
		return value;
	}
}
