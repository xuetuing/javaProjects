<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/videosUpload.css">
</head>
<body>
	<div class="main_title">产品管理</div>
	<div  class="main_body">
		<div class="nav_title autoH color_909090">
			<label>产品管理</label><span class="jiantou"></span><label class="color_0e6fb6">视频上传</label>
		</div>
		<!-- <div class="main video-upload color_666 rows">	 -->
		<div class="main video-upload rows">
			<form id="formData">
				<div><label>课程名称：</label><span><input type="text" name="product.name"></span></div>
				<div><label>课程方向：</label>
					<span>
					<select id="course" class="select" size="1" name="product.course_id">
					</select>
					</span>
				</div>
				<div><label>课程内容：</label>
					<span>
					<select id="lore" class="select" size="1" name="product.lore_id">
					</select>
					</span>
				</div>
				<div><label>课程描述：</label><span><input type="text" name="product.discription"></span></div>
				<div><label>收费方式：</label>
					<span>	
					<select id="status" class="select" size="1" name="product.status">
						<option value="0">免费</option>
						<option value="1">收费</option>
					</select>
					</span>
				</div>
				<div><label>课程价格：</label>
					<span>	
					<input id="price" readonly="readonly" type="text" name="product.price" value="0"/>
					</span>
				</div>
				<div>
					<label>课程图片：</label>
					<span class="upload_file" id="upload_file">
						<input type="file"  name="" accept="image/jpeg">
						<input type="text"  name="product.image">
					</span>
				</div>
				<div>
					<label>课程视频：</label>
					<span class="upload_file" id="upload_video">
						<input type="file" name="" accept="video/mp4">
						<input type="text" name="product.video">
					</span>					
				</div>
				<div>
					<input class="btn_blue" type="button" value="上传">
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/videosUpload.js"></script>
	<script type="text/javascript">
		
		$(".main_title").on("click",function(){
			$('#aa', window.parent.document).attr("src","");
		})
	</script>

</body>
</html>