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
//video�б�
videoList.loadProducts = function(page){
	$.ajax({
		"url":"/videocms/product/list.action",
		"type":"post",
		"data":$(".searchForm").serialize(),
		"dataType":"json",
		"success":function(data){
			//1.����ҳ��
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount:data.obj.totalPage,
				current:page,
				backFn:function(p){
					//����ǰҳ�븳ֵ�������ı���
					$("#page").val(p);
					videoList.loadProducts(p);
				}
			});
			//2.��������
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
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//��������������ѯ
videoList.searchByCond = function(){
	$(".search").click(function(){
		//1.�ռ���ѯ����
		//��ѡ�������ֵ���浽�����ı���
		$("#createTime").val($("#datetime").val());
		//��cond.page��ֵ��Ϊ1**
		$("#page").val(1);
		//��ѯ����
		videoList.loadProducts(1);
	});
	
};
//ɾ��
videoList.del = function(page){
	$(".delete").click(function(){
		var flag = window.confirm("ȷ��ɾ����?");
		if(!flag){
			return;
		}
		//��ajax����
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
			"error":function(){alert("ϵͳ��æ...");}
		});
		
	});
	
};

videoList.loadOneProd = function(){
	$(".edit").click(function(){
		//��������޸ı�
		$(".editShade").removeClass("hide").addClass("show");
		//�����������ָ��product��Ϣ
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
			"error":function(){alert("ϵͳ��æ...");}
		});
	});
};
//ͼƬ��Ƶ���ϴ�
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
//�ϴ�����
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
			alert("�ϴ��ɹ�");
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//�޸Ĳ�Ʒ��Ϣ
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
			"error":function(){alert("ϵͳ��æ...");}
		});
		$(".editShade").removeClass("show").addClass("hide");
	});
	
	$(".cancel").click(function(){
		$(".editShade").removeClass("show").addClass("hide");
	});
};
//���ؿγ̿γ̷���
videoList.loadCourse = function(){
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
//���ؿγ�����
videoList.loadLore = function(){
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













