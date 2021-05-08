package com.saurabh.dada.iq.impl.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

	public static void main(String[] args){
		System.out.println("RMI Server started...");
		if(System.getSecurityManager()==null){
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Security Manager installed...");
		}
		else{
			System.out.println("Security Manager already running...");
		}
		
		try{
			LocateRegistry.createRegistry(1099);
		}
		catch(RemoteException e){
			System.out.println("JAVA RMI registry already exists...");
		}
		
		try{
			Hello hello = new Hello("Saurabh Yadav...");
			Naming.rebind("//lyadasw7/RMIServer", hello);
			
		}
		catch(Exception e){
			System.out.println("RMI Server exception occured...");
			e.printStackTrace();
		}
	}

}
