<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	System.out.println("*** action is " + action + " " + request.getMethod()==null ? " not method" : request.getMethod() + " " + request.getCookies()==null ? "not cookie" :"cookie!");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<s:radio label="optype" name="optype" value="1" --%>
<%-- 		list="#{'1':'regist','2':'login'}"></s:radio> --%>
		<s:label value="注册"></s:label>
		<s:form action="regist">
			<s:textfield name="nickname" label="nickname"></s:textfield>
			<s:password name="password" label="password"></s:password>
			<s:submit value="register"></s:submit>
		</s:form>
		<br>
	
	
		<!--若要点击图片刷新，重新得到一个验证码，要在后面加上个随机数，这样保证每次提交过去的都是不一样的path，防止因为缓存而使图片不刷新-->
		<s:label>登录</s:label>
		<s:form action="login">
			<s:textfield name="nickname" label="nickname"></s:textfield>
			<s:password name="password" label="password"></s:password>
			<img src="verify" onclick="this.src='verify.action?'+ Math.random()" alt="看不清，换一张"></img>
			<s:textfield name="verifyCode" label="验证码"/>
			<s:submit value="login"></s:submit>
		</s:form>
	

</body>
</html>