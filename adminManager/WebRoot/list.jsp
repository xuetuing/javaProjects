<%@page pageEncoding="utf-8"%>
<%@page import="dao.AdminDAO"%>
<%@page import="factory.DAOFactory"%>
<%@page import="java.util.List"%>
<%@page import="entity.Admin"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="./css/userAdmin.css">
	<script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
	<style type="text/css">
		.current{
			background-color:yellow;
		}
	</style>
</head>
<body>
	<div class="normal">
		<div class="main_title">用户管理</div>
		<div  class="main_body">
			<div class="nav_title autoH color_909090">
				<label>用户管理</label><span class="jiantou"></span><label class="color_0e6fb6">管理员</label>
				<span class="jiantou"></span>
				<a href="logout.do">退出</a>
			</div>
			<!-- 右侧内容 -->
			<div class="content">
				<!-- 选项组 -->
				<div class="options">
					<div class="o_btns">
						<input class="add" value="增加" onclick="location.href='add.html'" />
					</div>
				</div>
				<div class="c_main">
					<table cellspacing="0" cellpadding="0">
						<tr class="thead">
							<td class="col_10">序号</td>
							<td class="col_20">用户名</td>
							<td class="col_20">密码</td>
							<td class="col_20">姓名</td>
							<td class="col_5">操作</td>
						</tr>
						<%--
							//AdminDAO dao = (AdminDAO)DAOFactory.getInstance("AdminDAO");
							//List<Admin> list = dao.findAll();
							//从request中取数据
							List<Admin> list = (List<Admin>)request.getAttribute("list");
							for(Admin admin : list){
							--%>
						<c:forEach items="${list}" var="admin">
							<tr>
							<td class="col_10">${admin.id}</td>
							<td class="col_20">${admin.username}</td>
							<td class="col_20">${admin.password}</td>
							<td class="col_20">${admin.realname}</td>
							<td class="col_5"><a class="edit" href="load.do?id=${admin.id}"></a>/
							<a href="del.do?id=${admin.id}" class="delete"></a></td>
							</tr>		
						</c:forEach>
						
					</table>
					<!-- 分页 -->
					<div class="Page navigation">
					  <ul class="pagination">
					    <li><a href="list.do?page=${page-1==0?page:page-1}">上一页</a></li>
					    <c:forEach begin="1" end="${totalPages}" var="p">
					   		<c:if test="${page==p}">
					    	<li><a class="current" href="list.do?page=${p}">${p}</a></li>
					    	</c:if>
					    	<c:if test="${page!=p}">
					    	<li><a href="list.do?page=${p}">${p}</a></li>
					    	</c:if>
					    </c:forEach>
					    <li><a href="list.do?page=${page+1>totalPages?totalPages:page+1}">下一页</a></li>
					  </ul>
					</div>
				</div>
			</div>
		</div>	
	</div>
	<script type="text/javascript">
		//设置当前class
		fuction selectPage(this){
			var p = $("current_page");
			if("上一页"==this.innerHTML){
				var page = parseInt(p.html())-1;
				this.href = "list.do?page='+page+'";
				if(page==0){
					return;
				}else{
					p.parent().prev().child().className = "current_page";
					p.className = "";
				}
			}
			if("下一页"==this.innerHTML){
				var page = parseInt(p.html())+1;
				this.href = "list.do?page='+page+'";
				if(page>5){
				
				}
				p.parent().next().child().className = "current_page";
				p.className = "";
			}
			
		}
		//去除其他class
		//设置href
	</script>
</body>
</html>










