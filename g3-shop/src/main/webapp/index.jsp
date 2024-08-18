<%--
Created by IntelliJ IDEA.
User: 菠萝°没有蜜
Date: 2024/7/24
Time: 22:28
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<meta charset="utf-8" />
		<title>好物商城首页</title>
		<!--引入Bootstrap-->
		<link rel="stylesheet" href="front/bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="front/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript" src="front/bootstrap/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="front/bootstrap/js/npm.js" ></script>
		
		<link rel="stylesheet" href="front/css/top.css" />
		<link rel="stylesheet" href="front/css/index.css" />
		<script src="js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">

	$(function (){
		findClassName("全部商品");
	})

	function findClassName(name){

		console.log(name)
		$.ajax({
			url:"${pageContext.request.contextPath}/index?classname="+name,
			type:"post",
			dataType:"json",
			success:function (data){
				console.log(data);
				var htmldiv = " <div class=\"title\"><a href=\"#\" title=\"显示更多！\">"+name+"</a></div>";
				$("#className").html(htmldiv)
				data.forEach(function (eleDom,index){
					console.log(eleDom.id+"---------"+index)
					var price = eleDom.price; // EL 表达式获取价格
					var name1 =eleDom.goodsname;
					var formattedPrice = price.toFixed(2);
					var htmldiv = "<div class=\"good\">\n" +
							"        <div class=\"img\"/><a href=\"${pageContext.request.contextPath}/index?id="+eleDom.id+"\" target=\"_blank\"><img src=\"${pageContext.request.contextPath}/front/img/goods/"+eleDom.picture+"\" ></a></div>\n" +
							"    <div class=\"info\">\n" +
							"        <div class=\"good_info good_name\">"+name1+"</div>\n" +
							"        <div class=\"good_info good_price\" data-goodsid="+eleDom.id+"\>￥"+formattedPrice+"<a href=\"javascript:void(0)\" class=\"glyphicon glyphicon-shopping-cart\" onclick=\"addGoods(this)\"></a></div>\n" +
							"    </div>"
					$("#className").append(htmldiv);
				})
			}
		})
	}


	function addGoods(element) {

		// 使用 .closest() 方法向上查找
		var goodsId = $(element).closest('.good').find('.good_price').data('goodsid');
		var priceText = $(element).closest('.good_price').text();
		// console.log(priceText);

		console.log('goodsId:', goodsId);


		location.href="${pageContext.request.contextPath}/addGoods?goodsId="+goodsId+"&priceText="+priceText;
		<%--$.ajax({--%>
		<%--	type: "POST",--%>
		<%--	url: "${pageContext.request.contextPath}/addGoods?goodsId="+goodsId,--%>
		<%--	data: { id: goodsId },--%>
		<%--	success: function(data) {--%>
		<%--	--%>
		<%--	},--%>
		<%--	--%>
		<%--});--%>
	}

	// function updateCartCount(count) {
	// 	var cartElement = $('a[href$="shopCar.jsp"]');
	// 	// if (cartElement.length > 0) {
	// 	// 	cartElement.html('<span class="glyphicon glyphicon-shopping-cart"></span>购物车(' + count + ')');
	// 	// }
	// }



</script>
	</head>
	<body>
	<a id="top"></a>
	<header class="header">
		<div class="menu_box">
			<span class="menu right"><a href="javascript:void(0)"><span class="glyphicon glyphicon-earphone"></span>联系客服</a></span>
			<span class="menu right"><a href="${pageContext.request.contextPath}/cartest" target="_blank"><span class="glyphicon glyphicon-shopping-cart"></span>购物车(0)</a></span>
			<span class="menu right"><a href="javascript:void(0)"><span class="glyphicon glyphicon-heart"></span>收藏</a></span>
			<span class="menu right"><a href="${pageContext.request.contextPath}/list"><span class="glyphicon glyphicon-tasks"></span>查看订单</a></span>
			<span class="menu right"><a href="${pageContext.request.contextPath}/index.jsp"><span class="glyphicon glyphicon-home"></span>首页</a></span>
			<span class="menu right"><a href="${pageContext.request.contextPath}/front/regist.jsp"><span class="glyphicon glyphicon-user"></span>注册</a></span>
			<span class="menu right"><a href="${pageContext.request.contextPath}/login.jsp">欢迎，登录</a>
					<div>
						<ul>
							<li><a href="${pageContext.request.contextPath}/edit"><span class="glyphicon glyphicon-edit"></span>修改资料</a></li>
							<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>安全退出</a></li>
						</ul>
					</div>
				</span>
		</div>
	</header>
	<div class="gg_img"></div>
	<div class="body">
		<div class="menu_box">
			<div class="left">
				<ul>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">全部商品</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">谷物</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">蔬菜</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">水果</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">畜禽</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">水产品</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">奶制品</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">茶叶</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">植物油</a></li>
					<li onclick="findClassName(this.textContent)"><a onclick="findClassName(this.textContent)">衣物</a></li>
				</ul>
			</div>
			<div class="lunbo">
				<span class="slide" style="background-image: url('${pageContext.request.contextPath}/front/img/lumbo/lunbo.jpg');"></span>
				<span class="slide" style="background-image: url('${pageContext.request.contextPath}/front/img/lumbo/23.jpg');"></span>
				<span class="slide" style="background-image: url('${pageContext.request.contextPath}/front/img/lumbo/lunbo01.jpg');"></span>
			</div>
			<div class="right">

				<div>
					<div class="title"><span class="glyphicon glyphicon-list"></span>公告信息</div>
					<ul>
						<li><a href="#">【新品上架】 </a></li>
						<li><a href="#">【限时抢购】 </a></li>
						<li><a href="#">【会员日特惠】 </a></li>
						<li><a href="#">【售后服务升级】 </a></li>
						<li><a href="#">【物流提速通知】 </a></li>
						<li><a href="#">【公益行动】 </a></li>
						<li><a href="#">【安全购物提醒】 </a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<div id="className" class="goodsType">


	</div>

	<div class="backTop"><a href="#top" class="glyphicon glyphicon-chevron-up"></a></div>
	</body>
</html>
