<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>搜索结果</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	<table border="1px">
		<tr align="center">
			<td>活动名称</td>
			<td>活动地点</td>
			<td>活动时间</td>
			<td>活动详情</td>
			<td>总计费用</td>
			<td>人均费用</td>
			<td>活动人数</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="act">
			<tr align="center">
				<td>${act.actName }</td>
				<td>${act.actPlace }</td>
				<td><fmt:formatDate value="${act.actTime }" pattern="yyyy-MM-dd HH:mm" /></td>
				<td>${act.actDetail }</td>
				<td>${act.actCost }</td>
				<td>${act.actPrice }</td>
				<td>${act.actSum }</td>
				<td><a href="../act/showActDetail.do?id=${act.id }">查看详情</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
</html>