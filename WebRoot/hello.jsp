<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form action="comboBox">
		<s:textfield name="username" label="UserName" />
		<s:password name="password" label="PassWd"></s:password>
		<s:submit value="Commit"></s:submit>



		<s:combobox label="What's your favor fruit" headerKey="-1"
			headerValue="--- Select ---" list="fruits" name="yourFruits" />

	</s:form>


</body>
</html>