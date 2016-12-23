<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
	<head>
		<title>CSS3 ordered list styles - demo</title>
		
	</head>
	<body>
		<style>
			body{
				margin: 20px auto;
			}

			/* -------------------------------------- */

			ol{
				counter-reset: li;
				list-style: none;
				*list-style: decimal;
				font: 15px 'trebuchet MS', 'lucida sans';
				padding: 0;
				text-shadow: 0 1px 0 rgba(255,255,255,.5);
			}

			/* -------------------------------------- */			

			.rounded-list a{
				position: relative;
				display: block;
				padding: .4em .4em .4em 2em;
				*padding: .4em;
				margin: .5em 0;
				background: #ddd;
				color: #444;
				text-decoration: none;
				-moz-border-radius: .3em;
				-webkit-border-radius: .3em;
				border-radius: .3em;
				-webkit-transition: all .3s ease-out;
				-moz-transition: all .3s ease-out;
				-ms-transition: all .3s ease-out;
				-o-transition: all .3s ease-out;
				transition: all .3s ease-out;	
			}

			.rounded-list a:hover{
				background: #eee;
			}

			.rounded-list a:hover:before{
				-moz-transform: rotate(360deg);
			  	-webkit-transform: rotate(360deg);
			    -moz-transform: rotate(360deg);
			    -ms-transform: rotate(360deg);
			    -o-transform: rotate(360deg);
			    transform: rotate(360deg);	
			}

			.rounded-list a:before{
				content: counter(li);
				counter-increment: li;
				position: absolute;	
				left: 0em;
				top: 50%;
				margin-top: -1.3em;
				background: #87ceeb;
				height: 2em;
				width: 2em;
				line-height: 2em;
				border: .3em solid #fff;
				text-align: center;
				font-weight: bold;
				-moz-border-radius: 2em;
				-webkit-border-radius: 2em;
				border-radius: 2em;
				-webkit-transition: all .3s ease-out;
				-moz-transition: all .3s ease-out;
				-ms-transition: all .3s ease-out;
				-o-transition: all .3s ease-out;
				transition: all .3s ease-out;
			}

		</style>
		<ol class="rounded-list">
		</ol>
		<script type="text/javascript">
			$(function() {
				$.ajax({
					type : "POST",
					async: false,
					cache:false,
					url : getContextPath()+"/buy/ticketItemData.do",
					dataType: "json",
					data:{'f_id':'${f_id}'},
					success : function(data) {
						var olMian = $(".rounded-list");
						var content = "";
						for(var i = 0; i < data.length; i++){
							content += '<li><a onclick="tobuyTicket('+data[i].plan_id+')" href="#">&nbsp;&nbsp;Time:'+data[i].play_time+'&nbsp;&nbsp;NO.'+data[i].ph_id+'号</a></li>';
						}
						olMian.append(content);
					}
				});
			});
			function tobuyTicket(target){
				$("#center").panel({
					href:getContextPath()+'/buy/buyTicketUI.do?plan_id='+target,    
				});
				$("#buyTicket_dlg").dialog('close');
			}
		</script>
	</body>
</html>
