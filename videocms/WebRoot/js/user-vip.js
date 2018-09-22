///向后台发送ajax请求，获取当前页面的数据，更新页面
$(function(){
	//3.调用方法
	user.loadUsers(1);
	user.searchByPage();
});
//1.定义对象
var user = {};
//2.定义方法
user.loadUsers = function(page){
	$.ajax({
		"url":"/videocms/user/list.action",
		"data":{"page":page},
		"dataType":"json",
		"success":function(data){
			//取得总页数
			//console.log(data.totalPage);
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount : totalPage,
				current : page,
				backFn : function(p){
					user.loadUsers(p);
				}
			});
			//清空上一页数据
			$(".mytr").remove();
			//遍历data.list
			$.each(data.list,function(index,obj){
				var str = '<tr class="mytr">'+
                    '<td class="col_15">'+obj.id+'</td>'+
                    '<td class="col_25">'+obj.username+'</td>'+
                    '<td class="col_25">'+obj.email+'</td>'+
                    '<td class="col_20">'+new Date(obj.registdate).toLocaleDateString().replace(/\//g,".")+'</td>'+
                	'</tr>';
				$("#currData").append(str);
				
			});
		},
		"error":function(){alert("系统繁忙");}
	});
}
//定义输入页面查询方法
user.searchByPage = function(){
	$("#selPage").click(function(){
		//获取用户输入的页码
		var cpage = $("#page").val();
		user.loadUsers(cpage);
	});
	
	
}

