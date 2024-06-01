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
	*初始化过滤器,和一般的Servlet一样，它也可以获得初始参数。
	*/
	    public void init(FilterConfig config) throws ServletException {
	      this.filterConfig = config;
	      this.targetEncoding = config.getInitParameter("encoding");
	    }
	    
	    /**
	     *进行过滤处理，这个方法最重要，所有过滤处理的代码都在此实现。
	    */
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain)
	    throws IOException, ServletException {
	      //System.out.println("使用以下方法对请求进行编码：encoding="+targetEncoding);   
	      HttpServletRequest request = (HttpServletRequest)srequest;
	      // 设置字符编码格式
	      //request.setCharacterEncoding(targetEncoding);
	      //HttpServletResponse response=(HttpServletResponse)sresponse;
	      sresponse.setContentType("text/html;charset=UTF-8");     
	      sresponse.setCharacterEncoding(targetEncoding);
	      srequest.setCharacterEncoding(targetEncoding);
	      System.out.println();
	      // 把处理权发送到下一个
	      System.out.println("srequest:"+srequest.getCharacterEncoding() );    
	      System.out.println("sresponse:"+sresponse.getCharacterEncoding() ); 
	      //System.out.println("过滤了一个页面编码");
	      chain.doFilter(srequest,sresponse); 
	    }

	public void setFilterConfig(final FilterConfig filterConfig){
	     this.filterConfig=filterConfig;
	}
	    
	   //销毁过滤器
	public void destroy(){
	     this.filterConfig=null;
	     this.targetEncoding=null;
	}

}