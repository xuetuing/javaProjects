//var checkFlag = false;
//非调试用
var checkFlag = true;

$(function(){
	//检查验证码是否正确
	$(".code").blur(function(){
		if(this.value==null){
			alert("请输入验证码！");
		}
		//发送ajax请求，进行验证码检查处理
		$.ajax({
			"url":"/Springvideocms/login/checkUserCode.do",
			"type":"post",
			"data":{"userCode":this.value},
			"dataType":"json",
			"success":function(data){
				console.log(data);
				if(!data.obj){
					$("#codeMsg").attr("style","color:red").html(data.msg);
					//checkFlag = false;
					checkFlag = true;
					
				}else{
					$("#codeMsg").attr("style","color:yellow").html(data.msg);
					checkFlag = true;
				}
			},
			"error":function(){alert("系统繁忙");}
		});
		
	});
	
});

function check(){
	return checkFlag;
}