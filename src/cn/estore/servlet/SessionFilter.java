package cn.estore.servlet;
 import java.io.IOException;
 import javax.servlet.Filter;
 import javax.servlet.FilterChain;
 import javax.servlet.FilterConfig;
 import javax.servlet.ServletException;
 import javax.servlet.ServletRequest;
 import javax.servlet.ServletResponse;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

 public class SessionFilter implements Filter {//继承Filter接口

   public FilterConfig config;//配置参数对象
   public void setFilterConfig(FilterConfig config) {
     this.config = config;
   }
   public FilterConfig getFilterConfig() {
     return config;
   }
   
   //在doFilter方法中放入过滤行为
   public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) 
      throws IOException, ServletException {
      HttpServletRequest httpreq = (HttpServletRequest) request;
      HttpServletResponse httpres = (HttpServletResponse) response;
      HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
     (HttpServletResponse) response); 
      //通过配置参数对象config获取配置信息中的初始化参数“logonStrings”（不需要过滤的页面！）
      String logonStrings = config.getInitParameter("logonStrings");
      //获取配置信息中的初始化参数“includeStrings”（需要过滤的页面！）
      String includeStrings = config.getInitParameter("includeStrings");
      //没有登录的话需要重定向到的页面
      String redirectPath = httpreq.getContextPath()+ config.getInitParameter ("redirectPath"); 
      //过滤器测试过滤行为初始值“N”  
      String disabletestfilter = config.getInitParameter("disabletestfilter");
      if (disabletestfilter.toUpperCase().equals("Y")) {
        chain.doFilter(request, response);
        return;
      }
      
     String[] logonList = logonStrings.split(";");
     String[] includeList = includeStrings.split(";");
     Object user = httpreq.getSession().getAttribute("user");//获取Session中的用户对象
     Object manager=httpreq.getSession().getAttribute("manager");//获取Session中管理员用户对象
     if (user == null&&manager==null) {
        if (!this.isContains(httpreq.getRequestURI(), includeList)) {
          chain.doFilter(request, response);
          return;
        }
        if (this.isContains(httpreq.getRequestURI(), logonList)) {
          chain.doFilter(request, response);
          return;
        }
        wrapper.sendRedirect(redirectPath);
      } else {
        chain.doFilter(request, response);
      }
    }
   //清除
   public void destroy() {
    this.config = null;
   }
   //初始化操作
   public void init(FilterConfig filterConfig) throws ServletException {
    this.config = filterConfig;
   }
   
   
   //字符串比较函数，判断container是否包含在regx中
   public static boolean isContains(String container, String[] regx) { 
      boolean result = false;
      for (int i = 0; i < regx.length; i++) {
       if (container.indexOf(regx[i]) != -1) {
        return true;
       }
      }
      return result;
   }   
   
 }
