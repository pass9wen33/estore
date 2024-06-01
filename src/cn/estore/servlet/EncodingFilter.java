package cn.estore.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EncodingFilter  implements Filter{

	    protected FilterConfig filterConfig;
	    private String targetEncoding = "GB2312";
	    protected boolean enable; 
	    
	/**
	*��ʼ��������,��һ���Servletһ������Ҳ���Ի�ó�ʼ������
	*/
	    public void init(FilterConfig config) throws ServletException {
	      this.filterConfig = config;
	      this.targetEncoding = config.getInitParameter("encoding");
	    }
	    
	    /**
	     *���й��˴��������������Ҫ�����й��˴���Ĵ��붼�ڴ�ʵ�֡�
	    */
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
	    throws IOException, ServletException {
	      //System.out.println("ʹ�����·�����������б��룺encoding="+targetEncoding);   
	      HttpServletRequest request = (HttpServletRequest)srequest;
	      // �����ַ������ʽ
	      //request.setCharacterEncoding(targetEncoding);
	      //HttpServletResponse response=(HttpServletResponse)sresponse;
	      sresponse.setContentType("text/html;charset=UTF-8");     
	      sresponse.setCharacterEncoding(targetEncoding);
	      srequest.setCharacterEncoding(targetEncoding);
	      System.out.println();
	      // �Ѵ���Ȩ���͵���һ��
	      System.out.println("srequest:"+srequest.getCharacterEncoding() );    
	      System.out.println("sresponse:"+sresponse.getCharacterEncoding() ); 
	      //System.out.println("������һ��ҳ�����");
	      chain.doFilter(srequest,sresponse); 
	    }

	public void setFilterConfig(final FilterConfig filterConfig){
	     this.filterConfig=filterConfig;
	}
	    
	   //���ٹ�����
	public void destroy(){
	     this.filterConfig=null;
	     this.targetEncoding=null;
	}

}