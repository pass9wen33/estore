package cn.estore.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
    public TestServlet() {
        super();
    }

    public void init() {

    }

    public void destroy() {
        super.destroy();
    }

    public void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("111");
    }
}
