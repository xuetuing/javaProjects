<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
   	<script type="text/javascript">
   		function check_email(){
   			$.ajax({
   				url:"/SpringMyBatisDay10_02/test/testFour.do",
   				data:"email="+$("#email").val,
   				type:"post",
   				dataType:"json",
   				success:function(data){
   					if(data.obj){
   						alert(data.name);
   					}
.   					console.log(data);
   				},
   				error:function(){}
   			});
   		}
   	
   	</script>
</head>
  
  <body>
   	邮箱:<input type="text" id="email" onblur="check_email()"/>
  </body>

</html>




