package com.vigorous.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	private List<String> fruits;
	private String yourFruits;
	
	public List<String> getFruits() {
		return fruits;
	}

	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	public String getYourFruits() {
		return yourFruits;
	}

	public void setYourFruits(String yourFruits) {
		this.yourFruits = yourFruits;
	}

	public HelloAction() {
		fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		fruits.add("Watermelon");
	}
	
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		return SUCCESS;
	}
	
	public String display() {
		return NONE;
	}

}
