<%@ page contentType="text/html; charset=utf-8" %>
<%
	session.removeAttribute("_CART_");
	response.sendRedirect("../product/main.jsp");
%>
