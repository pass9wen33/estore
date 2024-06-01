<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="cn.estore.cart.CartGoods"%>
<%@ page import="cn.estore.dao.ProductDao"%>
<%  ProductDao dao = new ProductDao(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>estore</title>
</head>
<link href="../../css/css.css" rel="stylesheet" type="text/css">
<body>
	<jsp:include page="../common/head.jsp" flush="true" />
	<table width="1024" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="300" bgcolor="#F5F5F5"><jsp:include
					page="../common/left.jsp" flush="true" /></td>
			<td width="724" valign="top" bgcolor="#FFFFFF" align="center"><strong>我的购物车</strong>

				<div align="center">
					<br>
					<%if (session.getAttribute("_CART_") == null) {%>
					您还没有购物！！
					<%} else {%>
				</div>
				<form method="post" action="cartModify.jsp" name="form">
					<table width="92%" border="1" align="center" cellpadding="0"
						cellspacing="0" bordercolor="#FFFFFF" frame="box">
						<tr>
							<td width="5%" height="28">
								<div align="center">序号</div>
							</td>
							<td width="40%">
								<div align="center">商品的名称</div>
							</td>
							<td width="18%">
								<div align="center">商品价格</div>
							</td>
							<td width="19%">
								<div align="center">商品数量</div>
							</td>
							<td width="18%">
								<div align="center">商品金额</div>
							</td>
						</tr>
						<% float sum = 0;//商品总金额									
	Vector cart = (Vector) session.getAttribute("_CART_");
for (int i = 0; i < cart.size(); i++) {//累计所有商品付款总额
	     CartGoods cartGoods = (CartGoods) cart.elementAt(i);
		sum = sum + cartGoods.number * cartGoods.price;
%>
						<tr>
							<td align="center" width="5%"><%=i + 1%></td>
							<td align="center" width="40%"><%=dao.selectOneNameByProductId(new Integer(cartGoods.ID))%>
							</td>
							<td align="center" width="18%"><%=cartGoods.price%>元</td>
							<td align="center" width="19%"><input name="num<%=i%>"
								size="7" type="text" value="<%=cartGoods.number%>"
								onBlur="check(this.form)"></td>
							<td align="center" width="18%"><%=cartGoods.number * cartGoods.price%>元</td>
						</tr>
					<script language="javascript">
			
			function check(myform){
				if(isNaN(myform.num<%=i%>.value) || myform.num<%=i%>.value.indexOf('.',0)!=-1){
					alert("请不要输入非法字符");myform.num<%=i%>.focus();return;}
				if(myform.num<%=i%>.value==""){
					alert("请输入修改的数量");myform.num<%=i%>.focus();return;}
				myform.submit();
			}
			
		</script>
						<%
							}
						%>
					</table>
				</form>
				<table width="100%" height="52" lign="center" cellpadding="0"
					cellspacing="0">
					<tr align="center" valign="middle">
						<td height="10">&nbsp;</td>
						<td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
					</tr>
					<tr align="center" valign="middle">
						<td height="21" class="tableBorder_B1">&nbsp;</td>
						<td height="21" colspan="-3" align="left">合计总金额：￥<%=sum%> <%
 	session.setAttribute("totalPrice", sum);
 %></td>
					</tr>
					<tr align="center" valign="middle">
						<td height="21" colspan="2"><a
							href="../product/main.jsp">继续购物</a> | <a
							href="../cart/cartCheckOut.jsp">去收银台结账</a> | <a
							href="../cart/cartClear.jsp">清空购物车</a> | 
							<a href="../cart/cartModify.jsp">修改数量
						</a></td>
					</tr>
				</table> 
				<%
 	}
 %></td>
		</tr>
	</table>
	<jsp:include page="../common/statusBarNavigation.jsp" flush="true" />
</body>
</html>
