//会员页面
$(function(){
	//加载默认页面数据
	user.loadUsers(1);
	
	user.searchByPage();
});
var user = {};

user.loadUsers = function(page){
	$.ajax({
		url:"/Springvideocms/user/userList.do",
		data:{"page":page},
		dataType:"json",
		success:function(data){
			var totalPage = data.totalPage;			
			//创建分页
			$(".pagination").createPage({
				pageCount : totalPage,
				current : page,
				backFn : function(p){
					user.loadUsers(p);
				}
			});
			
			//每次清空上一次信息
			$(".mytr").remove();
			//拼记录信息
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
		error:function(){alert("系统繁忙");}
	});

};

//定义输入页面查询方法
user.searchByPage = function(){
	$("#selPage").click(function(){
		//获取用户输入的页码
		var cpage = $("#page").val();
		user.loadUsers(cpage);
	});
	
	
}










