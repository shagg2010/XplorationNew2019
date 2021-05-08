package com.saurabh.dada.iq.impl;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

public class TryWithResourceInJava7 {
	
	public static void main(String[] args) {

		//Java will close resources in reverse order
		try (MyResource1 mr1 = new MyResource1();MyResource2 mr2 = new MyResource2();MyResource3 mr3 = new MyResource3()) {
			System.out.println("MyResource(s) created in try-with-resources");
			try {
				mr1.foo();
			}
			catch(IOException | JAXBException e) {
				//e = new Exception("");  === e is final and can't be re-assigned
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Out of try-catch block.");
	}

	static class MyResource1 implements AutoCloseable{
		
		public void foo() throws IOException, JAXBException{
			Float f = new Float("900.09f");
			System.out.println((float)f.doubleValue());;
		}
		
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource1");
		}
	}
	
	static class MyResource2 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource2");
		}
	}

	static class MyResource3 implements AutoCloseable{
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource3");
		}
	}
}
