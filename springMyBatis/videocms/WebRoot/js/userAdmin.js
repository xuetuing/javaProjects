var admin = {};
//var num = 1;
$(function(){
	//根据页码查询数据
	admin.loadAdmins(1);
	//给增加的遮罩层添加角色，不用重复查询
	admin.loadAllRoles("add");
	//给修改的遮罩层优先添加角色,不用重复查询
	admin.loadAllRoles("edit");
	//点击新增保存
	admin.addAdmin();
	//修改Admin  
	admin.updateAdmin();
	//删除
	admin.deleteMany();
});

admin.loadAdmins = function(page){
	
	$.ajax({
		"url":"/videocms/admin/list.action",
		"data":{"page":page},
		"datatype":"json",
		"success":function(data){
			//分页显示
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount :totalPage,
				current : page,
				backFn : function(p){
					admin.loadAdmins(p);
				}
			});
			//加载后清空选中状态
			$(".col_5 .checkAll").removeClass("checked");
			//页面序号顺序显示
			var num = (page - 1)*2 + 1;
			//先清空
			$(".mytr").remove();
			
			$.each(data.list,function(index,obj){
				
				var str = '<tr class="mytr">'+
                           '<td class="col_5">'+
                                '<label class="check" data-id="'+obj.id+'"></label>'+
                           '</td>'+
                            '<td class="col_5">'+(num++)+'</td>'+
                            '<td class="col_20">'+obj.username+'</td>'+
                            '<td class="col_20">'+obj.password+'</td>'+
                            '<td class="col_20">'+obj.realname+'</td>';
                            var rname = "";
                            $.each(obj.roles,function(index,obj2){
                            	rname += obj2.name+"&nbsp;";
                            });
                            str += '<td class="col_20">'+rname+'</td>'+
                            '<td><span class="edit" data-id="'+obj.id+'"></span>/' +
                            '<span class="delete" data-id="'+obj.id+'"></span></td>'+
                       		'</tr>';;
				$("#currData").append(str);
			});
			//复选框事件
			//点击复选框切换勾选状态图
		    admin.checkbox();
			//给动态生成的节点添加事件
			//点击编辑事件
			admin.loadAdmin();
			admin.delOneAdmin(page);
			
		},
		"error":function(){alert("系统繁忙");}
	});
};
//给增加按钮弹出事件
admin.addAdmin = function(){
	//点击显示
	$(".add").on("click", function() {
        $(".addShade").removeClass("hide").addClass("show");
        //清空表单内容
		$("#addForm")[0].reset();
    });
	
   //点击保存和关闭
    $(".addShade .save").on("click", function() {
    	//向后台发送页面数据入库
    	$.ajax({
    		"url":"/videocms/admin/addAdmin.action",
    		"type":"post",
    		"data":$("#addForm").serialize(),
    		"dataType":"json",
    		"success":function(data){
    			//重新加载页面数据
    			admin.loadAdmins(1);
    		},
    		"error":function(){alert("系统繁忙...");}
    	});
    	//关闭新增页面
        $(".addShade").removeClass("show").addClass("hide");
    });
	$(".addShade .cancel").on("click", function() {
    	$(".addShade").removeClass("show").addClass("hide");
    });
    
};

//给修改按钮弹出事件
admin.loadAdmin = function(){
	//清空form表单的数据**
	$("#editForm")[0].reset();
	//点击编辑
    $(".mytr .edit").on("click", function() {
    	//后台查询当前节点Admin信息
    	$.ajax({
    		"url":"/videocms/admin/loadAdmin.action",
    		"data":{"id":$(this).attr("data-id")},
    		"dataType":"json",
    		"success":function(data){
    			//将拿到的数据写入表单
    			$("#editForm [name='admin.id']").val(data.id);
    			$("#editForm [name='admin.username']").val(data.username);
    			$("#editForm [name='admin.password']").val(data.password);
    			$("#editForm [name='admin.realname']").val(data.realname);
    			//处理角色数据
    			$.each(data.roles,function(index,obj){
    				$("#editForm li").children("input[value="+obj.id+"]").prop("checked",true);
    			});
    		},
    		"error":function(){alert("系统繁忙...");}
    	});
    	$(".editShade").removeClass("hide").addClass("show");
    });
	
};
//更新数据
admin.updateAdmin = function(){
	//点击保存和关闭
	$(".editShade .save").on("click", function() {
		 $.ajax({
			"url":"/videocms/admin/updateAdmin.action",
    		"data":$("#editForm").serialize(),
    		"type":"post",
    		"dataType":"json",
    		"success":function(data){
			 	//将json字符串转换成json格式
			 	var data = eval('('+data+')');
			 	if(data.code==0){
			 		alert(data.msg);
			 	}
			 	admin.loadAdmins(1);
    		},
			"error":function(){alert("系统繁忙...");}
		 });
        $(".editShade").removeClass("show").addClass("hide");
    });
	$(".editShade .cancel").on("click", function() {
    	$(".editShade").removeClass("show").addClass("hide");
    });
};

//根据是增加还是修改操作将查询到的数据追加到对应节点
admin.loadAllRoles = function(action){
	$.ajax({
		"url":"/videocms/admin/roleList.action",
		"data":{"action":action},
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var str = '<li><input type="checkbox" name="roleIds" value="'+obj.id+'" id="'+action+'Role'+obj.id+'" />' +
						  '<label for="'+action+'Role'+obj.id+'">'+obj.name+'</label></li>';
				//这里面的字符串也可以拼接
				$("#"+action+"Roles").append(str);
			});
		},
		"error":function(){alert("系统繁忙...");}
	});
};

//复选框
admin.checkbox = function(){
	
//	var recordNum = $(".col_5 .check").length;
//	var count = 0;
//	$(".col_5 label").click(function(){
//		var br = $(this).hasClass("checked");
//		if(br){
//			$(this).removeClass("checked");
//		}else{
//			$(this).addClass("checked");
//		}
//		count = getNum().length;
//		if($(this).is(".checkAll")){
//			if(br){
//				$(".mytr .checked").removeClass("checked");
//			}else{
//				$(".mytr .check").addClass("checked");
//			}
//		}else{
//			if(count==recordNum){
//				$(".checkAll").addClass("checked");
//			}else{
//				$(".checkAll").removeClass("checked");
//			}
//		}
//	});
	$(".col_5 .checkAll").unbind().click(function(){
		if($(this).hasClass("checked")){
			$(this).removeClass("checked");
			$(".mytr .checked").removeClass("checked");
		}else{
			$(this).addClass("checked");
			$(".mytr .check").addClass("checked");
		}
	});
	
	$(".mytr .check").click(function(){
		if($(this).hasClass("checked")){
			$(this).removeClass("checked");
		}else{
			$(this).addClass("checked");
		}
		var num = $(".mytr label[class~='checked']").length;
		var count = $(".mytr").length;
		if(num==count){
			$(".checkAll").addClass("checked");
		}else{
			$(".checkAll").removeClass("checked");
		}
	});
};
//当前选中的记录
//function getNum(){
//	var arr = [];
//	var n = 0;
//	$(".col_5 .check").each(function(index,obj){
//		if($(obj).hasClass("checked")){
//			arr[n++] = $(obj).attr("data-id");
//		}
//	});
//	return arr;
//}
	
//批量删除记录
admin.deleteMany = function(){
	$(".deleteMany").click(function(){
		var $label = $(".mytr label[class~='checked']");
		if($label.length==0){
			alert("请至少选择一条记录！");
			return;
		}
		var ids = [];
		$.each($label,function(index,obj){
			//ids.push($(obj).attr("data-id"));
			ids.push($(obj).data("id"));  //html5新特性
		});
		admin.delAdmin(ids,null);
	});
	
};
//删除单个记录
admin.delOneAdmin = function(page){
	$(".mytr .delete").click(function(){
		var ids = [];
		ids.push($(this).data("id"));
		admin.delAdmin(ids,page);
	});
};
//删除记录方法
admin.delAdmin = function(ids,page){
	$.ajax({
		"url":"/videocms/admin/delAdmin.action",
		"data":{"ids":ids},
		//阻止数组深度序列化  默认false
		"traditional":true,
		"dataType":"json",
		"success":function(data){
			//admin.loadAdmins(1);
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
