var upload = {};
$(function(){
	upload.loadCourse();
	upload.loadLore();
	upload.checkPrice();
	upload.uploads("upload_file");
	upload.uploads("upload_video");
	upload.addProduct();
	
	
	
});

//加载所有课程方向
upload.loadCourse = function(){
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
//给select添加onchange事件
upload.loadLore = function(){
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

upload.checkPrice = function(){
	
	$("#status").change(function(){
		//switch方式
		switch(this.value){
			case "0" : $("#price").prop("readOnly",true);$("#price").val(0);break;
			case "1" : $("#price").prop("readOnly",false);break;
		}
		
//		if($(this).val()==1){
//			$("#price").removeAttr("readOnly");  //或改为false
//		}else{
//			$("#price").attr("readOnly","readOnly");
//			$("#price").val(0);
//		}
	});
//	$("#status").trigger("change");
};
//选择图片之后立即上传
//upload.uploadImg = function(){
//	$("#upload_file").change(function(){
//		//console.log(this.children[0].value);
//		//console.log(this.children[0].files[0]);
//		//需要上传的文件
//		var realFile = this.children[0].files[0];
//		//将file的值赋值个text的值，方便看到
//		this.children[1].value = this.children[0].value;
//		//封装文件的容器
//		var file = new FormData();
//		//将文件放入FormData中
//		file.append("some",realFile);
//		upload.uploadFile(file);
//	});
//};
//上传图片和视频到服务器
upload.uploads = function(id){
	$("#"+id).change(function(){
		var realFile = this.children[0].files[0];
		if(realFile==null){
			return;
		}
		this.children[1].value = this.children[0].value;
		var file = new FormData();
		file.append("some",realFile);
		upload.uploadFile(file);
	});
};
//上传文件方法
upload.uploadFile = function(file){
	$.ajax({
		"url":"/videocms/product/uploadFile.action",
		"type":"post",
		"data":file,
		"processData":false,//告诉jquery不需要将参数转换成字符串
		"contentType":false,
		"dataType":"json",
		"success":function(data){
			//将新的文件名显示在页面上
			var fix = data.fix;
			if(fix=="jpeg" || fix=="jpg"){
				$("#upload_file").children("input:text").val(data.newName+"."+fix);
			}else if(fix=="mp4"){
				$("#upload_video").children("input:text").val(data.newName+"."+fix);
			}
			alert("上传成功...");
		},
		"error":function(){alert("系统繁忙...");},
	});
};
//上传表单
upload.addProduct = function(){
	$(".btn_blue").click(function(){
		$.ajax({
			"url":"/videocms/product/addProduct.action",
			"type":"post",
			"data":$("#formData").serialize(),
			//"traditional":true,
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
					$("#formData")[0].reset();
					$("#status").trigger("change");
				}
			},
			"error":function(){alert("系统繁忙...");}
		});
		
	});
};





