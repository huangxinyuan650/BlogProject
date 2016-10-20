<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 
<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>

<script type="text/javascript">
    var editor = null;
    window.onload = function(){
        editor = CKEDITOR.replace('textbox1'); //参数‘content’是textarea元素的name属性值，而非id属性值
        editor.setData("huangxinyuan");
    }
</script>

<script type="text/javascript">
    function save(){
        editor.updateElement(); //非常重要的一句代码
        //前台验证工作
        //提交到后台
        session.setAttribute("userName");
        articalform.action="test";
    }
</script>
 -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>



	<form action="testOne">
		<input type="text" name="huang.userName">
		<input type="submit" value="提交">
	</form>
	<!-- <%=request.getSession().getAttribute("userName") %>
	<label name="userName" id="userName" value="huangxinyuan"/>
	<form id="articalform" method="post">
		<textarea rows="50" cols="50" id="textbox1" name="textbox1"></textarea>
		<input type="submit" value="OK" onclick="save()">	
	</form>
	 -->
</body>
</html>