/**
 * 搜索栏搜索活动
 */
$("#search_bt").click(function(){
	$.ajax({
		url:"../act/search.do",
		data:"search="+$("#search").val(),
		type:"post",
		dataType:"json",
		success:function(obj){
			location.href="../act/showSearchResult.do";
		}
	});
});
