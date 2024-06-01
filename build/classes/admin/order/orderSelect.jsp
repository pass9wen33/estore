<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="cn.estore.entity.OrderEntity"%>

<%
	//查询当前用户所有的订单
	Integer sign = null;//区分已出货未出货的变量sign
	List list = null;
	//获取当前用户所有订单
	list = (List) request.getAttribute("AllOrder");
	int pageNumber = list.size(); // 计算出有多少条记录
	System.out.println("pagenumber:" + pageNumber);
	int maxPage = pageNumber; // 计算有多少页数
	String strNumber = (String) request.getAttribute("i");
	int number = 0;
	if (maxPage % 10 == 0) {
		maxPage = maxPage / 10;
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
<script Language="JavaScript">
	function deleteOrder(orderID) {
		if (confirm("确定要删除吗？")) {
			window.location = "OrderServlet?orderAction=deleteOrder&orderId="
					+ orderID;
		}
	}
</script>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet"
	type="text/css">

<body>

	<table width="1024" border="0" align="center" cellpadding="0"
		cellspacing="0">

		<tr>
			<td colspan="2"><jsp:include
					page="../../../pages/common/head.jsp" flush="true" /></td>
		</tr>

		<tr>
			<td width="300" bgcolor="#F5F5F5" valign="top">
				<!--左侧01--> <jsp:include page="../../../pages/common/left.jsp"
					flush="true" />
			</td>

			<td width="724" align="center" valign="top" bgcolor="#FFFFFF"><br />
				<table width="100%" height="25" border="0" cellpadding="0"
					cellspacing="0"
					background="<%=request.getContextPath()%>/systemImages/bg_02.jpg">
					<tr>
						<td>
							<div align="center">
								<strong> 后台-订单操作 </strong>
							</div>
						</td>
					</tr>
				</table> <br /> <!--显示订单表头  -->
				<table width="99%" border="1" cellpadding="1" cellspacing="1"
					bordercolor="#FFFFFF" bgcolor="CCCCCC">

					<tr bgcolor="#DCDCDC">
						<td width="20%" height="25">
							<div align="center">编号</div>
						</td>
						<td width="10%">
							<div align="center">客户姓名</div>
						</td>

						<td width="14%">
							<div align="center">是否出货</div>
						</td>
						<td width="30%">
							<div align="center">订货时间</div>
						</td>
						<td width="20%">
							<div align="center">操作</div>
						</td>
					</tr>
					<!-- 循环显示list集合中每一个元素 -->
					<%
						for (int i = start; i < over; i++) {
							OrderEntity form = (OrderEntity) list.get(i);
					%>
					<tr align="center" bgcolor="#FFFFFF">
						<td height="25"><%=form.getOrderId()%></td>
						<td><%=form.getRealName()%></td>

						<td>
							<%
								//提取发货状态，若已发货，则在页面显示“是”否则显示“否”

									if (!form.getDeliverySign()) {
							%> 否 <%
								} else {
							%> 是 <%
								}
							%>

						</td>
						<td><%=form.getCreateTime()%></td>
						<td>
							<%-- //查询当前用户某一指定订单详细资料的请求--%> <a
							href="OrderServlet?orderAction=orderDetail&
										orderId=<%=form.getOrderId()%>">详细信息
						</a> <%
 	if (form.getDeliverySign()) {
 %> 已发 <%
 	} else {
 %> <a
							href="OrderServlet?orderAction=despatch&orderId=
<%=form.getOrderId()%>">
								<font color="red"> 发货 </font>
						</a> <%
 	}
 %> <a href="javascript:deleteOrder('<%=form.getOrderId()%>')">删除</a>

						</td>
					</tr>
					<%
						}
					%>
				</table> <%
 	//页号大于1页，才显示上下页指示条
 	if (maxPage > 1) {
 %>
				<table width="99%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr align="center">
						<td width="17%">共为<%=maxPage%>页
						</td>
						<td width="22%">共有<%=pageNumber%>条记录
						</td>
						<td width="26%">当前为第<%=number + 1%>页
						</td>
						<td width="19%">
							<%
								if ((number + 1) == 1) {
							%> 上一页<%
								} else {
							%><a
							href="OrderServlet?orderAction=selectAllOrder&i=<%=number - 1%>">上一页</a>
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
							href="OrderServlet?orderAction=selectAllOrder&i=<%=number + 1%>">下一页</a>
							<%
								}
							%>
						</td>
					</tr>
				</table> <%
 	}
 %></td>
		</tr>

		<tr>
			<td colspan="2"><jsp:include
					page="../../common/statusBarNavigation.jsp" flush="true" /></td>
		</tr>

	</table>

</body>
</html>
