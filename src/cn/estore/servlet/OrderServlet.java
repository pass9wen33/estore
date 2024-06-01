package cn.estore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import cn.estore.dao.OrderDao;
import cn.estore.entity.OrderEntity;
import cn.estore.dao.OrderItemDao;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet {
	public OrderServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		// 获取客户订单请求类别
		String orderAction = request.getParameter("orderAction").toString();
		OrderDao order = new OrderDao();
		OrderItemDao orderDetail = new OrderItemDao();
		String curUserName=null;
		try{
			curUserName = session.getAttribute("name").toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			// 1.若orderAction中存放的是orderList，表示查看当前用户所有订单信息
			if (orderAction.equals("orderAbstract")) {//表示查看会员订单请求
				List list = new ArrayList();//存放订单信息链表
				String i = request.getParameter("i");// i用于存放当前订单显示页号
				if (i != null)
					request.setAttribute("i", i);
				// 取得当前在线用户的订单
				if(curUserName!=null)
					list = order.selectOrderByName(curUserName);//生成订单集合
				request.setAttribute("orderAbstract", list);//将订单存至request
				//服务器端请求转发，跳转至前台订单显示页面，request不发生变化
				request.getRequestDispatcher("pages/order/orderList.jsp")
						.forward(request, response);
			}
			
			// 2.若orderAction中存放的是orderDetail，表示请求查看当前订单的详细信息
			else if (orderAction.equals("orderDetail")) {
				//指定订单号的详细资料
				String orderId = request.getParameter("orderId").toString();
				//据订单orderId筛选出订单基本资料
				OrderEntity orderAbstract = order.selectOrderByNumber(orderId);
				//保存至request，供显示页面获取
				request.setAttribute("orderAbstract", orderAbstract);//订单基本数据
				// 获取该用户指定某订单号的详细购物资料
				List list = new ArrayList();
				list = orderDetail.selectOrderDetailByNumber(orderId);
				request.setAttribute("orderItems", list);
				request.getRequestDispatcher("pages/order/orderItemList.jsp")
								.forward(request, response);
			 }
			//3.orderAction=orderDelivered表示显示查询已发货或未发货订单
			//deliverySign为发货标志，已发货为真，未发货为假
			else if (orderAction.equals("orderDelivered")) {
			//获取查询的已出货订单标识还是未出货订单标识
			Boolean boolSign = Boolean.valueOf(request.getParameter("deliverySign"));
			// 获取当前客号名
			String name = session.getAttribute("name").toString();
			// 调用底层方法，生成包含已出或未出订单的list
			List orderDeliveryList = order.
			selectOrderByNameAndDeliverySign(name, boolSign);
			//将查询出的订单集合传送出去
			request.setAttribute("orderDeliveryList", orderDeliveryList);
			//请求转发
			request.getRequestDispatcher(
			"pages/order/orderListDelivery.jsp").forward(request,response);
			}

			//后台---所有客户订单显示
			else if(orderAction.equals("selectAllOrder")){//查询所有订单
				List list=new ArrayList();
				String i=request.getParameter("i");
				if (i!=null)request.setAttribute("i",i);
				list=order.selectAllOrder();
				request.setAttribute("AllOrder", list);
				request.getRequestDispatcher("pages/admin/order/orderSelect.jsp").forward(request, response);
			}
			//orderAction=despatch表示显示查询已发货或未发货订单
			else if(orderAction.equals("despatch")){//根据获取的orderId出货
				List list=new ArrayList();
				String i=request.getParameter("i");
				if (i!=null)request.setAttribute("i",i);
				order.updateSignOrder(request.getParameter("orderId").toString());//更改出货状态
				list=order.selectAllOrder();//所有订单重新读取继续显示				
				request.setAttribute("AllOrder", list);
				request.getRequestDispatcher("pages/admin/order/orderSelect.jsp").forward(request, response);
			}
			else if(orderAction.equals("deleteOrder")){//根据获取的orderId删除指定订单
				List list=new ArrayList();
				String i=request.getParameter("i");
				if (i!=null)request.setAttribute("i",i);
				order.deleteOrder(request.getParameter("orderId").toString());//删除指定orderId订单
				list=order.selectAllOrder();//所有订单重新读取继续显示				
				request.setAttribute("AllOrder", list);
				request.getRequestDispatcher("pages/admin/order/orderSelect.jsp").forward(request, response);
			}
	
			//均不满足于，则显示主页面
			else {
				// 没有对应的action，显示主页面
				out.println("<script>parent.location.href='/estore/pages/product/main.jsp';</script>");
			}
			out.flush();
			out.close();
		} catch (Exception e) {// 没有登录用户，退至主页面
			out.println("<script>parent.location.href='/estore/pages/product/main.jsp';</script>");
		}

	}

	public void init() throws ServletException {
		// Put your code here
	}

	
	
}
