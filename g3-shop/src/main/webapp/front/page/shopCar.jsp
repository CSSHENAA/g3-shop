<%--
  Created by IntelliJ IDEA.
  User: 菠萝°没有蜜
  Date: 2024/7/24
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>购物车</title>
    <!--引入Bootstrap-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/bootstrap.min.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/bootstrap/js/npm.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/top.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/shopCar.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>

    <script type="text/javascript">
//异步分页
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
            //     请求页面--》向后台发送请求
            // location.href="list?currpage="+flg;
            creatDom(flg);
        }
//分页
        $(function (){
            creatDom(1);
        });
//分页
        function creatDom(flg){
            // alert(flg)
            $.ajax({
                url:"${pageContext.request.contextPath}/shopCar11?currpage="+flg,
                type:"post",
                dataType:"json",
                success:function (data){
                   // console.log(99999999)
                    console.log(data)
                    // if (data.code=="100"){
                    //     console.log("66666666666")
                    //     location.href="login.jsp";
                    //     return;
                    // }
                    var htmldiv =  "<div class=\"top_menu\">\n" +
                        "        <a href=\"javascript:void(0)\" style=\"background-color: blueviolet;\" onclick=\"checkAllGoods()\">全选</a>\n" +
                        "        <a href=\"javascript:void(0)\" style=\"background-color: blueviolet;\"onclick=\"toggleCheckAllGoods()\">反选</a>\n" +
                        "        <a href=\"javascript:void(0)\" style=\"background-color: blueviolet;\" onclick=\"deleteAll()\" >批量删除</a>\n" +
                        "        <a href=\"${pageContext.request.contextPath}/index.jsp\" style=\"background-color: blueviolet;\">继续购物</a>\n" +
                        "        <a href=\"javascript:void(0)\" onclick=\"sendOrder()\" style=\"background-color: blueviolet;\">提交订单</a>\n" +
                        "    </div>";
                    $(".body").html($(htmldiv));
                    data.list.forEach(function(eleDom,index){
                        console.log(eleDom+"---"+index);

                        var htmldiv= " <div class=\"goods\" doCheck=\"false\">\n" +
                            "            <div class=\"img\">\n" +
                            "                <img src=\"${pageContext.request.contextPath}/front/img/goods/"+eleDom.picture+"\" onclick=\"checkGoods(this)\">\n" +
                            "            </div>\n" +
                            "            <div class=\"info\">\n" +
                            "                <div class=\"title\"><a href=\"goodInfo.jsp\" target=\"_blank\">"+eleDom.goodsname+"</a></div>\n" +
                            "                <a class=\"menu glyphicon glyphicon-remove\" name=\"delete\" href=\"${pageContext.request.contextPath}/delete?id="+eleDom.id+"\" ></a>\n" +
                            "                <div class=\"price\">\n" +
                            "               <input type=\"hidden\"  name=\"id\"  value=\""+eleDom.id+"\" >\n "+
                            "                    <div>￥<span class=\"goodsPrice\">"+eleDom.price+"</span></div>\n" +
                            "                    <div class=\"num\">\n" +
                            "                        <a class=\"glyphicon glyphicon-minus\" onclick=\"changeCount(0, this,"+eleDom.id+",'${pageContext.request.contextPath}')\" ></a>\n" +
                            "                        <input type=\"text\" name=\"num\" value=\""+eleDom.number+"\" class=\"goodsCount\" onblur=\"changeCount(2, this)\"/>\n" +
                            "                        <a class=\"glyphicon glyphicon-plus\" onclick=\"changeCount(1, this,"+eleDom.id+",'${pageContext.request.contextPath}')\" ></a>\n" +
                            "                    </div>\n" +
                            "                </div>\n" +
                            "            </div>\n" +
                            "          </div>";
                       // "<input type=\"text\" name=\"num\" value=\""+eleDom.number+"\" class=\"goodsCount\" onblur=\"changeCount(2, this)\"/>";
                        $(".body").append($(htmldiv));

                    });

                    var a0 =  " <div class=\"result\">\n" +
                        "        <a href=\"javascript:splitePage(1)\">首页</a>\n" +
                        "        <a href=\"javascript:splitePage('pre')\">上一页</a>\n" +
                        "        <a href=\"javascript:splitePage("+data.currpage+")\"><span id='curr'>"+data.currpage+"</span>/<span id='total'>" + data.totalpage + "</span></a>\n" +
                        "        <a href=\"javascript:splitePage('next')\">下一页</a>\n" +
                        "        <a href=\"javascript:splitePage(" + data.totalpage + ")\">尾页</a>\n" +
                        "        <span style=\"color:orangered;font-weight:bold;font-size:18px ; float: right;\">总价：￥<span class=\"totalPrice\" name=\"totalPrice\" style=\"display:inline-block; text-align: left;\"></span></span></span>\n"+
                        "    </div>";

                    $(".body").append($(a0));


                }
            });
        }
        //批量删除
        function  deleteAll(){
            let ids = [];
            //获取商品id
            $("input[name=id]").filter(function() {
                return $(this).closest('.goods').attr('doCheck') === 'true';
            }).each(function() {
               ids.push($(this).val());
            });



         // console.log(ids);
            if (ids.length > 0) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/deleteAll?ids="+ids,
                    type: "POST",
                    data: { ids: ids.join(",") },
                    success: function(response) {
                        // 处理删除成功的逻辑
                        creatDom($("#curr").text());
                    }
                });
            } else {
                alert("请选择要删除的商品");
            }

        };

         function sendOrder() {
              // console.log("1111");
             let ids = [];
             // 获取选中商品的id
             $("input[name=id]").filter(function() {
                 return $(this).closest('.goods').attr('doCheck') === 'true';
             }).each(function() {
                 ids.push($(this).val());
             });
            // url: "${pageContext.request.contextPath}/deleteAll?ids="+ids,

             var totalPrice = $('.body .totalPrice').text();
             console.log(totalPrice);

            if (ids.length > 0) {
              // location.href="${pageContext.request.contextPath}/sendOrder?ids="+ids;

               <%--location.href="${pageContext.request.contextPath}/order?ids="+ids;--%>
                location.href="${pageContext.request.contextPath}/order?totalPrice="+totalPrice+"&ids="+ids;
            }else{
                alert("请选择要结算的商品")
            }

         }

    </script>
</head>
<body>
<span style="color: red;font-size: 30px" >${msg}</span> <br>
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
<div id="div2" class="body">
    <div class="top_menu">
        <a href="javascript:void(0)" style="background-color: blueviolet;" onclick="checkAllGoods()">全选</a>
        <a href="javascript:void(0)" style="background-color: blueviolet;"onclick="toggleCheckAllGoods()">反选</a>
        <a href="javascript:void(0)" style="background-color: blueviolet;">批量删除</a>
        <a href="${pageContext.request.contextPath}/index.jsp" style="background-color: blueviolet;">继续购物</a>
        <a  onclick="sendOrder()" style="background-color: blueviolet;">提交订单</a>

    </div>

    <div style="clear: both;"></div>
    <input type="hidden" value="">

    <div style="clear: both;"></div>

</div>

<div>
</div>
</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/shopCar.js" ></script>
</html>
