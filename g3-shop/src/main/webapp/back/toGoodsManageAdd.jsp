<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
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
          <h3><img src="${pageContext.request.contextPath}/back/images/25.gif" class="flo_right" /><img src="${pageContext.request.contextPath}/back/images/23.gif" class="flo_left" /><span>商品列表</span></h3>
          <div class="padd">
            <p> [  添加商品信息]</p>
            <form namespace="/" id="goodsManageAdd" name="addForm" action="${pageContext.request.contextPath}/manageadd" method="post" enctype="multipart/form-data">
              <ul class="add">
                <li><span> 商品名称： </span>
                  <input type="text" name="goodsName" value="" id="goodsManageAdd_shopGoods_goodsname"/> <font color="red">*</font>
                </li>
                <li><span>上传图片：</span>
                  <input type="file" name="goodsImg" value="" id="goodsManageAdd_upload"/> <font color="red">*</font>
                </li>
                <li><span>价&nbsp;&nbsp;&nbsp;&nbsp;格：</span>
                  <input type="text" name="goodsPrice" value="" id="goodsManageAdd_shopGoods_price"/> <font color="red">*</font>
                </li>
                <li><span>商品类别：</span>
                  <select name="className" id="categorySelect">
                    <option value="谷物">谷物</option>
                    <option value="蔬菜">蔬菜</option>
                    <option value="水果">水果</option>
                    <option value="畜禽">畜禽</option>
                    <option value="水产品">水产品</option>
                    <option value="奶制品">奶制品</option>
                    <option value="茶叶">茶叶</option>
                    <option value="植物油">植物油</option>
                  </select>
                </li>
                <li style="height:100px;"><span>商品简介：</span>
                  <textarea name="goodsIntroduce" cols="60" rows="5" id="goodsManageAdd_shopGoods_introduce"></textarea>
                </li>
              </ul>
              <p class="ali_center">
                <img src="${pageContext.request.contextPath}/back/images/12.gif" onclick="document.addForm.submit();" style="border:0; cursor:hand"/>
                <img src="${pageContext.request.contextPath}/back/images/13.gif" onclick="document.addForm.reset();" style="border:0; cursor:hand"/>
                <img src="${pageContext.request.contextPath}/back/images/29.gif" onclick="window.location.href='${pageContext.request.contextPath}/back/goodsManageList.jsp'" style="border:0; cursor:hand"/>
              </p>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

