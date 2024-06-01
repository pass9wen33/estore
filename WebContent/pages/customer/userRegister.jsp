<%@ page language="java" contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<title>estore</title>
	  
		<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
		<style type="text/css">
			/* 警告信息样式 */
			div.warning {
			    color:#FF0000;
			}
		</style>		
		<!-- 引入外部checker.js文件 -->
		<script type="text/javascript" src="../checker.js" charset="utf-8" ></script>
		
	</head>
	<link href="../../../css/css.css" rel="stylesheet" type="text/css">
	<% 
	    request.setCharacterEncoding("utf-8");//强制指定request获取参数的编码方式
		String titleImagePath=request.getContextPath()+"/images/systemImages/fg1.jpg"; 
		String tempSavePath=request.getContextPath()+"/images/systemImages/save.jpg"; 
		String tempClearPath=request.getContextPath()+"/images/systemImages/clear.gif"; 
		String tempBackPath=request.getContextPath()+"/images/systemImages/back.gif"; 
	%>
	<body>

		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" bordercolor="#000000">

			<tr>
				<td colspan="2"> 
					<%@ include file="/pages/common/head.jsp"%>
				</td>
			</tr>

			<tr>
				<td bgcolor="#F5F5F5" align="center">
					<img src="<%=titleImagePath %>" width="1024" height="39">
					<form name="userForm" action="../customer/user.jsp?action=0" method="post"
						onsubmit="">
						<table width="500" border="0" cellspacing="0" cellpadding="0">					
							
							<tr>
								<td width="107" height="35">
									<div align="right">
										用户名称：
									</div>
								</td>
								<td >
									<div align="left"> 
										<input type="text" name="userName" id="userName" onblur="Checker.checkNode(this)" /> 
									</div>
								</td>
								<td align="left">
        							<div  id="userNameCheckDiv" class="warning">请输入用户名 </div>
								</td>
							</tr>
							
							<tr>
								<td height="35">
									<div align="right">
										用户密码：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="password" name="password" id="password" onblur="Checker.checkPassword()">        
        							</div>
        						</td>
        						<td align="left">
       								<div id="passwordCheckDiv" class="warning">请输入密码</div>								
								</td>
							</tr>
							
							<tr>
								<td height="35">
									<div align="right">
										密码确认：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="password" name="password2" id="password2" 
											onblur="Checker.checkPassword()">
									</div>
								</td>
								<td align="left">		
       								<div id="password2CheckDiv" class="warning">请再次输入密码</div>
								</td>
							</tr>
							
							<tr>
								<td height="35">
									<div align="right">
										真实姓名：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="text" name="realName" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										用户手机：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="text" name="mobile" id="mobile" onblur="Checker.checkNode(this)" />
								</td>
								<td align="left">
										<div  id="mobileCheckDiv" class="warning">请输入手机号 </div>
									</div>
								</td>
							</tr>

							<tr>
								<td height="35">
									<div align="right">
										电邮地址：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="text" name="email" id="email" 
											onblur="Checker.checkNode(this)">
									</div>
								</td>
								<td align="left">		
        								<div id="emailCheckDiv" class="warning">请输入邮件地址</div>
								</td>
							</tr>
							
							<tr>
								<td height="35">
									<div align="right">
										密码提示：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="text" name="passwordQuestion" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="35">
									<div align="right">
										密码答案：
									</div>
								</td>
								<td>
									<div align="left">
										<input type="text" name="passwordHintAnswer" />
									</div>
								</td>
							</tr>
							
							<tr>
							    <td height="35">
									<div align="right">
										数字验证：
									</div>							    
							    </td>
							    <td>
							        <input type="text" name="code" id="code" size="5" onblur="Checker.checkNode(this)">
							        <img src="code.jsp" width="50" height="20" border="0" alt="">
							    </td>
							    <td align="left">
							        <div id="codeCheckDiv" class="warning">请输入验证码</div>
							    </td>
							</tr>
							
						</table>
						
						<br>
						<input type="image" class="input1" src="<%=tempSavePath%>" width="51" height="20">
						<a href="#" onClick="javascript:userForm.reset()"><img src="<%=tempClearPath%>"> </a> &nbsp;&nbsp;
						<a href="#" onClick="javasrcipt:history.go(-1)"><img src="<%=tempBackPath%>"> </a>
					</form>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<%@ include file="/pages/common/statusBarNavigation.jsp" %>
				</td>
			</tr><tr><td valign="top"><br></td><td valign="top"><br></td></tr>


		</table>

	</body>
</html>
