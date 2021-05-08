package com.saurabh.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {

	private String msg;
	private static final long serialVersionUID = -2706069493932352835L;
	
	protected Hello(String msg) throws RemoteException {
		this.msg= msg;
	}

	@Override
	public String getMessage() throws RemoteException {
		return "Hello, " + this.msg;
	}
	


}
