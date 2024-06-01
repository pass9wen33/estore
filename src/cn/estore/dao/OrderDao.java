package cn.estore.dao;

import cn.estore.entity.OrderEntity;
import cn.estore.util.DBConnection;
import java.sql.*;
import java.util.*;
import cn.estore.dao.OrderItemDao;

//������Ĳ���
public class OrderDao {
	private Connection connection = null; // �������ӵĶ���
	private PreparedStatement ps = null; // �������ݿ������������
	private DBConnection jdbc = null; // �������ݿ����Ӷ���

	public OrderDao() {
		jdbc = new DBConnection();
		connection = jdbc.connection; // ���ù��췽��ȡ�����ݿ�����
	}

	// ��Ӷ���
	public boolean insertOrder(OrderEntity form) {
		try {
			ps = connection.prepareStatement("insert into tb_order values (?,?,?,?,?,?,?,?,?,now(),?)");
			ps.setString(1, form.getOrderId());
			ps.setString(2, form.getName());
			ps.setString(3, form.getRealName());
			ps.setString(4, form.getAddress());
			ps.setString(5, form.getMobile());
			ps.setFloat(6, Float.valueOf(form.getTotalPrice()));
			ps.setString(7, form.getDeliveryMethod());
			ps.setString(8, form.getMemo());
			ps.setBoolean(9, form.getDeliverySign());
			ps.setString(10, form.getPaymentmode());
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (SQLException ex) {
			System.out.println("���ݿ����ʧ��");
			System.out.println(ex.getMessage());
			return false;
		}
	}
	/* ǰ̨��Ա������ѯ(����Ա����ѯ)
	 * ����: ��Ա��
	 * ������û�Ա��Ӧ�����ж�������List[e]�����е�e��OrderEntity����
	 */
	public List selectOrderByName(String name) {
		List list = new ArrayList();
		try {
			ps = connection.prepareStatement("select * from tb_order where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();// ��ȡָ�����������ж�������
			while (rs.next()) {// ѭ����rs�����ݴ���order������
				OrderEntity order = new OrderEntity();
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
				order.setRealName(rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setMobile(rs.getString(5));
				order.setTotalPrice(Float.valueOf(rs.getString(6)));
				order.setDeliveryMethod(rs.getString(7));
				order.setMemo(rs.getString(8));
				order.setDeliverySign(rs.getBoolean(9));
				order.setCreateTime(rs.getString(10));
				order.setPaymentmode(rs.getString(11));
				list.add(order);// ��order������list
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	// �Զ�����Ϊ������ѯ��Ϣ
	public OrderEntity selectOrderByNumber(String orderId) {
		OrderEntity order = null;
		try {
			ps = connection.prepareStatement("select * from tb_order where order_id=?");
			ps.setString(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				order = new OrderEntity();
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
				order.setRealName(rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setMobile(rs.getString(5));
				order.setTotalPrice(Float.valueOf(rs.getString(6)));
				order.setDeliveryMethod(rs.getString(7));
				String memo = null;
				try {
					memo = rs.getString(8);
				} catch (SQLException e) {
					// doNothing
				}
				order.setMemo(memo);
				order.setDeliverySign(rs.getBoolean(9));
				order.setCreateTime(rs.getString(10));
				order.setPaymentmode(rs.getString(11));
			}
		} catch (SQLException ex) {
		}
		return order;
	}

	// �Ի�Ա���ͳ�����־Ϊ������ѯ��Ϣ
	public List selectOrderByNameAndDeliverySign(String name, Boolean sign) {
		List list = new ArrayList();// ׼�������/δ��������
		OrderEntity order = null;
		try {// ������+�ѳ���δ������־��ѯ������Ϣ
			ps = connection.prepareStatement(
					"select * from tb_order " + "where name=? and delivery_sign=? order by  order_id DESC");
			ps.setString(1, name);// Ϊ�������������
			ps.setBoolean(2, sign);
			ResultSet rs = ps.executeQuery();// ִ��sql��ѯ
			while (rs.next()) {// ���ζ�ȡ���ݼ��������order��ʱ������
				order = new OrderEntity();
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
				order.setRealName(rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setMobile(rs.getString(5));
				order.setTotalPrice(Float.valueOf(rs.getString(6)));
				order.setDeliveryMethod(rs.getString(7));
				order.setMemo(rs.getString(8));
				order.setDeliverySign(rs.getBoolean(9));
				order.setCreateTime(rs.getString(10));
				order.setPaymentmode(rs.getString(11));
				list.add(order);// ��һ������ŵ�list��
			}
		} catch (SQLException ex) {
		}
		return list;// ���ز�ѯ�ѳ�����δ������������list
	}
	/* ����Ա��ѯ��Ա���ж�����ѯ
	 * ����: ��
	 * ������̳����ж�������List[e]�����е�e��OrderEntity����
	 */
	public List selectAllOrder() {
		List list = new ArrayList();
		try {
			ps = connection.prepareStatement("select * from tb_order");
			ResultSet rs = ps.executeQuery();// ��ȡ���ж�������
			while (rs.next()) {// ѭ����rs�е����ݴ���order������
				OrderEntity order = new OrderEntity();
				order.setOrderId(rs.getString(1));
				order.setName(rs.getString(2));
				order.setRealName(rs.getString(3));
				order.setAddress(rs.getString(4));
				order.setMobile(rs.getString(5));
				order.setTotalPrice(Float.valueOf(rs.getString(6)));
				order.setDeliveryMethod(rs.getString(7));
				order.setMemo(rs.getString(8));
				order.setDeliverySign(rs.getBoolean(9));
				order.setCreateTime(rs.getString(10));
				order.setPaymentmode(rs.getString(11));
				list.add(order);// ��order������list
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}
	// ��������
	public void updateSignOrder(String orderId) {
		try {
			ps = connection.prepareStatement(
	"update tb_order set delivery_sign=1 where order_id=?");
			ps.setString(1, orderId);
			ps.executeUpdate();
			ps.close();
			} catch (SQLException ex) {
	ex.printStackTrace();
		             }
	}

	// ɾ������(ɾ������ǰ������ɾ��������ϸ)
	public boolean deleteOrder(String orderId) {
	//ɾ��������ϸ
		OrderItemDao orderItem=new OrderItemDao();
		orderItem.deleteOrderItems(orderId);
		try {
			ps = connection.prepareStatement(
	"delete from tb_order where order_id=?");
	 
			ps.setString(1, orderId);
	       //ɾ������
			ps.executeUpdate();
			ps.close();
			return true;
			} catch (SQLException ex) {
				return false;
		}
	}

}
