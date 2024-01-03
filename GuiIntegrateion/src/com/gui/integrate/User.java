package com.gui.integrate;

public class User {
	User(String name, String mark) {
		this.mark=mark;
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	String name;
	String mark;
	
	

}
