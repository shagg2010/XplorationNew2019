package com.saurabh.dada.iq.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.saurabh.dada.iq.impl.entities.Message;

public class Hibernate_GetOrLoad {
	
	private static SessionFactory sessionFactory=null;
	private static final Object lock = new Object();

	public static void main(String[] args) {
		Session session = null;
		try{
			sessionFactory = getSessionFactory();
			session = sessionFactory.openSession();
			
			
			//Hibernate get
			Transaction tx = session.beginTransaction();
			Message msg1 = (Message) session.get(Message.class, new Long(1));
			System.out.println("Message fetched using get() method: "+msg1+"\n");
			tx.commit();
			
			//Hibernate load - it fetch only message with ID==1 because it is now associated with session (because of get method call above)
			//if you try to load with ID==2, java.lang.InstantiationException: com.saurabh.dada.iq.impl.entities.Message_$$_javassist_0 will be reported
			Transaction tx1 = session.beginTransaction();
			Message msg2 = (Message) session.load(Message.class, new Long(1));
			System.out.println("Message fetched using load() method: "+msg2+"\n");
			tx1.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(session!=null){
				session.close();
			}
			if(sessionFactory!=null){
				sessionFactory.close();
			}
		}
		
		
	}
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			synchronized (lock) {
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			}
		}
		return sessionFactory;
	}

}
