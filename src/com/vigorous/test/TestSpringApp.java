package com.vigorous.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vigorous.bean.HelloWorld;

public class TestSpringApp {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hWorld = (HelloWorld) context.getBean("helloBean");
		hWorld.printName();
	}

}
