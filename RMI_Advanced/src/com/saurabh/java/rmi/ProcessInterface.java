package com.saurabh.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ProcessInterface extends Remote {
	
	public int SUMMATION=1;
	public int SUBTRACTION=2;
	public int MULTIPLICATION=3;
	public int DIVISION=4;
	
	public double processData(int operation, double seedValue) throws RemoteException;
	
	public void setData(List<Data> items) throws RemoteException;

}
