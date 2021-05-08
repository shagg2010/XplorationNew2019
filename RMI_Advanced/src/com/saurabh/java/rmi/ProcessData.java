package com.saurabh.java.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ProcessData extends UnicastRemoteObject implements ProcessInterface {

	List<Data> items;
	private static final long serialVersionUID = -5021386860739207441L;
	
	protected ProcessData() throws RemoteException {
		super();
	}
	
	protected ProcessData(List<Data> items) throws RemoteException {
		this.items = items;
	}

	@Override
	public double processData(int operation, double seedValue) throws RemoteException, ClassCastException {
		
		double result=seedValue;
		try{
			
			if(operation==ProcessInterface.SUMMATION){
				for(Object item: items){
					Data data = (Data) item;
					result = result + data.getValue();
				}
			}
			else if(operation==ProcessInterface.SUBTRACTION){
				for(Object item: items){
					Data data = (Data) item;
					result = result - data.getValue();
				}
			}
			else if(operation==ProcessInterface.DIVISION){
				for(Object item: items){
					Data data = (Data) item;
					result = result / data.getValue();
				}
			}
			else if(operation==ProcessInterface.MULTIPLICATION){
				for(Object item: items){
					Data data = (Data) item;
					result = result * data.getValue();
				}
			}
		}
		catch(ClassCastException e){
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public void setData(List<Data> items) throws RemoteException {
		this.items = items;
	}

}
