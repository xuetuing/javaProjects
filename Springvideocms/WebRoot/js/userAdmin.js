//管理员页面
var admin = {};

$(function(){
	admin.loadAdmins(1);
	
	
	
});

admin.loadAdmins = function(page){
	$.ajax({
		url:"/Springvideocms/admin/adminList.do",
		data:{"page":page},
		dataType:"json",
		success:function(data){
			//总页数
			var totalPage = data.totalPage;
			//创建分页
			$(".pagination").createPage({
				pageCount:totalPage,
				current:page,
				backFn:function(p){
					admin.loadAdmins(p);
				}
			});
			//加载后清空选中状态
			$(".col_5 .checkAll").removeClass("checked");
			//清空上一次信息
			$(".myty").remove();
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
		},
		error:function(){alert("系统繁忙");}
		
	});
};

admin.addAdmin = function(){
	
};

admin.updateAdmin = function(){
	
};

admin.loadOneAdmin = function(){
	
};

admin.delOneAdmin = function(){
	
};

admin.checkBox = function(){
	
};

admin.delAdmins = function(){
	
};










