<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<meta charset="utf-8" />
	<title>电影商城</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="js/dist/css/bootstrap.css" />
	<script src="js/jquery.min.js"></script>
	<script src="js/dist/js/bootstrap.min.js"></script>
	<style>
		body {
			font-family: "Helvetica Neue";
			font-size: 14px;
			background-color: #FFFFFF;
		}
		
		#nav_top{
			height: 100%;
			background: #1E1E1E none repeat scroll 0 0;
		}
		
		#nav_top nav {
			border: none;
			background: #192332 none repeat scroll 0 0;
		}
		
		#nav_top a {
			font-size: 14px;
			color: #D1D1D1;
		}
		
		#nav_top a:hover {
			color: #FFFFFF;
		}
		
		#nav_top form {
			margin-left: 20px;
		}
		
		#nav_top input {
			width: 600px;
		}
		#main{
			width: 100%;
			height: 600px;
		}
		#search{
			height: 80px;
			background-color: #1E1E1E;
/* 			#1E1E1E,#E5E5E5 */
		}
		#footer{
			height: 40px;
			line-height:40px;
			text-align:center;
			margin-top:40px;
			background: #192332 none repeat scroll 0 0;
		}
	</style>
</head>
<body>
	<div id="box" class="easyui-layout" data-options="border:false,fit:true">
		<div style="height:100px;padding: 0px;margin: 0px;" class="welcomeTop"
			data-options="border:false,
					region:'north',
					collapsed:false,
					split:false,
					href:'${pageContext.servletContext.contextPath}/home/top.do'"></div>
		<div id="center" class="welcomeBg" data-options="region:'center',
			     						split:false,
			     						collapsed:false,
			     						border:false,
			     						href:'${pageContext.servletContext.contextPath}/home/center.do'"></div>
	</div>
</body>
</html>
