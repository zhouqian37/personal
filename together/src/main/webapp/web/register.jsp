<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>注册</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
<form action="" method="post" id="form_reg">
	<div>
		用户名：<input type="text" id="username" name="username">
	</div>
	<div>
		密 码：<input type="password" id="password" name="password">
	</div>
	<div>
		昵 称：<input type="text" id="nickname" name="nickname">
	</div>
	<div>
		邮 箱：<input type="text" id="email" name="email">
	</div>
	<div>
		电 话：<input type="text" id="phone" name="phone">
	</div>
	<div>
		<input type="button" value="注册" id="reg">
	</div>
<div id="showReg"></div>
</form>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	$("#reg").click(function(){
		$.ajax({
			url:"../user/register.do",
			data:$("#form_reg").serialize(),
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj.state==0){
					$("#showReg").html(obj.message);
					$("#showReg").css("color","red");
				}else{
					$("#showLog").html("");
					location.href="../main/showHome.do";
				}
			}
		});
	});
</script>
</html>