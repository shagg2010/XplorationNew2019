package com.saurabh.java.hfsj.ch05.listeners;

import java.util.Enumeration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletRequestListenerClass implements ServletRequestListener {
	
	private static Logger LOG = LoggerFactory.getLogger(ServletRequestListenerClass.class);

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		ServletRequest servletRequest = event.getServletRequest();
		LOG.info("\n>>>  >>> Destroying Request - [Remote Address: " + servletRequest.getRemoteAddr() + ", Remote Port: " + servletRequest.getRemotePort() + "]" + displayServletRequestXXXNames(servletRequest, "parameters") + displayServletRequestXXXNames(servletRequest, "attributes"));
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletRequest servletRequest = event.getServletRequest();
		LOG.info("\n>>>  >>> New Request - [Remote Address: " + servletRequest.getRemoteAddr() + ", Remote Port: " + servletRequest.getRemotePort() + "]" + displayServletRequestXXXNames(servletRequest, "parameters") + displayServletRequestXXXNames(servletRequest, "attributes"));
	}
	
	private StringBuffer displayServletRequestXXXNames(ServletRequest servletRequest, String type){
		StringBuffer buffer = new StringBuffer("");
		if(type.equalsIgnoreCase("attributes")){
			buffer.append("\n\tAttributes-");
			Enumeration<String> attributes = servletRequest.getAttributeNames();
			int i=0;
			while(attributes.hasMoreElements()){
				String name = attributes.nextElement();
				buffer.append("\n\t\t"+ (++i)+". "+name+ "=" + servletRequest.getAttribute(name));
			}
		}
		else if(type.equalsIgnoreCase("parameters")){
			buffer.append("\n\tParameters-");
			Enumeration<String> parameters = servletRequest.getParameterNames();
			int i=0;
			while(parameters.hasMoreElements()){
				String name = parameters.nextElement();
				buffer.append("\n\t\t"+ (++i)+". "+name+ "=" + servletRequest.getParameter(name));
			}
		}
		return buffer;
	}

}
