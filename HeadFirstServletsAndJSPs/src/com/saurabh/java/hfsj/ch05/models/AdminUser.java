package com.saurabh.java.hfsj.ch05.models;

import java.io.Serializable;

public class AdminUser implements Serializable {
	
	private static final long serialVersionUID = -3751685794693994973L;
	
	private String id;
	private String name;
	private String privilegesfqn;
	
	public AdminUser(String id, String name, String privileges) {
		super();
		this.id = id;
		this.name = name;
		this.privilegesfqn = privileges;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "AdminUser [Id: " + getId() + ", name: " + getName() + ", privileges: " + getPrivileges()+"]\n";
	}
}
