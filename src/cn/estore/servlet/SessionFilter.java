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

 public class SessionFilter implements Filter {//�̳�Filter�ӿ�

   public FilterConfig config;//���ò�������
   public void setFilterConfig(FilterConfig config) {
     this.config = config;
   }
   public FilterConfig getFilterConfig() {
     return config;
   }
   
   //��doFilter�����з��������Ϊ
   public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain) 
      throws IOException, ServletException {
      HttpServletRequest httpreq = (HttpServletRequest) request;
      HttpServletResponse httpres = (HttpServletResponse) response;
      HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
     (HttpServletResponse) response); 
      //ͨ�����ò�������config��ȡ������Ϣ�еĳ�ʼ��������logonStrings��������Ҫ���˵�ҳ�棡��
      String logonStrings = config.getInitParameter("logonStrings");
      //��ȡ������Ϣ�еĳ�ʼ��������includeStrings������Ҫ���˵�ҳ�棡��
      String includeStrings = config.getInitParameter("includeStrings");
      //û�е�¼�Ļ���Ҫ�ض��򵽵�ҳ��
      String redirectPath = httpreq.getContextPath()+ config.getInitParameter ("redirectPath"); 
      //���������Թ�����Ϊ��ʼֵ��N��  
      String disabletestfilter = config.getInitParameter("disabletestfilter");
      if (disabletestfilter.toUpperCase().equals("Y")) {
        chain.doFilter(request, response);
        return;
      }
      
     String[] logonList = logonStrings.split(";");
     String[] includeList = includeStrings.split(";");
     Object user = httpreq.getSession().getAttribute("user");//��ȡSession�е��û�����
     Object manager=httpreq.getSession().getAttribute("manager");//��ȡSession�й���Ա�û�����
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
   //���
   public void destroy() {
    this.config = null;
   }
   //��ʼ������
   public void init(FilterConfig filterConfig) throws ServletException {
    this.config = filterConfig;
   }
   
   
   //�ַ����ȽϺ������ж�container�Ƿ������regx��
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
