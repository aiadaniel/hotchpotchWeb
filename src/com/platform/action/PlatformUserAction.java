package com.platform.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.platform.bean.PlatformUser;
import com.platform.service.impl.PlatformService;
import com.platform.utils.Constant;
import com.platform.utils.CookieUtils;
import com.platform.utils.ErrCodeBase;

//@Namespace("/")
@Results({ @Result(name = "success", location = "/welcome.jsp"),
		@Result(name = "error", location = "/error.jsp"),
		@Result(name = "input", location = "/user/platform_register.jsp"),
		@Result(name = "login", location = "/user/platform_register.jsp")
})
public class PlatformUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 714502759237231114L;

	private String nickname;
	private String password;

	@RequiredFieldValidator(message = "nickname can not be empty!")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@RequiredFieldValidator(message = "password need to be set!")
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

	@Action(value = "regist")
	public String regist() {
		PlatformUser user = new PlatformUser();
		user.setNickname(nickname);
		user.setIdentifier(nickname);
		user.setCredential(password);
		user.setLogin_type(Constant.LOGIN_NAME);
		if (platformService.create(user) == ErrCodeBase.ERR_USER_ALREADY) {
			addActionError("该用户已经注册");
			return ERROR;
		}
		return SUCCESS;
	}

	@Action(value = "login")
	public String login() {
		//first verify code
		HttpSession ses = ServletActionContext.getRequest().getSession();
		String verify = (String) ses.getAttribute(VerifyCodeAction.VERIFY_CODE);
		System.out.println(" get verify " + verify);
		if (verifyCode==null || (verifyCode != null && !verifyCode.equals(verify))) {
			addFieldError("verifyCode", "验证码错误");
			return ERROR;
		}
		
		PlatformUser user = new PlatformUser();
		user.setNickname(nickname);
		user.setCredential(password);
		user.setLogin_type(Constant.LOGIN_NAME);
		StringBuffer sb = new StringBuffer();
		if (platformService.login(user,sb) != ErrCodeBase.ERR_SUC) {
			addActionMessage("用户密码错误");
			return ERROR;
		}
		
		//add for cookie test
		if (autoLogin) {
			Cookie cookie = cookieUtils.addCookie(nickname, sb.toString());
			response.addCookie(cookie);//note to write to client
		}
		// and set the user to session too
		ses.setAttribute(CookieUtils.PLATFORM_USER_SESSION, user);
		
		return SUCCESS;
	}

	// ====below for test cookie login====
	private HttpServletResponse response;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private CookieUtils cookieUtils = new CookieUtils();
	private boolean autoLogin;

	private String verifyCode;

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public boolean isAutoLogin() {
		return autoLogin;
	}

	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	//@Action(value = "autologin")
	public String autoLogin() {
		request = ServletActionContext.getRequest();
		String[] res = cookieUtils.getCookie();
		if (res != null) {
			String name = res[0];
			String cre = res[1];
			PlatformUser user = platformService.loginWithCookie(name, cre);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute(CookieUtils.PLATFORM_USER_SESSION, user);//note 
				return SUCCESS;
			}
		}
		return LOGIN;
	}

	// 用户退出
	public String logout() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session = request.getSession(false);
		if (session != null)
			session.removeAttribute(CookieUtils.PLATFORM_USER_SESSION);
		Cookie cookie = cookieUtils.delCookie(request);
		if (cookie != null)
			response.addCookie(cookie);
		return "login";
	}
}
