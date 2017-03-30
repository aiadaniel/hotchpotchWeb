package com.platform.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.platform.bean.PlatformUser;
import com.platform.service.impl.PlatformService;
import com.platform.utils.Constant;
import com.platform.utils.ErrCodeBase;

@Results({
		@Result(name="success",location="/welcome.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="input",location="/user/platform_register.jsp")
})
public class PlatformUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 714502759237231114L;

	private String nickname;
	private String password;
	
	@RequiredFieldValidator(message="nickname can not be empty!")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@RequiredFieldValidator(message="password need to be set!")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PlatformService<PlatformUser> getPlatformService() {
		return platformService;
	}

	public void setPlatformService(PlatformService<PlatformUser> platformService) {
		this.platformService = platformService;
	}

	PlatformService<PlatformUser> platformService;

	@Action(value="regist")
	public String regist() {
		PlatformUser user = new PlatformUser();
		user.setNickname(nickname);
		user.setIdentifier(nickname);
		user.setCredential(password);
		user.setLogin_type(Constant.LOGIN_NAME);
		if(platformService.create(user)==ErrCodeBase.ERR_USER_ALREADY) {
			addActionError("该用户已经注册");
			return ERROR;
		}
		return SUCCESS;
	}
	
	
	@Action(value="login")
	public String login(){
		PlatformUser user = new PlatformUser();
		user.setNickname(nickname);
		user.setCredential(password);
		user.setLogin_type(Constant.LOGIN_NAME);
		if (platformService.find(user) != ErrCodeBase.ERR_SUC) {
			addActionMessage("用户密码错误");
			return ERROR;
		}
		return SUCCESS;
	}
}
