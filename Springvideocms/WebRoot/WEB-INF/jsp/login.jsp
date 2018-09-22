<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Document</title>
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
	<link rel="stylesheet" type="text/css" href="${path}/css/login.css">
	<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/login.js"></script>
</head>
<body class="login_body">
	<div class="loginBox">
		<img class="login_logo" src="${path}/images/login_logo.png">
		<div class="loginForm">
			<form method="post" action="/Springvideocms/login/login.do" onsubmit="return check()">
				<div>
					<label class="fl w_20">昵称：</label>
					<span class="fr w_80"><input type="text" class="text_txt" name="username"></span>
				</div>
				<div>
					<label class="fl w_20">密码：</label>
					<span class="fr w_80"><input type="password" class="text_txt" name="password"></span>
					
					<span class="msg"  style="color:red">
						
					</span>
					
				</div>
				<div>
					<label class="fl w_20">验证码：</label>
					<span class="fr w_80 verify"><input type="text" class="text_txt code" name="userCode">
					<!-- 此处src的值可以是getCodeImg/getCodeimg.action -->
					<img id="num" src="getCodeImg.do"/>
					<a href="javascript:;" 
					onclick="document.getElementById('num').src='getCodeImg.do?'+(new Date()).getTime()">
					换一张</a>			
					</span>
					
					<span class="msg"  style="" id="codeMsg">
						
					</span>
				</div>
				<div>
					<label class="fl w_20"></label>
					<div class="fr w_80">
						<span class="fl"><input type="checkbox" name="auto" value="0"> 下次自动登录</span>
						<a class="fr forget" href="#">忘记密码</a>
					</div>
				</div>
				<div>
					<span class="fr w_80">
						<input type="submit" style="height: 50px;" value="登录">
					</span>
				</div>
			</form>
		</div>
	</div>

</body>
</html>