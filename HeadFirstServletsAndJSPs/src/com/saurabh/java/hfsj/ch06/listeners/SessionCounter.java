package com.saurabh.java.hfsj.ch06.listeners;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {

	static private int activeSessions=0;
	
	public static int getActiveSessions() {
		return activeSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("\nSession created: " + event.getSession().getId() + " @ " + new Date(event.getSession().getCreationTime()) + " with validity of: " + event.getSession().getMaxInactiveInterval() + " seconds.");
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("\nSession destroyed: " + event.getSession().getId() + " @ " + new Date(System.currentTimeMillis()) + " with validity of: " + event.getSession().getMaxInactiveInterval() + " seconds.");
		activeSessions--;
	}

}
