<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>

<%--引入--%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.soft.entity.Goods" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">



  <div class="top">
    <p><a href="goodsManageList.jsp">公告管理</a> |<a href="goodsManageList.jsp">商品管理</a> | <a href="memberManageList.jsp">会员管理</a> | <a href="orderManageList.jsp">订单管理</a> | <a href="../manage1.jsp">退出后台</a></p>
  </div>
  <div class="adm_con">
    <div class="bg_3">
      <div class="bg_1">
        <div class="bg_2">
          <h3><img src="${pageContext.request.contextPath}/back/images/25.gif" class="flo_right" /><img src="${pageContext.request.contextPath}/back/images/23.gif" class="flo_left" /><span>订单管理</span></h3>
          <div class="padd">
            <p> [商品详细信息]</p>
            <div style="width:500px;height:300px;margin:10px auto;">
              <p>商品名称： <span>${goods.goodsname}</span></p>
              <p>价&nbsp;&nbsp;&nbsp;&nbsp;格： <span>${goods.price}</span></p>
              <%
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str = sdf.format(((Goods)request.getAttribute("goods")).getCredate());
              %>
              <p>发布日期： <span><%=str%></span></p>
              <p>商品简介： <span>${goods.introduce}</span></p>
              <p class="ali_center">
                <img src="${pageContext.request.contextPath}/back/images/29.gif" onclick="window.location.href='${pageContext.request.contextPath}/back/goodsManageList.jsp'" style="border:0; cursor:hand"/>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
