<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<!-- 栏目管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>栏目管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="栏目名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>添加栏目</label></li>
                    </ul>
                    <form action="Newsupdateitem" method="post" >
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                            <input type="hidden" name="item.itemId" value="${item.itemId}">
                                <label class="text_center">栏目名</label>
                                <input type="text" placeholder="填写栏目名" name="item.name" value="${item.name}">
                            </div>
                            <input class="release_news_ok_btn text_center" type="submit" value="保    存">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>