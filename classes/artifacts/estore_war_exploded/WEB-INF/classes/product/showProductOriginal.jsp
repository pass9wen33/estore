<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@ page import="cn.estore.dao.ProductDao "%>
<%@page import="cn.estore.entity.ProductEntity "%>

<%
	// 显示新商品（无折扣）
	ProductDao dao = new ProductDao();
	List originalList = null;
	request.setCharacterEncoding("utf-8");
    originalList = dao.selectProductsDiscount(0);
	session.setAttribute("list",originalList);	
	session.setAttribute("imageSign","01");
%>

<jsp:forward page="main.jsp"></jsp:forward>