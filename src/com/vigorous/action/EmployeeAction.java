package com.vigorous.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


//����ע�ⷽʽ��ò����Ҫɾ��struts.xml�ļ�(���Է��ֲ���ɾ�����ɹ���)
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
	//ע�ⷽʽ
	//����ע�⻹�м����Ƚ���Ҫ�ģ�@Namespace  @Before  @After  @BeforeResult ... 
	//�Լ� @ConversionErrorFieldValidator�ȸ�����֤ע��
	//����@Conversion  @CreateIfNull  @Element  @Key  @KeyProperty  @TypeConversion...
	@Action(value="/employee")
	public String execute() {
		return SUCCESS;
	}
}
