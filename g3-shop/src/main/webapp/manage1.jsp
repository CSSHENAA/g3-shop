<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>好物商城</title>
  <link href="back/styles/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<span style="color: red">${msg}</span> <br>
<form namespace="/" id="adminLogin" name="loginForm" action="backlogin" method="post">
  <div class="login_bg">
    <p>
      用户名：<input type="text" name="sname" size="12" value="" id="adminLogin_shopManager_manager"/>
      密码：<input type="password" name="pass" size="12" id="adminLogin_shopManager_password"/><br>
      <img src="back/images/19.gif" onclick="document.loginForm.submit();" style="border:0; cursor:pointer; margin-top:16px; margin-left:100px"/>
      <img src="back/images/22.gif" onclick="window.location.href='index.jsp';" style="border:0; cursor:pointer;margin-left:50px"/>
    </p>

    <div style="width:446px;height:30px;margin:30px auto;">

    </div>
  </div>
</form>


</body>
</html>
