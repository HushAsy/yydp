<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<body>
<style type="text/css">
.carousel {
	margin: 0;
	padding: 0;
}

</style>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/easyui/themes/icon.css">
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/home.js"></script>
	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="${pageContext.servletContext.contextPath}/js/dist/img/logo1.jpg" alt="First slide">
			</div>
			<div class="item">
				<img src="${pageContext.servletContext.contextPath}/js/dist/img/logo2.jpg" alt="Second slide">
			</div>
		</div>
	</div>
	<!--end 轮播       -->
	<div id="main">
		<div class="container">
			<div id="home_center_head" class="row">
				<div class="col-lg-1"></div>
				<div id="home_center_first" class="col-lg-4">
				</div>
				<div id="home_center_second" class="col-lg-6">
				</div>
			</div>
			<div id="home_center_film" class="col-lg-12">
			</div>
		</div>

		<div class="row">
			<div class="row" style="height: 10px;"></div>
			<div id="clickMore" class="col-lg-12" style="height: 40px; background-color: #1B6D85;text-align: center;color: #FFFFFF;border-radius: 20px;line-height: 40px;" >点击加载更多</div>
		</div>

	</div>
	<script type="text/javascript">
		
		$(function() {
			$.ajax({
				type : "POST",
				async: false,
				cache:false,
				url : getContextPath()+"/film/infoList.do",
				dataType: "json",
				success : function(data) {
					init_first(data[0]);
					inin_seconde(data);
					$("#clickMore").data("data",data);
				}
			});
		});

		function init_first(target) {
			var first = $("#home_center_first");
			$('<a><img src="${pageContext.servletContext.contextPath}/'+target.localbigimage+'" onclick="filmInfoUI('+target.fId+')"/></a>'
				+	'<dl style="display: inline;">'
				+	'<h4>'+target.fName+'</h4>'
				+	'<h5>'+target.fType+'</h5>'
				+	'<h5>'+target.fOntime+'</h5>'
				+	'<h5 style="color: #1B6D85;">--正在热映--</h5>'
				+	'<div class="col-lg-4" style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+target.fId+')"><span style="cursor:pointer;">选座购票</span></div>'
				+'</dl>').appendTo(first);
		}
		
		function inin_seconde(data){
			var second = $("#home_center_second");
			var content = "";
			for(var i=1;i<=6;i++){
				content += '<div class="row">'
							+'	<div class="col-lg-6">'
							+'		<a><img style="height:140px;width:100px;" src="${pageContext.servletContext.contextPath}/'+data[i].localbigimage+'" onclick="filmInfoUI('+data[i].fId+')"/></a>'
							+'		<dl style="display: inline;float: right;">'
							+'			<h6>'+data[i].fName+'</h6>'
							+'			<h6>'+data[i].fType+'</h6>'
							+'			<h6>'+data[i].fOntime+'</h6>'
							+'			<h6 style="color: #1B6D85;">-正在热映-</h6>'
							+'			<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+data[i].fId+')"><span style="cursor:pointer;">选座购票</span></div>'
							+'		</dl>'
							+'	</div>'
							+'	<div class="col-lg-6">'
							+'		<a><img style="height:140px;width:100px;" src="${pageContext.servletContext.contextPath}/'+data[i+1].localbigimage+'" onclick="filmInfoUI('+data[i+1].fId+')"/></a>'
							+'		<dl style="display: inline;float: right;">'
							+'			<h6 title='+data[i+1].fName+'>'+data[i+1].fName+'</h6>'
							+'			<h6>'+data[i+1].fType+'</h6>'
							+'			<h6>'+data[i+1].fOntime+'</h6>'
							+'			<h6 style="color: #1B6D85;">-正在热映-</h6>'
							+'			<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+data[i+1].fId+')"><span style="cursor:pointer;">选座购票</span></div>'
							+'		</dl>'
							+'	</div>'
							+'</div>';
							i++;
			}
			second.append(content);
		}
		
		function ininMore(){
			var data = $("#clickMore").data("data");
			var content = "";
			for(var i = 7;i<data.length-2;i++){
				content +='<div class="row">'
						+'	<div class="col-lg-1"></div>'
						+'	<div class="col-lg-3">'
						+'		<a><img style="height:140px;width:100px;" src="${pageContext.servletContext.contextPath}/'+data[i].localbigimage+'" style="width:100px;height:140px;" onclick="filmInfoUI('+data[i].fId+')"/></a>'
						+'		<dl style="display: inline;float: right;">'
						+'			<h4>'+data[i].fName+'</h4>'
						+'			<h5>'+data[i].fType+'</h5>'
						+'			<h5>'+data[i].fOntime+'</h5>'
						+'			<h5 style="color: #1B6D85;">--正在热映--</h5>'
						+'			<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+data[i].fId+')"><span style="cursor:pointer;">选座购票</span></div>'
						+'		</dl>'
						+'	</div>'
						+'	<div class="col-lg-1"></div>'
						+'	<div class="col-lg-3">'
						+'		<a><img style="height:140px;width:100px;" src="${pageContext.servletContext.contextPath}/'+data[i+1].localbigimage+'" onclick="filmInfoUI('+data[i+1].fId+')"/></a>'
						+'		<dl style="display: inline;float: right;">'
						+'			<h4>'+data[i+1].fName+'</h4>'
						+'			<h5>'+data[i+1].fType+'</h5>'
						+'			<h5>'+data[i+1].fOntime+'</h5>'
						+'			<h5 style="color: #1B6D85;">--正在热映--</h5>'
						+'			<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+data[i+1].fId+')"><span style="cursor:pointer;">选座购票</span></div>'
						+'		</dl>'
						+'	</div>'
						+'	<div class="col-lg-3">'
						+'		<a><img style="height:140px;width:100px;" src="${pageContext.servletContext.contextPath}/'+data[i+2].localbigimage+'" onclick="filmInfoUI('+data[i+2].fId+')"/></a>'
						+'		<dl style="display: inline;float: right;">'
						+'			<h4>'+data[i+2].fName+'</h4>'
						+'			<h5>'+data[i+2].fType+'</h5>'
						+'			<h5>'+data[i+2].fOntime+'</h5>'
						+'			<h5 style="color: #1B6D85;">--正在热映--</h5>'
						+'			<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;cursor：pointer;" onclick="buyTicket('+data[i+2].fId+')"><span style="cursor:pointer;">选座购票</span></div>'
						+'		</dl>'
						+'	</div>'
						+'</div>';
						i+=3;
			}
			$("#home_center_film").append(content);
		}
		var  clickCount;
		$("#clickMore").click(function(){
			if(clickCount == undefined || clickCount == 0){
				clickCount = 1;
				$("#home_center_film").show();
				ininMore();
				$("#clickMore").html('隐藏电影');
			}else{
				$("#home_center_film").toggle();
				$("#clickMore").html('点击加载更多');
				clickCount = 0;
			}
			
		});
		function filmInfoUI(f_id){
			$('#center').panel({    
			    href:getContextPath()+'/film/filmInfo.do?='+f_id,    
			});
		}
		
		
		
		function buyTicket(f_id){
			var divDlg = '<div id="buyTicket_dlg"></div>';
			$(divDlg).appendTo($("#center"));
			$('#buyTicket_dlg').dialog({    
			    title: '请选择档期',    
			    width: 350,    
			    height: 205,
			    href:getContextPath()+'/buy/ticketItem.do?f_id='+f_id,
			    closed: false,    
			    cache: false,    
			    modal: true,
			});
			
		}
		
	</script>
</body>
</html>