package com.saurabh.dada.iq.impl;

import java.io.IOException;

public class TryCatchExceptionFinally {

	public static void main(String[] args) {
		
		try{
			try{
				System.out.println("Try Block just before throwing exception!");
				throw new IOException("Nulle Oye!");
			}
			finally{
				System.out.println("Finally Block!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
