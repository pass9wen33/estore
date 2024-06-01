<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="cn.estore.entity.CustomerEntity"%>
<html>
<body>
	<%
			String curPath = request.getContextPath().trim();
			String userlink = "/estore/pages/customer/userLoginPlease.jsp";
			String orderlink = "/estore/pages/customer/userLoginPlease.jsp";
			String shoppinglink = "/estore/pages/customer/userLoginPlease.jsp";
			String orderlink2 = "/estore/pages/customer/userLoginPlease.jsp";
			CustomerEntity user = null;
			if (session.getAttribute("user") != null) {
				user = (CustomerEntity) session.getAttribute("user");
				userlink = "/estore/pages/customer/userUpdate.jsp?name="
						+ user.getUserName();
				shoppinglink = "/estore/pages/cart/cartShow.jsp";
				//String realPath=request.getRequestURI();
				String realPath = application.getRealPath("/");
				orderlink = "/estore/OrderServlet?orderAction=orderAbstract";//发起查看当前用户所有订单请求 (用完成servlet/javabean/jsp)  
			}

			//String backOrder = "/estore/OrderServlet?orderAction=selectAllOrder";
		%>


	<table width="1024" height="80" bordercolor="#FFFFFF" bgcolor="#ffff"
		border="0" align="center" cellpadding="0" cellspacing="0"
		background="/estore/images/systemImages/top.jpg">
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table width="1024" border="0" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF"
		bordercolordark="#819BBC"
		background="<%=request.getContextPath()%>/images/systemImages/fg_top03.jpg">
		<tr align="center" height="30">
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=request.getContextPath()%>/pages/product/main.jsp">首页</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=request.getContextPath()%>/pages/product/showProductOriginal.jsp"
				class="a4">商城新品</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=request.getContextPath()%>/pages/product/showProductDiscount.jsp"
				class="a4">特价商品</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=shoppinglink%>" class="a4">购物车</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=orderlink%>" class="a4">订单查看</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="<%=userlink%>" class="a4">用户修改</a></td>
			<td width="100"
				onMouseOver="this.style.backgroundImage='url(<%=request.getContextPath()%>/images/systemImages/topMenu.jpg)'"
				onMouseOut="this.style.backgroundImage=''"><a
				href="/estore/OrderServlet?orderAction=selectAllOrder">管理订单 </a></td>

		</tr>
	</table>
</body>
</html>
