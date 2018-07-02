<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!-- 用c:if 导入这句话-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<style type="text/css">
			table{
				background-color: black;
				margin: 0 auto;
			}
			
			td{
			background-color: white;}
		</style>
<body>

	<h1 style="text-align: center;">编辑用户信息</h1>
		<form action="UpdateUserServlet" method="post">
				<input type="hidden" name="userId" value="${userInfo.userId}"/>
			<table cellspacing="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="userName" value="${userInfo.userName}"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="userPwd" value="${userInfo.userPwd}"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
					<c:if test="${userInfo.userSex=='男'}">
					<input type="radio" name="userSex" value="男" checked="checked"/>男
					<input type="radio" name="userSex" value="女">女
					</c:if>
					<c:if test="${userInfo.userSex=='女' }">
					<input type="radio" name="userSex" value="男">男
					<input type="radio" name="userSex" value="女" checked="checked">女
					</c:if>	
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="number" name="userAge" value="${userInfo.userAge }"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="更新"/></td>
				</tr>
			</table>
		</form>
</body>
</html>