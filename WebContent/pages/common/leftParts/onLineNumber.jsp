<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>left-online-number</title>
  </head>
  <link href="/estore/css/css.css" rel="stylesheet"	type="text/css">
  <body>
   <table width="300" height="28" border="0" cellpadding="0" cellspacing="0" >
	 <tr>
        <td>
<font color="red">在线人数
<%
if(application.getAttribute("counter")!= null){
%>
<%=application.getAttribute("counter")%>
<%}else{ %>1
<%}%>
</font>
</td>

	 </tr>
	</table>
	
  </body>
</html>
