package com.vigorous.bean;

public class HelloWorld {

	private String name;
	
	public void setName(String n) {
		name = n;
	}
	
	public void printName() {
		System.out.println("spring hello == " + name);
	}
}
