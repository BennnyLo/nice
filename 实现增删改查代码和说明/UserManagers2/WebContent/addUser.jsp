<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;">添加用户信息</h1>
		<form action="AddUserServlet" method="post">
			<table cellspacing="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="userPwd"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<input type="radio" name="userSex" value="男"/>男
						<input type="radio" name="userSex" value="女"/>女
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input type="number" name="userAge"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="添加"/></td>
				</tr>
			</table>
		</form>
</body>
</html>