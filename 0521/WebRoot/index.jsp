<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>

<body>
	<H1>This is my JSP page.1</H1>
	<hr>
	<br>
	<form action="${pageContext.request.contextPath}/stuServlet?method=addStu" method="post">
		输入姓名：<input name="name"><input type="submit" value="提交">
	</form><hr><br>
	<a href="${pageContext.request.contextPath}/stuServlet?method=delStu&stuId=001">删除学生</a><hr><br>
	<!-- AJax -->
	<button id="btn">AJax请求</button><hr><br>
	
	<button id="btn2">JavaScript先服务器发请求</button><hr><br>

</body>
<script type="text/javascript">
	$(function() {
		$('#btn').click(function() {
			$.post("/0521/stuServlet", {"method" : "updateStu","stuId" : "001"}, function(date) {alert(1);})
		});
		$("#btn2").click(function(){
			location.href="/0521/stuServlet?method=findStu";
		})
	});
</script>
</html>
