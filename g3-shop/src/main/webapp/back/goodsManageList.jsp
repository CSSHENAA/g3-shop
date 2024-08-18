<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--导入标签类库--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>好物商城</title>
  <link href="${pageContext.request.contextPath}/back/styles/style.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script>
        function splitePage(flg) {

            // 获取当前页数
            var curr=  $("#curr").html();

            // 总页数
            var total=  $("#total").html();

            if (flg=="pre"){
                if (parseInt(curr)-1==0){
                    curr=1;
                }else{
                    curr=parseInt(curr)-1;
                }
                flg=curr;

            }else if(flg=="next"){
                if (parseInt(curr)+1>=parseInt(total)){
                    curr=total;
                }else{
                    curr=parseInt(curr)+1;
                }
                flg=curr;
            }


            // //     请求页面--》向后台发送请求
            //     location.href="list?currpage="+flg;

            createDom(flg);
        }

        $(function(){
            createDom(1);
        })

        function deleteGoods(goodid) {
           location.href="${pageContext.request.contextPath}/managedelete?id="+goodid;
        }

        function updateGoods(goodid) {
            location.href="${pageContext.request.contextPath}/manageupdate?id="+goodid;
        }


        function createDom(flg) {
            $.ajax({
                url:"${pageContext.request.contextPath}/managelist?currpage="+flg,
                type:"post",
                dataType:"json",
                success:function(data){
                    console.log(data);

                    // 清空表格中的数据
                    var htmltr= "<tr>\n" +
                        "            <td>商品名称</td>\n" +
                        "            <td>价格</td>\n" +
                        "            <td>发布时间</td>\n" +
                        "            <td>修改</td>\n" +
                        "            <td>删除</td>\n" +
                        "        </tr>";
                    $("table tbody").html($(htmltr));

                    //     动态创建表格
                    // 遍历data.list，每遍历一次 就产生一个tr对象
                    data.list.forEach(function(eleDom,index){
                        console.log(eleDom+"-------------"+index);
                        var date = new Date(eleDom.credate);
                        var mydate = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
                        <%--var htmltr="<tr>\n" +--%>
                        <%--    "        <td>"+eleDom.goodsname+"</td>\n" +--%>
                        <%--    "        <td>"+eleDom.price+"</td>\n" +--%>
                        <%--    "        <td>"+mydate+"</td>\n" +--%>
                        <%--    "        <td><a href=${pageContext.request.contextPath}\"manageupdate?id="+eleDom.id+"\">修改</a></td>\n" +--%>
                        <%--    // "<td><img src='images/34.gif' onclick='window.location.href=\"manageupdate?id="+eleDom.id+"' style='border:0; cursor:hand;'/></td>"+--%>
                        <%--    // "<td><img src='images/35.gif' onclick='window.location.href=\"managedelete?id="+eleDom.id+" ' style='border:0; cursor:hand;'/></td>"+--%>
                        <%--    // "<td><img src='images/35.gif' href=\'managedelete?id='"+eleDom.id+" style='border:0; cursor:hand;'/></td>"+--%>
                        <%--    "        <td><a href=\"managedelete?id="+eleDom.id+"\">删除</a></td>\n" +--%>
                        <%--    "    </tr>";--%>
                        var goodid =eleDom.id;
                        var htmltr="<tr>\n" +
                            "        <td><a href=\"${pageContext.request.contextPath}/managelist?id="+goodid+"\">"+eleDom.goodsname+"</a></td>\n" +
                            <%--"        <td><a href\"${pageContext.request.contextPath}/managelist?id="+goodid+"\">"+eleDom.goodsname+"</a></td>\n" +--%>
                            "        <td>"+eleDom.price+"</td>\n" +
                            "        <td>"+mydate+"</td>\n" +
                            // "        <td>"+eleDom.img+"</td>\n" +

                            "<td><img src=\"${pageContext.request.contextPath}/back/images/34.gif\" onclick=updateGoods("+goodid+") style=\"border:0; cursor:hand;\"/></td>\n" +
                            "  <td><img src=\"${pageContext.request.contextPath}/back/images/35.gif\" onclick=deleteGoods("+goodid+") style=\"border:0; cursor:hand;\"/></td>\n"+

                           /* "<td><img src='images/34.gif' onclick='window.location.href=\"manageupdate?id="+eleDom.id+"' style='border:0; cursor:hand;'/></td>"+
                            "<td><img src="images/35.gif" onclick=deleteGoods("+goodid+"); style="border:0; cursor:pointer;"/></td>"+*/
                            <%--"        <td><a href=${pageContext.request.contextPath}/manageupdate?id="+eleDom.id+"\>修改</a></td>\n" +--%>
                            <%--"        <td><a href=${pageContext.request.contextPath}/managedelete?id="+eleDom.id+"\>删除</a></td>\n" +--%>
                            "    </tr>";


                        $("table tbody").append($(htmltr));
                    })
                    console.log(data.currpage);
                    // 清空div中的内容
                    $("#page").html("");
                    var a1 = '<a href="javascript:splitePage(1)">首页&nbsp;&nbsp;&nbsp;</a>';
                    var a2 = "<a href='javascript:splitePage(\"pre\")'>上一页&nbsp;&nbsp;&nbsp;</a>";
                    var a3 = "<a href='javascript:splitePage(\"next\")'>下一页&nbsp;&nbsp;&nbsp;</a>";
                    var a4 = "<a href=\"javascript:splitePage("+data.totalpage+")\">尾页&nbsp;&nbsp;&nbsp;</a>";
                    var spanHtml = "<span>显示：当前第<span id=\"curr\">"+data.currpage+"</span>页，总共有<span id=\"total\">"+data.totalpage+"</span>页</span>";
                    console.log(spanHtml)


                    $("#page").append($(a1))

                    $("#page").append($(a2))


                    $("#page").append($(a3))

                    $("#page").append($(a4))
                    $("#page").append($(spanHtml));

                }
            })
        }




    </script>

    <style>
        #page{
            color: #3e8f3e;
            align-content: center;
            position: relative;
            left: 200px;
        }

    </style>



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

              <div id="page">

              </div>
            <p>[ 商品列表 ] [ <a href="toGoodsManageAdd.jsp">添加商品信息</a>]</p>

<span style="color: red">${msg}</span><br>
<%--            <table border="1px" style="border-collapse: collapse;width: 600px;height: 400px; ">--%>
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr style="color: aqua">
                <td>商品名称</td>
                <td>价格</td>
                <td>发布日期</td>
                <td>修改</td>
                <td>删除</td>
              </tr>

<%--<c:forEach items="${back/managelist}" var="man" varStatus="st">&ndash;%&gt;--%>
<%--          <tr>--%>
<%--              <td>${man.goodsname}</td>--%>
<%--              <td>${man.price}</td>--%>
<%--              <td>--%>

<%--                  <fmt:formatDate value="${man.credate}" pattern="yyyy-MM-dd "></fmt:formatDate>--%>
<%--              </td>--%>
<%--              <td><a href="update?id=${man.id}">修改</a></td>--%>
<%--              <td><a href="delete?id=${man.id}">删除</a></td>--%>
<%--          </tr>--%>
<%--      </c:forEach>--%>
            </table>


          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>

