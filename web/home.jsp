<%@page import="java.net.URLDecoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US"
	xml:lang="en">
<head>
<!--
    Created by Artisteer v2.6.0.35446
    Base template (without user's data) checked by http://validator.w3.org : "This page is valid XHTML 1.0 Transitional"
    -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Estore购物商城</title>

<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" href="style.ie6.css" type="text/css" media="screen" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" href="style.ie7.css" type="text/css" media="screen" /><![endif]-->

<script type="text/javascript" src="script.js"></script>
<script type="text/javascript">
	var focus_width = 632;
	var focus_height = 320;
	var picPath;
	var linkUrl = "";
	var swfPath = "adImage.swf";
	var sp = "|";
	var banners = new Array("images/screen1.jpg", "images/screen2.jpg",
			"images/screen3.jpg", "images/screen4.jpg", "images/screen5.jpg",
			"images/screen6.jpg");
	var links = new Array("#", "#", "#", "#", "#", "#");

	for ( var i = 0; i < banners.length; i++) {
		if (i == banners.length - 1) {
			sp = "";
		}
		picPath += banners[i] + sp;
		var index = picPath.indexOf("undefined");
		if (index != -1) {
			picPath = picPath.substr(index + 9, picPath.length);
		}
		linkUrl += links[i] + sp;
	}
	
	window.onload=function(){//页面加载成功后跳用这个函数。
		var username=document.getElementById("username");
		window.de
		username.value=window.decodeURIComponent("${cookie.remember.value}","utf-8");
	};
	
	//根据id查询商品
	function findProductById(id){
		location.href="http://www.estore.com/findProductById?id="+id;
	};
</script>
</head>
<body>
	<div id="art-main">
		<div class="art-sheet">
			<div class="art-sheet-tl"></div>
			<div class="art-sheet-tr"></div>
			<div class="art-sheet-bl"></div>
			<div class="art-sheet-br"></div>
			<div class="art-sheet-tc"></div>
			<div class="art-sheet-bc"></div>
			<div class="art-sheet-cl"></div>
			<div class="art-sheet-cr"></div>
			<div class="art-sheet-cc"></div>
			<div class="art-sheet-body">
				<div class="art-header">
					<div class="art-header-png"></div>
					<div class="art-header-jpeg"></div>
					<div class="art-logo">
						<h1 id="name-text" class="art-logo-name">
							<a href="#">Estore购物商城</a>
						</h1>
						<div id="slogan-text" class="art-logo-text">快乐的购物天堂...</div>
					</div>
				</div>
				<div class="art-nav">
					<div class="l"></div>
					<div class="r"></div>
					<ul class="art-menu">
						<li><a href="#" class="active"><span class="l"></span><span
								class="r"></span><span class="t">主页</span> </a></li>
						<li><a href="#"><span class="l"></span><span class="r"></span><span
								class="t">商品分类</span> </a>
							<ul>
								<li><a href="#">图书、电子书刊、音像</a>
								</li>
								<li><a href="#">电子数码</a>
									<ul>
										<li><a href="#">家用电器</a>
										</li>
										<li><a href="#">手机数码</a>
										</li>
										<li><a href="#">电脑、办公</a>
										</li>
									</ul></li>
								<li><a href="#">家居、家具、家装、厨具</a>
								</li>
							</ul></li>
						<li><a href="#"><span class="l"></span><span class="r"></span><span
								class="t">关于我们</span> </a>
								
								</li>
								
								
						
						<c:if test="${not empty user }">
							<li>
								当前用户:${user.username}
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/logout">注销</a>
							</li>
						</c:if>
						<c:if test="${ empty user }">
							<li>
								未登录
							</li>
						</c:if>
					
						
					</ul>
				</div>
				<div class="art-content-layout">
					<div class="art-content-layout-row">
						<div class="art-layout-cell art-content">
							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">商品促销信息</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<script type="text/javascript" src="mutilpleFlash.js"></script>
											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-post">
								<div class="art-post-tl"></div>
								<div class="art-post-tr"></div>
								<div class="art-post-bl"></div>
								<div class="art-post-br"></div>
								<div class="art-post-tc"></div>
								<div class="art-post-bc"></div>
								<div class="art-post-cl"></div>
								<div class="art-post-cr"></div>
								<div class="art-post-cc"></div>
								<div class="art-post-body">
									<div class="art-post-inner art-article">
										<div class="art-postmetadataheader">
											<h2 class="art-postheader">热卖商品销售中</h2>
										</div>
										<div class="art-postcontent">
											<!-- article-content -->
											<p>
												<span class="art-button-wrapper"> <span class="l">
												</span> <span class="r"> </span> <a class="art-button"
													href="javascript:void(0)">更多商品...</a> </span>
											</p>
											<div class="cleared"></div>
											<div class="art-content-layout overview-table">
												<div class="art-content-layout-row">
												<c:forEach items="${ps}" var="p" varStatus="vs">
													<div class="art-layout-cell">
														<div class="overview-table-inner">
															<h4>${p.name }</h4>
															<img src="${pageContext.request.contextPath}${p.imgurl}" width="55px" height="55px"
																alt="an image" class="image" onclick="findProductById('${p.id}')"/>
															<p>价格: ￥${p.price }</p>
															<p><a href="${pageContext.request.contextPath}/findProductById?id=${p.id}">速速抢购</a></p>
														</div>
													</div>										
													<c:if test="${vs.count%5==0}">
														</div> <!-- 判断当前已经有5个商品了，这 一行结束，在重新开启一行 -->
														<div class="art-content-layout-row">
													</c:if>		
												</c:forEach>
													<!-- end cell -->
												</div>
												
												<!-- end row -->
											</div>
											<!-- end table -->

											<!-- /article-content -->
										</div>
										<div class="cleared"></div>
									</div>

									<div class="cleared"></div>
								</div>
							</div>
						</div>
						<div class="art-layout-cell art-sidebar1">
							<div class="art-vmenublock">
								<div class="art-vmenublock-body">
									<div class="art-vmenublockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">导航菜单</div>
									</div>
									<div class="art-vmenublockcontent">
										<div class="art-vmenublockcontent-tl"></div>
										<div class="art-vmenublockcontent-tr"></div>
										<div class="art-vmenublockcontent-bl"></div>
										<div class="art-vmenublockcontent-br"></div>
										<div class="art-vmenublockcontent-tc"></div>
										<div class="art-vmenublockcontent-bc"></div>
										<div class="art-vmenublockcontent-cl"></div>
										<div class="art-vmenublockcontent-cr"></div>
										<div class="art-vmenublockcontent-cc"></div>
										<div class="art-vmenublockcontent-body">
											<!-- block-content -->
											<ul class="art-vmenu">
												<li><a href="page.html?i1"><span class="l"></span><span
														class="r"></span><span class="t">主页</span> </a></li>
												<li><a href="${pageContext.request.contextPath}/addProduct.jsp"><span class="l"></span><span
														class="r"></span><span class="t">添加商品</span> </a></li>
												<li><a href="page.html?i4"><span class="l"></span><span
														class="r"></span><span class="t">查看商品</span> </a></li>
												<li><a href="http://www.estore.com/showCart.jsp"><span class="l"></span><span
														class="r"></span><span class="t">查看购物车</span> </a></li>
												<li><a href="${pageContext.request.contextPath}/showOrder"><span class="l"></span><span
														class="r"></span><span class="t">查看订单</span> </a></li>
												<li><a href="${pageContext.request.contextPath}/download"><span class="l"></span><span
														class="r"></span><span class="t">下载榜单</span> </a></li>
												<li><a href="page.html?i8"><span class="l"></span><span
														class="r"></span><span class="t">联系方式</span> </a></li>
											</ul>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">用户登陆</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="post" id="loginForm"
													action="${pageContext.request.contextPath}/login">
													<table>
														<tr>
															<td colspan="2">${requestScope["login.message"] }</td>

														</tr>
														<tr>
															<td>用户名</td>
															<td><input type="text" value="" name="username"
																id="username" /><br />
															</td>
														</tr>
														<tr>
															<td>密 码</td>
															<td><input type="password" value="" name="password"
																id="password" />
															</td>
														</tr>
														<tr>
															<td colspan="2"><input type="checkbox"
																name="remember" value="on" />记住用户 <input
																type="checkbox" name="autologin" value="on" />自动登陆</td>
														</tr>
														<tr>
															<td colspan="2"><span class="art-button-wrapper">
																	<span class="l"> </span> <span class="r"> </span> <input
																	class="art-button" type="submit" name="loginbtn"
																	value="登陆" /> </span> &nbsp;&nbsp;&nbsp;<a
																href="${pageContext.request.contextPath}/regist.jsp">注册</a>
													</table>
												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">查询商品</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<form method="get" id="newsletterform"
													action="javascript:void(0)">
													<input type="text" value="" name="email" id="s"
														style="width: 95%;" /> <span class="art-button-wrapper">
														<span class="l"> </span> <span class="r"> </span> <input
														class="art-button" type="submit" name="search" value="查询" />
													</span>

												</form>
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>

							<div class="art-block">
								<div class="art-block-body">
									<div class="art-blockheader">
										<div class="l"></div>
										<div class="r"></div>
										<div class="t">联系信息</div>
									</div>
									<div class="art-blockcontent">
										<div class="art-blockcontent-tl"></div>
										<div class="art-blockcontent-tr"></div>
										<div class="art-blockcontent-bl"></div>
										<div class="art-blockcontent-br"></div>
										<div class="art-blockcontent-tc"></div>
										<div class="art-blockcontent-bc"></div>
										<div class="art-blockcontent-cl"></div>
										<div class="art-blockcontent-cr"></div>
										<div class="art-blockcontent-cc"></div>
										<div class="art-blockcontent-body">
											<!-- block-content -->
											<div>
												<img src="images/contact.jpg" alt="an image"
													style="margin: 0 auto;display:block;width:95%" /> <br />
												<b>公司信息</b><br /> 传智播客<br /> 电子邮箱: <a
													href="mailto:yuyang@itcast.cn">yuyang@itcast.cn</a><br />
												<br /> 电话: (010)51552112 <br /> 传真: (010)51552110
											</div>
											<!-- /block-content -->

											<div class="cleared"></div>
										</div>
									</div>
									<div class="cleared"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="cleared"></div>
				<div class="art-footer">
					<div class="art-footer-t"></div>
					<div class="art-footer-l"></div>
					<div class="art-footer-b"></div>
					<div class="art-footer-r"></div>
					<div class="art-footer-body">
						<a href="#" class="art-rss-tag-icon" title="RSS"></a>
						<div class="art-footer-text">
							<p>
								<a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="#">人才招聘</a>
								| <a href="#">商家入驻</a><br /> 版权 &#169; 2012 ---. 传智播客 版权所有.
							</p>
						</div>
						<div class="cleared"></div>
					</div>
				</div>
				<div class="cleared"></div>
			</div>
		</div>
		<div class="cleared"></div>
	</div>

</body>
</html>
