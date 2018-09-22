var role = {};
$(function(){
	//页面加载
	role.loadRoles(1);
	//加载权限
	role.loadPrivileges("add");
	role.loadPrivileges("edit");
	//添加角色
	role.addRole();
	//修改信息
	role.updateRole();
	//批量删除
	role.delSomeRole();
	
});
//加载角色列表
role.loadRoles = function(page){
	$.ajax({
		"url":"/videocms/roleManage/list.action",
		"data":{"page":page},
		"dataType":"json",
		"success":function(data){
			//分页
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount : totalPage,
				current : page,
				backFn : function(p){
					role.loadRoles(p);
				}
			});
			//拼表格
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
			//edit接点上的事件
			role.loadOneRole();
			//delete节点上的事件
			role.delRoleById();
			//复选框上的事件
			role.checkedBox();
		},
		"error":function(){alert("系统繁忙...");}
	});
};
//弹出框加载所有权限
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
		"error":function(){alert("系统繁忙...");}
	});
};
//修改框的回显
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
				//给权限赋值
				$.each(role.privs,function(index,obj2){
					$("#editRole li").children("input [value='"+obj2.id+"']").prop("checked",true);
				});
			},
			"error":function(){alert("系统繁忙...");}
		});
	});
	
};
//增加角色
role.addRole = function(){
	//点击add节点显示addForm
	$(".o_btns .add").click(function(){
		$(".addShade").removeClass("hide").addClass("show");
	});
	//每次添加前先清空表单
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
			"error":function(){alert("系统繁忙...");}
		});
		$(".addShade").removeClass("show").addClass("hide");
	});
};
//修改信息
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
			"error":function(){alert("系统繁忙...");}
		});
		$(".editShade").removeClass("show").addClass("hide");
	});
	$(".cancel").click(function(){
		$(".editShade").removeClass("show").addClass("hide");
	});
};
//删除信息方法
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
		"error":function(){alert("系统繁忙...");}
	});
};
//通过id删除单条记录
role.delRoleById = function(page){
	$(".delete").click(function(){
		var ids = [];
		ids.put($(".delete").data("id"));
		role.delRole(ids,page);
	});
};
//检查复选框
role.checkedBox = function(){
	//全选框上的事件
	$(".mytr .checkAll").unbind().click(function(){
		if($(this).hasClass("checked")){
			$(this).removeClass("checked");
			$(".mytr .check").removeClass("checked");
		}else{
			$(this).addClass("checked");
			$(".mytr .check").addClass("checked");
		}
		
	});
	//单选框上的事件
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

//批量删除信息
role.delSomeRole = function(){
	$(".deleteMany").click(function(){
		var $checkeds = $(".mytr label[class~='checked']");
		if($checkeds.length==0){
			alert("请至少选择一条记录");
			return;
		}
		//得到所有选中的id
		var ids = [];
		$.each($checkeds,function(index,obj){
				ids.put($(this).data("id"));
		});
		role.delRole(ids,null);	
	});
};
	































