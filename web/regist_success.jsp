<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'regist.jsp' starting page</title>
<meta http-equiv="refresh" content="3;url=http://www.estore.com">
<link rel="stylesheet" href="style.css" type="text/css" media="screen" />

<script type="text/javascript">
	var interval;
	window.onload = function() {
		interval = window.setInterval("fun()", 1000); //设置1秒调用一次fun函数
	};

	function fun() {
		var time = document.getElementById("s").innerHTML;

		//判断如果等于0了，不在进行调用fun函数，
		if (time == 0) {
			window.clearInterval(interval);
			return;
		}

		document.getElementById("s").innerHTML = (time - 1);
	}
</script>
</head>

<body>
	<h1>
		注册成功，<span id="s">3</span>秒后跳转到<a href='http://www.estore.com'>首页</a>
	</h1>
</body>
</html>
