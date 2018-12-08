package com.qimo.entity;

public class Users {
	private String name = null;
	private String password = null;
	
	public Users() {
		super();
	}
	
	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
