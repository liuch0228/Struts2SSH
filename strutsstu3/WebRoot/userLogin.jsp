<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>userLogin page</title>
    </head>
  <body>
    <div style="margin:10px;padding:10px">
    	<form name="fomr1" action="<%=basePath%>user/userLogin.action" method="post">
    		用户名：<input type="text" name="user.name" /><br/>
    		密码： <input type="password" name="user.password" /><br/>
    		<input type="submit" value="登陆" />
    	</form>
    </div>
  </body>
</html>
