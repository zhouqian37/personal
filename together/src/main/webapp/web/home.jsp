<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>首页</title>
</head>
<body>
<%@include file="header.jsp" %>
<div id="cateDiv">
	
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	onload=function (){
		$.ajax({
			url:"../main/getCategory.do",
			data:"",
			type:"get",
			dataType:"json",
			success:function(obj){
				for(i=0;i<obj.data.length;i++){
					var str="<span><a href='../act/getCategoryAct.do?categoryId="+obj.data[i].id+"'>"+obj.data[i].categoryName+"</a></span>&nbsp&nbsp&nbsp&nbsp&nbsp";
					$("#cateDiv").append(str);
				}
			}
		});
	}
</script>
</html>