<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
</head>

<body>
	<style type="text/css">
		.l-btn-text {
		  display: inline-block;
		  vertical-align: top;
		  width: auto;
		  line-height: 24px;
		  font-size: 18px;
		  font-weight:bold;
		  padding: 0;
		  margin: 0 4px;
		}
		</style>
		<div style="margin-left: 20px;margin-top: 30px;">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/user.do')">用户管理</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/film.do')">影片管理</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/schedule.do')">档期管理</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/order.do')">订单管理</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/statistics.do')">信息统计</a>
					</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/center.do')">首页</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/fileQuery.do')">影片查询</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/orderOnline.do')">在线订票</a>
					</td>
				</tr>
				<tr height="25">
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton"  data-options="plain:true,iconCls:'icon-tip',width:125,size:'large',
		                    	 	iconAlign:'left'" onclick="refreshCenter('${pageContext.servletContext.contextPath}'+'/myOrder.do')">我的订单</a>
					</td>
				</tr>
			</table>
		</div>
	<script type="text/javascript">
    	function refreshCenter(url){
    		$("#center").panel('open').panel('refresh',url);
    	}
    </script>
</body>
</html>
