<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%
	String mainPath=request.getContextPath()+"/pages/product/main.jsp"; 
    session.invalidate();
 	out.println("<script>parent.location.href='/estore/pages/product/main.jsp';</script>");
%>
