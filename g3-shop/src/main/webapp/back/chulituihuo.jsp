<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="inc/style.css" rel="stylesheet" type="text/css" />
  <link href="styles/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="chulituihuo">

  <form id="memberModify_action" name="memberRegisterForm" onsubmit="return true;" action="" method="post">

    <table width="60%" border="0" cellspacing="0" cellpadding="0" align = "center">
      <tr>
        <td>处理结果
        </td>
        <td><select><option value="同意退货">同意退货</option><option value="拒绝退货">拒绝退货</option></select></td>
      </tr>
      <tr>
        <td>退货地址
        </td>
        <td><input type="text" name="member.cardno" value="河南省林州市（从商家信息里拉过来）" id="memberModify_action_member_cardno"/></td>
      </tr>
      <tr>
        <td>退货理由
        </td>
        <td><textarea name="member.address" rows="4" cols="30" id="memberModify_action_member_address"/></textarea></td>
      </tr>
      <tr>
        <td><img   src="images/12.gif"   onclick="document.memberRegisterForm.submit();" style= "CURSOR:hand"/>
        </td>
        <td><img   src="images/13.gif"   onclick="document.memberRegisterForm.reset();" style= "CURSOR:hand"/></td>
      </tr>

    </table>
  </form>
</div>
</body>
</html>
