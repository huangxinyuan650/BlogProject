<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
	<style type="text/css">
	body{
		background: #3fa0bd;
	}
	#login{
		width: 350px;
		height: 350px;
		background: #34495e;
		border-radius: 175px;
		margin: 100px auto;

	}
	#login #logincon{
		width: 240px;
		height: 200px;
		
		padding-left: 60px;
		padding-top: 80px;
		position: relative;
	}
	#login #logincon .txt{
		height: 44px;
		width: 188px;
		background: #4f6475 url("image/1.png") no-repeat 14px;
		color: #ffffff;
		font-size: 15px;
		font-family: "微软雅黑";
		padding-left: 50px;
		border: 1px solid #637686;
		border-radius: 5px;
	}
	#login #logincon .txt2{
		background-image: url("image/2.png");
		margin-top: 25px;
	}
	#login #logincon .but{
		height: 40px;
		width: 114px;
		background: #00c9aa;
		border: 0px;
		border-radius: 5px;
		font-size: 20px;
		font-family: "微软雅黑";
		margin-top: 25px;
		float: right;
		cursor: pointer;
	}
	#login #logincon a.reg{
		width: 120px;
		height: 120px;
		background: #00c9aa;
		display: block;
		text-align: center;
		line-height: 120px;
		font-size: 24px;
		color: #ffffff;
		font-family: "微软雅黑";
		text-decoration: none;
		border-radius: 60px;
		filter:Alpha(opacity=80);
		-moz-opacity:0.8;
		opacity: 0.8;
		position: absolute;
		top: 250px;
		left: 0px;
	}
	</style>

</head>
<body>
	<div id="login">
		<div id="logincon">
			<form action="login"><input type="hidden" name="arid" value="这是个隐藏的id"/>
				<div align="center"><label><font color="#FFFFFF" size="6">用户登录</font></label></div><br>
				&nbsp;&nbsp;&nbsp;&nbsp;<label>用户名：</label><input type="text" class="txt" name="user.userName"/><br>
				&nbsp;&nbsp;&nbsp;&nbsp;<label>密&nbsp;&nbsp;码：</label><input type="password" class="txt txt2" name="user.password"/><br>
				<div align="center"><input type="submit" class="but" value="登录" /></div>				
			</form>
				<a href="regester_h.html" class="reg">注册</a>
		</div>
	</div>
</body>
</html>