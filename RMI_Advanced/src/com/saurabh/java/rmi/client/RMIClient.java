package com.saurabh.java.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import com.saurabh.java.rmi.Data;
import com.saurabh.java.rmi.ProcessInterface;


public class RMIClient {
	
	public static void main(String[] args) {
		try {
			Data[] dataItems = {new Data(10), new Data(8)};
			List<Data> list = Arrays.asList(dataItems);
			ProcessInterface process = (ProcessInterface) Naming.lookup("//localhost/RMIServer");
			process.setData(list);
			System.out.println(process.processData(ProcessInterface.SUMMATION, 8));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}
