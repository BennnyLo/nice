<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>新闻</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" type="text/css" href="qianduan/css/news.css">
</head>
<body>
<div class="header_fixed">
	<div class="header text_center">
		<span class="back"><img src="qianduan/images/back.png">返回</span>
		新闻 
		<span class="close">关闭</span>
	</div>

</div>

<div class="content">
	<div class="container">
		<div class="news_title">
			<h3>${news.title}</h3>
			<div class="news_title_b"><span class="news_from">完美校园</span> <span class="news_date fr">12-26 11:34</span> </div>
		</div>	
		<div class="news_bd">
				<img src="${news.imgUrl}">
				<!-- <p>这次“健康校园 免费早餐”的活动也得到了各行业的大力支持，西麦为本次活动提供独家赞助，并为学生提供了特价的西麦麦片作为早餐，学生登录完美校园，在京东学生特价专区就可以享受到大学生的专属特惠。</p>
				<p>在中国校园联盟的指导下，这次活动也得到了微博校园、京东金融、中兴校园、暴风体育、全国校园文学联盟、PU口袋校园、BOSS直聘、乐视商城、乐视影业、第二世校园、平行世界、英语流利说、实习僧、59store等优质校园品牌企业的大力支持。</p>
				<p>这次“健康校园 免费早餐”的活动也得到了各行业的大力支持，西麦为本次活动提供独家赞助，并为学生提供了特价的西麦麦片作为早餐，学生登录完美校园，在京东学生特价专区就可以享受到大学生的专属特惠。</p> -->
				<p>${news.detail}</p>

				<img src="${news.imgUrl}">
				<!-- <p>这次“健康校园 免费早餐”的活动也得到了各行业的大力支持，西麦为本次活动提供独家赞助，并为学生提供了特价的西麦麦片作为早餐，学生登录完美校园，在京东学生特价专区就可以享受到大学生的专属特惠。</p>
				<p>在中国校园联盟的指导下，这次活动也得到了微博校园、京东金融、中兴校园、暴风体育、全国校园文学联盟、PU口袋校园、BOSS直聘、乐视商城、乐视影业、第二世校园、平行世界、英语流利说、实习僧、59store等优质校园品牌企业的大力支持。</p>
				<p>这次“健康校园 免费早餐”的活动也得到了各行业的大力支持，西麦为本次活动提供独家赞助，并为学生提供了特价的西麦麦片作为早餐，学生登录完美校园，在京东学生特价专区就可以享受到大学生的专属特惠。</p> -->
				<p>${news.detail}</p>
		</div>	
	</div>
</div>
</body>
</html>