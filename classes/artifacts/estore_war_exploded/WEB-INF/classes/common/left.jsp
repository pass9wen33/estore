<%@ page contentType="text/html;charset=utf-8"%>

<html>
<script language="javascript">
	 function checkEmpty(form) {//form是要进行验证的表单名称
	   for (i = 0; i < form.length; i++) {
		 if (form.elements[i].value == "") { //对elements对象中的每个子元素进行判断
		    alert("表单信息不能为空");
		    return false;
		 }
	   }
	 }	  
	 function quit() {
			if (confirm("没有要买的东西了吗？")) {
				window.location.href = "<%=request.getContextPath()%>/pages/customer/loginOut.jsp";
			}
		}
</script>

  <body >
  <table  >
		<tr valign="top">
			<td >
				<%@ include file="leftParts/onLineNumber.jsp" %>
			</td>
	</table>
    <table width="100%"  border="0" align="center" 
cell padding="0" cellspacing="0">   
        <tr>
            <!--左侧00： 按商品名搜索框-->
		<tr valign="top">
			<td>
				<%@ include file="leftParts/findProductsByName.jsp" %>
			</td>
		</tr>
           
           <!--左侧01： 登录-->
		<tr>
			<td>
				<%@ include file="leftParts/login.jsp" %>
			</td>
		</tr>
        </tr>
     </table>
  </body>
</html>
