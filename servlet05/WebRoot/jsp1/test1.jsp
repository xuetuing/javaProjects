<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Test1页面</h2>
	<h3>相对路径演示</h3>
	<a href="../test2.jsp">点击，跳转到test2页面</a>
	<h3>绝对路径演示</h3>
	<a href="/servlet05/test2.jsp">点击，跳转到test2页面</a>
	<br/>
	<a href="<%=request.getContextPath()%>/test2.jsp">点击，跳转到test2页面</a>
	
</body>
</html>