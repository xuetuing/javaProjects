<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title></title>
		<style></style>
	<head>
		<script>
		var div = document.getElementById("rightheader");
		function showTime(){
			console.log(div.fistChild);
			div.firstChild.innerHTML = "<%=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())%>";
		}
		setInterval(showTime,1000);
		</script>
	<body>
		<div id="rightheader">
			<p></p>
		</div>
	</body>

</html>