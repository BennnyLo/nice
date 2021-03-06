<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>完美校园新闻</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" type="text/css" href="qianduan/css/news.css">
</head>
<body>
	<div class="header_fixed">
		<div class="header text_center">
			<span class="back"><img src="qianduan/images/back.png">返回</span>
			校内新闻 
			<span class="close">关闭</span>
		</div>
	
	<!-- 导航 -->
    <nav>
    	<div class="nav_scrollbar text_center">
	        <ul>
	            <li class="nav_scrollbar_on"><a href="javascript:void(0);">教务处</a></li>
	            <li><a href="javascript:void(0);">教务处</a></li>
	            <li><a href="javascript:void(0);">教务处</a></li>
	            <li><a href="javascript:void(0);">图书馆里</a></li>
	            <li><a href="javascript:void(0);">图书馆里我我我</a></li>

	        </ul>
	    </div>
	    <div class="nav_more text_center dn"><img src="qianduan/images/nav_icon.png"></div>
    </nav>
    </div>
    <div class="news_list">
    	<div class="container">
    		<!-- 列表 i -->
    		<c:forEach items="${newslist}" var="news">
    		<a href="Appqianduan2?newsId=${news.newsId}">
	    	<div class="news_list_content" id="xinwen">
	    		<div class="news_list_content_left fl">
	    			<img src="${news.imgUrl}">
	    		</div>
	    		<div class="news_list_content_right fr">
	    			<h3>${news.title}</h3>
	    			<!-- <p>11月10日，中国高等教育学会教育信息化分会、河南省教育厅相关领导以及清华大学、北京大学、复旦大学、同济大学等优秀高等学府的学者、教师和企业界代表的广泛参与，大家共聚一堂，......  </p> -->
	    		</div>
    			<div class="date fr">${news.createTime}</div>
	    	</div>
	    	</a>
	    	</c:forEach>
	    	<!-- 列表 i
	    	<div class="news_list_content">
	    		<div class="news_list_content_left fl">
	    			<img src="qianduan/images/14.jpg">
	    		</div>
	    		<div class="news_list_content_right fr">
	    			<h3>11月10日，中国高等教育学会教育信息化分会、河南省教育厅相关领导以及清华大学、</h3>
	    			<p>11月10日，中国高等教育学会教育信息化分会、河南省教育厅相关领导以及清华大学、北京大学、复旦大学、同济大学等优秀高等学府的学者、教师和企业界代表的广泛参与，大家共聚一堂，......  </p>
	    			<div class="date fr">2016-12-23</div>
	    		</div>
	    	</div>
	    	列表 i
	    	<div class="news_list_content">
	    		<div class="news_list_content_left fl">
	    			<img src="qianduan/images/14.jpg">
	    		</div>
	    		<div class="news_list_content_right fr">
	    			<h3>同济大学等优秀高等学府的学者、教师和企业界代表的广泛参与，大家共聚一堂.</h3>
	    			<p>11月10日，中国高等教育学会教育信息化分会、河南省教育厅相关领导以及清华大学、北京大学、复旦大学、同济大学等优秀高等学府的学者、教师和企业界代表的广泛参与，大家共聚一堂，......  </p>
	    			<div class="date fr">2016-12-23</div>
	    		</div>
	    	</div>
	    	列表 i
	    	<div class="news_list_content">
	    		<div class="news_list_content_left fl">
	    			<img src="qianduan/images/14.jpg">
	    		</div>
	    		<div class="news_list_content_right fr">
	    			<h3>玩笑升级完美校园</h3>
	    			<p>11月10日，中国高等教育学会教育信息化分会、河南省教育厅相关领导以及清华大学、北京大学、复旦大学、同济大学等优秀高等学府的学者、教师和企业界代表的广泛参与，大家共聚一堂，......  </p>
	    			<div class="date fr">2016-12-23</div>
	    		</div>
	    	</div> -->

	    	<div class="load_more text_center">点击加载更多</div>

    	</div>
    </div>

    <!-- popup nav -->
    <div class="popup_nav dn">
    	<!-- <div class="popup_nav_close"></div> -->
    	div.a_
    	<ul>
    		<li>教务处123123</li>
    		<li>教务处123</li>
    		<li>教务处123123</li>
    		<li>教务处123123</li>
    		<li>教务处123123</li>
    		<li>教务处3</li>
    		<li>教务处2</li>
    		<li>教务处1</li>
    	</ul>
    </div>

	<!-- 异常页 -->
	<div class="load_error text_center dn">
		<img src="qianduan/images/error.png">
		<div>宝宝别急哦…… <br/>点击我重新加载吖……</div>
	</div>
	<script type="text/javascript">
   					 var img=document.getElementById("xinwen"); 
   					 var a=document.getElementById("q");
   						 img.onclick=function(){
   							 a.click();	 
   						 }			
			</script>
</body>
<script type="text/javascript" src="qianduan/js/jquery.js"></script>
<script type="text/javascript" src="qianduan/js/main.js"></script>
</html>