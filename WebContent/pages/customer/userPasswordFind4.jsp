<%@ page contentType="text/html;charset=utf-8"%>
<%@page import="java.util.*"%>
<%@ page import="cn.estore.dao.CustomerDao "%>
<%@page import="cn.estore.entity.CustomerEntity "%>
<%@page import="cn.estore.util.Encrypt" %>
<%
	CustomerDao dao = new CustomerDao();
	request.setCharacterEncoding("utf-8");
	String password=request.getParameter("password").trim();
	Integer id=Integer.valueOf(request.getParameter("id"));
	Encrypt des = new Encrypt("njcit");//自定义密钥   
	password=des.encrypt(password);
	boolean change=dao.updatePassword(password,id);	
%>


<html>
	<head>
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
					<img src="<%=tempImagePath%>" width="752" height="45">
					   <p><strong>
					    <%if(change){%>		    密码修改成功！！！
					  <%}else{%>     		    密码修改失败！！！
					  <%}%>
					  </strong></p>
					<meta http-equiv="refresh" content="2;URL=../product/main.jsp">
					   </td>
					  </tr>
					</table>

				</td>

					<tr>
						<td colspan="2"><jsp:include page="../common/statusBarNavigation.jsp"
								flush="true" />
						</td>
					</tr>
		</table>

	</body>
</html>
