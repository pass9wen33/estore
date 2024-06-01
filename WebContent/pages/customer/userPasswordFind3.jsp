<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.*"%>
<%@ page import="cn.estore.dao.CustomerDao "%>
<%@page import="cn.estore.entity.CustomerEntity "%>
<%
	CustomerDao dao = new CustomerDao();
	request.setCharacterEncoding("utf-8");
	String result=request.getParameter("result").trim();
//	CustomerEntity user=(CustomerEntity)session.getAttribute("user");	
	CustomerEntity user=(CustomerEntity)application.getAttribute("user");	
	String name=request.getParameter("name").trim();
//	CustomerEntity user=dao.selectFind(name,result); 将前述的user保存起来，可以减少一次数据查询
%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>${titleName}</title>
		<% 
		   String tempImagePath=request.getContextPath()+"/images/systemImages/fg2.jpg"; 
		   String tempSavePath=request.getContextPath()+"/images/systemImages/save.jpg"; 
		   String tempClearPath=request.getContextPath()+"/images/systemImages/clear.gif"; 
		   String tempBackPath=request.getContextPath()+"/images/systemImages/back.gif"; 
		%>
	</head>
	
	<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
	function checkEmpty(form){
	for(i=0;i<form.length;i++){
	 if(form.elements[i].value==""){
		alert("表单信息不能为空");
		return false;
		  }
		}
     }		
	if(document.form.password.value!=document.form.passwordOne.value){
		window.alert("您两次输入的密码不一致，请重新输入");
			return false;
			}
	

</script>

	<body>

		<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0">
	    	<tr>
	    		<td colspan="2" height="100">
	 				<jsp:include   page="../common/head.jsp" flush="true" />
	     		</td>
	    	</tr>
	    	
			<tr>
				<td width="300" valign="top" bgcolor="#F5F5F5">
					<!--左侧01-->
					<jsp:include page="../common/left.jsp" flush="true" />
				</td>
				
				<td width="724" align="center" valign="top" bgcolor="#FFFFFF">

					<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
					  <tr>
					    <td bgcolor="#FFFFFF" align="center">
					    	<img src="<%=tempImagePath %>" width="752" height="45">
					 <%
					   	//if(user==null||user.equals(""))
					   	if(!result.equals(user.getPasswordHintAnswer()))
					   		{
					  %>
					 <p><strong>答案不正确,请重新输入！！！</strong></p>
					 <meta http-equiv="refresh" content="2;URL=userPasswordFind2.jsp?name=<%=name%>">
					  <%}else{%>
					  <p><strong>输入新密码</strong></p>
					  <form name="form" method="post" action="userPasswordFind4.jsp?id=<%=user.getId()%>" onSubmit="return checkEmpty(form)">
					    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
					      <tr>
					        <td width="105" height="35">
					          <div align="right">请输入新的密码：</div></td>
					        <td width="187"><div align="center">
					          <input type="password" name="password">
					        </div></td>
					      </tr>
					       <tr>
					        <td width="105" height="35">
					          <div align="right">确认密码：</div></td>
					        <td width="187"><div align="center">
					                 <input type="password" name="passwordOne">
					        </div></td>
					      </tr>
					    </table>
					    <br>
					     <input type="image" class="input1"  src="<%=tempSavePath %>" width="51" height="20">
					&nbsp;&nbsp;
					      <a href="#" onClick="javascript:form.reset()"><img src="<%=tempClearPath %>"></a>
					&nbsp;&nbsp;
					      <a href="#" onClick="javasrcipt:history.go(-1)"><img src="<%=tempBackPath %>"></a>
					  </form>
					<%}%>
					   </td>
					  </tr>
					</table>

				</td>

					<tr>
						<td colspan="2">
							<jsp:include page="../common/statusBarNavigation.jsp"
								flush="true" />
						</td>
					</tr>
		</table>

	</body>
</html>
