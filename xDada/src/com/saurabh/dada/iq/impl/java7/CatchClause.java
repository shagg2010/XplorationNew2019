package com.saurabh.dada.iq.impl.java7;

import java.rmi.UnexpectedException;

import javax.naming.NameNotFoundException;

public class CatchClause {

	public static void main(String[] args) {
		
		int a=1;
		
		try{
			if(a<=0){
				throw new IllegalAccessException("a=0");
			}
			else if(a==1){
				throw new NameNotFoundException("a=1");
			}
			else{
				throw new UnexpectedException("a>0");
			}
		}
		catch(IllegalAccessException | NameNotFoundException | UnexpectedException e){
			e.printStackTrace();
		}

	}

}
