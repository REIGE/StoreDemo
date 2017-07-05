<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>展示订单</title>
<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/my.js"></script>
<script type="text/javascript">
	function findProduct(orderid) {
		var btn = document.getElementById("btn_" + orderid);
		var div = document.getElementById("div_" + orderid);
		if (btn.value != "关闭") {
			div.style.display = "block";
			//1.得到XMLHttpRequest对象
			var xmlhttp = getXmlHttpRequest();

			//2.注册回调函数
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

					//5.得到返回的json数据
					var jsonobj = eval("(" + xmlhttp.responseText + ")");

					var table = "<table border='1' align='center'><tr><td>商品名称</td><td>商品价格</td><td>商品描述</td></tr>";

					for ( var i = 0; i < jsonobj.length; i++) {

						table += "<tr><td>" + jsonobj[i].name + "</td><td>"
								+ jsonobj[i].price + "</td><td>"
								+ jsonobj[i].description + "</td></tr>"
					}
					table += "</table>";

					div.innerHTML = table;
				}
				;
			};

			//3.open
			xmlhttp.open("GET",
					"${pageContext.request.contextPath}/findProductByOrder?id="
							+ orderid);
			//4 send
			xmlhttp.send(null);

			btn.value = "关闭";
		} else {
			btn.value = "查看订单中商品";
			//document.getElementById("div_" + orderid).innerHTML="";

			div.style.display = "none";
		}
	};
</script>

</head>

<body>

	<c:forEach items="${orders}" var="order" varStatus="vs">
		<br>
		<br>
		<br>
		<table border='1' align="center">
			<tr>
				<td>订单编号</td>
				<td>订单总价</td>

				<td>订单信息</td>
				<td>送货地址</td>
				<td>所属用户</td>
				<td>订单状态</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>${order.id}</td>
				<td>${order.money }</td>
				<td><input type='button' value="查看订单中商品" id="btn_${order.id}"
					onclick="findProduct('${order.id}')">
					<div id="div_${order.id}"></div>
				</td>
				<td>${order.receiverinfo }</td>
				<td>${order.username}【${order.nickname}】</td>
				<td>
				
					<c:if test="${order.paystate==0 }">
						<a href='${pageContext.request.contextPath}/pay.jsp?orderid=${order.id}&money=${order.money}'>未支付</a>
					</c:if>
					
					<c:if test="${order.paystate!=0}">
						已支付
					</c:if>
				</td>
				<td>
				<c:if test="${order.paystate==0}">
				<a href="${pageContext.request.contextPath}/delOrder?orderid=${order.id}">删除</a>
				</c:if>
				
				<c:if test="${order.paystate!=0}">
				删除
				</c:if>
				</td>
			</tr>
		</table>
		<br>
		<br>
	</c:forEach>


</body>
</html>
