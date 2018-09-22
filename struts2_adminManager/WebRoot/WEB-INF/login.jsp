<%@page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/login.css">
	<script type="text/javascript" src="/struts2_adminManager/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		var codeFlag = false;
		$(function(){
			$(".code").blur(function(){
				//检查验证码是否为空
				if(!this.value.trim()){
					$("#codeMsg").html("请输入验证码");
					return;
				}
				$.ajax({
					"url":"checkUserCode.action",
					"type":"post",
					"data":{"userCode":this.value},
					"datatype":"json",
					"success":function(data){
						if(!data){
							codeFlag = false;
							$("#codeMsg").html("验证码错误");
						}else{
							codeFlag = true;
							$("#codeMsg").html("验证码正确");
						}
					},
					"error":function(){alert("服务器繁忙");}
				});
				
			});
		
		});
		function check(){
			return codeFlag;
		}
	</script>
</head>
<body class="login_body">
	<div class="loginBox">
		<img class="login_logo" src="../images/login_logo.png">
		<div class="loginForm">
			<form method="post" action="login.action" onsubmit="return check();">
				<div>
					<label class="fl w_20">昵称：</label>
					<span class="fr w_80"><input type="text" class="text_txt" name="username"></span>
				</div>
				<div>
					<label class="fl w_20">密码：</label>
					<span class="fr w_80"><input type="password" class="text_txt" name="password"></span>
				
					<span class="msg"  style="color:red">
						<c:choose>
							<c:when test="${msg==null}"></c:when>
							<c:otherwise>${msg}</c:otherwise>
						</c:choose>
					</span>
					
				</div>
				<div>
					<label class="fl w_20">验证码：</label>
					<span class="fr w_80 verify"><input type="text" class="text_txt code" name="userCode"> 
					<img id="num" src="checkCode" />
					<a href="javascript:;" 
					onclick="document.getElementById('num').src = 'checkCode?t='+(new Date()).getTime()">
					换一张</a>			
					</span>
					
					<span class="msg"  style="color:red" id="codeMsg">
						
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