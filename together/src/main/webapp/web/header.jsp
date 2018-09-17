<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<div>
<a href="../main/showHome.do">首页</a>
</div>
<c:if test="${user!=null }">
<div>
<span><input type="text" id="search"></span><span><input type="button" value="搜索" id="search_bt"></span>
</div>
</c:if>
<div>
	<ul>
		<c:if test="${user==null }">
		<li><a href="../user/showLogin.do">登录</a></li>
		<li><a href="../user/showRegister.do">注册</a></li>
		</c:if>
		<c:if test="${user!=null }">
		<li><a href="../user/showPersonalPage.do">${user.nickname }</a></li>
		<li><a href="../act/showActivity.do">活动管理</a></li>
		<li><a href="../user/exit.do">退出</a></li>
		<li><a href="../user/showRegister.do">注册</a></li>
		</c:if>
	</ul>
</div>
</header>
