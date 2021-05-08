package com.saurabh.java.hfsj.ch05.listeners;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class AdminUserHttpSessionBindingListernerClass implements
		HttpSessionBindingListener, Serializable {
	
	private static final long serialVersionUID = 6395806588040766491L;
	private String name;
	private String privilegesfqn;
	
	public AdminUserHttpSessionBindingListernerClass(String name, String privileges) {
		super();
		this.name = name;
		this.privilegesfqn = privileges;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivileges() {
		return privilegesfqn;
	}
	public void setPrivileges(String privileges) {
		this.privilegesfqn = privileges;
	}
	
	public String toString(){
		return "AdminUserHttpSessionBindingListernerClass [name: " + getName() + ", privileges: " + getPrivileges()+"]\n";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("AdminUserHttpSessionBindingListernerClass added to the session [ID: " + event.getSession().getId() + "], time to synchronize it with Database!");

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("AdminUserHttpSessionBindingListernerClass removed from the session [ID: " + event.getSession().getId() + "], time to synchronize it with Database!");
	}

}
