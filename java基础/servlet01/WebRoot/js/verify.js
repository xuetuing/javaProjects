//表单验证
$(function(){
	$(".a1").each(function(){
		var star = $("<strong class='reda'>*</strong>");
		$(this).parent().append(star);
	});
	
	$("form :input").blur(function(){
		$(this).parent().find(".a2").remove();
		//用户名验证
		if($(this).is("#username")){
			if(this.value==""){
				var err = "<span class='a2 error'>用户名不能为空</span>";
				$(this).parent().append(err);
			}else{
				var right = "<span class='a2 righta'>正确</span>";
				$(this).parent().append(right);
			}
		}
		//密码验证
		if($(this).is("#password")){
			if(this.value.length<6){
				var err = "<span class='a2 error'>密码不能小于6位</span>";
				$(this).parent().append(err);
			}else{
				var right = "<span class='a2 righta'>正确</span>";
				$(this).parent().append(right);
			}
		}
		//密码确认
		if($(this).is("#passwords")){
			if(this.value=="" || this.value!=$("#password").val()){
				var err = "<span class='a2 error'>两次密码不一致</span>";
				$(this).parent().append(err);
			}else{
				var right = "<span class='a2 righta'>正确</span>";
				$(this).parent().append(right);
			}
		}
		//邮件验证
		if($(this).is("#email")){
			if(this.value=="" || (this.value!="" && !/.+@.+\.[a-zA-Z]{2,4}$/.test(this.value))){
				var err = "<span class='a2 error'>邮箱格式不正确</span>";
				$(this).parent().append(err);
			}else{
				var right = "<span class='a2 righta'>正确</span>";
				$(this).parent().append(right);
			}
		}
		//手机验证
		if($(this).is("#tel")){
			if(isNaN($(this).val()) || this.value.length<11){
				var err = "<span class='a2 error'>手机号格式不正确</span>";
				$(this).parent().append(err);
			}else{
				var right = "<span class='a2 righta'>正确</span>";
				$(this).parent().append(right);
			}
		}
	});
	//提交按钮上的事件
	$("#send").click(function(){
		$("form :input").trigger("blur");
		var num = $(".error").length;
		if(num){
			return false;
		}
		alert("注册成功");
	});
	//重置按钮上的事件，重置按钮会自动清空表单数据
	//而添加的click事件是来清除error信息
	$("#res").click(function(){
		$(".a2").remove();
	});
	
	
	
});