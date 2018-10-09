<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/videosList.css">
	<link rel="stylesheet" type="text/css" href="../datetimepicker/jquery.datetimepicker.css">
</head>
<body>
	<div class="normal">
		<div class="main_title">产品管理</div>
		<div  class="main_body">
			<div class="nav_title autoH color_909090">
				<label>产品管理</label><span class="jiantou"></span><label class="color_0e6fb6">视频查看</label>
			</div>
			<!-- 右侧内容 -->
			<div class="content">
				<form class="searchForm">
					<!-- 选项组 -->
					<div class="options">
						<div>
							<label>课程方向:</label>
							<span><input class="find" type="text" name="cond.courseName" placeholder="请输入信息"></span>
						</div>
						<div>
							<label>课程名称:</label>
							<span><input class="find" type="text" name="cond.productName" placeholder="请输入信息"></span>
						</div>
						<div>
							<label>上传者:</label>
							<span><input class="find" type="text" name="cond.creater" placeholder="请输入信息"></span>
						</div>
						<div>
							<input type="button" class="datetime" id="datetime" value="-请选择-">	
						</div>
						<!-- 用隐藏标签保存选择的日期的值 比如上面的button -->
						<input type="hidden" id="createTime" name="cond.createtime"/>
						<!-- 保存页码的值 -->
						<input type="hidden" id="page" name="cond.page" value="1"/>
						<div class="search">搜索</div>
					</div>
				</form>
				
				<div class="c_main">
					<table cellspacing="0" cellpadding="0" id="currData">
						<tr class="thead">
							<td class="col_10">视频编号</td>
							<td class="col_12">课程方向</td>
							<td class="col_20">课程名称</td>							
							<td class="col_12">课程价格</td>
							<td class="col_12">上传者</td>
							<td class="col_10">上传时间</td>
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
	<!-- 遮罩层 -->
	<div class="editShade hide">
		<div class="shade">	
		</div>
		<div class="shade_main rows">
			<div class="shade_title">修改信息</div>
			<div class="shade_content">
				<form method="post" id="editForm">	
					<div>
						<label>课程ID:</label>
						<span>
							<input readonly="readonly"  type="text" name="product.id">
						</span>
					</div>
					<div>
						<label>课程方向:</label>
						<span>
							<select id="course" class="select" size="1" name="product.course_id">
							</select>
						</span>
					</div>
					<div>
						<label>课程名称:</label>
						<span>
							<input type="text" name="product.name">
						</span>
					</div>
					<div><label>课程内容:</label>
						<span>
							<select id="lore" class="select" size="1" name="product.lore_id">
							</select>
						</span>
					</div>
					<div>
						<label>课程描述:</label>
						<span><input type="text" name="product.discription"></span>
					</div>					
					<div><label>收费方式：</label>
					<span>	
					<select id="status" class="select" size="1" name="product.status">
						<option  value="0">免费</option>
						<option value="1">收费</option>
					</select>
					</span>
					</div>
					<div><label>课程价格：</label>
					<span>	
					<input id="price"  type="text" name="product.price" value="0"/>
					</span>
					</div>
					<div>
					<label>课程图片:</label>
					<span class="upload_file" id="upload_file">
						<input type="file" id="imgFile" name="" accept="image/jpeg">
						<input type="text" id="hidden_txt" name="product.image">
						<input type="hidden" id="img" name="imgFlag" value="false">
					</span>
					</div>
					<div>
					<label>课程视频:</label>
					<span class="upload_file" id="upload_video">
						<input type="file" id="videoFile" name="videoFile" accept="video/mp4">
						<input type="text" name="product.video">
						<input type="hidden" id="video" name="videoFlag" value="false">
					</span>
					</div>
					<div>
						<label>上传者:</label>
						<span>
							<input readonly="readonly"  type="text" name="product.creater">
						</span>
					</div>
				<!-- <div>
						<label>上传时间:</label>
						<span>
							<input readonly="readonly"  type="text" name="">
						</span>
					</div> -->
					<div class="btns">
						<input class="save" type="button" value="保存">
						<input class="cancel" type="button" value="取消">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../datetimepicker/jquery.datetimepicker.js"></script>
<script type="text/javascript" src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/videoList.js"></script>
 <script type="text/javascript">
	$('#datetime').datetimepicker({
		language:  'zh-CN',//语言
		timepicker:false,//不选时间
	  	format:'Y-m-d'//日期格式
	});
	
	//关闭右侧
	$(".main_title").on("click",function(){
		$('#aa', window.parent.document).attr("src","");
	})
 </script>
</html>










