<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" session="true" errorPage="error.jsp"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date d = new Date();
		out.print(d);
	
	 %>
	<%
		request.setAttribute("username","jack");
		pageContext.setAttribute("password","1234");
	 %>
	 <%=request.getAttribute("username") %>&nbsp;
	 <%=pageContext.getAttribute("password") %>
	 <br/>
	 <a href="jsp2.jsp">CLICK ME</a>
	 
	<hr/>
	<%=config.getInitParameter("city") %>
	<!-- 错误处理 -->
	<%--Integer.parseInt("abc");--%><hr/>
	<%session.getAttribute("user");%>
	<hr/>
	<%!
		int num = 10;
		int sum(int a,int b){
			return a + b;
		}
	 %>
	 <%=num %><br/>
	 <%=sum(3,4)%><br/>
</body>
</html>