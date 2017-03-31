package com.vigorous.action;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.platform.bean.UserInfo;
import com.vigorous.dao.impl.UserDao;

public class HelloAction extends ActionSupport{
	
	private String name;
	private int age;
	private Date registerDate;
	
	private List<String> fruits;
	private String yourFruits;
	
	//test spring+struts2
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date createDate) {
		this.registerDate = createDate;
	}

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
	
	public java.util.Date getTodayDate() {
		return new java.util.Date();
	}
	
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		//UserDao userDao = new UserDao();//todo 这样实例化的话，内部对象的注入会有问题
		
		//直接使用spring注入更好
//		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserDao userDao = factory.getBean(UserDao.class);
		userDao.userRegister(new UserInfo(getName(),getAge(),new Timestamp(getRegisterDate().getTime()),true));
		return SUCCESS;
	}
	
	//这个方法在execue方法前被调用，目前看没有配置就能调用
	//另外，还可以建立根据xml配置文件的验证
	public void validate() {
		System.out.println("==hello validate");
		if (name == null || "".equals(name)) {
			addFieldError("name", "名字不能为空");//任何这类型的语句都导致execute不被调用。 另外没有配置input的result会抛出异常
		}
	}
	
	//http://localhost:8080/hotchpotchWeb/comboBox.action 用这样的访问方式才有效
	public String display() {
		return NONE;
	}

}
