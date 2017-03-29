package com.vigorous.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


//测试注解方式，貌似需要删除struts.xml文件(测试发现不用删除，可共存)
@Results({ 
	@Result(name="success",location="/welcome.jsp"),
	@Result(name="input",location="/user/employee.jsp")
})
public class EmployeeAction extends ActionSupport {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String name;
	private int age;
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
	//注解方式
	//另外注解还有几个比较重要的：@Namespace  @Before  @After  @BeforeResult ... 
	//以及 @ConversionErrorFieldValidator等各种验证注解
	//还有@Conversion  @CreateIfNull  @Element  @Key  @KeyProperty  @TypeConversion...
	@Action(value="/employee")
	public String execute() {
		return SUCCESS;
	}
}
