<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
<script type="text/javascript">
	var editor = null;//声明一个全局变量来完成对编辑框的操作
	window.onload = function(){
		editor = CKEDITOR.replace("editArea");
	}
</script>
<script type="text/javascript">
	function save(){
		editor.updateElement();
		editorform.action = "saveBlog";
	}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编写文章</title>
</head>
<body>
	<form id="editorform" method="post">
		<textarea rows="50" cols="50" name="editArea" style="width: 50%"></textarea>
		<input type="submit" onclick="save()" value="保存">
	</form>
</body>
</html>