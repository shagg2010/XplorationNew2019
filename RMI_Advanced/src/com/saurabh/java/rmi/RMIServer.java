package com.saurabh.java.rmi;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

	/**
	 * @param args
	 */
	
	//https://forums.oracle.com/forums/thread.jspa?messageID=4800937
	//Provide the following VM arguments 
	//-Djava.security.policy=D:\workbench\workspace\SeriouslySaurabh\RMI_Advanced\src\server.policy
	
	
	public static void main(String[] args) {
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
			ProcessData pData = new ProcessData();
			Naming.rebind("//localhost/RMIServer", pData);
			
		}
		catch(Exception e){
			System.out.println("RMI Server exception occured...");
			e.printStackTrace();
		}
	}


}
