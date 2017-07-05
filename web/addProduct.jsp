<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>添加商品</title>

<link rel="stylesheet" href="style.css" type="text/css" media="screen" />

</head>

<body>
	<form action="${pageContext.request.contextPath}/addProduct"
		method="post" encType="multipart/form-data">
		<table border="1" align="center">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>商品类别</td>
				<td><select name="category">
						<option>--请选择类别-</option>
						<option value="图书音像">图书音像</option>
						<option value="家用电器">家用电器</option>
						<option value="服装衣帽">服装衣帽</option>
				</select></td>
			</tr>
			<tr>
				<td>商品数量</td>
				<td><input type="text" name="pnum"></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td><input type="file" name="f"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><textarea rows="10" cols="20" name="description"></textarea>
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="添加">&nbsp;&nbsp;
					<input type="reset" value="取消">
				</td>

			</tr>
		</table>
	</form>
</body>
</html>
