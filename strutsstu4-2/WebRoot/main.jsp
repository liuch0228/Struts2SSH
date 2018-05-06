<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>main.jsp</title>
  </head>
  
  <body>
   当前登陆用户：${username } <br/>
   <a href="<%=basePath%>book_add">bookAdd</a> <br>
   <a href="<%=basePath%>book_del">bookDel</a> <br>
   <a href="<%=basePath%>book_update">bookUpdate</a> <br>
   <a href="<%=basePath%>bookind">bookFind</a> <br>
  </body>
</html>
