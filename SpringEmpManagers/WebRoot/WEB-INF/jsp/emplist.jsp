<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//WDOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<c:set value="${pageContext.request.contextPath}" var='path' scope="page"/>
		<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	</head>
	
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())%>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
						<a style="float:right;" href="logout.do">退出</a>
					</h1>
					
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Operation
							</td>
						</tr> 
						<c:set value="1" var="count"></c:set>
						<c:forEach items="${empList}" var='obj'>
							<tr class="row<c:out value="${(count+1)%2==0?2:1}"/>">
								<td><c:out value="${obj.id}"/></td>
								<td><c:out value="${obj.name}"/></td>
								<td><c:out value="${obj.salary}"/></td>
								<td><c:out value="${obj.age}"/></td>
								<td>
									<a href="del.do?id=<c:out value='${obj.id}'/>">delete</a> /
									<a href="load.do?id=<c:out value="${obj.id}"/>">update</a>
								</td>
							</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
	<script language="javascript">
		window.onload = function(){
			window.setInterval(function(){
				var date = new Date();
				var year = date.getFullYear();
				var month = date.getMonth()+1;
				var day = date.getDate();
				var hour = date.getHours();
				var min = date.getMinutes();
				var second = date.getSeconds();
				if(month<10) month = "0" + month;
				if(day<10) day = "0" + day;
				if(hour<10) hour = "0" + hour;
				if(min<10) min = "0" + min;
				if(second<10) second = "0" + second;
				var dateStr = year+"/"+month+"/"+day+" "+hour+":"+min+":"+second;
				document.querySelector("#rightheader p").innerHTML = dateStr;
				},1000);
		}
	</script>
</html>






