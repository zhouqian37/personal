<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>创建活动</title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
	<form action="" method="post" id="act_form">
		<div>
			活动分类：<select id="actCategory" onchange="getCategory()"><option>请选择分类</option><option value="1">美食</option><option value="2">运动</option><option value="3">旅游</option><option value="4">休闲</option></select>
		</div>
		<div>
			活动名：<input type="text" id="actName" name="actName">
		</div>
		<div>
			活动时间：	<select id="actYear" onchange="getYear()"><option>请选择年</option><c:forEach var="year" begin="2018" end="2030"><option value="${year }">${year }</option></c:forEach></select>年
					<select id="actMonth" onchange="getMonth()"><option>请选择月</option><c:forEach var="month" begin="1" end="12"><option value="${month }">${month }</option></c:forEach></select>月
					<select id="actDay" onchange="getDay()"><option>请选择日</option><c:forEach var="day" begin="1" end="31"><option value="${day }">${day }</option></c:forEach></select>日
					<select id="actHour" onchange="getHour()"><option>请选择时</option><c:forEach var="hour" begin="1" end="24"><option value="${hour }">${hour }</option></c:forEach></select>：
					<select id="actMinute" onchange="getMinute()"><option>请选择分</option><c:forEach var="minute" begin="0" end="59"><option value="${minute }">${minute }</option></c:forEach></select>
		</div>
		<div>
			活动地点：<input type="text" id="actPlace" name="actPlace">
		</div>
		<div>
			活动详情：<textarea rows="10" cols="50" id="actDetail" name="actDetail"></textarea>
		</div>
		<div>
			总计费用：<input type="text" id="actCost" name="actCost">
		</div>
		<div>
			参与人数：<input type="text" id="actSum" name="actSum">
		</div>
		<div>
			人均费用：<input type="text" id="actPrice" name="actPrice" onfocus="getPrice()">
		</div>
		<div>
			<input type="button" value="创建" id="bt_act">
		</div>
	</form>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/search.js"></script>
<script type="text/javascript">
	function getPrice(){
		var cost=$("#actCost").val();
		var sum=$("#actSum").val();
		var price=cost/sum;
		$("#actPrice").val(price);
		return price;
	}
	
	function getCategory(){
		var category=$("#actCategory").val();
		return category;
	}
	
	function getYear(){
		var year=$("#actYear").val();
		return year;
	}
	
	function getMonth(){
		var month=$("#actMonth").val();
		return month;
	}
	
	function getDay(){
		var day=$("#actDay").val();
		return day;
	}
	
	function getHour(){
		var hour=$("#actHour").val();
		return hour;
	}
	
	function getMinute(){
		var minute=$("#actMinute").val();
		return minute;
	}
	
	$("#bt_act").click(function(){
		var category=getCategory();
		var year=getYear();
		var month=getMonth();
		var day=getDay();
		var hour=getHour();
		var minute=getMinute();
		var date=year+"-"+month+"-"+day+" "+hour+":"+minute;
		var price=getPrice();
		$.ajax({
			url:"../act/createActivity.do",
			data:"categoryId="+category+"&actName="+$("#actName").val()+"&actPlace="+$("#actPlace").val()+"&actDetail="+$("#actDetail").val()
			+"&actCost="+$("#actCost").val()+"&actPrice="+price+"&actSum="+$("#actSum").val()+"&actTime="+date,
			type:"post",
			dataType:"json",
			success:function(obj){
				location.href="../act/showActivity.do";
			}
		});
	});
	
	
</script>
</html>