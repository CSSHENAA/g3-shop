<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/front/js/jquery-3.7.1.min.js"></script>

  <script>
    function splitePage(flg){

      var curr=$("#curr").html();
      var total=$("#total").html();
      if (flg=="pre")
      {
        if (parseInt(curr)-1==0)
        {
          curr=1;
        }
        else
        {
          curr=parseInt(curr)-1;
        }
        flg=curr;
      }
      else if (flg=="next")
      {
        if (parseInt(curr)+1>=parseInt(total))
        {
          curr=total;
        }
        else
        {
          curr=parseInt(curr)+1;
        }
        flg=curr;
      }

      // location.href="list?currpage="+flg;

      createDom(flg);

    }

    $(function (){
      createDom(1);
    })

    function createDom(flg){
      $.ajax({
        url:"${pageContext.request.contextPath}/memberManageList?currpage="+flg,
        type:"post",
        dataType:"json",
        success:function (data){
          console.log(data);

          var htmltr= "<tr>\n" +
              "  <td scope=\"col\" width=\"10%\"> 用户名 </td>\n" +
              "  <td scope=\"col\" width=\"10%\"> 真实姓名 </td>\n" +
              "  <td scope=\"col\" width=\"15%\"> 城 市 </td>\n" +
              "  <td scope=\"col\" width=\"10%\"> 电 话 </td>\n" +
              "  <td scope=\"col\" width=\"20%\"> E-mail </td>\n" +
              "  <td scope=\"col\" width=\"10%\"> 冻结/解冻 </td>\n" +
              "</tr>"
          $("table tbody").html($(htmltr))
          data.list.forEach(function (eleDom,index){
              if (eleDom.freeze==0)
              {
                  eleDom.freeze=' <img alt="正常" src="${pageContext.request.contextPath}/back/images/32.gif" onclick="tt(1,'+eleDom.id+')" style="border:0; cursor:hand;"/>'
              }
              else {
                  eleDom.freeze=' <img alt="正常" src="${pageContext.request.contextPath}/back/images/31.gif" onclick="tt(0,'+eleDom.id+');" style="border:0; cursor:hand;"/>'

              }

            console.log(eleDom+"--------"+index);
            var htmltr = "<tr>\n" +
                    "    <td><a href='${pageContext.request.contextPath}/memberManageView?id="+eleDom.id+"'>"+eleDom.username+"</a></td>\n" +
                    "    <td>"+eleDom.truename+"</td>\n" +
                    "    <td>"+eleDom.city+"</td>\n" +
                    "    <td>"+eleDom.tel+"</td>\n" +
                    "    <td>"+eleDom.email+"</td>\n" +
                    "    <td>"+eleDom.freeze+"</td>\n" +
                    "</tr>"

            $("table tbody").append($(htmltr));
          })

          $("#page").html("");
          var a1 = '<a href=\"javascript:splitePage(1)\">首页&nbsp;&nbsp;&nbsp;</a>';
          var a2 = "<a href=\'javascript:splitePage(\"pre\")'>上一页&nbsp;&nbsp;&nbsp;</a>";
          var a3 = "<a href=\'javascript:splitePage(\"next\")'>下一页&nbsp;&nbsp;&nbsp;</a>";
          var a4 = "<a href=\"javascript:splitePage("+data.totalpage+")\">尾页&nbsp;&nbsp;&nbsp;</a>";
          var spanHtml = "<span>当前第<span id=\"curr\">"+data.currpage+"</span>页&nbsp;&nbsp;&nbsp;共有<span id=\"total\">"+data.totalpage+"</span>页</span>";
          console.log(spanHtml);
          $("#page").append($(a1))
          $("#page").append($(a2))
          $("#page").append($(a3))
          $("#page").append($(a4))
          $("#page").append($(spanHtml))
        }
      })
    }


    function tt(flg,id) {
        window.location.href="${pageContext.request.contextPath}/memberUpdate?freeze="+flg+"&id="+id;
    }
  </script>

</head>
<body>
<div class="main">


    <div class="top">
        <p><a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">公告管理</a> |<a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">商品管理</a> | <a href="${pageContext.request.contextPath}/back/memberManageList.jsp">会员管理</a> | <a href="${pageContext.request.contextPath}/back/orderManageList.jsp">订单管理</a> | <a href="${pageContext.request.contextPath}/manage1.jsp">退出后台</a></p>
    </div>
  <div class="adm_con">
    <div class="bg_3">
      <div class="bg_1">
        <div class="bg_2">
          <h3><img src="images/25.gif" class="flo_right" /><img src="images/23.gif" class="flo_left" /><span>会员管理</span></h3>
          <div class="padd">

              <div div id="page" style="text-align: center">

              </div>

            <p> [会员列表]</p>

            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td scope="col" width="10%"> 用户名 </td>
                <td scope="col" width="10%"> 真实姓名 </td>
                <td scope="col" width="10%"> 用户等级 </td>
                <td scope="col" width="15%"> 城 市 </td>
                <td scope="col" width="10%"> 电 话 </td>
                <td scope="col" width="20%"> E-mail </td>
                <td scope="col" width="10%"> 冻结/解冻 </td>
              </tr>

<%--              <tr>--%>
<%--                <td><a href="memberManageView.jsp">1</a></td>--%>

<%--                <td>1</td>--%>
<%--                <td>黄金会员</td>--%>
<%--                <td></td>--%>
<%--                <td></td>--%>
<%--                <td>1@163.com</td>--%>
<%--                <td>--%>
<%--                  <img alt="正常" src="images/32.gif" onclick="window.location.href='#'" style="border:0; cursor:hand;"/>--%>
<%--                </td>--%>
<%--              </tr>--%>

<%--              <tr>--%>
<%--                <td><a href="memberManageView.jsp">wahaha</a></td>--%>

<%--                <td>懒洋洋</td>--%>
<%--                <td>钻石会员</td>--%>
<%--                <td>上海</td>--%>
<%--                <td>021-789462136</td>--%>
<%--                <td>yangyang@sohu.com</td>--%>
<%--                <td>--%>
<%--                  <img alt="正常" src="images/32.gif" onclick="window.location.href='#'" style="border:0; cursor:hand;"/>--%>
<%--                </td>--%>
<%--              </tr>--%>

<%--              <tr>--%>
<%--                <td><a href="memberManageView.jsp">caoqing</a></td>--%>

<%--                <td>caoqing</td>--%>
<%--                <td>普通会员</td>--%>
<%--                <td>ttt</td>--%>
<%--                <td>15136289598</td>--%>
<%--                <td>caoq@163.com</td>--%>
<%--                <td>--%>
<%--                  <img alt="正常" src="images/32.gif" onclick="window.location.href='#'" style="border:0; cursor:hand;"/>--%>
<%--                </td>--%>
<%--              </tr>--%>

            </table>

          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
