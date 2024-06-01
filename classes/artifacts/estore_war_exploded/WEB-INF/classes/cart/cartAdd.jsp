<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.estore.cart.CartGoods"%>
<%
	//获取request中的某商品编号及商品价格
	int goodsID = Integer.parseInt(request.getParameter("goodsId"));
	float goodsPrice = Float.parseFloat(request.getParameter("price"));
	//选商品件数
 
	int buyGoodsNumber=1;
	//构造商品对象，默认每次选一个对象
	CartGoods cartGoods = new CartGoods(goodsID,goodsPrice, buyGoodsNumber);		boolean flag = true;
	//判断该用户是否已经有购物车
	Vector cart = (Vector) session.getAttribute("_CART_");
	if (cart == null) {
		cart = new Vector();//新建购物车
	} else {
		for (int i = 0; i < cart.size(); i++) {
			CartGoods boughtGoods = (CartGoods) cart.elementAt(i);
			if (boughtGoods.ID == cartGoods.ID) {
				boughtGoods.number++;
				cart.setElementAt(boughtGoods, i);
				flag = false;
			}
		}
	}
	//原购物车中没有要添加的商品
	if (flag)
		cart.add(cartGoods);
	session.setAttribute("_CART_", cart);
	out.println("<script language='javascript'> window.close(); alert('购买商品成功!');</script>");
%>
