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
<!-- 新闻管理 -->
            <div class="AccountManagement_c" id="NewsManagement_c">
                <h3>新闻管理 
                    <div class="amcl fr">
                        <select class="fl NewsManagement_search">
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                            <option>教务处</option>
                        </select>
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="images/search.png"></div>
                    </div> 
                </h3>
                <div class="list" id="release_news">
                    <ul class="list_h">
                        <li class="b80"><label>发布新闻</label></li>
                    </ul>
                    		<form action="Newsupdatenews" method="post" >
                    <div class="list_b_c" id="release_news_in">
                        <div class="release_news">
                        <input type="hidden" name="news.newsId" value="${news.newsId}">
                         <input type="hidden" name="news.createTime"value="${news.createTime}" />
                            <div class="news_title">
                                <label class="text_center">标题</label>
                                <input type="text" name="news.title" value="${news.title}">
                            </div>
                            <div class="column_name">
                                <label class="text_center">栏目</label>
                                <select class="column_name_release" name="news.item.itemId">
                               <c:forEach items="${itemlist}" var="item">
									<option value="${item.itemId}"<c:if test="${news.item.itemId eq item.itemId}" >selected</c:if>>${item.name}</option>
								</c:forEach>
                                </select>
                            </div>
                            <textarea class="release_news_content" rows="50" cols="60" name="news.detail" >${news.detail}</textarea>  
                            <br>   
                            <input class="release_news_ok_btn text_center" type="submit" value="发      布">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>