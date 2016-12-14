<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<style type="text/css">
		html,body {
			width: 100%;
			height: 100%;
			background-image:
				url("${pageContext.servletContext.contextPath}/images/home_right.jpg") norepeat;
			margin: 0;
		}
	</style>
  </head>
  
  <body>
  </body>
</html>