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
 * ��������ͳ��
 */
public class OnlineCount implements ServletContextListener, HttpSessionListener {

 
    public OnlineCount() {
        // TODO Auto-generated constructor stub
    }

    
    public void sessionCreated(HttpSessionEvent se)  { 
    	  HttpSession session=se.getSession();
    	  ServletContext context=session.getServletContext();
    	  Integer counter=(Integer)context.getAttribute("counter");
        	  counter=new Integer(counter.intValue()+1); //����������1
    	  context.setAttribute("counter", counter);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 HttpSession session=se.getSession();
    	  ServletContext context=session.getServletContext();
    	  Integer counter=(Integer)context.getAttribute("counter");
    		  counter=new Integer(counter.intValue()-1); //����������1
    	  context.setAttribute("counter", counter);

    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	ServletContext context=sce.getServletContext();
    	  context.removeAttribute("counter");//ɾ����������������

    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	 ServletContext context=sce.getServletContext();
    	  Integer counter=0;
    	  context.setAttribute("counter", counter); //��ʼ����������������

    }
    /*
	public void sessionCreated(HttpSessionEvent se) {
		// TODO session����ʱ����
		HttpSession session=se.getSession();
		ServletContext context=session.getServletContext();
		//counter�����������
		int counter= Integer.valueOf(
context.getAttribute("counter").toString());
		counter=counter+1;
		context.setAttribute("counter", counter);
	}
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO session����ʱ����
		HttpSession session=se.getSession();
		ServletContext context=session.getServletContext();
		//counter�����������
		int counter=Integer.valueOf(
context.getAttribute("counter").toString());
		counter=counter-1;//�˳�ʱ����������1
		context.setAttribute("counter", counter);
	}
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext context=arg0.getServletContext();
		context.removeAttribute("counter");
	}
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Ӧ�ó����ʼ��ʱ����
		ServletContext context=arg0.getServletContext();
		int counter=0;
		context.setAttribute("counter", counter);
	}
*/
}
