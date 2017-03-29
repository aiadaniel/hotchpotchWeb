<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="Hello">
		<s:textfield name="name" label="username"></s:textfield>
		<s:textfield name="age" label="age"></s:textfield>
		<sx:datetimepicker name="registerDate" label="registerDate" displayFormat="dd-MM-yyyy" value="%{'2017-03-01'}"/>
		<s:submit value="register"></s:submit>
	</s:form>
</body>
</html>