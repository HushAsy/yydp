<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/yydp.js"></script>
<style type="text/css">

body {
	margin: 0px;
	padding: 0px;
}
</style>
</head>

<body>
	<a id="lbonlinePaya" onclick="sendEmail()">Send E-Mail</a>
<script type="text/javascript">
	$("#lbonlinePaya").linkbutton({
		iconCls:"icon-man",
		iconAlign: "left",
	});
	function sendEmail () {
		var str = $("#reciver_phoneip").val();
		str = str.replace(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/,"true");
		if ( str == "true") {
			window.location.href=getContextPath() + "/home/sentEmail.do?receiver="+$("#reciver_phoneip").val();
		} else {
			swal({
				title: "!!!!!",
				text: "哦豁,邮箱格式不对啊!",
				imageSize: 300*300,
				timer: 2000,
			});
		}
	
	}
</script>
</body>
</html>
