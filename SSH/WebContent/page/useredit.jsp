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
<!-- 用户管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>用户管理 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>添加用户</label></li>
                    </ul>
                    <form action="Newsupdateusers" method="post" >
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                            <div class="news_title">
                            <input type="hidden" name="users.userId" value="${users.userId}">
                                <label class="text_center">用户名</label>
                                <input type="text" placeholder="填写用户名" name="users.name" value="${users.name}">
                            </div>
                            <div class="news_title">
                               <label class="text_center">密码</label>
                               <input type="text" placeholder="填写密码" name="users.pwd" value="${users.pwd}">
                            </div>
                            <input class="release_news_ok_btn text_center" type="submit" value="保    存">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>