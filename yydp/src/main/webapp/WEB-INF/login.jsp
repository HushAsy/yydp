<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,initial-scale=1.0,width=device-width"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
	<title>用户登录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/sweetalert.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/sweetalert.min.js"></script>
	<style>
	html,body {
		background: #ebebeb;
		font-family: "Helvetica Neue", "Hiragino Sans GB", "Microsoft YaHei",
			"\9ED1\4F53", Arial, sans-serif;
		color: #222;
		font-size: 12px;
		width:100%;
		height:100%;
	}
	
	* {
		padding: 0px;
		margin: 0px;
	}
	
	.top_div {
		background: #008ead;
		width: 100%;
		height: 50%;
	}
	
	.ipt {
		border: 1px solid #d3d3d3;
		padding: 10px 10px;
		width: 290px;
		border-radius: 4px;
		padding-left: 35px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
			ease-in-out .15s;
		-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
			.15s;
		transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
	}
	
	.ipt1{
		border: 1px solid #d3d3d3;
		padding: 5px 5px;
		width: 290px;
		border-radius: 4px;
		padding-left: 35px;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
		-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
			ease-in-out .15s;
		-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
			.15s;
		transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
	}
	
	.ipt:focus {
		border-color: #66afe9;
		outline: 0;
		-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
			rgba(102, 175, 233, .6);
		box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
			rgba(102, 175, 233, .6)
	}
	
	.u_logo {
		background: url("images/username.png") no-repeat;
		padding: 10px 10px;
		position: absolute;
		top: 43px;
		left: 40px;
	}
	
	.p_logo {
		background: url("images/password.png") no-repeat;
		padding: 10px 10px;
		position: absolute;
		top: 12px;
		left: 40px;
	}
	
	a {
		text-decoration: none;
	}
	
	.tou {
		background: url("images/tou.png") no-repeat;
		width: 97px;
		height: 92px;
		position: absolute;
		top: -87px;
		left: 140px;
	}
	
	.left_hand {
		background: url("images/left_hand.png") no-repeat;
		width: 32px;
		height: 37px;
		position: absolute;
		top: -38px;
		left: 150px;
	}
	
	.right_hand {
		background: url("images/right_hand.png") no-repeat;
		width: 32px;
		height: 37px;
		position: absolute;
		top: -38px;
		right: -64px;
	}
	
	.initial_left_hand {
		background: url("images/hand.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -12px;
		left: 100px;
	}
	
	.initial_right_hand {
		background: url("images/hand.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -12px;
		right: -112px;
	}
	
	.left_handing {
		background: url("images/left-handing.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -24px;
		left: 139px;
	}
	
	.right_handinging {
		background: url("images/right_handing.png") no-repeat;
		width: 30px;
		height: 20px;
		position: absolute;
		top: -21px;
		left: 210px;
	}
	</style>
</head>
<body>
	<div class="top_div"></div>
	<div id="loginDiv" style="display:block;background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;-moz-border-radius: 8px 8px 8px 8px;-webkit-border-radius: 8px 8px 8px 8px;border-radius: 8px 8px 8px 8px;">
		<div style="width: 165px; height: 90px; position: absolute;">
			<div class="tou"></div>
			<div class="initial_left_hand" id="left_hand"></div>
			<div class="initial_right_hand" id="right_hand"></div>
		</div>
		<div>
			<form id="loginForm" method="post">
				<p style="padding: 30px 0px 10px; position: relative;">
					<span class="u_logo"></span> <input id="username" name="username" class="ipt" type="text" placeholder="请输入用户名" value="">
				</p>
				<p style="position: relative;">
					<span class="p_logo"></span> <input class="ipt" id="password" name="password" type="password" placeholder="请输入密码" value="">
				</p>
			</form>
		</div>
		<div style="height: 25px; line-height:25px; margin-top: 18px;  ">
				 <a id="login"
					style="display:inline-block;width:200px;background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;font-size: 16px;"
					href="#" onclick="login()">登&nbsp;&nbsp;录</a>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			//得到焦点
			$("#password").focus(function(){
				$("#left_hand").animate({
					left: "150",
					top: " -38"
				},{step: function(){
					if(parseInt($("#left_hand").css("left"))>140){
						$("#left_hand").attr("class","left_hand");
					}
				}}, 2000);
				$("#right_hand").animate({
					right: "-64",
					top: "-38px"
				},{step: function(){
					if(parseInt($("#right_hand").css("right"))> -70){
						$("#right_hand").attr("class","right_hand");
					}
				}}, 2000);
			});
			//失去焦点
			$("#password").blur(function(){
				$("#left_hand").animate({
					left: "0",
					top: " 0"
				},{step: function(){
					$("#left_hand").attr("class","initial_left_hand");
					$("#left_hand").attr("style","left:100px;top:-12px;");
				}}, 3000);
				$("#right_hand").animate({
					right: "0",
					top: "0"
				},{step: function(){
					$("#right_hand").attr("class","initial_right_hand");
	 				$("#right_hand").attr("style","right:-112px;top:-12px");
				}}, 3000);
			});
			
			
			// 回车直接提交
			document.onkeydown = function(e) {
				var event = window.event || e; 
				if (event.keyCode == 13) {
						login();
				}
			};
			
			
			
		});
		function login() {
			$('#loginForm').form('submit', {    
// 			    url: sss,    
			    onSubmit: function(){
			    	if($("#username").val()==""||$("#password").val()){
			    		swal("提示!", "用户名或密码不能为空！", "error");
			    		return false;
			    	}
			    },    
			    success:function(data){    
			    		
			    }    
			}); 
		}
		
		
		function getContextPath() {
			var localObj = window.location;
			var contextPath = localObj.pathname.split("/")[1];
			return localObj.protocol + "//" + localObj.host + "/" + contextPath;
		}
</script>
</body>
</html>