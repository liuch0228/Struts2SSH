<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		登陆成功，session中的登陆用户名是：<!--
		<%=request.getAttribute("user.name") %>方式获取session中的值
		--><%=request.getAttribute("user.name") %><br>
		通过EL表达式获取Session中保存的用户名：${sessionScope.username }<br>
		<!--<s:property value="name"/> value里面写上Action类中定义的属性，就能在jsp页面显示请求中所带的参数了  -->
		采用OGNL与Struts2标签输出Action类的属性值（Action类获取到的请求参数值） <br/>
		name=<s:property value="user.name" />&nbsp;&nbsp; password=<s:property value="user.password" />	<br>
		采用EL表达式 输出Action类的属性值(${对象名.属性名 })：<br>
		name=${user.name }
	</body> 
</html>
