package com.saurabh.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {
	
	public String getMessage() throws RemoteException;

}
