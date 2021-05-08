package com.saurabh.java.hfsj.ch06.listeners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpSessionAttributeListenerClass implements
		HttpSessionAttributeListener {
	
	private static Logger LOG = LoggerFactory.getLogger(HttpSessionAttributeListenerClass.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("\n>>>  >>>[Added:HttpSessionAttribute] An attribute [" + event.getName() + "] was added to the ServletSession object.");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("\n>>>  >>> [Removed:HttpSessionAttribute] An attribute [" + event.getName() + "] was removed from the ServletSession object");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("\n>>>  >>> [Replaced:HttpSessionAttribute] An attribute [" + event.getName() + "] was replaced in the ServletSession object");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

}
