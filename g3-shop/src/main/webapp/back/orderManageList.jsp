<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="styles/style.css" rel="stylesheet" type="text/css" />
  <script src="${pageContext.request.contextPath}/front/js/jquery-3.7.1.min.js"></script>
  <script>
    function splitePage(flg){
      var curr=$("#curr").html();//当前页
      var total=$("#total").html();
      console.log(curr)
      console.log(total)

      if(flg=="pre"){
        if (parseInt(curr)-1==0){
          curr=1;
        }else {
          curr=parseInt(curr)-1;
        }
        flg=curr;
      }else  if (flg=="next"){
        if (parseInt(curr)+1>=parseInt(total)){
          curr=total;
        }else {
          curr=parseInt(curr)+1;
        }
        flg=curr;
      }
      createDom(flg);
    }

    $(function (){
      createDom(1);
    })

    function createDom(flg){
      $.ajax({
        url:"${pageContext.request.contextPath}/backList?currpage="+flg,
        type:"post",
        dataType:"json",
        success:function (data){

            console.log(data)
          var htmltr="<tr>\n" +
                  "                <td scope=\"col\" width=\"15%\"> 订单号 </td>\n" +
                  "                <td scope=\"col\" width=\"8%\"> 品种数 </td>\n" +
                  "                <td scope=\"col\" width=\"15%\"> 收件人 </td>\n" +
                  "                <td scope=\"col\" width=\"15%\"> 付款方式 </td>\n" +
                  "                <td scope=\"col\" width=\"15%\"> 运送方式 </td>\n" +
                  "                <td scope=\"col\" width=\"15%\"> 订货日期 </td>\n" +
                  "                <td scope=\"col\" width=\"5%\"> 执行</td>\n" +
                  "                <td scope=\"col\" width=\"5%\"> 操作</td>\n" +
                  "              </tr>";
          $("table tbody").html($(htmltr));


          data.backList.forEach(function (ele){
            if (ele.enforce==1){
              ele.enforce="已执行"
            }else {
              ele.enforce='<img src="${pageContext.request.contextPath}/back/images/30.gif" onclick="window.location.href="#""" style="border:0; cursor:hand;"/>'
            }
          var htmltr=" <tr>\n" +
                    "                <td><a href='${pageContext.request.contextPath}/infoBack?ordercode="+ele.id+"'>"+ele.ordercode+"</a></td>\n" +
                    "                <td>"+ele.bnumber+"</td>\n" +
                    "                <td>"+ele.username+"</td>\n" +
                    "                <td>"+ele.pay+"</td>\n" +
                    "                <td>"+ele.carry+"</td>\n" +
                    "                <td>"+ele.orderdate+"</td>\n"  +
                    "                <td>"+ele.enforce+"</td>\n" +
                    "                <td><a href=\"javascript:chulituihuo()\">处理退货</a>  <a href=\"javascript:tuikuan()\">退款</a>  <a href=\"javascript:guanbi()\">关闭</a></td>\n" +
                    "              </tr>";
            $("#page").html("");
            var a1 = '<a href="javascript:splitePage(1)">首页 </a> ';
            var a2 = "<a href='javascript:splitePage(\"pre\")'>上一页 |</a>";
            var a3 = "<a href='javascript:splitePage(\"next\")'>下一页 </a>";
            var a4 = "<a href=\"javascript:splitePage("+data.totalpage+")\">尾页 </a>";
            var spanHtml = "<span>&emsp;当前第<span id=\"curr\">"+data.currpage+"</span>页，&emsp;总共有<span id=\"total\">"+data.totalpage+"</span>页</span>";

            $("#page").append($(a1))
            $("#page").append($(a2))
            $("#page").append($(a3))
            $("#page").append($(a4))
            $("#page").append($(spanHtml));
            $("table tbody").append($(htmltr));

          })
          }
        })
    }
  </script>
</head>
<body>
<div class="main">

  <script type="text/javascript">
    function chulituihuo(){
      window.open("chulituihuo.html","","width=600,height=600,top=300,left=300");
    }
    function tuikuan(){
      window.open("tuikuan.html","","width=600,height=600,top=300,left=300");
    }
    function guanbi(){
      window.open("guanbi.html","","width=600,height=600,top=300,left=300");
    }

  </script>

  <div class="top">
    <p><a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">公告管理</a> |<a href="${pageContext.request.contextPath}/back/goodsManageList.jsp">商品管理</a> | <a href="${pageContext.request.contextPath}/back/memberManageList.jsp">会员管理</a> | <a href="${pageContext.request.contextPath}/back/orderManageList.jsp">订单管理</a> | <a href="${pageContext.request.contextPath}/manage1.jsp">退出后台</a></p>
  </div>
  <div class="adm_con">
    <div class="bg_3">
      <div class="bg_1">
        <div class="bg_2">
          <h3><img src="images/25.gif" class="flo_right" /><img src="images/23.gif" class="flo_left" /><span>订单管理</span></h3>
          <div class="padd">
            <p class="ali_center">

              <div id="page" align="center" >
          </div>
            </p>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td scope="col" width="15%"> 订单号 </td>
                <td scope="col" width="8%"> 品种数 </td>
                <td scope="col" width="15%"> 收件人 </td>
                <td scope="col" width="15%"> 付款方式 </td>
                <td scope="col" width="15%"> 运送方式 </td>
                <td scope="col" width="15%"> 订货日期 </td>
                <td scope="col" width="5%"> 执行</td>
                <td scope="col" width="5%"> 操作</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
