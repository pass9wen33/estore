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
//������ϸ��Ĳ���
public class OrderItemDao {
  private Connection connection = null; 	//�������ӵĶ���
  private PreparedStatement ps = null; 	//�������ݿ������������
  private DBConnection jdbc = null; 		//�������ݿ����Ӷ���
  public OrderItemDao() {
    jdbc = new DBConnection();
    connection = jdbc.connection; 		//���ù��췽��ȡ�����ݿ�����
  }
	// ��ӵķ���
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
		System.out.println("���ݿ����ʧ��");
		return false;
	    }
}
//�������Ų�ѯ������ϸ
	public List selectOrderDetailByNumber(String orderId) {
//��ŷ���ָ��ID������ϸ����List[OrderItemEntity]
		List list = new ArrayList();
		OrderItemEntity orderDetail = null;	//��Ŷ���ĳһ������Ʒ����ϸ
		ProductDao goodsDao = new ProductDao();
		try {
			ps = connection.prepareStatement(
				 "select * from tb_order_item where order_id=?");
			ps.setString(1, orderId);			//���ݲ���orderIdֵ
			ResultSet rs = ps.executeQuery();	//ִ�в�ѯ����RS
			while (rs.next()) {			//ѭ��ÿһ�ֶΣ�������Ʒ��ϸ����
				orderDetail = new OrderItemEntity();				
				orderDetail.setOrderId(rs.getString(2));
				orderDetail.setProductId(rs.getInt(3));
				orderDetail.setProductName(rs.getString(4));
				orderDetail.setProductPrice(rs.getFloat(5));
				orderDetail.setAmount(rs.getInt(6));
				list.add(orderDetail);//��ĳһ��Ʒ��ϸ���������list
				}
		} catch (SQLException ex) {
		}
		return list;
	}
	// ɾ���ӱ�Ĳ���
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

