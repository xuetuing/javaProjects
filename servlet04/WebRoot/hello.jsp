<%@page pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<html>
	<head>
		<title>第一个JSP页面</title>
	</head>
	<body>
		<%=new Date() %>
		<br/>
		<%
			Date d = new Date();
			out.print(d);
		 %>
		<%
			for(int i=0;i<100;i++){
				out.print("hello JSP<br/>");
			}
		%>
		<h2>Hello JSP</h2>
	</body>
</html>