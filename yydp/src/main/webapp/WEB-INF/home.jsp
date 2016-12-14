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
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/sweetalert.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/sweetalert.min.js"></script>
<style type="text/css">
html,body {
	width: 100%;
	height: 100%;
	margin: 0;
}
.welcomeBg{
	background-image: url(${pageContext.servletContext.contextPath}/images/home_right.jpg);
	background-size:100% 100%;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='${pageContext.servletContext.contextPath}/images/home_right.jpg',sizingMethod='scale');
}
.welcomeTop{
	background-image: url(${pageContext.servletContext.contextPath}/images/home_head.jpg);
	background-size:100% 100%;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='${pageContext.servletContext.contextPath}/images/home_head.jpg',sizingMethod='scale');
}
.welcomeLeft{
	background-image: url(${pageContext.servletContext.contextPath}/images/home_left.jpg);
	background-size:100% 100%;
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='${pageContext.servletContext.contextPath}/images/home_left.jpg',sizingMethod='scale');
}
</style>
</head>
<body>
	<div id="box" class="easyui-layout" data-options="border:false,fit:true">
		<div style="height:130px;padding: 0px;margin: 0px;" class="welcomeTop"
			data-options="border:false,
					region:'north',
					collapsed:false,
					split:false,
					href:'${pageContext.servletContext.contextPath}/home/top.do'"></div>
		<div style="width:180px;" class="welcomeLeft"
			data-options="border:false,
             			region:'west',
             			collapsed:false,
             			maxWidth:180,
             			minWidth:180,
             			split:false,
             			href:'${pageContext.servletContext.contextPath}/home/left.do'"></div>
		<div id="center" class="welcomeBg" data-options="region:'center',
			     						split:false,
			     						href:'${pageContext.servletContext.contextPath}/home/center.do'"></div>
	</div>
</body>
</html>
