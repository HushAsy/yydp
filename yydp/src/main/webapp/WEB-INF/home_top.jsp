<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

</head>
<body>
	<style text="text/css">
		.form-control{
			line-height: 43px;
			height: 48px;
			font-size: 18px;
		}
		.row{
			margin-top: 20px;
		}
		.top_but{
			padding-top: 25px;
		}
		.top_head_btn1{
			position: relative;
			bottom: -5px;
		}
	</style>
	<div id="nav_top">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control">
						</div>
						<button type="button" class="btn btn-info btn-lg">搜索</button> 
						
					</form>
				</div>
				<div class="col-lg-4 top_but">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="#">首页</a></li>
							<li class="active"><a href="#">购票</a></li>
							<li class="active"><a href="#">我的订单</a></li>
							<li><a href="#">登录</a></li>
							<li><a href="#">注册</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>