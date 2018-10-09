<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.row1{
		background-color:yellow; 
	}
	.row2{
		background-color:red; 
	}
</style>
</head>
<body>
	<%
		User u1 = new User();
		u1.setUsername("jack");
		u1.setAge(10);
		User u2 = new User();
		u2.setUsername("rose");
		u2.setAge(23);
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		request.setAttribute("user",u1);
		request.setAttribute("list",list);
	 %>
	<table border="1px">
		<tr><td>昵称</td><td>年龄</td></tr> 
	 	<c:forEach items="${list}" var="user" varStatus="vs">
	 		<tr class="row${vs.index%2+1}">
	 		<td>${user.username}</td>
	 		<td>${user.age}</td>
	 		</tr>
	 	</c:forEach>
	</table>
	 
	<c:choose>
		<c:when test="${user.age>=18}">大了</c:when>
		<c:otherwise>还小</c:otherwise>
	</c:choose>
	<hr/>
	<c:if test="${user.age>=18}" var="f" scope="session">成年了</c:if> 
	<c:if test="${!f}">未成年</c:if> 
	 
	 
	 
	 
	 
</body>
</html>