<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="cn.estore.dao.CustomerDao" %>
<%@ page import="cn.estore.entity.CustomerEntity" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.*" %>
<%@ page import="cn.estore.util.*"%>

<jsp:useBean id="user" scope="session" class="cn.estore.entity.CustomerEntity">
</jsp:useBean>

<jsp:setProperty name="user" property="*" />

<%
	request.setCharacterEncoding("utf-8");//JSP获取页面参数
	response.setContentType("text/html;charset=utf-8");
	Encrypt des = new Encrypt("njcit");//自定义密钥   
	user.setPassword(des.encrypt(user.getPassword()));
 //     System.out.println("解密后的字符：" + des.decrypt(des.encrypt(test))); 	
	//用户管理
	CustomerDao dao = new CustomerDao();
	int action = Integer.parseInt(request.getParameter("action"));
	switch (action) {
	case 0: { // 添加用户信息
		CustomerEntity formSelect = dao.selectCustomerEntity(user.getUserName());
		if (formSelect == null || formSelect.equals("")) {
			if (dao.insertCustomer(user)){
			request.setAttribute("registerResult", "注册成功!!!");
			session.setAttribute("user",user);//注册成功后需提交当前用户的相关资料，servlet跳转要取这些数据
			session.setAttribute("name",user.getUserName());
			}else{
			request.setAttribute("registerResult", "数据库操作失败，注册不成功！请重新注册！");
			}
		} else {
            request.setAttribute("registerResult", "该用户名称已经存在！！！！！！");
    }

		%>
		<jsp:forward page="userRegisterResult.jsp"></jsp:forward>
 		<%
 		}
 		case 4: {// 删除用户信息
 			if(dao.deleteCustomer(Integer.valueOf(request.getParameter("id")))){
	 		%>
			<script language='javascript'>alert("删除成功！！！");window.location.href='userSelect.jsp';</script>
	 		<%
	 		}else{
	 		%>
			<script language='javascript'>alert("该用户还有订单，不能删除！！！");window.location.href='userSelect.jsp';</script>
	 		<%
	 		}
 		}
 		case 2: {//修改用户信息
			if (dao.updateCustomer(user)){
				request.setAttribute("userUpdateResult", "用户信息修改成功!!!");
			}else{
				request.setAttribute("userUpdateResult", "数据库操作失败，用户信息修改不成功！请重新操作！");
			}
		%>
		<jsp:forward page="userUpdateResult.jsp"></jsp:forward>
 		<%
 		}
 	}
%>
