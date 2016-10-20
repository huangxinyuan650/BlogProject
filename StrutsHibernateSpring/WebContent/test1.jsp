<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="hxy" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
哈哈哈哈哈哈哈哈哈哈哈哈哈哈
<!-- 
<hxy:property value="huang.userName"/>
 -->
 <hxy:iterator id="hh" value="reList">
 	<hxy:property value="#hh.userName"/><br>
 </hxy:iterator>
</body>
</html>