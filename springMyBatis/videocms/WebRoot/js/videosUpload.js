var upload = {};
$(function(){
	upload.loadCourse();
	upload.loadLore();
	upload.checkPrice();
	upload.uploads("upload_file");
	upload.uploads("upload_video");
	upload.addProduct();
	
	
	
});

//�������пγ̷���
upload.loadCourse = function(){
	$.ajax({
		"url":"/videocms/product/loadCourse.action",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var option = '<option value="'+obj.id+'">'+obj.name+'</option>';
				$("#course").append(option);
			});
			//�ֶ�����course��change�¼�
			$("#course").trigger("change");
		
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//��select���onchange�¼�
upload.loadLore = function(){
	$("#course").change(function(){
		$.ajax({
		"url":"/videocms/product/loadLore.action",
		"type":"post",
		"data":{"courseId":$(this).val()},
		"dataType":"json",
		"success":function(data){
			$("#lore").html("");  //���
			$.each(data,function(index,obj){
				var option = '<option value="'+obj.id+'">'+obj.name+'</option>';
				$("#lore").append(option);
			});
		
		},
		"error":function(){alert("ϵͳ��æ...");}
		
		});
		
		
	});
	
};

upload.checkPrice = function(){
	
	$("#status").change(function(){
		//switch��ʽ
		switch(this.value){
			case "0" : $("#price").prop("readOnly",true);$("#price").val(0);break;
			case "1" : $("#price").prop("readOnly",false);break;
		}
		
//		if($(this).val()==1){
//			$("#price").removeAttr("readOnly");  //���Ϊfalse
//		}else{
//			$("#price").attr("readOnly","readOnly");
//			$("#price").val(0);
//		}
	});
//	$("#status").trigger("change");
};
//ѡ��ͼƬ֮�������ϴ�
//upload.uploadImg = function(){
//	$("#upload_file").change(function(){
//		//console.log(this.children[0].value);
//		//console.log(this.children[0].files[0]);
//		//��Ҫ�ϴ����ļ�
//		var realFile = this.children[0].files[0];
//		//��file��ֵ��ֵ��text��ֵ�����㿴��
//		this.children[1].value = this.children[0].value;
//		//��װ�ļ�������
//		var file = new FormData();
//		//���ļ�����FormData��
//		file.append("some",realFile);
//		upload.uploadFile(file);
//	});
//};
//�ϴ�ͼƬ����Ƶ��������
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
//�ϴ��ļ�����
upload.uploadFile = function(file){
	$.ajax({
		"url":"/videocms/product/uploadFile.action",
		"type":"post",
		"data":file,
		"processData":false,//����jquery����Ҫ������ת�����ַ���
		"contentType":false,
		"dataType":"json",
		"success":function(data){
			//���µ��ļ�����ʾ��ҳ����
			var fix = data.fix;
			if(fix=="jpeg" || fix=="jpg"){
				$("#upload_file").children("input:text").val(data.newName+"."+fix);
			}else if(fix=="mp4"){
				$("#upload_video").children("input:text").val(data.newName+"."+fix);
			}
			alert("�ϴ��ɹ�...");
		},
		"error":function(){alert("ϵͳ��æ...");},
	});
};
//�ϴ���
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
			"error":function(){alert("ϵͳ��æ...");}
		});
		
	});
};





