package cn.estore.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.estore.entity.OrderItemEntity;
import cn.estore.util.DBConnection;
import cn.estore.dao.ProductDao;
//订单明细表的操作
public class OrderItemDao {
  private Connection connection = null; 	//定义连接的对象
  private PreparedStatement ps = null; 	//定义数据库操作的语句对象
  private DBConnection jdbc = null; 		//定义数据库连接对象
  public OrderItemDao() {
    jdbc = new DBConnection();
    connection = jdbc.connection; 		//利用构造方法取得数据库连接
  }
	// 添加的方法
public boolean insertOrderItem(OrderItemEntity form) {
try {
		ps = connection.prepareStatement("insert into tb_order_item(order_id,product_id,product_name,product_price,amount) values (?,?,?,?,?)");
		ps.setString(1, form.getOrderId());
		ps.setInt(2, form.getProductId());
		ps.setString(3,form.getProductName());
		ps.setFloat(4, form.getProductPrice());
		ps.setInt(5, form.getAmount());
		ps.executeUpdate();
		ps.close();
		return true;
	} catch (SQLException ex) {
		System.out.println("数据库访问失败");
		return false;
	    }
}
//按订单号查询订单明细
	public List selectOrderDetailByNumber(String orderId) {
//存放返回指定ID订单明细集合List[OrderItemEntity]
		List list = new ArrayList();
		OrderItemEntity orderDetail = null;	//存放订单某一购买商品的明细
		ProductDao goodsDao = new ProductDao();
		try {
			ps = connection.prepareStatement(
				 "select * from tb_order_item where order_id=?");
			ps.setString(1, orderId);			//传递参数orderId值
			ResultSet rs = ps.executeQuery();	//执行查询返回RS
			while (rs.next()) {			//循环每一字段，存至商品明细对象
				orderDetail = new OrderItemEntity();				
				orderDetail.setOrderId(rs.getString(2));
				orderDetail.setProductId(rs.getInt(3));
				orderDetail.setProductName(rs.getString(4));
				orderDetail.setProductPrice(rs.getFloat(5));
				orderDetail.setAmount(rs.getInt(6));
				list.add(orderDetail);//将某一商品明细对象添加至list
				}
		} catch (SQLException ex) {
		}
		return list;
	}
	// 删除子表的操作
		public void deleteOrderItems(String orderId) {
			try {
				ps = connection
						.prepareStatement("delete from tb_order_item where order_id=?");
				ps.setString(1, orderId);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException ex) {
			}

		}}

