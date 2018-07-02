<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>登陆</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<script type="text/javascript">
function change(){  
    var img1=document.getElementById("checkImg");  
    img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime(); //加时间戳防止缓存  
}  
</script>
	<div class="login_head">
		<div class="container">
			<img src="images/logo.png">
		</div>
	</div>

	<div class="login_banner">
		<div class="container">
			<div class="login">
                <div class="login_in">
                	<form action="Userslogin" method="post">
                    <div class="login_h">后台登陆</div>
                    <div class="user_login">
                        <input type="text" placeholder="账号" value="${users.name}" name="name">
                        <input type="text" placeholder="密码" name="pwd">
                    </div>
                    <div class="img_code">
		<span class="fieldSet">
			<input type="text" id="checkcode" name="checkcode" class="text captcha" maxlength="4" autocomplete="off">
			<img id="checkImg" class="captchaImage"src="${pageContext.request.contextPath}/checkImg.action" onclick="change()"title="点击更换验证码">
		</span>
                    </div>
                    <!-- <div class="login_btn">登陆</div> -->
                    <input class="login_btn" type="submit" value="登    陆">
                    <br>
                    <span style="color:red;">${msg}</span>
                </div>
                
            </div>
		</div>
	</div>

	<div class="login_end text_center">版权所有&copy;：新开普电子股份有限公司  豫ICP备08102576号  未经授权本站内容禁止私自转载使用！</div>
</body>
</html>