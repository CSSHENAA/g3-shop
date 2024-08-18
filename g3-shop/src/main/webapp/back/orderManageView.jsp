<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/back/orderManageView.jsp"></script>
    <script src="${pageContext.request.contextPath}/front/js/jquery-3.7.1.min.js" ></script>

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
          <h3><img src="${pageContext.request.contextPath}/back/images/25.gif" class="flo_right" /><img src="${pageContext.request.contextPath}/back/images/23.gif" class="flo_left" /><span>订单管理</span></h3>
          <div class="padd">
            <p> [订单详细信息]</p>
            <div style="width:500px;height:300px;margin:10px auto;">
              <p>会员姓名： ${ordercode.username}</p>
              <p>订 单 号： ${ordercode.ordercode}</p>
              <p>收 件 人： ${ordercode.username}</p>
              <p>收件地址： ${ordercode.address}</p>
              <p>邮政编码： ${ordercode.postcode}</p>
              <p>收件电话： ${ordercode.tel}</p>
              <p>备&nbsp;&nbsp;&nbsp;&nbsp;注： ${ordercode.bz}</p>
              <table width="400" border="0" cellspacing="0" cellpadding="0">
                <tr>
                 <td width="50%" >商品名称</td>
                  <td width="25%" >单&nbsp;&nbsp;价</td>
                  <td width="25%" >数&nbsp;&nbsp;量</td>
                </tr>
                  <c:forEach items="${goods}" var="woman" varStatus="id">
                      <tr>
                          <td>${woman.goodsname}</td>
                          <td>${woman.price}</td>
                          <td>${woman.numbers}</td>
                      </tr>
                  </c:forEach>
              </table>
              <p class="ali_center">
                <img src="${pageContext.request.contextPath}/back/images/29.gif" onclick="window.location.href='${pageContext.request.contextPath}/back/orderManageList.jsp'" style="border:0; cursor:hand"/>
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

