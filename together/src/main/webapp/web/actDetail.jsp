<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>活动详情</title>
</head>
<body>
<%@include file="header.jsp" %>
活动名称：${act.actName }<br>
活动时间：<fmt:formatDate value="${act.actTime }" pattern="yyyy年MM月dd日  HH:mm" /><br>
活动地点：${act.actPlace }<br>
活动详情：${act.actDetail }<br>
总计费用：${act.actCost }<br>
人均费用：${act.actPrice }<br>
活动人数：${act.actSum }<br>
<input type="button" id="detail_bt" value="马上参加">
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	$("#detail_bt").click(function(){
		$.ajax({
			url:"../act/addUserToActivity.do",
			data:"uid="+${user.id}+"&aid="+${act.id},
			type:"get",
			dataType:"json",
			success:function(obj){
				if(obj.state==1){
					location.href="../act/showActivity.do";
				}else{
					alert(obj.message);
				}
			}
		});
	});
</script>
</html>