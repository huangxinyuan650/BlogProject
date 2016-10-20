<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input id="userName" type="text" name="userName"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="password" type="password" name="password"></td>
			</tr>
			<tr>
				<input id="ok" type="submit" name="ok" value="登录">
			</tr>
		</table>
	</form>
	<s:a href="login.action">登录</s:a><br>
	<s:file name="UploadFileName" accept="text/*" label="文件上传"/>
</body>
</html>