<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/front/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="main">



  <div class="top">
    <p><a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">公告管理</a> |<a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">商品管理</a> | <a href="${pageContext.request.contextPath}/back/memberManageList.jsp">会员管理</a> | <a href="${pageContext.request.contextPath}/back/orderManageList.jsp">订单管理</a> | <a href="manage1.jsp">退出后台</a></p>
  </div>
  <div class="adm_con">
    <div class="bg_3">
      <div class="bg_1">
        <div class="bg_2">
          <h3><img src="${pageContext.request.contextPath}/back/images/25.gif" class="flo_right" /><img src="${pageContext.request.contextPath}/back/images/23.gif" class="flo_left" /><span>会员管理</span></h3>
          <div class="padd">
            <p> [会员详细信息]</p>
            <div style="width:500px;height:300px;margin:10px auto;">
              <p>会 员 名： ${me.username}</p>
              <p>真实姓名： ${me.truename}</p>
              <p>城&nbsp;&nbsp;&nbsp;&nbsp;市： ${me.city}</p>
              <p>地&nbsp;&nbsp;&nbsp;&nbsp;址： ${me.address}</p>
              <p>邮政编码： ${me.postcode}</p>
              <p>证件号码： ${me.cardno}</p>
              <p>电&nbsp;&nbsp;&nbsp;&nbsp;话： ${me.tel}</p>
              <p>E-mail： ${me.email}</p>
              <p class="ali_center">
                <img src="${pageContext.request.contextPath}/back/images/29.gif" onclick="window.location.href='${pageContext.request.contextPath}/back/memberManageList.jsp'" style="border:0; cursor:hand"/>
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
