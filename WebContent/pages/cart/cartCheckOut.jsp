<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.estore.entity.CustomerEntity"%>
<%--导入StringUitl用于手动生成订单编号 --%>
<%@ page import="cn.estore.util.StringUitl" %>
<%
	java.util.Date date = new java.util.Date();
	CustomerEntity user = (CustomerEntity) session.getAttribute("user");
	String orderId=StringUitl.createOrderId();
	//将orderId存至session,作为订单编号和cartToOrder.jsp保存到订单表和订单详细表中
	session.setAttribute("orderId",orderId);
%>
<html>
	<script language="javascript">
		function checkEmpty(form) {
		for (i = 0; i < form.length; i++) {
			if (form.elements[i].value == "") {
				alert("表单信息不能为空");
				return false;
			}
		}
	}
</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${titleName}</title>

		<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
	</head>
	<link href="../../css/css.css" rel="stylesheet" type="text/css">
	<body>
		<jsp:include page="../common/head.jsp" flush="true" />
		<table width="1024" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
			
				<td width="300" bgcolor="#F5F5F5">
					<jsp:include page="../common/left.jsp" flush="true" />
				</td>
				
				<td width="724" valign="top" bgcolor="#FFFFFF" align="center">

					<br>
					<br>
					<strong>收银结帐</strong>
					<form name="form" method="post" action="cartToOrder.jsp"
						onSubmit="checkEmpty(form)">
						<table width="68%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="30" colspan="2">
									<div align="center" class="style1">
										注意：请您不要恶意提交订单!
									</div>
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="center">
										订单编号：
									</div>
								</td>
								<td>
									&nbsp;
									<input type="hidden" name="order_id" value="<%=orderId%>"><%=orderId%>
								</td>
							</tr>
							<tr>
								<td width="24%" height="30">
									<div align="center">
										用户帐号：
									</div>
								</td>
								<td width="76%">
									&nbsp;
									<input type="text" name="name" value="<%=user.getUserName()%>">
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="center">
										真实姓名：
									</div>
								</td>
								<td>
									&nbsp;
									<input type="text" name="realName"
										value="<%=user.getRealName()%>">
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="center">
										邮寄地址：
									</div>
								</td>
								<td>
									&nbsp;
									<input type="text" name="address" >
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="center">
										联系电话：
									</div>
								</td>
								<td>
									&nbsp;
									<input type="text" name="mobile" value="<%=user.getMobile()%>">
								</td>
							</tr>
							
							<tr>
								<td height="30">
									<div align="center">
										应付金额：
									</div>
								</td>
								<td>
									&nbsp;
									<input type="text" name="totalPrice" value=<%=session.getAttribute("totalPrice") %>>
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="center">
										付款方式：
									</div>
								</td>
								<td>
									&nbsp;
									<select name="paymentMode" class="textarea">
										<option value="">
											请选择
										</option>
										<option value="银行付款" >
											银行付款
										</option>
										<option value="邮政付款">
											邮政付款
										</option>
										<option value="现金支付" selected="selected">
											现金支付
										</option>
									</select>
								</td>
							</tr>

							<tr>
								<td height="30">
									<div align="center">
										送货方式：
									</div>
								</td>
								<td>
									&nbsp;
									<select name="deliveryMethod" class="textarea">
										<option value="">
											请选择
										</option>
										<option value="普通邮寄" selected="selected">
											普通邮寄
										</option>
										<option value="特快专递">
											特快专递
										</option>
										<option value="EMS专递方式">
											EMS专递方式
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td height="60">
									<div align="center">
										备注信息：
									</div>
								</td>
								<td>
									&nbsp;
									<textarea name="memo"></textarea>
								</td>
							</tr>
						</table>
						<br>
						<input type="submit" name="Submit2" value="提交">
						&nbsp;
						<input type="reset" name="reset" value="清除">
						&nbsp;
						<input type="button" name="back" value="返回"
							onClick="javasrcipt:history.go(-1)">
					</form>
				</td>
			</tr>
		</table>
		<jsp:include page="../common/statusBarNavigation.jsp" flush="true" />
	</body>
</html>
