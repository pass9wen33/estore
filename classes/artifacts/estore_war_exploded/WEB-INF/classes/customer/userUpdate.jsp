<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="cn.estore.dao.CustomerDao"%>
<%@page import="cn.estore.entity.CustomerEntity"%>
<html>
	<head>
		<title>estore</title>
	</head>
	
	<% //指定图片的位置
		String titleImagePath=request.getContextPath()+"/images/systemImages/fg1.jpg"; 
		String tempSavePath=request.getContextPath()+"/images/systemImages/save.jpg"; 
		String tempClearPath=request.getContextPath()+"/images/systemImages/clear.gif"; 
		String tempBackPath=request.getContextPath()+"/images/systemImages/back.gif"; 
	%>
		
	<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">

	<script language="javascript">
	function checkEmpty(userForm) {
		for (i = 0; i < userForm.length; i++) {
			if (userForm.elements[i].value == "") {
				alert("表单信息不能为空");
				return false;
			}
		}
		if (document.userForm.password.value != document.userForm.password_1.value) {
			window.alert("您两次输入的密码不一致，请重新输入");
			return false;
		}
		if (isNaN(document.userForm.mobile.value)) {
			window.alert("手机号码只能为数字");
			return false;
		}
	}
</script>

	<%
		CustomerDao dao = new CustomerDao();
		CustomerEntity user = (CustomerEntity)dao.selectCustomerEntity((String)request.getParameter("name"));
	%>
	<body>

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" bordercolor="#000000">
			<tr>
				<td colspan="2">
					<jsp:include page="../common/head.jsp" flush="true" />
				</td>
			</tr>


			<tr>
				<td bgcolor="#F5F5F5" align="center">
					<img src="<%=titleImagePath %>" width="1024" height="39">
					<form name="userForm" action="user.jsp?action=2" method="POST"
						onsubmit="return checkEmpty(userForm)">
						<input type="hidden" name="id" value="<%=user.getId()%>" />
						<table width="298" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="105" height="35">
									<div align="right">
										用户名称：
									</div>
								</td>
								<td width="187">
									<div align="center">
										<input type="hidden" name="user_name"
											value="<%=user.getUserName()%>"><%=user.getUserName()%>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<input type="hidden" name="password_hint_answer"
											value="<%=user.getPasswordHintAnswer()%>">
										<input type="hidden" name="password_question"
											value="<%=user.getPasswordQuestion()%>">
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										用户密码：
									</div>
								</td>
								<td>
									<div align="center">
										<input type="password" name="password">
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										密码确认：
									</div>
								</td>
								<td>
									<div align="center">
										<input type="password" name="password_1">
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										真实姓名：
									</div>
								</td>
								<td>
									<div align="center">
										<input type="text" name="real_name"
											value="<%=user.getRealName()%>">
									</div>
								</td>
							</tr>

							<tr>
								<td height="35">
									<div align="right">
										手机号码：
									</div>
								</td>
								<td>
									<div align="center">
										<input type="text" name="mobile" value="<%=user.getMobile()%>">
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										邮件地址：
									</div>
								</td>
								<td>
									<div align="center">
										<input name="email" type="text" value="<%=user.getEmail()%>">
									</div>
								</td>
							</tr>
						</table>
						<br>
						<input type="image" class="input1"
							src="<%=tempSavePath %>" width="51" height="20">
						&nbsp;&nbsp;
						<a href="#" onClick="javascript:userForm.reset()"><img
								src="<%=tempClearPath%>">
						</a> &nbsp;&nbsp;
						<a href="#" onClick="javasrcipt:history.go(-1)"><img
								src="<%=tempBackPath %>">
						</a>
					</form>
					<p>
						&nbsp;
					</p>
				</td>
			</tr>


			<tr>
				<td colspan="2">
					<jsp:include page="../common/statusBarNavigation.jsp" flush="true"/>
				</td>
			</tr>

		</table>


	</body>
</html>
