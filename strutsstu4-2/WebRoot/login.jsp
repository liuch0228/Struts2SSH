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
		<title>登陆</title>
	</head>
	<body>
		${requestScope.msg }
		<br>
		<form action="<%=basePath%>login.action" method="post">
			<table>
				<tr>
					<td><label style="text-align:right;">用户名：</label></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><label style="text-align:right;">密码：</label></td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr >
					<td colspan="2" align="right"><input type="submit" value="登陆"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>
