<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>修改密码</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	<form method="post" id="pwdForm">
		<div>
		旧密码：<input type="password" name="oldPwd" id="oldPwd">
		</div>
		<div>
		新密码：<input type="password" name="newPwd" id="newPwd">
		</div>
		<div>
		确认密码：<input type="password" name="checkPwd" id="checkPwd">
		</div>
		<div>
		<input type="button" id="pwd" value="确定"><div id="showPwd"></div>
		</div>
	</form>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	$("#pwd").click(function(){
		$.ajax({
			url:"../user/changePwd.do",
			data:"oldPwd="+$("#oldPwd").val()+"&newPwd="+$("#newPwd").val()+"&checkPwd="+$("#checkPwd").val(),
			type:"post",
			dataType:"json",
			success:function(obj){
				if(obj.state==0){
					alert(obj.message);
				}else{
					location.href="../user/showLogin.do";
				}
			}
		});
	});
</script>
</html>