///���̨����ajax���󣬻�ȡ��ǰҳ������ݣ�����ҳ��
$(function(){
	//3.���÷���
	user.loadUsers(1);
	user.searchByPage();
});
//1.�������
var user = {};
//2.���巽��
user.loadUsers = function(page){
	$.ajax({
		"url":"/videocms/user/list.action",
		"data":{"page":page},
		"dataType":"json",
		"success":function(data){
			//ȡ����ҳ��
			//console.log(data.totalPage);
			var totalPage = data.totalPage;
			$(".pagination").createPage({
				pageCount : totalPage,
				current : page,
				backFn : function(p){
					user.loadUsers(p);
				}
			});
			//�����һҳ����
			$(".mytr").remove();
			//����data.list
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
		"error":function(){alert("ϵͳ��æ");}
	});
}
//��������ҳ���ѯ����
user.searchByPage = function(){
	$("#selPage").click(function(){
		//��ȡ�û������ҳ��
		var cpage = $("#page").val();
		user.loadUsers(cpage);
	});
	
	
}

