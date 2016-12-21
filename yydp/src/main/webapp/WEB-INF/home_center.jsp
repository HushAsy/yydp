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
				<div class="col-lg-4">
					<a><img src="${pageContext.servletContext.contextPath}/images/filmInfo/229534.jpg" /></a>
					<dl style="display: inline;">
						<h4>血战钢锯岭</h4>
						<h5>139分钟-剧情/历史</h5>
						<h5>138家影院上映600场</h5>
						<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
						<div class="col-lg-4" style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
					</dl>
				</div>
				<div id="home_center_film" class="col-lg-6">
					<div class="row">
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/122227.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>血战钢锯岭123</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/126700.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>神奇侠侣</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/157155.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>奇幻城堡</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/153097.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>铜雀台</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/190450.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>警察故事</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
						<div class="col-lg-6">
							<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/205909.jpg" /></a>
							<dl style="display: inline;float: right;">
								<h4>急速之巅</h4>
								<h5>139分钟-剧情/历史</h5>
								<h5>138家影院上映600场</h5>
								<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
								<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
							</dl>
						</div>
					</div>
				</div>
			</div>





			<div id="home_center_film" class="col-lg-12">
				<div class="row">
					<div class="col-lg-1"></div>
					<div class="col-lg-3">
						<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/122227.jpg" style="width:100px;height:140px;" /></a>
						<dl style="display: inline;float: right;">
							<h4>血战钢锯岭123</h4>
							<h5>139分钟-剧情/历史</h5>
							<h5>138家影院上映600场</h5>
							<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
							<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
						</dl>
					</div>
					<div class="col-lg-1"></div>
					<div class="col-lg-3">
						<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/126700.jpg" /></a>
						<dl style="display: inline;float: right;">
							<h4>神奇侠侣</h4>
							<h5>139分钟-剧情/历史</h5>
							<h5>138家影院上映600场</h5>
							<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
							<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
						</dl>
					</div>
					<div class="col-lg-3">
						<a><img src="${pageContext.servletContext.contextPath}/js/dist/img/126700.jpg" /></a>
						<dl style="display: inline;float: right;">
							<h4>神奇侠侣</h4>
							<h5>139分钟-剧情/历史</h5>
							<h5>138家影院上映600场</h5>
							<h5 style="color: #1B6D85;">加菲演绎铁血柔情</h5>
							<div style="background-color: #1B6D85;text-align: center; border-radius: 25px;color: #FFFFFF;">选座购票</div>
						</dl>
					</div>
				</div>

			</div>
		</div>


		<div class="row">
			<div class="row" style="height: 10px;"></div>
			<div class="col-lg-12" style="height: 40px; background-color: #1B6D85;text-align: center;color: #FFFFFF;border-radius: 20px;line-height: 40px;">点击加载更多</div>

		</div>

	</div>
	<script type="text/javascript">
		
		$(function() {
			var home_center_head = $("#home_center_head");
			$.ajax({
				type : "POST",
				async: false,
				cache:false,
				url : getContextPath()+"/filmInfo/infoList.do",
				dataType: "json",
				data : "name=John&location=Boston",
				success : function(data) {
					alert(data.length);
				}
			});
		});

		function init() {

		}
	</script>
</body>
</html>