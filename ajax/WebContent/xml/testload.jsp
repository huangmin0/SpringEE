<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
		var url=this.href;
		var args={"time":new Date()}; 
		$("#content").load(url,args);
		return false;	
	});
});

</script>
<body>
<a href="login.jsp">这是ajax方法实现</a>
<div id="content" style="color: pink"></div>
</body>
</html>