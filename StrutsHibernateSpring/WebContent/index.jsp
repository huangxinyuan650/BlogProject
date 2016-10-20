<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("userName") %>
<%=application.getAttribute("userName") %>
<%=request.getAttribute("userName") %>
<%=request.getParameter("userName") %>
<%=request.getSession().getAttribute("userName") %>
<%=session.getValue("userName") %>
<%=session.getAttribute("userName") %>
<%=session.getCreationTime() %>
<%=session.getAttributeNames().equals("userName") %>
<p>Hello world!!!</p>
<s:property value="#application.userName"/><br>
<s:property value="#session.userName"/>
<a href="test.jsp">huang</a>
</body>
</html>