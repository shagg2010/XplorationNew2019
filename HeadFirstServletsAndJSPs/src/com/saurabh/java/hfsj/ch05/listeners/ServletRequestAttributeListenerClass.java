package com.saurabh.java.hfsj.ch05.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletRequestAttributeListenerClass implements
		ServletRequestAttributeListener {
	
	private static Logger LOG = LoggerFactory.getLogger(ServletRequestAttributeListenerClass.class);

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("\n>>>  >>> [Added:ServletRequestAttribute] An attribute [" + event.getName() + "] was added to the ServletRequest object.");
		LOG.debug(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("\n>>>  >>> [Removed:ServletRequestAttribute] An attribute [" + event.getName() + "] was removed from the ServletRequest object.");
		LOG.debug(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("\n>>>  >>> [Replaced:ServletRequestAttribute] An attribute [" + event.getName() + "] was replaced in the ServletRequest object.");
		LOG.debug(">>>  >>>Name: " + event.getName() + ", Value: " + event.getValue());
	}

}
