<%@ page contentType="text/plain; charset=utf-8"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="cn.estore.dao.CustomerDao"%>
<%	
       out.clear();      					//清空当前的输出内容（空格和换行符）
       request.setCharacterEncoding("utf-8");	
											//设置请求体字符编码格式为GB2312
       String name = request.getParameter("name");	//获取name参数
       if ((name!=null)&&(name.equals("userName"))){ 
           name="user_name"; 
}
       String value = request.getParameter("value");	//获取value参数
       String info = null;      							//用于保存提示对象的名称
   //如果需要判断的是验证码，采用session方式验证
       if ("code".equals(name)) {
          //获取session中保存的验证码
String sessionCode = (String) session.getAttribute("_CODE_");   
          //根据对比结果输出响应信息
          if (value != null && value.equals(sessionCode)) {
              out.print("1验证码正确!");
          } else {
              out.print("0验证码错误!");
          }
       } else {
          //根据name变量确定提示对象的名称
          if ("user_name".equals(name)) {
              info = "用户名";
          } else if ("email".equals(name)) {
              info = "邮件地址";
          }else if ("mobile".equals(name)) {
              info = "手机号码";
          }
          //根据是否存在相同信息输出对应的响应
          CustomerDao eDao=new CustomerDao();
          if (eDao.hasSameValue(name,value)) {
              out.print("0该" + info + "已存在，请更换!");
          } else {
              out.print("1该" + info + "可用!");
          }
        }
%>
