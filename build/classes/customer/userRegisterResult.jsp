<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
<title>estore</title>
</head>
<link href="/estore/css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<table width="100%" border="0" align="center" cellpadding="0" 
cellspacing="0">
  <tr>
    <td width="724" valign="top" bgcolor="#FFFFFF" align= "center">
                   <p>&nbsp;</p> <p><strong><%=request.getAttribute("registerResult")%>
</strong></p>
	     <meta http-equiv="refresh" content="2;URL=../product/main.jsp">
      <p>&nbsp;</p>
   </td>
 </tr>
</table>
<jsp:include page="../common/statusBarNavigation.jsp" flush="true" />
</body>
</html>
