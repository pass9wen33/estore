<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
	 <title>findProductsByName</title>
   </head>
   <body>
	 <table width="300" height="152" border="0" align="center"
		background="/estore/images/systemImages/fg_left00.jpg">
         <!--显示提示信息-->
		<tr>
		   <td width="100" align="left" valign="bottom">
			<br>
			&nbsp;&nbsp;搜索商品：
		   </td>
		</tr>
		<tr>
	         <td>
          <!--设计提交表单，并指定执行查询页面-->
			 <form name="searchForm" method="post" action=
                  "<%=request.getContextPath()%>/pages/product/showFindProductsByName.jsp"
				onsubmit="return checkEmpty(searchForm)">
				<table>
		             <tr>
					 <td>
						&nbsp;&nbsp;
					 </td>
					 <td>
						<input name="search" type="text" size="22" align="left">
					 </td>
					 <td>			
						<input type="image" class="input1" src=
					   "<%=request.getContextPath()%>/images/systemImages/Search.gif" 
						align="middle" />
					  </td>
					</tr>
			       </table>
				</form>
			 </td>
		  </tr>
	   </table>
   </body>
</html>
