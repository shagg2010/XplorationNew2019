package com.shagg.java.hib.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Session session = null;
		
		try{
			System.out.println("Creating Hibernate Session...");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction tx=session.beginTransaction(); 
			System.out.println("Hibernate Session Created Successfully...");
			System.out.println("Creating a Record...");
			InputDataTable inputDataTable = new InputDataTable();
			inputDataTable.setId("108");
			inputDataTable.setX(18f);
			inputDataTable.setY(18f);
			session.save(inputDataTable);
			tx.commit(); 
			System.out.println("Record Inserted Into Database Successfully...");
		}
		catch(Exception e){
			System.out.println("Exception caught: " + e);
		}
		finally{
			session.flush();
			session.close();
		}

	}

}
