<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>订单详情</title>
    <!--引入Bootstrap-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/npm.js" ></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/top.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/orderInfo.css" />



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
            <td><span class="inp">${ordercode.ordercode}</span></td>
        </tr>
        <td>交易日期：</td>
        <td><span class="inp">${ordercode.orderdate}</span></td>
        </tr>
        <tr>
            <td>寄件人信息：</td>
            <td>
                <span class="inp">八六三软件</span>
                <span class="inp">68636863</span>
            </td>
        </tr>
        <tr>
            <td>寄件地址：</td>
            <td><span class="inp">${ordercode.address}</span></td>
        </tr>
        <tr>
            <td>收件人信息：</td>
            <td>
                <span class="inp">${ordercode.username}</span>
                <span class="inp">${ordercode.tel}</span>
            </td>
        </tr>
        <tr>
            <td>收件地址：</td>
            <td><span class="inp">河南省郑州市高新区xx小区xx号楼1单元503</span></td>
        </tr>
        <tr>
            <td>邮政编码：</td>
            <td><span class="inp">${ordercode.postcode}</span></td>
        </tr>
        <tr>
            <td>支付方式：</td>
            <td><span class="inp">${ordercode.pay}</span></td>
        </tr>
        <tr>
            <td>运输方式：</td>
            <td><span class="inp">${ordercode.carry}</span></td>
        </tr>
        <tr>
            <td>备注说明：</td>
            <td><span class="inp">${ordercode.bz}</span></td>
        </tr>
    </table>
    <div class="goodsList">
        <c:forEach items="${god}" var="good" varStatus="tt">
        <div class="good_info">
            <div class="img">
                <a href="${pageContext.request.contextPath}/front/page/goodInfo.jsp" target="_blank"><img src="${pageContext.request.contextPath}/front/img/goods/${good.picture}"></a>
            </div>
            <div class="info">
                <div class="name">${good.goodsname}</div>
                <div class="price_num"><span>${good.price}</span> x <span>${good.numbers}</span></div>
            </div>
        </div>
        </c:forEach>
    </div>

    <div style="clear: both;"></div>
    <div colspan="2" style="text-align: center;" class="menu">
        <a href="javascript:void(0)" onclick="history.back(-1)">返回</a>
        <a href="${pageContext.request.contextPath}/index.jsp">继续购物</a>
        <a href="#" >取消订单</a>
        <a href="javascript:void(0)">申请退款</a>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/city.js" ></script>
</html>
