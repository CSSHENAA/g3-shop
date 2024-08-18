<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>提交订单</title>
    <!--引入Bootstrap-->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../bootstrap/js/npm.js" ></script>

    <link rel="stylesheet" href="../css/top.css" />
    <link rel="stylesheet" href="../css/orderCode.css" />
</head>
<body>
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
<div class="body">
    <div class="order_code">
        下单成功，订单号：<a href="orderInfo.jsp" title="点击查看详情">20190101000100010001</a>
    </div>
    <div class="menu">
        <a href="../../index.jsp">继续购物</a>
        <a href="orderList.jsp">查看所有订单</a>
    </div>
</div>
</body>
</html>