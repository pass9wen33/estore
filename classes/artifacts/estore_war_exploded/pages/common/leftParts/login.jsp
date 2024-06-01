<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@page import="cn.estore.entity.CustomerEntity"%>

<jsp:useBean id="countTime" scope="page" class="cn.estore.util.CountTime"/>
		
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>login</title>	
			
	</head>
<link href="/estore/css/css.css" rel="stylesheet"	type="text/css">
	<body>

		<!--左侧01-->
		<%
			if (session.getAttribute("user") == null) {
		%>
		<table width="300" height="138" border="0" cellpadding="0" 
			cellspacing="0" background="/estore/images/systemImages/fg_left01.jpg" style="background-repeat: no-repeat">
			<tr>
				<td valign="middle">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="5">
							</td>
						</tr>
					</table>
					<form name="form" method="post" action="/estore/pages/customer/userLoginResult.jsp"
						onSubmit="return checkEmpty(form)">
						<table width="185" border="0" align="center">
							<tr height="10">
								<td></td>
							</tr>
							<tr>
							<br>
								<td width="60" height="25">
									帐号：
								</td>
								<td width="115" height="25">
									<input name="name" type="text" size="17">
								</td>
							</tr>
							<tr>
								<td height="35">
									密码：
								</td>
								<td>
									<input name="password" type="password" size="17">
								</td>
							</tr>
							<tr>
								<td height="25">
									<input type="image" class="input1" src="/estore/images/systemImages/fg-land.gif"
										width="51" height="20">
								</td>
								<td height="25">
									<a href="/estore/pages/customer/userRegister.jsp">注册</a>&nbsp;&nbsp;
									<a href="/estore/pages/customer/userPasswordFind1.jsp">找回密码</a>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
		<%
			} else {
				CustomerEntity user = (CustomerEntity)session.getAttribute("user");
		%>

		<table width="300" height="152" border="0" cellpadding="0"
			cellspacing="0" background="/estore/images/systemImages/fg_left01.jpg" style="background-repeat: no-repeat">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="30">
								&nbsp;
							</td>
						</tr>
					</table>

					<table width="200" border="0" align="center">
						<tr>
							<td width="200" height="25">
								<%=user.getUserName()%>登录成功
							</td>
						</tr>
						<tr>
							<td height="25"><%=countTime.currentlyTime()%></td>
						</tr>
						<tr>
							<td height="25">
								用户姓名：<%=user.getRealName()%></td>
						</tr>
						<tr>
							<td height="20" align="right" valign="middle">
								<a href="javascript:quit()">安全退出</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<%
			}
		%>		

	</body>
</html>
