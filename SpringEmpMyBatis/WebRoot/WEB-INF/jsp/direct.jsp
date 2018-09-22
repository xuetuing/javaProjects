<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color:red">请先登录！</h2>
	<div>
		<label>正在跳转到登录页面...</label>
		<span id="dd"></span>
	</div>
	
</body>
<script type="text/javascript">
	var t = 5;
	function showTime(){
		t -= 1;
		document.getElementById("dd").innerHTML = t;
		if(t==0){
			location.href = "/SpringEmpManagers/login/toLogin.do";
		}
		setTimeout("showTime()",1000);
	}
	showTime();
</script>
</html>