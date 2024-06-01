<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.estore.cart.CartGoods"%>
<%
	Vector cart=(Vector)session.getAttribute("_CART_");
	Vector newcart=new Vector();
	for(int i=0;i<cart.size();i++){
		CartGoods cartGoods=(CartGoods)cart.elementAt(i);
		String num=request.getParameter("num"+i);
		try{
		int newnum=Integer.parseInt(num);
		cartGoods.number=newnum;
 
		if(newnum!=0){
			newcart.addElement(cartGoods);}
		}catch(Exception e){
			out.println("<script language='javascript'>alert('您输入的数量不是有效的整数!');history.back(); </script>");
			return;
		}
	}
	session.setAttribute("_CART_",newcart);
	response.sendRedirect("cartShow.jsp");
%>
