<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>登录</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	<form action="" method="post">
		<div>
			用户名：<input type="text" id="username">
		</div>
		<div>
			密 码：<input type="password" id="password">
		</div>
		<div>
		<div><input type="button" value="登录" id="login"></div><div id="showLog"></div>
		</div>
	</form>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	$("#login").click(function(){
		$.ajax({
			url:"../user/login.do",
			data:"username="+$("#username").val()+"&password="+$("#password").val(),
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj.state==0){
					$("#showLog").html(obj.message);
					$("#showLog").css("color","red");
				}else{
					$("#showLog").html("");
					location.href="../main/showHome.do";
				}
			}
		});
	});
</script>
</html>