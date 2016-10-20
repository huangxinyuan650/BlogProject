<%@ taglib uri="/struts-tags" prefix="hxy"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>blogshow</title>

<script type="text/javascript">
	function starta(){
		}

	function remarkSubmit(){
		criticForm.action = "saveCritic";
		alert("评论已提交！！！");
	}
</script>

<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background: #4E5869;
	margin: 0;
	padding: 0;
	color: #000;
	background-color: #F0FFFF;
}

/* ~~ 元素/标签选择器 ~~ */
ul, ol, dl { /* 由于浏览器之间的差异，最佳做法是在列表中将填充和边距都设置为零。为了保持一致，您可以在此处指定需要的数值，也可以在列表所包含的列表项（LI、DT 和 DD）中指定需要的数值。请注意，除非编写一个更为具体的选择器，否则您在此处进行的设置将会层叠到 .nav 列表。 */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* 删除上边距可以解决边距会超出其包含的 div 的问题。剩余的下边距可以使 div 与后面的任何元素保持一定距离。 */
	padding-right: 15px;
	padding-left: 15px; /* 向 div 内的元素侧边（而不是 div 自身）添加填充可避免使用任何方框模型数学。此外，也可将具有侧边填充的嵌套 div 用作替代方法。 */
}
a img { /* 此选择器将删除某些浏览器中显示在图像周围的默认蓝色边框（当该图像包含在链接中时） */
	border: none;
}

/* ~~ 站点链接的样式必须保持此顺序，包括用于创建悬停效果的选择器组在内。 ~~ */
a:link {
	color:#414958;
	text-decoration: underline; /* 除非将链接设置成极为独特的外观样式，否则最好提供下划线，以便可从视觉上快速识别 */
}
a:visited {
	color: #4E5869;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* 此组选择器将为键盘导航者提供与鼠标使用者相同的悬停体验。 */
	text-decoration: none;
}

/* ~~ 此容器包含所有其它 div，并依百分比设定其宽度 ~~ */
.container {
	border: 1;
	width: 80%;
	max-width: 1260px;/* 可能需要最大宽度，以防止此布局在大型显示器上过宽。这将使行长度更便于阅读。IE6 不遵循此声明。 */
	min-width: 780px;/* 可能需要最小宽度，以防止此布局过窄。这将使侧面列中的行长度更便于阅读。IE6 不遵循此声明。 */
	background: #F0FFFF;
	margin: 0 auto; /* 侧边的自动值与宽度结合使用，可以将布局居中对齐。如果将 .container 宽度设置为 100%，则不需要此设置。 */
}

/* ~~ 标题未指定宽度。它将扩展到布局的完整宽度。标题包含一个图像占位符，该占位符应替换为您自己的链接徽标 ~~ */
.header {
	background: #F0FFFF;
	color: #39C;
}

/* ~~ 以下是此布局的列。 ~~ 

1) 填充只会放置于 div 的顶部和/或底部。此 div 中的元素侧边会有填充。这样，您可以避免使用任何“方框模型数学”。请注意，如果向 div 自身添加任何侧边填充或边框，这些侧边填充或边框将与您定义的宽度相加，得出 *总计* 宽度。您也可以选择删除 div 中的元素的填充，并在该元素中另外放置一个没有任何宽度但具有设计所需填充的 div。

2) 由于这些列均为浮动列，因此未对其指定边距。如果必须添加边距，请避免在浮动方向一侧放置边距（例如：div 中的右边距设置为向右浮动）。在很多情况下，都可以改用填充。对于必须打破此规则的 div，应向该 div 的规则中添加“display:inline”声明，以控制某些版本的 Internet Explorer 会使边距翻倍的错误。

3) 由于可以在一个文档中多次使用类（并且一个元素可以应用多个类），因此已向这些列分配类名，而不是 ID。例如，必要时可堆叠两个侧栏 div。您可以根据个人偏好将这些名称轻松地改为 ID，前提是仅对每个文档使用一次。

4) 如果您更喜欢在右侧（而不是左侧）进行导航，只需使这些列向相反方向浮动（全部向右，而非全部向左），它们将按相反顺序显示。您无需在 HTML 源文件中移动 div。

*/
.sidebar1 {
	float: left;
	width: 25%;
	background: #F0FFFF;
	padding-bottom: 10px;
}
.content {
	padding: 10px 0;
	width: 74%;
	float: left;
}

/* ~~ 此分组的选择器为 .content 区域中的列表提供了空间 ~~ */
.content ul, .content ol { 
	padding: 0 15px 15px 40px; /* 此填充反映上述标题和段落规则中的右填充。填充放置于下方可用于间隔列表中其它元素，置于左侧可用于创建缩进。您可以根据需要进行调整。 */
}

/* ~~ 导航列表样式（如果选择使用预先创建的 Spry 等弹出菜单，则可以删除此样式） ~~ */
ul.nav {
	list-style: none; /* 这将删除列表标记 */
	border-top: 1px solid #666; /* 这将为链接创建上边框 – 使用下边框将所有其它项放置在 LI 中 */
	margin-bottom: 15px; /* 这将在下面内容的导航之间创建间距 */
}
ul.nav li {
	border-bottom: 1px solid #666; /* 这将创建按钮间隔 */
}
ul.nav a, ul.nav a:visited { /* 对这些选择器进行分组可确保链接即使在访问之后也能保持其按钮外观 */
	padding: 5px 5px 5px 15px;
	display: block; /* 这将为链接赋予块属性，使其填满包含它的整个 LI。这样，整个区域都可以响应鼠标单击操作。 */
	text-decoration: none;
	background: #F0FFFF;
	color: #000;
}
ul.nav a:hover, ul.nav a:active, ul.nav a:focus { /* 这将更改鼠标和键盘导航的背景和文本颜色 */
	background: #6F7D94;
	color: #FFF;
}

/* ~~ 脚注 ~~ */
.footer {
	padding: 10px 0;
	background: #F0FFFF;
	position: relative;/* 这可以使 IE6 hasLayout 以正确方式进行清除 */
	clear: both; /* 此清除属性强制 .container 了解列的结束位置以及包含列的位置 */
}

/* ~~ 其它浮动/清除类 ~~ */
.fltrt {  /* 此类可用于在页面中使元素向右浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: right;
	margin-left: 8px;
}
.fltlft { /* 此类可用于在页面中使元素向左浮动。浮动元素必须位于其在页面上的相邻元素之前。 */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* 如果从 #container 中删除或移出了 #footer，则可以将此类放置在 <br /> 或空 div 中，作为 #container 内最后一个浮动 div 之后的最终元素 */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
-->
</style><!--[if lte IE 7]>
<style>
.content { margin-right: -1px; } /* 此 1px 负边距可以放置在此布局中的任何列中，且具有相同的校正效果。 */
ul.nav a { zoom: 1; }  /* 缩放属性将为 IE 提供其需要的 hasLayout 触发器，用于校正链接之间的额外空白 */
</style>
<![endif]--><script type="text/javascript">
</script>
</head>
<body onload="starta()">
<div class="container">
  <div class="header" style="border-width: 0.1px;border-color: silver;border: thick;"><!-- end .header -->
    <div style="background-color: #1C86EE;">
      <table width="882" border="0">
        <tr>
          <td width="237" height="123"><div>
            <div align="center">
              <h1><font color="#000000">航运新人论坛</font></h1>
            </div>
          </div></td>
          <td width="413">&nbsp;</td>
          <td width="200" style="text-align: right;">
          	<table width="100%" height="118" border="0">
            <tr>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td align="right"><table width="100%" border="0">
                <tr align="right" style="text-align: center;">
                  <td width="40%"><font color="#000" size="3">当前用户</font></td>
                  <td width="60%" id="userName" style="color: #FFF"><%=request.getSession().getAttribute("userName") %></td>
                </tr>
              </table></td>
            </tr>
          </table></td>
        </tr>
      </table>
    </div>
  </div>
  <div style="height: 0px"></div>
  <div class="sidebar1" style="border: ridge;border-width: 0.1px;border-color: black;">
    <ul class="nav">
      <li><a href="#">链接一</a></li>
      <li><a href="#">链接二</a></li>
      <li><a href="#">链接三</a></li>
      <li><a href="#">所有文章</a></li>
    </ul>
    <table>
    	<tr>
    		<td>作者</td>
    		<td><hxy:property value="blogAuthor.authorName"/></td>
    	</tr>
    	<tr>
    		<td>公司</td>
    		<td><hxy:property value="blogAuthor.company"/></td>
    	</tr>
    </table>
    <div>
    <br /><!--  
    <table style="width:100%" border="1" bgcolor="#F0FFFF">
    	<tr>
        	<td style="width:40%;text-align: center;">作者</td>
            <td style="width:60%" id="author" align="center"><%=request.getSession().getAttribute("author") %></td>
        </tr>
        <tr>
        	<td style="width:40%;text-align: center;">职位</td>
            <td style="width:60%" align="center" id="position"><%=request.getSession().getAttribute("position") %></td>
        </tr>
    </table>
    <table  style="width:100%;height: 300px" border="1" bgcolor="#F0FFFF">
        <tr style="width: 100%;height: 100px">
        	<td id="briefshow" width="100%" height="100%"><font color="#000" size="5" style="text-align: center;">个人简介：</font><br /><%=request.getSession().getAttribute("brief") %> <br /></td>
        </tr>
    </table>
    -->
    <h1 align="center"></h1>
    </div>   
    <!-- end .sidebar1 --></div>
  <div class="content" style="border-left-color: green;border-width: 0.1px;border: thin;">
  	<form style="height: 100%;width: 100%">
  		<table>
  			<tr>
  				<td>
  					<input style="height:40px;width:100%;font-size: 25px;border: none;text-align: center;background-color: #FFFFFF;" value="" readonly="readonly">
  					<hxy:property value="blogContent.blogHead"/>
  					</input>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<textarea rows="30" cols="60" style="border: 0;font-size: 20px" readonly="readonly">
  						<hxy:property value="blogInfo.author"/>	
  					</textarea>
  				</td>
  			</tr>
  		</table>
  		
  	</form>  	 	
  <!-- end .content -->
  </div>     
  <div id="div1" style="width: 100%">  	 		
   		<table id="table1" style="width: 100%" border="0">
   		</table>
   		<table>
   			<caption>评论</caption>
   			<hxy:iterator id="critic" value="hxy">
   				<tr>
   					<td><hxy:property value="#critic.blogId"/></td>
   					<td><hxy:property value="#critic.content"/></td>
   				</tr>
   			</hxy:iterator>
   		</table>
   		<br />
   		<form method="post" id="criticForm">
   		<textarea rows="3" cols="20" name="criticEditor" style="width: 100%;height: 80px">留个言</textarea><br/>
   		<div style="text-align: right;">
   			<input type="submit" value="提交评论" onclick="remarkSubmit()" align="left" style="text-align: center;width: 75px;height: 35px"/>
   		</div>   		
   		</form>
  </div>
  
  <div class="footer" align="right" style="color: #F0FFFF">
  	<br />
    <p align="right"><font color="#000" size="5">powered by Bluesir</font></p>
  </div>
  </div>
</body>
</html>
