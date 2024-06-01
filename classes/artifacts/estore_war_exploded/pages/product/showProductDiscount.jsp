<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@ page import="cn.estore.dao.ProductDao "%>
<%@page import="cn.estore.entity.ProductEntity "%>

<%  //显示打折商品
	ProductDao dao = new ProductDao();
	List discountList = null;
	request.setCharacterEncoding("utf-8");
	discountList = dao.selectProductsDiscount(1);
	session.setAttribute("list",discountList);	
	session.setAttribute("imageSign","02");
%>

<jsp:forward page="main.jsp"></jsp:forward>