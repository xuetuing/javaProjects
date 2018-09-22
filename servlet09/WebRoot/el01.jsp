<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u1 = new User();
		u1.setUsername("jack");
		u1.setAge(10);
		u1.setArgs(new String[]{"java","web"});
		request.setAttribute("u1",u1);
		User u2 = new User();
		u2.setUsername("rose");
		u2.setAge(12);
		session.setAttribute("u1",u2);
	 %>
	 <%
	 	User user = (User)request.getAttribute("u1");
	 	out.print(user.getUsername());
	  %>
	 <br/>
	 ${u1.username}<br/>
	 ${u1.username}<br/>
	 
	 ${sessionScope.u1.username}<br/>
	 ${u1.args}<br/>${u1['args']}<br/>
	 ${u1.args[0]}<br/>
	 <%
	 	request.setAttribute("paraname","age");
	  %>
	 ${u1[paraname]}<br/>	${u1['age']}<br/>
	 ${param.name}<br/>	
	 
	 ${paramValues.city[0]}<br/>	 
</body>
</html>
















