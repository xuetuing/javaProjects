<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css">

</head>
<body>
<form action="/xmsproject/login/login.do" method="post">
	<div class="login_box">
		<div class="left col_50">
			<!-- <img src="images/login/logo_2.png">
			<h3>视频点播系统</h3> -->
		</div>
		<div class="right col_50 login_form">
			<div class="row_1 row_350 margin_40" >
				<input type="text" data-name="email" name="email" placeholder="请输入用户名" autocomplete="off">
				<label>${UsernameException}</label>
			</div>
			<div class="row_1 row_350">
				<input type="password" data-name="password" name="password" placeholder="请输入密码">
				<label>${PasswordException}</label>
			</div>
			
			<div class="row_1">
				<input type="checkbox" name=""> 记住密码
				<a href="#" class="color_999 a_right">忘记密码</a>
			</div>
			<div class="row_1">
				<input type="submit" value="登录" />
			</div>
			<div class="row_1">
				<a href="register.html" class="color_blue a_right">立即注册</a>
			</div>

		</div>
	</div>
</form>
</body>
</html>