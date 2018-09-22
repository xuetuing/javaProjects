<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/>
	<s:property value="name"/>等同于${name}
	<s:if test="age>18">成年</s:if>
	<s:else>未成年</s:else>
	
	<s:iterator value="list">
		<s:property value="username"/>
	</s:iterator>
	
	<s:iterator begin="1" end="5" var="p_value">
		<s:property value="#p_value"/>
	</s:iterator>
</body>
</html>









