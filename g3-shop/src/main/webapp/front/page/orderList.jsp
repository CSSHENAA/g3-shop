<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="utf-8" />
  <title>查看订单</title>
  <!--引入Bootstrap-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap-theme.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap.min.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/bootstrap.min.js" ></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/npm.js" ></script>
  <script src="${pageContext.request.contextPath}/front/js/jquery-3.7.1.min.js" ></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/top.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/orderList.css" />

  <script>
    function splitePage(flg){
      var curr = $("#curr").html();
      if(flg=="pre"){
        if (parseInt(curr)-1==0){
          curr=1;
        }else {
          curr=parseInt(curr)-1;
        }
        flg=curr;
      }else if (flg=="next"){
        if (parseInt(curr)+1 >= parseInt(${totalpage})){
          curr=${totalpage};
        }else {
          curr=parseInt(curr)+1;
        }
        flg=curr;
      }
      location.href="list?currpage="+flg;
    }
  </script>

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
  <form action="list" method="post">
  <div class="tj">
    <span>订单号：</span><input type="text" name="ordercode" value="${ordercode}" placeholder="订单号！" class="inp">
    <span>收件人姓名：</span><input type="text" name="username" value="${username}" placeholder="收件人姓名！" class="inp">
    <input type="submit" value="查询订单" class="but">
  </div>
  </form>
  <table border="1">
    <thead>
    <tr>
      <td>订单号</td>
      <td>商品种类</td>
      <td>收件人</td>
      <td>下单日期</td>
      <td>金额</td>
      <td>订单状态</td>
      <td>操作</td>
    </tr>
    </thead>
    <tbody>

      <c:forEach items="${list}" var="man" varStatus="id">
         <tr>
           <td><a href="${pageContext.request.contextPath}/listinfo?ordercode=${man.ordercode}" title="点击查看详情">${man.ordercode}</a></td>
           <td>${man.bnumber}</td>
           <td>${man.username}</td>
           <td>${man.orderdate}</td>
           <td>${man.allprice}</td>
           <td>
             <c:if test="${man.enforce=='1'}">已完成</c:if>
             <c:if test="${man.enforce=='0'}">处理中</c:if>
           </td>
           <td>
               <a href="javascript:void(0)" class="del">删除订单</a>
               <a href="javascript:void(0)">取消订单</a>
               <a href="refund.jsp">申请退款</a>
               <a href="refund.jsp">申请退货</a>
           </td>
         </tr>
      </c:forEach>
    </tbody>
  </table>
  <div class="menu">
    <a href="javascript:splitePage(1)" class="toPage">首页</a>
    <a href="javascript:splitePage('pre')" class="toPage">上一页</a>
    <span id="curr" class="toPage"> ${currpage}/${totalpage}</span>
    <a href="javascript:splitePage('next')" class="toPage">下一页</a>
    <a href="javascript:splitePage(${totalpage})" class="toPage">尾页</a>
  </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/city.js" ></script>
</html>
