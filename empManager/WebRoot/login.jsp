<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%=new SimpleDateFormat("yyyy/MM/dd").format(new Date())%>
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
						login
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
						</table>
						<div style="font-size:15px;">
							<label class="fl w_20">验证码：</label>
							<span class="fr w_80 verify"><input type="text" class="text_txt code" name="userCode">
							<img id="num" src="checkCode" align="top"/>
							<a href="javascript:;" onclick="document.getElementById('num').src = 'checkCode?'+(new Date()).getTime()">
							换一张</a>			
							</span>
							<%
								String code_msg = (String)request.getAttribute("code_msg");
							 %>
							<p style="color:red"><%=code_msg==null?"":code_msg%></p>
						</div>
						<p>
							<%
								String login_msg = (String)request.getAttribute("login_msg");
							 %>
							<input type="submit" class="button" value="Submit &raquo;" />
							<span style="color:red;">&nbsp;&nbsp;<%=login_msg==null?"":login_msg%></span>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
