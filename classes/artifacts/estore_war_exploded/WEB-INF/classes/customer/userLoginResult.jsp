<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="cn.estore.dao.CustomerDao"%>
<%@ page import="cn.estore.entity.CustomerEntity"%>
<%@ page import="cn.estore.util.*" %>
<html>
<head>
<title>用户登录结果</title>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
</head>
 
<body>
<p>&nbsp; <br></p>
<div align="center">
  <p><strong>
 	<%
	// 用户登录
		CustomerDao dao = new CustomerDao();
		String name = request.getParameter("name");
		CustomerEntity userEntity = dao.selectCustomerEntity(name);
		String mainPath=request.getContextPath().trim()+"/pages/product/main.jsp";
		if(userEntity==null||userEntity.equals("")){//当前登录用名的用户不存在
	%>
		<script language='javascript'>alert('不存在此用户，请重新登录！！！');history.go(-1);</script>		
	<%  }else {//存在此用户，将数据库中密码取出来解密，并和用户录入的密码进行对比
		Encrypt des = new Encrypt("njcit");//自定义密钥   
	   	String pswDecrypt=des.encrypt(request.getParameter("password").trim());//将客户输入密码加密码和数据库中密码比较
	   	//用户名正确，但密码加密后与数据表中密码不一致，表明密码错误
		if (!pswDecrypt.equals(userEntity.getPassword())) { 
		//if (!request.getParameter("password").trim().equals(userEntity.getPassword())) {
	%>
		<script language='javascript'>alert('密码错误，请重新登录！！！');history.go(-1);</script>
	<%	
		} else {//用户名加密后与数据表中密码一致，为授权用户
			session.setAttribute("user", userEntity);
			session.setAttribute("name",name);			
	%>
		<script language='javascript'>window.location.href='<%=mainPath%>';</script>
	<%
		}}
  	%>
  </strong></p>

</div>
</body>
</html>
