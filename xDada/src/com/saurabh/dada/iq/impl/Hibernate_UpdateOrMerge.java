package com.saurabh.dada.iq.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.saurabh.dada.iq.impl.entities.Message;

public class Hibernate_UpdateOrMerge {

	private static SessionFactory sessionFactory=null;
	private static final Object lock = new Object();

	public static void main(String[] args) {
		Session session = null;
		try{
			sessionFactory = getSessionFactory();
			
			//Hibernate get
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Message msg1 = (Message) session.get(Message.class, new Long(2));
			System.out.println("Message fetched using get() method: "+msg1+"\n");
			tx.commit();
			session.close();
			
			//changing persistent object after session close - detached state
			msg1.setMessageText("Using Hibernate 3.5.4 for this example.");
			
			//session.merge method will update the detached object smoothly  
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			Message msg2 = (Message) session.merge(msg1);
			System.out.println("Message saved using merge() method: "+msg2+"\n");
			tx1.commit();
			session.close();
			
			//session.update method will NOT update the detached object and below changes will not be reflected in database
			msg2.setMessageText("Using Hibernate 3.5.4");
			//this update to messageText will not be persisted in database
			session = sessionFactory.openSession();
			Transaction tx2 = session.beginTransaction();
			session.update(msg1);
			System.out.println("Message saved using update() method: "+session.load(Message.class, new Long(2))+"\n");
			tx2.commit();
			session.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(session!=null&&session.isOpen()){
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
