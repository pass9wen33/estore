<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.estore.entity.OrderEntity"%>
<%@page import="cn.estore.entity.OrderItemEntity"%>
<%
	//查询具体订单的详细信息
	String number = request.getParameter("orderId");//接收订单编号
   //接收后台servler传回的参数（订单基本信息）
	OrderEntity orderEntity = (OrderEntity) request.getAttribute("orderAbstract");//类型转换		
	//接收后台servler传回的参数（订单详细信息）	
	List list = (List) request.getAttribute("orderItems");

%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>电子商城的前台订单详细信息的查询</title>
	</head>
	
	<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
	
	<body>

		<table width="1024" border="0" align="center" cellpadding="0"
			cellspacing="0">

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
					<br>
					<table width="723" height="25" border="0" cellpadding="0"
						cellspacing="0"
						background="<%=request.getContextPath()%>/systemImages/bg_02.jpg">
						<tr>
							<td align="center">
								<strong>订单号为：<%=orderEntity.getOrderId()%>&nbsp;&nbsp;的详细信息</strong>
							</td>
						</tr>
					</table>
					<br>
					<table width="76%" border="1" cellpadding="1" cellspacing="1"
						bordercolor="#FFFFFF" bgcolor="#DCDCDC">
						<tr align="center">
							<td width="26%" height="25">
								用户账号
							</td>
							<td width="22%" bgcolor="#FFFFFF"><%=orderEntity.getName()%></td>
							<td width="26%">
								用户姓名
							</td>
							<td width="22%" bgcolor="#FFFFFF"><%=orderEntity.getRealName()%></td>
						</tr>
						<tr align="center">
							<td height="25">
								送货电话
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getMobile()%></td>
							<td>
								送货地址
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getAddress()%></td>
						</tr>
						<tr align="center">
							<td height="25">
								付款方式
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getPaymentmode()%></td>
							<td>
								运送方式
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getPaymentmode()%></td>
						</tr>
						<tr align="center">
							<td height="25">
								备注信息
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getMemo()%></td>
							<td>
								订货时间
							</td>
							<td bgcolor="#FFFFFF"><%=orderEntity.getCreateTime()%></td>
						</tr>
					</table>
					<br>
					
					<hr align="center" size="3" width="76%" color="brown" noshade/>

					<strong>商品详细信息</strong>
					<br>
					<br>
					<table width="74%" border="1" cellpadding="1" cellspacing="1"
						bordercolor="#FFFFFF" bgcolor="#DCDCDC">
						<tr>
							<td>
								<div align="center">
									商品名称
								</div>
							</td>
							<td>
								<div align="center">
									商品数量
								</div>
							</td>
							<td>
								<div align="center">
									商品价格
								</div>
							</td>
						</tr>
						<%//求得本订单总金额
							float sum = 0;
							for (int i = 0; i < list.size(); i++) {
								OrderItemEntity form = (OrderItemEntity) list.get(i);
								sum = sum + form.getAmount() * form.getProductPrice();
						%>
						<tr bgcolor="#FFFFFF">
							<td>
								<div align="center"><%=form.getProductName()%></div>
							</td>
							<td>
								<div align="center"><%=form.getAmount()%></div>
							</td>
							<td>
								<div align="center"><%=form.getProductPrice()%>元
								</div>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<br/><br/><br/><br/>

					<table width="20%" border="0" align="center">
						<tr>
							<td align="right"><font color="red" >合计金额:</font></td>
							<td align="left"><%=sum%></td>
						</tr>
						<tr>
							<td align="right"><font color="red" >发货状态:</font></td>
							<td align="left">
									<%
										if (orderEntity.getDeliverySign()) {
									%>
									是
									<%
										} else {
									%>
									否
									<%
										}
									%>
								</td>
						</tr>
						<tr>
							<td align="right" colspan="2">
									<a href="javascript:history.go(-1)"><font color="blue" >返回</font></a>
							</td>
						</tr>
					</table>
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
