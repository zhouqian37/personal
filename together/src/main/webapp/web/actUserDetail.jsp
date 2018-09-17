<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>活动和参与人员详情</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	活动名称：${act.actName }<br>
	活动时间：<fmt:formatDate value="${act.actTime }" pattern="yyyy年MM月dd日  HH:mm" /><br>
	活动地点：${act.actPlace }<br>
	活动详情：${act.actDetail }<br>
	总计费用：${act.actCost }<br>
	人均费用：${act.actPrice }<br>
	活动人数：${act.actSum }<br>
</div>
<hr>
<div>
	<ul>
	<c:forEach items="${listUser }" var="user">
		<li><span>${user.nickname }</span></li>
	</c:forEach>
	</ul>
	<input type="button" value="离开此活动" id="leaveActivity" onclick="leaveActivity()">
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	function leaveActivity(){
		$.ajax({
			url:"../act/leaveActivity.do",
			data:"uid="+${user.id}+"&aid="+${act.id},
			typr:"get",
			dataType:"json",
			success:function(){
				location.href="../act/showActivity.do";
			}
		});
	}
</script>
</html>