var role = {};
$(function(){
	//ҳ�����
	role.loadRoles(1);
	//����Ȩ��
	role.loadPrivileges("add");
	role.loadPrivileges("edit");
	//��ӽ�ɫ
	role.addRole();
	//�޸���Ϣ
	role.updateRole();
	//����ɾ��
	role.delSomeRole();
	
});
//���ؽ�ɫ�б�
role.loadRoles = function(page){
	$.ajax({
		"url":"/videocms/roleManage/list.action",
		"data":{"page":page},
		"dataType":"json",
		"success":function(data){
			//��ҳ
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount : totalPage,
				current : page,
				backFn : function(p){
					role.loadRoles(p);
				}
			});
			//ƴ���
			$(".mytr").remove();
			$.each(data.list,function(index,obj){
				var str = '<tr class="mytr">'+
							'<td class="col_5">'+
								'<label class="check" data-id="'+obj.id+'"></label>'+
							'</td>'+
							'<td class="col_10">'+obj.id+'</td>'+						
							'<td class="col_20">'+obj.name+'</td>';
							var priv = "";
							$.each(obj.privs,function(index,obj2){
								priv += obj2.name+'&nbsp;';
							});
					 str += '<td class="col_20">'+priv+'</td>'+
							'<td><span class="edit" data-id="'+obj.id+'"></span>/' +
							'<span class="delete" data-id="'+obj.id+'"></span></td>'+
						  '</tr>';
				$("#roleData").append(str);
			});
			//edit�ӵ��ϵ��¼�
			role.loadOneRole();
			//delete�ڵ��ϵ��¼�
			role.delRoleById();
			//��ѡ���ϵ��¼�
			role.checkedBox();
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//�������������Ȩ��
role.loadPrivileges = function(action){
	$.ajax({
		"url":"/videocms/roleManage/privList.action",
		"data":{"action":action},
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var str = '<li><input type="checkbox" name="privIds" value="'+obj.id+'" id="'+action+"Role"+obj.id+'"/>' +
						  '<label for="'+action+"Role"+obj.id+'">'+obj.name+'</label></li>';
				$("#"+action+"Role").append(str);
			});
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//�޸Ŀ�Ļ���
role.loadOneRole = function(){
	$(".mytr .edit").click(function(){
		$(".editShade").removeClass("hide").addClass("show");
		$.ajax({
			"url":"/videocms/roleManage/loadOneRole.action",
			"data":{"id":$(".edit").data("id")},
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
				}
				var role = data.obj;
				$("#editForm [name='role.id']").val(role.id);
				$("#editForm [name='role.name']").val(role.name);
				//��Ȩ�޸�ֵ
				$.each(role.privs,function(index,obj2){
					$("#editRole li").children("input [value='"+obj2.id+"']").prop("checked",true);
				});
			},
			"error":function(){alert("ϵͳ��æ...");}
		});
	});
	
};
//���ӽ�ɫ
role.addRole = function(){
	//���add�ڵ���ʾaddForm
	$(".o_btns .add").click(function(){
		$(".addShade").removeClass("hide").addClass("show");
	});
	//ÿ�����ǰ����ձ�
	$("#addForm")[0].reset();
	$(".addShade .save").click(function(){
		$.ajax({
			"url":"/videocms/roleManage/addRole.action",
			"type":"post",
			"data":$("#addForm").serialize(),
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
				}
			},
			"error":function(){alert("ϵͳ��æ...");}
		});
		$(".addShade").removeClass("show").addClass("hide");
	});
};
//�޸���Ϣ
role.updateRole = function(){
	$(".editShade .save").click(function(){
		$.ajax({
			"url":"/videocms/roleManage/updateRole.action",
			"type":"post",
			"data":$("#editForm").serialize(),
			"dataType":"json",
			"success":function(data){
				if(data.code=="000"){
					alert(data.msg);
				}
			},
			"error":function(){alert("ϵͳ��æ...");}
		});
		$(".editShade").removeClass("show").addClass("hide");
	});
	$(".cancel").click(function(){
		$(".editShade").removeClass("show").addClass("hide");
	});
};
//ɾ����Ϣ����
role.delRole = function(ids,page){
	$.ajax({
		"url":"/videocms/roleManage/delRole.action",
		"data":{"ids":ids},
		"dataType":"json",
		"success":function(data){
			if(data.code=='000'){
				alert(data.msg);
			}
			if(page==null){
				admin.loadAdmins(1);
			}else{
				admin.loadAdmins(page);
			}
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};
//ͨ��idɾ��������¼
role.delRoleById = function(page){
	$(".delete").click(function(){
		var ids = [];
		ids.put($(".delete").data("id"));
		role.delRole(ids,page);
	});
};
//��鸴ѡ��
role.checkedBox = function(){
	//ȫѡ���ϵ��¼�
	$(".mytr .checkAll").unbind().click(function(){
		if($(this).hasClass("checked")){
			$(this).removeClass("checked");
			$(".mytr .check").removeClass("checked");
		}else{
			$(this).addClass("checked");
			$(".mytr .check").addClass("checked");
		}
		
	});
	//��ѡ���ϵ��¼�
	$(".mytr .checkAll").click(function(){
		if($(this).hasClass("checked")){
			$(this).removeClass("checked");
		}else{
			$(this).addClass("checked");
		}
		var num = $(".mytr label[class~='checked']").length;
		var count = $(".mytr").length;
		if(num==count){
			$(".mytr .checkAll").addClass("checked");
		}else if(num<count){
			$(".mytr .checkAll").removeClass("checked");
		}
	});
};

//����ɾ����Ϣ
role.delSomeRole = function(){
	$(".deleteMany").click(function(){
		var $checkeds = $(".mytr label[class~='checked']");
		if($checkeds.length==0){
			alert("������ѡ��һ����¼");
			return;
		}
		//�õ�����ѡ�е�id
		var ids = [];
		$.each($checkeds,function(index,obj){
				ids.put($(this).data("id"));
		});
		role.delRole(ids,null);	
	});
};
	































