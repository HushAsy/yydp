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
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/js/dist/sweetalert.css"> -->
<!-- <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/dist/sweetalert.min.js"></script> -->
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/home.js"></script>
</head>

<body>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}
#mainBody #title_nav {
	background-image: url(./images/nav_background.png);
	height: 63px;
	width: 100%;
	background-repeat: repeat-x;
}
#mainBody {
	height: 760px;
	width: 100%;
	margin: 0;
	padding:0;
}
#mainBody #main {
	height: 777px;
	width: 960px;
	margin-right: auto;
	margin-left: auto;
}
#mainBody #main #main_left {
	float: left;
	height: 777px;
	width: 651px;
	background-color: #FFFFFF;
}
#mainBody #main #main_right {
	height: 777px;
	width: 309px;
	float: left;
	background-color: #FFFFFF;
}
#mainBody #middle {
	background-image: url(./images/bgColor.png);
	background-repeat: repeat-x;
	height: 797px;
	width: 100%;
	margin:0;
	padding:0;
}
#mainBody #footer {
	background-image: url(./images/bottom.png);
	height: 337px;
	width: 100%;
}
#logo {
	background-image: url(./images/logo.png);
	height: 55px;
	width: 544px;
	margin-top: 30px;
	margin-right: auto;
	margin-left: auto;
}
#mainBody #middle #main #main_left #logo_main {
	height: 105px;
	width: 572px;
	margin-right: auto;
	margin-bottom: 10px;
	margin-left: auto;
}
#mainBody #middle #main #main_left #logo_main #subtitle {
	height: 15px;
	width: 552px;
	font-family: "宋体";
	font-size: 16px;
	text-align: center;
}
#mainBody #middle #main #main_left #logo_main #person_count {
	height: 15px;
	width: 552px;
	font-size: 14px;
	text-align: center;
	margin-top: 10px;
}
#mainBody #middle #main #main_left #table_seat {
	/* 	background-image: url(./images/table.png); */
	height: 450px;
	width: 489px;
	margin-right: auto;
	margin-left: auto;
	float: left;
}
#mainBody #middle #main #main_left #table_anitation {
	background-image: url(./images/logo_bottom.png);
	height: 47px;
	width: 484px;
	margin-right: auto;
	margin-left: auto;
	background-repeat: no-repeat;
	background-position: center;
	clear: both;
}
#mainBody #title_nav #nav_logo {
	background-image: url(./images/nav_logo.png);
	background-repeat: no-repeat;
	margin-right: 10%;
	margin-left: 10%;
	height: 63px;
	width: 134px;
	float: left;
}
#mainBody #title_nav li {
	float: left;
	text-align: center;
	list-style-type: none;
}
#mainBody #title_nav #nav_button_left a {
	display: block;
	height: 63px;
	width: 90px;
	text-align: center;
	color: #FFFFFF;
	text-decoration: none;
}
#mainBody #title_nav a:hover {
	font-size: 20px;
}

#mainBody #title_nav ul {
	list-style-type: none;
}
#mainBody #title_nav #nav_button_left {
	float: left;
}
#mainBody #title_nav #nav_button_right {
	float: left;
}
#mainBody #title_nav #nav_button_right ul {
	list-style-type: none;
}
#mainBody #title_nav #nav_button_right li {
	float:left;
}
#mainBody #title_nav #nav_button_right a {
	color: #FFFFFF;
	height: 60px;
	width: 90px;
	display: block;
	text-decoration: none;
}
#mainBody #title_nav #nav_button_right a:hover {
	font-size: 20px;
}

#mainBody #title_nav #nav_button_right #line_while {
	background-repeat: no-repeat;
	background-position: center;
	height: 63px;
	width: 20px;
	float: left;
}
#mainBody #title_nav #nav_shopping {
	background-image: url(./images/nav_shopping.png);
	float: left;
	height: 63px;
	width: 61px;
}
#mainBody #middle #main #main_right #main_right_top {
	background-image: url(./images/main_right_03.png);
	height: 30px;
	margin-top: 60px;
	margin-right: auto;
	margin-left: auto;
	background-repeat: no-repeat;
}
#mainBody #middle #main #main_right #main_right_bottom {
	background-image: url(./images/main_right_16.png);
	background-repeat: no-repeat;
	background-position: center center;
	margin-bottom: 10px;
	height: 163px;
	width: 100%;
}
#mainBody #middle #main #main_right #main_right_middle {
	height: 464px;
	width: 100%;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail {
	height: 60%;
	width: 276px;
	margin-right: auto;
	margin-left: auto;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count {
	height: 36%;
	width: 276px;
	margin-right: auto;
	margin-left: auto;
}
#mainBody #middle #main #main_right #main_right_middle #file_whiteLine {
	background-image: url(./images/main_right_10.png);
	background-repeat: no-repeat;
	background-position: center center;
	height: 20px;
	width: 276px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #file_cover {
	height: 89px;
	width: 61px;
	margin-top: 20px;
	float: left;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #file_cover_detail {
	float: left;
	height: 89px;
	width: 187px;
	margin-top: 20px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #file_cover_detail #film_detail_title {
	height: 30px;
	width: 215px;
	font-family: "宋体";
	font-size: 16px;
	font-weight: bold;
	line-height: 30px;
	text-indent: 20px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #file_cover_detail #film_detail_type {
	height: 59px;
	width: 215px;
	text-indent: 15px;
	line-height: 30px;
	font-size: 14px;
	font-weight: lighter;
	font-family: "宋体";
	padding-left: 10px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price {
	height: 168px;
	width: 276px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_yy_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_yy {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_bb_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_bb {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_cc_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_cc {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_zw_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_zw {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_pj_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_pj {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_ps_name {
	height: 30px;
	width: 50px;
	float:left;
	font-family: "黑体";
	font-size: 16px;
	line-height: 30px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_price #film_ps {
	height: 30px;
	width: 226px;
	float: right;
	font-family: "黑体";
	font-size: 14px;
	line-height: 30px;
}

#mainBody #middle #main #main_right #main_right_middle #film_Detail #film_cover_all {
	height: 109px;
	width: 276px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #film_sum_name {
	height: 30px;
	width: 50px;
	float: left;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #film_sum {
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #film_sum_name {
	height: 30px;
	width: 50px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #film_sum_name {
	height: 30px;
	width: 50px;
	font-family: "宋体";
	font-size: 16px;
	line-height: 30px;
	font-weight: bold;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #film_sum {
	float: right;
	height: 30px;
	width: 226px;
	font-family: "黑体";
	font-size: 24px;
	line-height: 30px;
	font-weight: bolder;
	color: #FFCC33;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #buy_reciver {
	height: 30px;
	width: 276px;
	clear: both;
	font-family: "宋体";
	font-size: 16px;
	line-height: 30px;
	font-weight: bold;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #reciver_phone {
	height: 40px;
	width: 276px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #reciver_phone #reciver_phoneip {
	height: 40px;
	width: 276px;
	padding-left: 10px;
	font-size: 20px;
	font-family: "黑体";
	color: #666666;
	border-radius: 10px;
}
#mainBody #middle #main #main_right #main_right_middle #film_Count #submit_Btn {
	height: 40px;
	width: 221px;
	margin-right: auto;
	margin-left: auto;
	margin-top: 10px;
}
#mainBody #middle #main #main_left #seat_rowName {
	height: 450px;
	width: 100px;
	float: left;
	font-family: "宋体";
	font-size: 12px;
	line-height: 40px;
	color: #666666;
	text-align: center;
}
</style>
	<div id="mainBody">
		<div id="middle">
			<div id="main">
				<div id="main_left">
				  <div id="logo_main">
						<div id="logo"></div>
						<div id="subtitle">世纪影城(No.厅)</div><!-- 具体数据具体再弄 -->
						<div id="person_count"></div><!--  -->
				  </div>
					<div id="seat_rowName"></div>
					<div id="table_seat"></div><!-- 要用动态的座位表 -->
					<div id="table_anitation"></div>
				</div>
				<div id="main_right">
					<div id="main_right_top"></div>
					<div id="main_right_middle">
						<div id="film_Detail">
							<div id="film_cover_all">
							<div id="file_cover"></div>
							<div id="file_cover_detail">
								<div id="film_detail_title"></div><!-- 电影题目 -->
								<div id="film_detail_type"></div><!-- 电影类型 -->
							</div>
							</div>
							<div id="film_price">
								<div id="film_yy_name">影院:</div>
								<div id="film_yy">世纪影城</div><!-- 从数据库读取 -->
								<div id="film_bb_name">版本:</div>
								<div id="film_bb">2D英文版</div><!-- 从数据库读取 -->
								<div id="film_cc_name">上映:</div>
								<div id="film_cc">xx月xx日 19：30</div><!-- 从数据库读取 -->
								<div id="film_zw_name">放映:</div>
								<div id="film_zw"></div><!-- 从数据库读取 -->
								<div id="film_pj_name">票价:</div>
								<div id="film_pj"></div><!-- 从数据库读取 -->
								<div id="film_ps_name">票数:</div>
								<div id="film_ps"></div><!-- 从数据库读取 -->
							</div>
						</div>
						<div id="file_whiteLine"></div>
						<div id="film_Count">
							<div id="film_sum_name">总计:</div>
							<div id="film_sum">￥0</div><!-- 从数据库读取 -->
							<div id="buy_reciver">接收兑换码邮箱:</div>
							<div id="reciver_phone"><input id="reciver_phoneip" name="reciver_phone"/></div>
							<div id="submit_Btn"><a href="javascript:void(0);" onclick="nextStep()"><img src="./images/main_right_13.png"/></a></div>
						</div>
					</div>
					<div id="main_right_bottom"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">

	var tCount = 0;
	var totalPay =0;
	var row = 0;
	var col = 0;
	var imgUrl = "";
	var imgId = '${plan.fId}';
	var name = "";
	var type = "";
	var version = "";
	var ontime = "";
	var pay = 0;
	var pay_show="";
	var playTime = "";
	var subtitle = "";
	var person_count = "";
	$.ajax({
		url: getContextPath()+ "/buy/getMovieInfo.do",
		data:{"plan_id":'${plan.id}'},
		dataType: "json",
		async: false,
		success: function (result) {
			imgUrl = getContextPath() +"/images/film/"+imgId+".jpg" ;
			name=result.f_name;
			type=result.f_type;
			version = result.f_country;	
			ontime = result.f_ontime;
			pay = result.money;
			pay_show = result.money+"元/张";
			playTime = result.playTime;
			subtitle = result.number;
			person_count = result.rest;
		},
		error: function () {
			alert("error");
		}
	});	
	$("#file_cover").css("background-image","url("+imgUrl+")");
	$("#film_detail_title")[0].innerHTML = '<h5>'+name+'</h5>';
	$("#film_detail_type")[0].innerHTML = '<h6>类型:'+type+'</h6>';
	$("#film_bb")[0].innerHTML = version;
	$("#film_cc")[0].innerHTML = ontime;
	$("#film_pj")[0].innerHTML = pay_show;
	$("#film_zw")[0].innerHTML = playTime;
	$("#subtitle")[0].innerHTML = '世纪影城(No.'+subtitle+'厅)';
	$("#person_count")[0].innerHTML = '(剩余'+person_count+'个座位)';
	var seatData = getSeatData();
	for(var i=0;i<seatData.length;i++) {
		if ((i+1)%10 != 0) {
			row = Math.ceil((i+1)/10);
			col = i%10;
		} else {
			row = Math.ceil((i+1)/10);
			col = 10;
			$("#seat_rowName").append("第"+Math.ceil((i+1)/10)+"排<br/>");
		}
		getSeat(seatData[i],row,col);
	}
	
	function getSeatData () {
		var seatData = "";
		$.ajax({
			url: getContextPath()+ "/buy/getSeatsArray.do",
			data:{"plan_id":'${plan.id}'},
			dataType: "json",
			async: false,
			success: function (result) {
				seatData = result;
			},
			error: function () {
				alert("error");
			}
		});	
			return seatData;
	}
		
	function getSeat (status,row,col) {
		//0表示可选 1表示不可选
		var table_seat_view_active = $("<div title='第"+row+"排,第"+col+"列' id='table_seat_view' style='width:46px;height:40px;background-image: url(./images/logo_kx.png);float:left;background-repeat: no-repeat;background-position: center center;'onclick='changeStatus(this)'></div>");
		var table_seat_view_unactive = $("<div title='第"+row+"排,第"+col+"列' id='table_seat_view' style='width:46px;height:40px;background-image: url(./images/logo_bkx.png);float:left;background-repeat: no-repeat;background-position: center center;'onclick='changeStatus(this)'></div>");
		if (status == 0) {
			table_seat_view_active.appendTo("#table_seat");
		} else {
			table_seat_view_unactive.data("clickStatus","2");
			table_seat_view_unactive.appendTo("#table_seat");
		} 
	}
	
	function changeStatus(target) {
		
		if ($(target).data("clickStatus") == 2) {
			return false;
		}
		if (target.clickStatus == undefined || target.clickStatus == 0) {
			if (tCount == 4){
				alert("每个用户仅限买4张票");
				return false;
			}
			target.clickStatus = 1;
			tCount++;
			totalPay = "￥"+tCount*pay;
			$(target).css("background-image","url(./images/logo_yx.png)");
			$("#film_ps")[0].innerHTML=tCount;
			$("#film_sum")[0].innerHTML=totalPay;
		} else if (target.clickStatus == 1){
			$(target).css("background-image","url(./images/logo_kx.png)");
			target.clickStatus = 0;
			tCount--;
			totalPay = "￥"+tCount*pay;
			$("#film_ps")[0].innerHTML=tCount;
			$("#film_sum")[0].innerHTML=totalPay;
		}
	}
	
	function nextStep(){
		var dlgpayTicketdiv = $("<div id='dlgpayTicketdiv'></div>");
		dlgpayTicketdiv.appendTo("body");
		$("#dlgpayTicketdiv").dialog({
			href: getContextPath() + "/buy/onlinePayUI.do",
			left: 400,
			top:200,
			width: 512,
			height: 300,
			title: "在线支付",
			
		});
	}
</script>
</body>

</html>
