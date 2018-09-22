<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	${1+3}<br/>
	${1+"3"}<br/>
	<%-- ${1+"a"}<br/> --%>
	${1>3}<br/>
	<%
		request.setAttribute("str","abc");
	 %>
	${"abc"==str}<br/>
	${1>3 && 3>1}<br/>
	<%
		request.setAttribute("obj1","");
		request.setAttribute("obj2",null);
		List list = new ArrayList();
		request.setAttribute("obj3",list);
	 %>
	${empty obj}
	${empty obj1}
	${empty obj2}
	${empty obj3}
	
	
</body>
</html>