<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@ page import="cn.estore.dao.ProductDao "%>
<%@page import="cn.estore.entity.ProductEntity "%>

<%
	// 根据商品名称查询
	ProductDao dao = new ProductDao();
	List findList = null;
	request.setCharacterEncoding("utf-8");
	String search=request.getParameter("search").trim();	
	findList = (List)dao.selectProductsSearch(search);
	session.setAttribute("list",findList);	
%>

<jsp:forward page="main.jsp"></jsp:forward>