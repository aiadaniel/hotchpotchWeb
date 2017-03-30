<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

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
	
		<s:label>登录</s:label>
		<s:form action="login">
			<s:textfield name="nickname" label="nickname"></s:textfield>
			<s:password name="password" label="password"></s:password>
			<s:submit value="login"></s:submit>
		</s:form>
	

</body>
</html>