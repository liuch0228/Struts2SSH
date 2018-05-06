<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'success.jsp' starting page</title>
	</head>
	<body>
		真不巧，您访问的页面走丢了<br>
		<a href="userLogin.jsp">单击链接返回登陆页面</a>
	</body>
</html>
