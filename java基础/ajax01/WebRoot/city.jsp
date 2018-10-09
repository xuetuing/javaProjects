<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ajax01/js/my.js"></script>
<script type="text/javascript">
function change(c){
	//获取ajax对象
	var xhr = getXhr();
	//初始化
	xhr.open("get","city.do?city="+c,true);
	//根据服务器返回的数据，局部更新页面
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
		var data = xhr.responseText;
		var arr = data.split(";");
		document.getElementById("city").innerHTML = "";
/*		for(var i=0;i<arr.length;i++){
			var str = arr[i].split(":");
			var op = document.createElement("option");
			op.setAttribute("value",str[0]);
			op.innerHTML = str[1];
			document.getElementById("city").appendChild(op);
			}*/
		for(var i=0;i<arr.length;i++){
			var val = arr[i].split(":")[0];
			var txt = arr[i].split(":")[1];
			var option = new Option(txt,val);
			document.getElementById("city").options[i] = option;
			}
		}
	};
	//发生请求
	xhr.send(null);
}
</script>
</head>
<body>
	省份:
	<select onchange="change(this.value);">
		<option value="-1">请选择</option>
		<option value="hn">河南</option>
		<option value="js">江苏</option>
	</select>
	城市:
	<select id="city">
		<option>请选择</option>
	</select>
	


</body>
</html>
















