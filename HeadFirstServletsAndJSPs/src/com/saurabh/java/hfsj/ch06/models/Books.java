package com.saurabh.java.hfsj.ch06.models;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Books implements HttpSessionBindingListener,
		HttpSessionActivationListener, Serializable {

	private static final long serialVersionUID = -2111428903098693280L;
	
	private String isbn;
	private String name;
	private String authors;

	public String getIsbn() {
		return isbn;
	}

	public Books(String isbn, String name, String authors) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.authors = authors;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("Session has just been activated.");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("Session is about to be passivated.");
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(toString() + " added to session [" + event.getSession().getId() + "].");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(toString() + " from the session [" + event.getSession().getId() + "].");
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", authors="
				+ authors + "]";
	}

}
