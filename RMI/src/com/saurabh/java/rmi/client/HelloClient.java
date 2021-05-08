package com.saurabh.java.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.saurabh.java.rmi.HelloInterface;

public class HelloClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloInterface helloI = (HelloInterface) Naming.lookup("//lyadasw7/RMIServer");
			System.out.println(helloI.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
