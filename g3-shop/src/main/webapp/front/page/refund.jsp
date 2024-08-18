<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>申请退款/退货</title>
    <!--引入Bootstrap-->
    <link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="../bootstrap/js/npm.js" ></script>

    <link rel="stylesheet" href="../css/top.css" />
    <link rel="stylesheet" href="../css/orderInfo.css" />
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
    <table border="0">
        <tr>
            <td>订单号：</td>
            <td><span class="inp">20190101000100010001</span></td>
        </tr>
        <td>交易日期：</td>
        <td><span class="inp">20190101 10:20:30</span></td>
        </tr>
    </table>
    <div class="goodsList">
        <div class="good_info">
            <div class="img">
                <a href="goodInfo.jsp" target="_blank"><img src="../img/goods/kunrou.jpg"></a>
            </div>
            <div class="info">
                <div class="name">黑粉们专属坤肉</div>
                <div class="price_num"><span>￥200.0</span> x <span>3</span></div>
            </div>
        </div>
        <div class="good_info">
            <div class="img">
                <a href="goodInfo.jsp" target="_blank"><img src="../img/goods/kunrou.jpg"></a>
            </div>
            <div class="info">
                <div class="name">黑粉们专属坤肉</div>
                <div class="price_num"><span>￥200.0</span> x <span>3</span></div>
            </div>
        </div>
    </div>
    <div style="clear: both;"></div>
    <div colspan="2" style="text-align: center;" class="menu">
        <a href="javascript:void(0)" onclick="history.back(-1)">返回</a>
        <a href="../../index.jsp">继续购物</a>
        <a href="javascript:void(0)">取消订单</a>
        <a href="javascript:void(0)">申请退款</a>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/city.js" ></script>
</html>