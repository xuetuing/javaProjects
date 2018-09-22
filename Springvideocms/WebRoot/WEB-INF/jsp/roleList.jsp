<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/userAdmin.css">
</head>
<body>
	<div class="normal">
		<div class="main_title">用户管理</div>
		<div  class="main_body">
			<div class="nav_title autoH color_909090">
				<label>用户管理</label><span class="jiantou"></span><label class="color_0e6fb6">角色管理</label>
			</div>
			<!-- 右侧内容 -->
			<div class="content">
				<!-- 选项组 -->
				<div class="options">
					<div class="o_btns">
						<input class="deleteMany" value="批量删除"/>
						<input class="add" value="增加"/>
					</div>
				</div>
				<div class="c_main">
					<table cellspacing="0" cellpadding="0" id="roleData">
						<tr class="thead">
							<td class="col_5">
								<label  class="checkAll"></label>
							</td>
							<td class="col_10">序号</td>
							<td class="col_20">角色名称</td>
							<td class="col_20">权限</td>
							<td>操作</td>
						</tr>
						
					</table>
					<!-- 分页 -->
					<div class="Page navigation">
                        <div class="pagination">
                        </div>
                    </div>
				</div>
			</div>
		</div>	
	</div>
	<!-- 修改的遮罩层 -->
	<div class="editShade hide">
		<div class="shade">	
		</div>
		<div class="shade_main rows">
			<div class="shade_title">修改信息</div>
			<div class="shade_content">
				<form method="post" id="editForm">	
					<div>
						<label>ID:</label>
						<span>
							<input type="text" name="role.id">
						</span>
					</div>
					<div>
						<label>角色名称:</label>
						<span>
							<input type="text" name="role.name">
						</span>
					</div>
					<div class="checkboxs">
						<label>权限:</label>
						<ul id="editRole">
						</ul>
					</div>
					<div class="btns">
						<input class="save" type="button" value="保存">
						<input class="cancel" type="button" value="取消">
					</div>
				</form>
			</div>
		</div>		
	</div>
	<!-- 增加的遮罩层 -->
	<div class="addShade hide">
		<div class="shade">	
		</div>
		<div class="shade_main rows">
			<div class="shade_title">增加人员</div>
			<div class="shade_content">
				<form method="post" id="addForm">
					<div>
						<label>角色名称:</label>
						<span>
							<input type="text" name="role.name">
						</span>
					</div>
					<div class="checkboxs">
						<label>权限:</label>
						<ul id="addRole">
						</ul>
					</div>
					<div class="btns">
						<input class="save" type="submit" value="保存">
						<input class="cancel" type="submit" value="取消">
					</div>
				</form>
			</div>
		</div>		
	</div>

</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/roleList.js"></script>
 <script type="text/javascript">
	//关闭右侧
	$(".main_title").on("click",function(){
		$('#aa', window.parent.document).attr("src","");
	})
 </script>
</html>










