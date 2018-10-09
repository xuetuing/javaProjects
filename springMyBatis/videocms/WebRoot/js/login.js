var codeFlag = false;
$(function(){
	$(".code").blur(function(){
		//检查验证码是否为null
		if(!this.value.trim()){
			$("#codeMsg").html("请输入验证码");
			return;
		}
		$.ajax({
			"url":"/videocms/login/checkUserCode.action",
			"type":"post",
			"data":{"userCode":this.value},
			"datatype":"json",
			"success":function(data){
				if(!data.obj){
					codeFlag = false;
					$("#codeMsg").html(data.msg);
				}else{
					codeFlag = true;
					$("#codeMsg").html(data.msg);
				}
			},
			"error":function(){alert("系统繁忙...");}
		});
		
	});

});
function check(){
	return codeFlag;
}