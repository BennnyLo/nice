<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 调用c:forEach写入这句话 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style type="text/css">
			td{
				background-color: white;
			}
		</style>
</head>
<body>
<h1 style="text-align: center;">用户信息</h1>
<table cellspacing="1" style="margin: 0 auto; background-color: black;">
<tr>
			<td colspan="6" align="right"><a href="addUser.jsp">添加</a></td>
			
		</tr>
		<tr>
			<td>userId</td>
			<td>userName</td>
			<td>userPwd</td>
			<td>userAge</td>
			<td>userSex</td>
			<td>删除/编辑</td>
		</tr>
		<c:forEach  items="${userInfos}" var="userInfo">
		<tr>
		<td>${userInfo.userId}</td>
		<td>${userInfo.userName}</td>
		<td>${userInfo.userPwd}</td>
		<td>${userInfo.userAge}</td>
		<td>${userInfo.userSex}</td>
		<td><a href="DeleteUserServlet?userId=${userInfo.userId}">删除</a><a href="GetUserByIdServlet?userId=${userInfo.userId}">编辑</a></td>
		</tr>
		</c:forEach>
</table>
</body>
</html>