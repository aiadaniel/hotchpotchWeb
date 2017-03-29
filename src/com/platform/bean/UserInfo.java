package com.platform.bean;

import java.sql.Timestamp;


public class UserInfo {
	
	public String name;
	public int age;
	public Timestamp registerDate;
	public boolean isActive;
	
	public UserInfo(String n,int ag,Timestamp d,boolean is) {
		name = n;
		age = ag;
		registerDate = d;
		isActive = is;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
