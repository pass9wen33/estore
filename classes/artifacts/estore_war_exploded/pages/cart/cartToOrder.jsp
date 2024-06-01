<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.estore.cart.CartGoods"%>
<%@ page import="cn.estore.entity.OrderEntity"%>
<%@ page import="cn.estore.entity.OrderItemEntity"%>
<%@ page import="cn.estore.dao.ProductDao"%>
<%@ page import="cn.estore.dao.OrderDao"%>
<%@ page import="cn.estore.dao.OrderItemDao"%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${titleName}</title>

	</head>
	<link href="/estore/css/css.css" rel="stylesheet" type="text/css">

	<body>

		<table border="0" width="1024" align="center">

			<tr>
				<td colspan="2">
					<jsp:include page="../common/head.jsp" flush="true" />
				</td>
			</tr>

			<tr>
				<td width="300" bgcolor="#F5F5F5" valign="top">
					<!--左侧01-->
					<jsp:include page="../common/left.jsp" flush="true" />
				</td>

				<td width="724" align="center" valign="top" bgcolor="#FFFFFF">
					<!--右侧01-->

					<%
						//将客户购物车中数据提交至订单
						OrderEntity order = new OrderEntity();
						OrderDao orderDao = new OrderDao();
						OrderItemDao orderDetailDao = new OrderItemDao();
						OrderItemEntity orderDetail = new OrderItemEntity();
						ProductDao goodsDao = new ProductDao();

						String orderId = session.getAttribute("orderId").toString();
						//先添加订单表
						order.setOrderId(orderId);
						order.setName(request.getParameter("name"));
						order.setRealName(request.getParameter("realName"));
						order.setAddress(request.getParameter("address"));
						order.setMobile(request.getParameter("mobile"));
						order.setTotalPrice(Float.valueOf(session
								.getAttribute("totalPrice").toString()));
						order.setDeliveryMethod(request.getParameter("deliveryMethod"));
						order.setMemo(request.getParameter("memo"));
						order.setDeliverySign(false);//默认没发货
						//将订单时间格式化为"yyyy-MM-dd HH:mm:ss",存至当前时间字段中
						java.util.Date date = new java.util.Date();
						java.text.SimpleDateFormat orderTime = new java.text.SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						order.setCreateTime(orderTime.format(date));
						order.setPaymentmode(request.getParameter("paymentMode"));
						//存至订单表
						orderDao.insertOrder(order);

						//将订单涉及的商品添加到该订单相关联的明细表
						Vector cart = (Vector) session.getAttribute("_CART_");
						for (int i = 0; i < cart.size(); i++) {
							CartGoods cartGoods = (CartGoods) cart.elementAt(i);
							//这一订单明细中所有商品的订单号均一样，同订单表中的订单号
							orderDetail.setOrderId(orderId);
							orderDetail.setProductId(new Integer(cartGoods.ID));
							orderDetail.setProductName(goodsDao
									.selectOneNameByProductId(new Integer(cartGoods.ID)));
							orderDetail.setProductPrice(cartGoods.price);
							orderDetail.setAmount(cartGoods.number);
							//修改该商品销量，用于后期统计销售排行
							goodsDao.updateAProductSoldNumber(cartGoods.number,
									new Integer(cartGoods.ID));
							orderDetailDao.insertOrderItem(orderDetail);
						}

						session.removeAttribute("_CART_");
						//过5秒钟转到cartClear.jsp页面，用以给客户记录订单
						//response.setHeader("refresh", "5 ; url=cartClear.jsp");
						//response.write("<script>alert('发送失败'+result+'')</script>");
						//response.write("<script>alert(\"+result+\")</script>");
						//out.println("<script language='javascript'>alert('下单成功，请记住订单编号:');window.location.href='cartClear.jsp';</script>"	);
						
						//response.sendRedirect("../product/main.jsp");
					%>
					
					<table>
						<tr>
							<td height="100"> </td>
						</tr>
						<tr>
							<td align="center">
								<font color="red" size="5">已经生成订单，编号:<%=orderId%></font>
							</td>
						</tr>
					</table>
					
					<div align="center">
						<%--依次存放[记录总数，总页数，当前页号--%>
					</div>

				</td>
			</tr>

			<tr>
				<td colspan="2">
					<jsp:include page="../common/statusBarNavigation.jsp" flush="true" />
				</td>
			</tr>

		</table>
	</body>


</html>

