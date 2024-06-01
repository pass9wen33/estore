package cn.estore.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
/*
 * 在线人数统计
 */
public class OnlineCount implements ServletContextListener, HttpSessionListener {

 
    public OnlineCount() {
        // TODO Auto-generated constructor stub
    }

    
    public void sessionCreated(HttpSessionEvent se)  { 
    	  HttpSession session=se.getSession();
    	  ServletContext context=session.getServletContext();
    	  Integer counter=(Integer)context.getAttribute("counter");
        	  counter=new Integer(counter.intValue()+1); //在线人数加1
    	  context.setAttribute("counter", counter);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 HttpSession session=se.getSession();
    	  ServletContext context=session.getServletContext();
    	  Integer counter=(Integer)context.getAttribute("counter");
    		  counter=new Integer(counter.intValue()-1); //在线人数减1
    	  context.setAttribute("counter", counter);

    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ServletContext context=sce.getServletContext();
    	  context.removeAttribute("counter");//删除在线人数计数器

    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	 ServletContext context=sce.getServletContext();
    	  Integer counter=0;
    	  context.setAttribute("counter", counter); //初始化在线人数计数器

    }
    /*
	public void sessionCreated(HttpSessionEvent se) {
		// TODO session创建时启动
		HttpSession session=se.getSession();
		ServletContext context=session.getServletContext();
		//counter存放在线人数
		int counter= Integer.valueOf(
context.getAttribute("counter").toString());
		counter=counter+1;
		context.setAttribute("counter", counter);
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO session销毁时启动
		HttpSession session=se.getSession();
		ServletContext context=session.getServletContext();
		//counter存放在线人数
		int counter=Integer.valueOf(
context.getAttribute("counter").toString());
		counter=counter-1;//退出时在线人数减1
		context.setAttribute("counter", counter);
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext context=arg0.getServletContext();
		context.removeAttribute("counter");
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO 应用程序初始化时启动
		ServletContext context=arg0.getServletContext();
		int counter=0;
		context.setAttribute("counter", counter);
	}
*/
}
