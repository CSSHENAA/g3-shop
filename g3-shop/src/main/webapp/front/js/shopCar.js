//<script src="/js/jquery-3.7.1.min.js"></script>
// 点击商品选中
function checkGoods(obj){
	var goods = obj.parentNode.parentNode;
	var isCheck = goods.getAttribute("doCheck");

	if(isCheck == "true"){
		goods.setAttribute("doCheck", "false");
	} else {
		goods.setAttribute("doCheck", "true");
	}
	totalPrice();
	checkGoodsNum();
}

function checkAllGoods(){
	var goods = document.querySelectorAll(".goods");
	for(var i = 0; i < goods.length; i++){
		goods[i].setAttribute("doCheck", "true");
	}
	totalPrice();
	checkGoodsNum();
}

function unCheckAllGoods(){
	var goods = document.querySelectorAll(".goods");
	for(var i = 0; i < goods.length; i++){
		goods[i].setAttribute("doCheck", "false");
	}
	totalPrice();
	checkGoodsNum();
}


//反选
function toggleCheckAllGoods() {
	var goods = document.querySelectorAll(".goods");
	for (var i = 0; i < goods.length; i++) {
		// 切换 doCheck 的值
		var isChecked = goods[i].getAttribute("doCheck") === "true";
		goods[i].setAttribute("doCheck", !isChecked);
	}
	totalPrice();
	checkGoodsNum();
}


// 修改商品数量
// function changeCount(flg, obj,id,num){
// 	var inp;
// 	var val = 1;
// 	if(flg == 1){
// 		inp = obj.previousElementSibling;
// 		var temp = inp.value;
// 		val = parseFloat(temp) + 1;
// 	} else if(flg == 0){
// 		inp = obj.nextElementSibling;
// 		var temp = inp.value;
// 		val = parseFloat(temp) - 1;
// 	} else if(flg == 2){
// 		inp = obj;
// 		val = parseFloat(obj.value);
// 	}
//
// 	if(val <= 0){
// 		val = 1;
// 	}
//
// 	inp.value = val;
//
// 	 var url = "${pageContext.request.contextPath}/update?id="+id+"&num="+num+"";
// 	//var url = "${pageContext.request.contextPath}/update?id="+id+"";
// 	console.log(url)
// 	updateGoodsCount(url);
//
// 	function updateGoodsCount(url) {
// 		$.ajax({
// 			// url:"${pageContext.request.contextPath}/update?id="+id,
// 			url:url,
// 			type:"post",
// 			dataType:"json",
// 			success: function(data) {
// 				if (data!=0){
// 					// 处理响应（如显示成功消息等）
// 					console.log('商品数量更新成功');
// 				}else {
//
// 					console.log('商品数量修改失败');
// 				}
//
// 			},
// 			error: function(xhr, status, error) {
// 				// 处理错误
// 				console.error('商品数量更新失败', error);
// 			}
// 		})
// 	}
//
//
// 	totalPrice();
// 	goodsTotalPrice(val, obj);
//
// }
//修改购物车中商品数量
function changeCount(flg, obj, id,url1) {
	console.log(id);
	var inp;
	var val = 1;
	if (flg == 1) {
		inp = obj.previousElementSibling;
		var temp = inp.value;
		val = parseFloat(temp) + 1;
	} else if (flg == 0) {
		inp = obj.nextElementSibling;
		var temp = inp.value;
		val = parseFloat(temp) - 1;
	} else if (flg == 2) {
		inp = obj;
		val = parseFloat(obj.value);
	}

	if (val <= 0) {
		val = 1;
	}

	inp.value = val;

	// 这里更新 num 为计算后的 val
	var num = val;

	console.log("更新后："+num);
//"${pageContext.request.contextPath}/update?id=${eleDom.id}&num=${eleDom.number}"
	// 拼接 URL
	var url =url1+ "/update?id=" + id + "&num=" + num;
	//console.log(url);

	// 发送 AJAX 请求
	updateGoodsCount(url);

	totalPrice();
	goodsTotalPrice(val, obj);
}

// 发送 AJAX 请求
function updateGoodsCount(url) {
	$.ajax({
		url: url,
		type: "POST",
		dataType: "json",
		success: function (data) {
		},
	});
}




// 计算单个商品价格
function goodsTotalPrice(num, obj){
	var price = parseFloat(obj.parentNode.previousElementSibling.childNodes[1].innerHTML);
	var result = parseFloat(num) * price;
	obj.parentNode.nextElementSibling.childNodes[1].innerHTML = result;
}


function goodsPrice(){
	var goodsCount = document.querySelectorAll(".goodsCount");

	for(var i = 0; i < goodsCount.length; i++){
		var obj = goodsCount[i];
		var num = obj.value;

		goodsTotalPrice(num, obj);
	}
}
goodsPrice();

// 计算购物车总价
function totalPrice(){
	var goodsList = document.querySelectorAll(".goods");
	var goodsCount = document.querySelectorAll(".goodsCount");
	var goodsPrice = document.querySelectorAll(".goodsPrice");

	var result = 0;

	for(var i = 0; i < goodsList.length; i++){
		var goods = goodsList[i].getAttribute("doCheck");
		if(goods == "true"){
			var count = goodsCount[i].value;
			var price = goodsPrice[i].innerHTML;

			result += parseFloat(count) * parseFloat(price);
		}
	}

	var obj = document.querySelector(".totalPrice").innerHTML = result;
}

totalPrice();


function checkGoodsNum(){
	var goodsList = document.querySelectorAll(".goods");
	var num = 0;
	for(var i = 0; i < goodsList.length; i++){
		var goods = goodsList[i];
		var attr = goods.getAttribute("doCheck");

		if(attr == "true"){
			num++;
		}
	}
	document.querySelector(".checkedGoodsNum").innerHTML = num;
}
checkGoodsNum();

// function sendOrder(){
// 	// 获取所有的单价
// 	var prices = document.querySelectorAll(".goodsPrice");
// 	// 获取所有数量
// 	var counts = document.querySelectorAll(".goodsCount");
// 	// 获取所有的单个商品的总价
// 	var totals = document.querySelectorAll(".goodsTotalPrice");
//
// 	var jsonObj = new Object();
//
// 	// 创建数组用于存放商品对象
// 	var goodsArray = new Array();
//
// 	for(var i = 0; i < prices.length; i++){
// 		var price = prices[i].innerHTML;
// 		var count = counts[i].value;
// 		var total = totals[i].innerHTML;
//
// 		// 创建商品对象
// 		var temp = new Object();
// 		temp.price = price;
// 		temp.count = count;
// 		temp.total = total;
//
// 		goodsArray.push(temp);
// 	}
//
// 	jsonObj.goods = goodsArray;
//
// 	// 把对象转成JSON字符
// 	var jsonStr = JSON.stringify(jsonObj);
// 	// URL转码
// 	var res = encodeURI(jsonStr);
// 	// location.href = "http://localhost:8080/Servlet/json?result=" + res;
// }
// sendOrder();



