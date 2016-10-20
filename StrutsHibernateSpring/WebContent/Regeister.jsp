<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regeister</title>
<script type="text/javascript">
	function regeister(){
		
	}
</script>
</head>
<body>
	<table style="width: 100%;" border="0">
		<tr>
			<p align="center"><font color = "blue" size = "10pt">用户注册</font></p>
		</tr>
		<tr>
			<td style = "width: 30%"/>
			<td style = "width: 20%" align="center">用户名：</td>
			<td style = "width: 20%" align="left"><input id = "userName" type = "text"></td>
			<td style = "width: 30%"/>
		</tr>
		<tr>		
			<td style = "width: 30%"/>
			<td style = "width: 20%" align="center">密&nbsp&nbsp&nbsp&nbsp码：</td>
			<td style = "width: 20%" align="left"><input id = "password" type = "password"></td>
			<td style = "width: 30%"/>
		</tr>
		<tr>
			<td style = "width: 30%"/>
			<td style = "width: 20%" align="right"><input id = "ok" value = "确认" type = "button" onclick="regeister()"></td>
			<td style = "width: 20%" align="left"><input id = "cancel" value = "取消" type = "button"></td>
			<td style = "width: 30%"/>
		</tr>
	</table>
</body>
</html>