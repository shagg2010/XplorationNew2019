package com.saurabh.java.hfsj.ch05.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppContextAttributeListener implements
		ServletContextAttributeListener {
	
	private static Logger LOG = LoggerFactory.getLogger(AppContextAttributeListener.class);

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("\n>>>  >>>[Added:ServletContextAttribute] An attribute [" + event.getName() + "] was added to the ServletContext object.");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("\n>>>  >>> [Removed:ServletContextAttribute] An attribute [" + event.getName() + "] was removed from the ServletContext object");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("\n>>>  >>> [Replaced:ServletContextAttribute] An attribute [" + event.getName() + "] was replaced in the ServletContext object");
		LOG.info(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

}
