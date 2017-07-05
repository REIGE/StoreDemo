<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>订单页面</title>

<link rel="stylesheet" href="style.css" type="text/css" media="screen" />

</head>

<body>
	<br>
	<br>
	<br>
	<div align="center">
		<form action="${pageContext.request.contextPath}/addOrder" method="get">
			送货地址:<input type="text" name="receiverinfo"><br>
			<c:set value="0" var="money"></c:set>

			<table border='1'>
				<tr>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>数量</td>
				</tr>

				<c:forEach items="${cart}" var="c">
					<tr>
						<td>${c.key.name}</td>
						<td>${c.key.price}</td>
						<td>${c.value}</td>
					</tr>
					<c:set value="${money+c.key.price*c.value}" var="money"></c:set>
				</c:forEach>
			</table>



			订单总价:<input type="text" readonly="readonly" value="${money}"
				name="money"><br> <input type="submit" value="生成订单">
		</form>
	</div>
</body>
</html>
