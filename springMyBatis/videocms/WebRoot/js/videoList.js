var videoList = {};
$(function(){
	videoList.loadProducts(1);
	videoList.loadCourse();
	videoList.loadLore();
	videoList.searchByCond();
	videoList.updateProduct();
	videoList.uploads("upload_file");
	videoList.uploads("upload_video");
	
});
//video列表
videoList.loadProducts = function(page){
	$.ajax({
		"url":"/videocms/product/list.action",
		"type":"post",
		"data":$(".searchForm").serialize(),
		"dataType":"json",
		"success":function(data){
			//1.生成页码
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount:data.obj.totalPage,
				current:page,
				backFn:function(p){
					//将当前页码赋值给隐藏文本框
					$("#page").val(p);
					videoList.loadProducts(p);
				}
			});
			//2.生成数据
			$("#currData .mytr").remove();
			$.each(data.obj.list,function(index,obj){
				var str = '<tr class="mytr">'+
							'<td class="col_10">'+obj.id+'</td>'+
							'<td class="col_12">'+obj.c.name+'</td>'+
							'<td class="col_20">'+obj.name+'</td>'+
							'<td class="col_12">'+obj.price+'</td>'+
							'<td class="col_12">'+obj.creater+'</td>'+
							'<td class="col_10">'+new Date(obj.createtime).toLocaleDateString().replace(/\//g,".")+'</td>'+
							'<td><span class="edit" data-id='+obj.id+'></span>/<span class="delete" data-id='+obj.id+'></span></td>'+
						  '</tr>';
				$("#currData").append(str);
			});
			videoList.loadOneProd();
			videoList.del(page);
		},
		"error":function(){alert("系统繁忙...");}
	});
};
//根据搜索条件查询
videoList.searchByCond = function(){
	$(".search").click(function(){
		//1.收集查询条件
		//将选择的日期值保存到隐藏文本中
		$("#createTime").val($("#datetime").val());
		//将cond.page的值变为1**
		$("#page").val(1);
		//查询数据
		videoList.loadProducts(1);
	});
	
};
//删除
videoList.del = function(page){
	$(".delete").click(function(){
		var flag = window.confirm("确定删除吗?");
		if(!flag){
			return;
		}
		//发ajax请求
		$.ajax({
			"url":"/videocms/product/del.action",
			"data":{"id":$(this).data("id")},
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
				}
				videoList.loadProducts(page);
			},
			"error":function(){alert("系统繁忙...");}
		});
		
	});
	
};

videoList.loadOneProd = function(){
	$(".edit").click(function(){
		//点击弹出修改表单
		$(".editShade").removeClass("hide").addClass("show");
		//发生请求加载指定product信息
		$.ajax({
			"url":"/videocms/product/loadOneProd.action",
			"data":{"id":$(this).data("id")},
			"dataType":"json",
			"success":function(data){
				var product = data.obj;
				$("#editForm [name='product.id']").val(product.id);
				$("#editForm [name='product.name']").val(product.name);
				$("#editForm [name='product.course_id']").val(product.course_id);
				$("#editForm [name='product.lore_id']").val(product.lore_id);
				$("#editForm [name='product.discription']").val(product.discription);
				$("#editForm [name='product.status']").val(product.status);
				$("#editForm [name='product.price']").val(product.price);
				$("#editForm [name='product.creater']").val(product.creater);
				$("#editForm [name='product.image']").val(product.image);
				$("#editForm [name='product.video']").val(product.video);
			},
			"error":function(){alert("系统繁忙...");}
		});
	});
};
//图片视频的上传
videoList.uploads = function(id){
	$("#"+id).change(function(){
		if(id=="upload_file"){
			$("#img").val(true);
		}else if(id=="upload_video"){
			$("#video").val(true);
		}
		var realFile = this.children[0].files[0];
		if(realFile==null){
			return;
		}
		this.children[1].value = this.children[0].value;
		var file = new FormData();
		file.append("some",realFile);
		videoList.uploadFile(file);
	});
};
//上传方法
videoList.uploadFile = function(file){
	$.ajax({
		"url":"/videocms/product/uploadFile.action",
		"type":"post",
		"data":file,
		"processData":false,
		"contentType":false,
		"dataType":"json",
		"success":function(data){
			var fix = data.fix;
			if(fix=="jpeg" || fix=="jpg"){
				$("#upload_file").children("input:text").val(data.newName+"."+fix);
			}else if(fix=="mp4"){
				$("#upload_video").children("input:text").val(data.newName+"."+fix);
			}
			alert("上传成功");
		},
		"error":function(){alert("系统繁忙...");}
	});
};
//修改产品信息
videoList.updateProduct = function(){
	$(".save").click(function(){
		$.ajax({
			"url":"/videocms/product/updateProd.action",
			"type":"post",
			"data":$("#editForm").serialize(),
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
				}
				videoList.loadProducts(1);
			},
			"error":function(){alert("系统繁忙...");}
		});
		$(".editShade").removeClass("show").addClass("hide");
	});
	
	$(".cancel").click(function(){
		$(".editShade").removeClass("show").addClass("hide");
	});
};
//加载课程课程方向
videoList.loadCourse = function(){
	$.ajax({
		"url":"/videocms/product/loadCourse.action",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var option = '<option value="'+obj.id+'">'+obj.name+'</option>';
				$("#course").append(option);
			});
			//手动触发course的change事件
			$("#course").trigger("change");
		},
		"error":function(){alert("系统繁忙...");}
	
		
	});
};
//加载课程内容
videoList.loadLore = function(){
	$("#course").change(function(){
		$.ajax({
			"url":"/videocms/product/loadLore.action",
			"type":"post",
			"data":{"courseId":$(this).val()},
			"dataType":"json",
			"success":function(data){
				$("#lore").html("");  //清空
				$.each(data,function(index,obj){
					var option = '<option value="'+obj.id+'">'+obj.name+'</option>';
					$("#lore").append(option);
				});
			},
			"error":function(){alert("系统繁忙...");}
		});
	});
};













