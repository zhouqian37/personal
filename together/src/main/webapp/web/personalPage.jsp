<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>我的信息</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	用户名：${user.username }
</div>
<div>
	昵 称：${user.nickname }
</div>
<div>
	邮 箱：${user.email }
</div>
<div>
	电 话：${user.phone }
</div>
<div>
	<a href="../user/showPersonalPwd.do">更改密码</a><br>
	<a href="../user/showChangeUserInfo.do">修改用户信息</a><br>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
</html>