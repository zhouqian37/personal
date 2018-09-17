<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>修改用户信息</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	<form method="post" id="userForm">
		<div>
			用户名：${user.username }
		</div>
		<div>
			昵 称：<input type="text" id="nickname" name="nickname">(选填)
		</div>
		<div>
			邮 箱：<input type="text" id="email" name="email">(选填)
		</div>
		<div>
			电 话：<input type="text" id="phone" name="phone">(选填)
		</div>
		<div>
			<input type="button" id="upUser" value="确定"><div id="showUser"></div>
		</div>
	</form>
	<div>
		<p>*不需修改内容可不填写*</p>
	</div>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	$("#upUser").click(function(){
		$.ajax({
			url:"../user/updateUser.do",
			data:$("#userForm").serialize(),
			type:"post",
			dataType:"json",
			success:function(obj){
				location.href="../user/showPersonalPage.do";
			}
		});
	});
</script>
</html>