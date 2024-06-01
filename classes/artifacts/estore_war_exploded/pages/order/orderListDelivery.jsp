<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.estore.dao.OrderDao"%>
<%@page import="cn.estore.entity.OrderEntity"%>

<%
	//查询当前用户所有的订单
	OrderDao order = new OrderDao();
	List list = null;
	
	//取得出货或未出货订单	
	list = (List)request.getAttribute("orderDeliveryList");
	
	int pageNumber = list.size(); // 计算出有多少条记录
	int maxPage = pageNumber; // 计算有多少页数
	String strNumber = (String) request.getAttribute("i");
	int number = 0;
	if (maxPage % 10 == 0) {
		maxPage = maxPage / 19;
	} else {
		maxPage = maxPage / 10 + 1;
	}
	if (strNumber == null) {
		number = 0;
	} else {
		number = Integer.parseInt(strNumber);
	}
	int start = number * 10;//开始条数
	int over = (number + 1) * 10;//结束条数
	int count = pageNumber - over;//还剩多少条记录
	if (count <= 0) {
		over = pageNumber;
	}
%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>用户订单查询</title>
	</head>
	<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet"
		type="text/css">

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
					<table width="724" height="25" border="0" cellpadding="0"
						cellspacing="0"
						background="<%=request.getContextPath()%>/systemImages/bg_02.jpg">
						<tr>
							<td>
								<div align="center">
									<strong>用户&nbsp;&nbsp;<%=session.getAttribute("name").toString()%>&nbsp;&nbsp;的所有订单信息</strong>
								</div>
							</td>
						</tr>
					</table>
					<br>
					<table width="96%" border="1" cellpadding="1" cellspacing="1"
						bordercolor="#FFFFFF" bgcolor="CCCCCC">

						<tr bgcolor="#DCDCDC">
							<td width="12%" height="25">
								<div align="center">
									编号
								</div>
							</td>
							<td width="12%">
								<div align="center">
									电 话
								</div>
							</td>
							<td width="36%">
								<div align="center">
									地 址
								</div>
							</td>
							<td width="16%">
								<div align="center">
									是否出货
								</div>
							</td>
							<td width="12%">
								<div align="center">
									订货时间
								</div>
							</td>
							<td width="12%">
								<div align="center">
									操作
								</div>
							</td>
						</tr>
						<%
							for (int i = start; i < over; i++) {
								OrderEntity form = (OrderEntity) list.get(i);
						%>
						<tr align="center" bgcolor="#FFFFFF">
							<td height="25"><%=form.getOrderId()%></td>
							<td><%=form.getMobile()%></td>
							<td><%=form.getAddress()%></td>
							<td>
								<%
									if (Boolean.valueOf(form.getDeliverySign())) {
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
							<td><%=form.getCreateTime()%></td>
							<td>
								<%-- //发起查看查询当前用户某一指定订单详细资料的请求 (用完成servlet/javabean/jsp)--%>
								<a
									href="OrderServlet?orderAction=orderDetail&orderId=<%=form.getOrderId()%>">详细信息</a>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<br/>

					<div align="right">	<a href="javascript:history.go(-1)">返回</a>	</div>
					
					<%//页号大于1页，才显示上下页指示条
						if (maxPage>1){				
					%>
					<table width="96%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td width="17%">
								共为<%=maxPage%>页
							</td>
							<td width="22%">
								共有<%=pageNumber%>条记录
							</td>
							<td width="26%">
								当前为第<%=number + 1%>页
							</td>
							<td width="19%">
								<%
									if ((number + 1) == 1) {
								%>
								上一页<%
									} else {
								%><a
									href="OrderServlet?orderAction=orderListDelivery.jsp&i=<%=number - 1%>">上一页</a>
							</td>
							<%
								}
							%>
							<td width="16%">
								<%
									if (maxPage <= (number + 1)) {
								%>下一页<%
									} else {
								%><a
									href="OrderServlet?orderAction=orderListDelivery.jsp&i=<%=number + 1%>">下一页</a>
							</td>
							<%
								}
							%>
						</tr>
					</table>
					<%
						} 
					%>
				</td>
			</tr>

			<tr>
				<td colspan="2"><jsp:include
						page="../common/statusBarNavigation.jsp" flush="true" />
				</td>
			</tr>

		</table>


	</body>
</html>
