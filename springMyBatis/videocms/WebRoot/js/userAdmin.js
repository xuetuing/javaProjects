var admin = {};
//var num = 1;
$(function(){
	//����ҳ���ѯ����
	admin.loadAdmins(1);
	//�����ӵ����ֲ���ӽ�ɫ�������ظ���ѯ
	admin.loadAllRoles("add");
	//���޸ĵ����ֲ�������ӽ�ɫ,�����ظ���ѯ
	admin.loadAllRoles("edit");
	//�����������
	admin.addAdmin();
	//�޸�Admin  
	admin.updateAdmin();
	//ɾ��
	admin.deleteMany();
});

admin.loadAdmins = function(page){
	
	$.ajax({
		"url":"/videocms/admin/list.action",
		"data":{"page":page},
		"datatype":"json",
		"success":function(data){
			//��ҳ��ʾ
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount :totalPage,
				current : page,
				backFn : function(p){
					admin.loadAdmins(p);
				}
			});
			//���غ����ѡ��״̬
			$(".col_5 .checkAll").removeClass("checked");
			//ҳ�����˳����ʾ
			var num = (page - 1)*2 + 1;
			//�����
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
			//��ѡ���¼�
			//�����ѡ���л���ѡ״̬ͼ
		    admin.checkbox();
			//����̬���ɵĽڵ�����¼�
			//����༭�¼�
			admin.loadAdmin();
			admin.delOneAdmin(page);
			
		},
		"error":function(){alert("ϵͳ��æ");}
	});
};
//�����Ӱ�ť�����¼�
admin.addAdmin = function(){
	//�����ʾ
	$(".add").on("click", function() {
        $(".addShade").removeClass("hide").addClass("show");
        //��ձ�����
		$("#addForm")[0].reset();
    });
	
   //�������͹ر�
    $(".addShade .save").on("click", function() {
    	//���̨����ҳ���������
    	$.ajax({
    		"url":"/videocms/admin/addAdmin.action",
    		"type":"post",
    		"data":$("#addForm").serialize(),
    		"dataType":"json",
    		"success":function(data){
    			//���¼���ҳ������
    			admin.loadAdmins(1);
    		},
    		"error":function(){alert("ϵͳ��æ...");}
    	});
    	//�ر�����ҳ��
        $(".addShade").removeClass("show").addClass("hide");
    });
	$(".addShade .cancel").on("click", function() {
    	$(".addShade").removeClass("show").addClass("hide");
    });
    
};

//���޸İ�ť�����¼�
admin.loadAdmin = function(){
	//���form��������**
	$("#editForm")[0].reset();
	//����༭
    $(".mytr .edit").on("click", function() {
    	//��̨��ѯ��ǰ�ڵ�Admin��Ϣ
    	$.ajax({
    		"url":"/videocms/admin/loadAdmin.action",
    		"data":{"id":$(this).attr("data-id")},
    		"dataType":"json",
    		"success":function(data){
    			//���õ�������д���
    			$("#editForm [name='admin.id']").val(data.id);
    			$("#editForm [name='admin.username']").val(data.username);
    			$("#editForm [name='admin.password']").val(data.password);
    			$("#editForm [name='admin.realname']").val(data.realname);
    			//�����ɫ����
    			$.each(data.roles,function(index,obj){
    				$("#editForm li").children("input[value="+obj.id+"]").prop("checked",true);
    			});
    		},
    		"error":function(){alert("ϵͳ��æ...");}
    	});
    	$(".editShade").removeClass("hide").addClass("show");
    });
	
};
//��������
admin.updateAdmin = function(){
	//�������͹ر�
	$(".editShade .save").on("click", function() {
		 $.ajax({
			"url":"/videocms/admin/updateAdmin.action",
    		"data":$("#editForm").serialize(),
    		"type":"post",
    		"dataType":"json",
    		"success":function(data){
			 	//��json�ַ���ת����json��ʽ
			 	var data = eval('('+data+')');
			 	if(data.code==0){
			 		alert(data.msg);
			 	}
			 	admin.loadAdmins(1);
    		},
			"error":function(){alert("ϵͳ��æ...");}
		 });
        $(".editShade").removeClass("show").addClass("hide");
    });
	$(".editShade .cancel").on("click", function() {
    	$(".editShade").removeClass("show").addClass("hide");
    });
};

//���������ӻ����޸Ĳ�������ѯ��������׷�ӵ���Ӧ�ڵ�
admin.loadAllRoles = function(action){
	$.ajax({
		"url":"/videocms/admin/roleList.action",
		"data":{"action":action},
		"dataType":"json",
		"success":function(data){
			$.each(data,function(index,obj){
				var str = '<li><input type="checkbox" name="roleIds" value="'+obj.id+'" id="'+action+'Role'+obj.id+'" />' +
						  '<label for="'+action+'Role'+obj.id+'">'+obj.name+'</label></li>';
				//��������ַ���Ҳ����ƴ��
				$("#"+action+"Roles").append(str);
			});
		},
		"error":function(){alert("ϵͳ��æ...");}
	});
};

//��ѡ��
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
//��ǰѡ�еļ�¼
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
	
//����ɾ����¼
admin.deleteMany = function(){
	$(".deleteMany").click(function(){
		var $label = $(".mytr label[class~='checked']");
		if($label.length==0){
			alert("������ѡ��һ����¼��");
			return;
		}
		var ids = [];
		$.each($label,function(index,obj){
			//ids.push($(obj).attr("data-id"));
			ids.push($(obj).data("id"));  //html5������
		});
		admin.delAdmin(ids,null);
	});
	
};
//ɾ��������¼
admin.delOneAdmin = function(page){
	$(".mytr .delete").click(function(){
		var ids = [];
		ids.push($(this).data("id"));
		admin.delAdmin(ids,page);
	});
};
//ɾ����¼����
admin.delAdmin = function(ids,page){
	$.ajax({
		"url":"/videocms/admin/delAdmin.action",
		"data":{"ids":ids},
		//��ֹ����������л�  Ĭ��false
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
		"error":function(){alert("ϵͳ��æ...");}
	});
};
